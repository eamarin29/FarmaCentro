package Bean;

import ClasesAuxiliares.ReporteFactura;
import Controller.FacturasController;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import Model.Factura;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class FacturasBean implements Serializable{

    private List<Factura> listaFactura;
    private Factura factura;

    public FacturasBean() {
    }

    @PostConstruct
    public void Init() {
        factura = new Factura();
    }

    public List<Factura> getListaFactura() {
        FacturasController fDao = new FacturasController();
        listaFactura = fDao.listarFacturas();
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void eliminarFactura() {
        FacturasController facturasController = new FacturasController();
        facturasController.deleteFactura(factura);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogEliminarFactura').hide();");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "La factura se ha eliminado correctamente."));
        factura = new Factura();
    }

    public void imprimirFacturaSeleccionada() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String cc = factura.getCliente().getCodcliente();
        String cv = factura.getVendedor().getCedula();
        int cf = factura.getCodfactura().intValue();

        //Instancia hacia la clase ReporteFactura        
        ReporteFactura rFactura = new ReporteFactura();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/Factura/factura.jasper");

        rFactura.getReporte(ruta, cc, cv, cf);
        FacesContext.getCurrentInstance().responseComplete();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogImprimirFactura').hide();");

    }

}
