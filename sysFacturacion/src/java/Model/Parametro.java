package Model;
// Generated 22-jul-2017 17:32:23 by Hibernate Tools 4.3.1



/**
 * Parametro generated by hbm2java
 */
public class Parametro  implements java.io.Serializable {


     private String nombreParametro;
     private String valorParametro;

    public Parametro() {
    }

	
    public Parametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }
    public Parametro(String nombreParametro, String valorParametro) {
       this.nombreParametro = nombreParametro;
       this.valorParametro = valorParametro;
    }
   
    public String getNombreParametro() {
        return this.nombreParametro;
    }
    
    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }
    public String getValorParametro() {
        return this.valorParametro;
    }
    
    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }




}


