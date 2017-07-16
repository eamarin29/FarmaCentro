package Bean;

import ClasesAuxiliares.Statics;
import static ClasesAuxiliares.Statics.direccionIp;
import static ClasesAuxiliares.Statics.nombreApp;
import static ClasesAuxiliares.Statics.puerto;
import ClasesAuxiliares.TipoController;
import ClasesAuxiliares.Validaciones;
import Controller.AdminController;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Tipo;
import Model.Usuario;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;

@ManagedBean
@ViewScoped

public class SolicitarRegistroBean implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String tipo;
    private Map<String, String> tipos;

    private OutputLabel labelCedula;
    private InputText txtCedula;

    private OutputLabel labelCorreoElectronico;
    private InputText txtCorreoElectronico;

    private OutputLabel labelNombres;
    private InputText txtNombres;

    private OutputLabel labelApellidos;
    private InputText txtApellidos;

    private OutputLabel labelCelular;
    private InputText txtCelular;

    private OutputLabel labelDireccion;
    private InputText txtDireccion;

    public SolicitarRegistroBean() {
    }

    public OutputLabel getLabelCedula() {
        return labelCedula;
    }

    public void setLabelCedula(OutputLabel labelCedula) {
        this.labelCedula = labelCedula;
    }

    public InputText getTxtCedula() {
        return txtCedula;
    }

    public OutputLabel getLabelCorreoElectronico() {
        return labelCorreoElectronico;
    }

    public void setLabelCorreoElectronico(OutputLabel labelCorreoElectronico) {
        this.labelCorreoElectronico = labelCorreoElectronico;
    }

    public InputText getTxtCorreoElectronico() {
        return txtCorreoElectronico;
    }

    public void setTxtCorreoElectronico(InputText txtCorreoElectronico) {
        this.txtCorreoElectronico = txtCorreoElectronico;
    }

    public OutputLabel getLabelNombres() {
        return labelNombres;
    }

    public void setLabelNombres(OutputLabel labelNombres) {
        this.labelNombres = labelNombres;
    }

    public InputText getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(InputText txtNombres) {
        this.txtNombres = txtNombres;
    }

    public OutputLabel getLabelApellidos() {
        return labelApellidos;
    }

    public void setLabelApellidos(OutputLabel labelApellidos) {
        this.labelApellidos = labelApellidos;
    }

    public InputText getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(InputText txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public OutputLabel getLabelCelular() {
        return labelCelular;
    }

    public void setLabelCelular(OutputLabel labelCelular) {
        this.labelCelular = labelCelular;
    }

    public InputText getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(InputText txtCelular) {
        this.txtCelular = txtCelular;
    }

    public OutputLabel getLabelDireccion() {
        return labelDireccion;
    }

    public void setLabelDireccion(OutputLabel labelDireccion) {
        this.labelDireccion = labelDireccion;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public void setTxtCedula(InputText txtCedula) {
        this.txtCedula = txtCedula;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Map<String, String> getTipos() {
        return tipos;
    }

    public void setTipos(Map<String, String> tipos) {
        this.tipos = tipos;
    }

    @PostConstruct
    public void init() {

        tipos = new HashMap<String, String>();

        TipoController tipoController = new TipoController();
        List<Tipo> lista = tipoController.listarTipos();

        for (int i = 0; i < lista.size(); i++) {
            tipos.put(lista.get(i).getDescripcion(), lista.get(i).getCodtipo().toString());
        }

    }

    public void onCountryChange() {

        if (tipo == null) {

        } else {

            if (tipo.equals("1")) {
                txtNombres.setDisabled(true);
                txtApellidos.setDisabled(true);
                txtCelular.setDisabled(true);
                txtDireccion.setDisabled(true);

            } else if (tipo.equals("2")) {
                txtNombres.setDisabled(false);
                txtApellidos.setDisabled(false);
                txtCelular.setDisabled(false);
                txtDireccion.setDisabled(false);

            }
        }

    }

    public void solicitarRegistro() {

        if (tipo == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Debe de seleccionar un rol."));
        } else {
            Validaciones v = new Validaciones();
            boolean valid = v.validateEmail(txtCorreoElectronico.getValue().toString());
            if (valid == true) {
                if (tipo.equals("1")) {
                    if (txtCedula.getValue().toString().equals("") || txtCorreoElectronico.getValue().toString().equals("")) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El campo cédula y correo electrónico son requeridos."));
                    } else {

                        //envio email
                        String tituloEmail = "Solicitud de registro Sistema de Facturación Web " + Statics.nombreApp;

                        String contenidoEmail
                                = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                                + " <h3 style='color: black;''>Un usuario ha solicitado un registro en el Sistema de Facturación Web " + Statics.nombreApp + "</h3>\n"
                                + " <p style='color: black;''>Sus datos son los siguientes: <br></br> Rol: Administrador <br> Cédula: " + txtCedula.getValue().toString().toUpperCase() + "<br> Correo electrónico: " + txtCorreoElectronico.getValue().toString() + " <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios!  </p>   <br>   </div>    </div>";

                        AdminController adminController = new AdminController();
                        List<Usuario> listaAdmins = adminController.listarAdmin();

                        for (int i = 0; i < listaAdmins.size(); i++) {

                            v.sendMailConfirmacion(listaAdmins.get(i).getEmail(), contenidoEmail, tituloEmail);
                        }
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Su solicitud de registro ha sido enviada correctamente."));
                    }
                } else if (tipo.equals("2")) {
                    if (txtCedula.getValue().toString().equals("") || txtCorreoElectronico.getValue().toString().equals("") || txtNombres.getValue().toString().equals("") || txtApellidos.getValue().toString().equals("") || txtCelular.getValue().toString().equals("") || txtDireccion.getValue().toString().equals("")) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son requeridos."));
                    } else {
                        //envio email

                        String tituloEmail = "Solicitud de registro Sistema de Facturación Web " + Statics.nombreApp;

                        String contenidoEmail
                                = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                                + " <h3 style='color: black;''>Un usuario ha solicitado un registro en el Sistema de Facturación Web " + Statics.nombreApp + "</h3>\n"
                                + " <p style='color: black;''>Sus datos son los siguientes: <br></br> Rol: Vendedor <br> Cédula: " + txtCedula.getValue().toString().toUpperCase() + "<br> Correo electrónico: " + txtCorreoElectronico.getValue().toString() + " <br> Nombres: " + txtNombres.getValue().toString().toUpperCase() + " <br> Apellidos: " + txtApellidos.getValue().toString().toUpperCase() + " <br> Celular: " + txtCelular.getValue().toString().toUpperCase() + " <br> Dirección: " + txtDireccion.getValue().toString().toUpperCase() + " <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios! </p>   <br>   </div>    </div>";

                        AdminController adminController = new AdminController();
                        List<Usuario> listaAdmins = adminController.listarAdmin();

                        for (int i = 0; i < listaAdmins.size(); i++) {

                            v.sendMailConfirmacion(listaAdmins.get(i).getEmail(), contenidoEmail, tituloEmail);
                        }
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Su solicitud de registro ha sido enviada correctamente."));
                    }
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Email es incorrecto."));
            }

        }
    }
}
