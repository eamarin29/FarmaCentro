package Bean;

import ClasesAuxiliares.ImpresionReportes;
import Controller.ReporteController;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import Model.Reporte;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped

public class ReporteBean implements Serializable {

    private String reporte;
    private Map<String, String> reportes;


    private Date fechaInicial;
    private Date fechaFinal;

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
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogReporte1').show();");
            }
        }

    }

    public void imprimirReporte1() {

    }
}
