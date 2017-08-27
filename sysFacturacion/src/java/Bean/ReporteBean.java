package Bean;

import ClasesAuxiliares.ImpresionReportes;
import Controller.ReporteController;
import Controller.VendedorController;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Reporte;
import Model.Vendedor;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped

public class ReporteBean implements Serializable {

    private String reporte;
    private Map<String, String> reportes;

    private Date fechaInicial;
    private Date fechaFinal;
    private String vendedor;
    private Map<String, String> vendedores;

    public ReporteBean() {
    }

    @PostConstruct
    public void Init() {

        //combo de empleados
        reportes = new HashMap<String, String>();
        ReporteController reporteController = new ReporteController();
        List<Reporte> listaReportes = reporteController.listarReportes();
        for (int i = 0; i < listaReportes.size(); i++) {
            reportes.put(listaReportes.get(i).getDescripcion(), String.valueOf(listaReportes.get(i).getCodigo()));
        }

    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Map<String, String> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Map<String, String> vendedores) {
        this.vendedores = vendedores;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public Map<String, String> getReportes() {
        return reportes;
    }

    public void setReportes(Map<String, String> reportes) {
        this.reportes = reportes;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void aceptarReporte() {

        if (this.reporte == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Debe seleccionar un reporte."));
        } else {
            if (this.reporte.equals("1")) {

                //combo de empleados
                vendedores = new HashMap<String, String>();
                VendedorController VendedorController = new VendedorController();
                List<Vendedor> listaVendedores = VendedorController.listarVendedores();
                for (int i = 0; i < listaVendedores.size(); i++) {
                    vendedores.put(listaVendedores.get(i).getNombres() + listaVendedores.get(i).getApellidos(), String.valueOf(listaVendedores.get(i).getCedula()));
                }

                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogReporte1').show();");
            }
        }
    }

    public void imprimirReporte1() {

        try {

            String cedula_vendedor = (this.vendedor);

            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            String fecha_ini = formateador.format(this.fechaInicial);
            String fecha_fin = formateador.format(this.fechaFinal);

            //inicia metodo de visualizacion de la factura
            ImpresionReportes rFactura = new ImpresionReportes();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("/Reportes/1/1.jasper");

            rFactura.getReporte1(ruta, cedula_vendedor, this.fechaFinal, this.fechaInicial);
            FacesContext.getCurrentInstance().responseComplete();

            //finaliza metodo de la visualizacion de la factura
        } catch (Exception ex) {
            Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
