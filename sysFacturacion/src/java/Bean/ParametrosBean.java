package Bean;

import Controller.ParametrosController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import Model.Parametro;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ParametrosBean {

    private Parametro parametros;
    private Parametro parametroViejo;
    private List<Parametro> listaParametros;
    private List<Parametro> filtroParametros;

    public ParametrosBean() {
    }

    @PostConstruct
    public void Init() {
        parametros = new Parametro();
        parametroViejo = new Parametro();
    }

    public Parametro getParametros() {
        return parametros;
    }

    public void setParametros(Parametro parametros) {
        this.parametros = parametros;
    }

    public Parametro getParametroViejo() {
        return parametroViejo;
    }

    public void setParametroViejo(Parametro parametroViejo) {
        this.parametroViejo = parametroViejo;
    }

    public List<Parametro> getListaParametros() {
        ParametrosController pDao = new ParametrosController();
        listaParametros = pDao.listarParametros();
        return listaParametros;
    }

    public void setListaParametros(List<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public List<Parametro> getFiltroParametros() {
        return filtroParametros;
    }

    public void setFiltroParametros(List<Parametro> filtroParametros) {
        this.filtroParametros = filtroParametros;
    }

    public void prepararNuevoParametro() {
        parametros = new Parametro();
    }

    public void nuevoParametro() {

        if (parametros.getNombreParametro().equals("") || parametros.getValorParametro().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
        } else {

            parametros.setNombreParametro(parametros.getNombreParametro().toUpperCase());
            parametros.setValorParametro(parametros.getValorParametro().toUpperCase());

            try {
                ParametrosController parametrosController = new ParametrosController();
                parametroViejo = parametrosController.consultarParametroPorNombre(parametros.getNombreParametro());

                if (parametroViejo == null) {

                    parametrosController.newParametro(parametros);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogNuevoParametro').hide();");

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Parámetro se ha registrado correctamente."));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ya existe un Parámetro con el mismo nombre."));
                }
                parametros = new Parametro();
            } catch (Exception ex) {
                parametros = new Parametro();
                Logger.getLogger(ParametrosBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void modificarParametro() {

        if (parametros.getValorParametro().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
        } else {
             ParametrosController parametrosController = new ParametrosController();
            if (parametros.getNombreParametro().equals("IVA")) {

                try {
                    Double nuevoIVA = Double.parseDouble(parametros.getValorParametro());
                   
                    parametrosController.updateParametro(parametros);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogModificarParametro').hide();");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Parametro se ha modificado correctamente."));
                    parametros = new Parametro();
                    
                    //convertir productos
                    parametrosController.convertirPrecioVentaProductosNuevoIva();

                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El valor del parámetro IVA debe de ser numérico."));
                }

            } else {
                    parametrosController.updateParametro(parametros);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogModificarParametro').hide();");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Parametro se ha modificado correctamente."));
                    parametros = new Parametro();
            }

        }

    }

    public void eliminarParametro() {

    }

}
