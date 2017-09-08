package Controller;

import ClasesAuxiliares.Conexion;
import Model.DetalleFactura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoController {

    public List<Producto> listarProductos() {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto ORDER BY codBarras ASC";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public int filasProductosPorCodBarras(String codBarras) {

        int ret = 0;

        try {
            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe
            PreparedStatement consulta = conn.prepareStatement("SELECT COD_BARRAS FROM PRODUCTO WHERE COD_BARRAS=?");
            consulta.setString(1, codBarras);
            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {
                ret++;
            }
            conn.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public List<Producto> listaDeProductosPorCodBarras(String codBarras) {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto WHERE codBarras=:codBarras";
        Query q = session.createQuery(hql);
        q.setParameter("codBarras", codBarras);

        try {
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;

    }

    public void newProducto(Producto producto) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void updateProducto(Producto producto) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public int deleteProducto(Producto producto) {

        Session session = null;
        int errores = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            errores++;
            return errores;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return errores;
    }

    public boolean obtenerProductoPorCodigoBarras(String codBarras) {
        //true si existe
        boolean ret = false;

        try {

            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE COD_BARRAS=?");
            consulta.setString(1, codBarras);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                ret = true;
                conn.close();
                rs.close();
            } else {
                ret = false;
                conn.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public List<Producto> listarProductosMayorCero() {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto WHERE stockActual > 0";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public Producto obtenerUltimoRegistro() throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Producto p = new Producto();
        p = null;

        try {
            String hql = "FROM Producto ORDER BY codigo DESC";
            Query q = session.createQuery(hql).setMaxResults(1);
            p = (Producto) q.uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return p;
    }

    public Producto obtenerUltimoRegistroComun() throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Producto p = new Producto();
        p = null;

        try {
            String hql = "FROM Producto WHERE codComun IS NOT NULL ORDER BY codComun DESC ";
            Query q = session.createQuery(hql).setMaxResults(1);
            p = (Producto) q.uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return p;
    }

    public Long obtenerCuantosRegistrosHayEnProducto() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Long p = 0L;

        try {
            String hql = "SELECT COUNT(*) FROM Producto";
            Query q = session.createQuery(hql);
            p = (Long) q.uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return p;

    }

    public Long obtenerCuantosRegistrosHayEnProductoComun() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Long p = 0L;

        try {
            String hql = "SELECT COUNT(DISTINCT codComun) FROM Producto WHERE codComun IS NOT NULL";
            Query q = session.createQuery(hql);
            p = (Long) q.uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return p;

    }

    public Producto actualizarProductosDondeSeaUnidades(String codBarras) {

        Session session = null;
        Producto ret = new Producto();
        ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Producto WHERE codBarras=:codBarras AND unidadXPaquete=1";
            Query q = session.createQuery(hql);
            q.setParameter("codBarras", codBarras);
            session.getTransaction().commit();
            ret = (Producto) q.uniqueResult();
            return ret;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;
    }

    public Producto obtenerProductoPorCodigo(BigDecimal codProducto) {

        Producto ret = new Producto();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto WHERE codigo=:codProducto";
        Query q = session.createQuery(hql);
        q.setParameter("codProducto", codProducto);
        t.commit();

        try {
            ret = (Producto) q.uniqueResult();
            session.close();
            return ret;

        } catch (HibernateException e) {
            t.rollback();
        }
        return ret;

    }

    public List<Producto> listaDeProductosPorCodComun(BigDecimal codComun) {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto WHERE codComun=:codComun";
        Query q = session.createQuery(hql);
        q.setParameter("codComun", codComun);

        try {
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;

    }

    public boolean obtenerProductoPorCodigoBarrasAndCodigoComun(String codBarras, BigDecimal codComun) {
        //false, modificó el cod de barras
        boolean ret = false;

        try {

            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe 
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE COD_BARRAS=? AND COD_COMUN=?");
            consulta.setString(1, codBarras);
            consulta.setBigDecimal(2, codComun);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                ret = true;
                conn.close();
                rs.close();
            } else {
                ret = false;
                conn.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean obtenerProductoPorCodigoBarrasAndCodComunExiste(String codBarras, BigDecimal codComun) {
        //true, existe, no lo puede agregar
        boolean ret = false;

        try {

            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE COD_BARRAS=? AND COD_COMUN!=?");
            consulta.setString(1, codBarras);
            consulta.setBigDecimal(2, codComun);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                ret = true;
                conn.close();
                rs.close();
            } else {
                ret = false;
                conn.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public Producto verificarProductoEnFactura(BigDecimal codProducto) {

        Producto ret = new Producto();
        ret = null;

        try {

            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM DETALLE_FACTURA WHERE CODPRODUCTO=?");
            consulta.setBigDecimal(1, codProducto);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                Producto p1 = new Producto();
                p1.setCodigo(new BigDecimal(3333));
                ret = p1;
                conn.close();
                rs.close();
            } else {
                ret = null;
                conn.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public List<Producto> listaDeProductosPorCodComunOrderByOrden(BigDecimal codComun) {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto WHERE codComun=:codComun ORDER BY orden DESC";
        Query q = session.createQuery(hql);
        q.setParameter("codComun", codComun);

        try {
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;

    }

}
