-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.18-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para facturacion
CREATE DATABASE IF NOT EXISTS `facturacion` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `facturacion`;

-- Volcando estructura para tabla facturacion.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `codCliente` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla facturacion.detallefactura
CREATE TABLE IF NOT EXISTS `detallefactura` (
  `codDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `codFactura` int(11) NOT NULL,
  `codProducto` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `totalDetalle` double(10,2) NOT NULL,
  PRIMARY KEY (`codDetalle`),
  KEY `FK_detallefactura_factura` (`codFactura`),
  KEY `FK_detallefactura_producto` (`codProducto`),
  CONSTRAINT `FK_detallefactura_factura` FOREIGN KEY (`codFactura`) REFERENCES `factura` (`codFactura`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_detallefactura_producto` FOREIGN KEY (`codProducto`) REFERENCES `producto` (`codProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla facturacion.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `codFactura` int(11) NOT NULL AUTO_INCREMENT,
  `codCliente` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `codVendedor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `totalVenta` double(10,2) NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`codFactura`),
  KEY `codCliente` (`codCliente`),
  KEY `codVendedor` (`codVendedor`),
  CONSTRAINT `FK_factura_cliente` FOREIGN KEY (`codCliente`) REFERENCES `cliente` (`codCliente`),
  CONSTRAINT `FK_factura_vendedor` FOREIGN KEY (`codVendedor`) REFERENCES `vendedor` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla facturacion.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `codProducto` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombreProducto` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `precioVenta` double(10,2) NOT NULL,
  `stockMinimo` int(11) NOT NULL,
  `stockActual` int(11) NOT NULL,
  PRIMARY KEY (`codProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla facturacion.tipo
CREATE TABLE IF NOT EXISTS `tipo` (
  `codTipo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla facturacion.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `cedula` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` int(11) NOT NULL,
  `validado` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `codRegistro` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cedula`),
  KEY `tipo` (`tipo`),
  CONSTRAINT `FK_usuario_tipo` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`codTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla facturacion.vendedor
CREATE TABLE IF NOT EXISTS `vendedor` (
  `cedula` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `dui` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `celular` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cedula`),
  KEY `cedula` (`cedula`),
  CONSTRAINT `FK_vendedor_usuario` FOREIGN KEY (`cedula`) REFERENCES `usuario` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para disparador facturacion.detallefactura_before_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `detallefactura_before_insert` BEFORE INSERT ON `detallefactura` FOR EACH ROW BEGIN
SET @stockAntiguo=(SELECT stockActual FROM producto WHERE codProducto=new.codProducto);
UPDATE producto
SET stockActual=@stockAntiguo-new.cantidad WHERE codProducto=new.codProducto;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
