package Model;
// Generated 12-sep-2017 18:01:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Vendedor generated by hbm2java
 */
public class Vendedor  implements java.io.Serializable {


     private String cedula;
     private Usuario usuario;
     private String nombres;
     private String apellidos;
     private String celular;
     private String direccion;
     private Set<Comision> comisions = new HashSet<Comision>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Vendedor() {
    }

	
    public Vendedor(Usuario usuario) {
        this.usuario = usuario;
    }
    public Vendedor(Usuario usuario, String nombres, String apellidos, String celular, String direccion, Set<Comision> comisions, Set<Factura> facturas) {
       this.usuario = usuario;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.celular = celular;
       this.direccion = direccion;
       this.comisions = comisions;
       this.facturas = facturas;
    }
   
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set<Comision> getComisions() {
        return this.comisions;
    }
    
    public void setComisions(Set<Comision> comisions) {
        this.comisions = comisions;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


