package Model;
// Generated 12-sep-2017 18:01:40 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Comision generated by hbm2java
 */
public class Comision  implements java.io.Serializable {


     private BigDecimal codigo;
     private Vendedor vendedor;
     private Factura factura;
     private BigDecimal saldo;
     private Date fecha;

    public Comision() {
    }

	
    public Comision(BigDecimal codigo) {
        this.codigo = codigo;
    }
    public Comision(BigDecimal codigo, Vendedor vendedor, Factura factura, BigDecimal saldo, Date fecha) {
       this.codigo = codigo;
       this.vendedor = vendedor;
       this.factura = factura;
       this.saldo = saldo;
       this.fecha = fecha;
    }
   
    public BigDecimal getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public BigDecimal getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


