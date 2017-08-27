package Bean;

import ClasesAuxiliares.ImpresionReportes;
import Controller.ComisionController;
import Controller.FacturaController;
import Controller.FacturasController;
import Controller.ProductoController;
import Model.Comision;
import Model.DetalleFactura;
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
import Model.Producto;
import java.math.BigDecimal;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class FacturasBean implements Serializable {

    private List<Factura> listaFactura;
    private Factura factura;

    private Factura anularFactura;

    public FacturasBean() {
    }

    @PostConstruct
    public void Init() {
        factura = new Factura();
        anularFactura = new Factura();
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

    public Factura getAnularFactura() {
        return anularFactura;
    }

    public void setAnularFactura(Factura anularFactura) {
        this.anularFactura = anularFactura;
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

        //Instancia hacia la clase ImpresionReportes        
        ImpresionReportes rFactura = new ImpresionReportes();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/Factura/factura.jasper");

        rFactura.getReporteFactura(ruta, cc, cv, cf);
        FacesContext.getCurrentInstance().responseComplete();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogImprimirFactura').hide();");

    }

    public void anularFactura() {

        FacturasController FacturasController = new FacturasController();
        FacturaController FacturaController = new FacturaController();
        boolean fAnulada = false;
        fAnulada = FacturasController.consultarFacturaAnulada(this.anularFactura.getCodfactura());

        if (fAnulada == true) {
            //ya esta anulada
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Esta Factura ya está anulada."));

        } else {

            List<DetalleFactura> listaDetalle = null;
            listaDetalle = FacturasController.listaProductosXfactura(this.anularFactura.getCodfactura());

            for (int i = 0; i < listaDetalle.size(); i++) {
                ProductoController ProductoController = new ProductoController();
                ComisionController ComisionController = new ComisionController();
                Producto pr = new Producto();
                pr = ProductoController.obtenerProductoPorCodigo(listaDetalle.get(i).getProducto().getCodigo());
                if (pr == null) {

                } else {
                    //actualizo el stock
                    pr.setStockActUni(pr.getStockActUni() + listaDetalle.get(i).getCantidad().longValue());
                    ProductoController.updateProducto(pr);

                    //actualizo comision
                    Comision co = new Comision();
                    co = ComisionController.consultarComisionXfacturaAndVendedor(this.anularFactura.getCodfactura(), this.anularFactura.getVendedor().getCedula());
                    if (co == null) {
                    } else {
                        co.setSaldo(new BigDecimal(0));
                        ComisionController.updateComision(co);
                        this.anularFactura.setAnulada('S');
                        FacturaController.updateFactura(this.anularFactura);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "La factura se ha anulado exitosamente."));
                    }

                }

            }
        }

    }

}
