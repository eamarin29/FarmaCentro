package Model;
// Generated 12-sep-2017 18:01:40 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * DetalleFactura generated by hbm2java
 */
public class DetalleFactura  implements java.io.Serializable {


     private BigDecimal coddetalle;
     private Factura factura;
     private Producto producto;
     private BigDecimal cantidad;
     private BigDecimal totalDetalle;

    public DetalleFactura() {
    }

	
    public DetalleFactura(BigDecimal coddetalle) {
        this.coddetalle = coddetalle;
    }
    public DetalleFactura(BigDecimal coddetalle, Factura factura, Producto producto, BigDecimal cantidad, BigDecimal totalDetalle) {
       this.coddetalle = coddetalle;
       this.factura = factura;
       this.producto = producto;
       this.cantidad = cantidad;
       this.totalDetalle = totalDetalle;
    }
   
    public BigDecimal getCoddetalle() {
        return this.coddetalle;
    }
    
    public void setCoddetalle(BigDecimal coddetalle) {
        this.coddetalle = coddetalle;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getTotalDetalle() {
        return this.totalDetalle;
    }
    
    public void setTotalDetalle(BigDecimal totalDetalle) {
        this.totalDetalle = totalDetalle;
    }




}


