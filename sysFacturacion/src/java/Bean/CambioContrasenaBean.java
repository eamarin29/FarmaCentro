package Bean;

import ClasesAuxiliares.FiltroUrl;
import static ClasesAuxiliares.Statics.nombreApp;
import ClasesAuxiliares.Validaciones;
import Controller.UsuarioController;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import Model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.component.commandbutton.CommandButton;

/**
 *
 * @author Eduar
 */
@ManagedBean
@ViewScoped
public class CambioContrasenaBean implements Serializable {

    @ManagedProperty("#{usuarioBean}")
    private usuarioBean usuarioBean;

    private String cedulaAcambiar;
    private String codRegistroAcambiar;

    private String contraseñaNueva = "";
    private String contraseñaNuevaRepetir = "";
    private CommandButton pbutton;

    private HtmlForm formh;

    @PostConstruct
    public void Init() {

    }

    public HtmlForm getFormh() {

        Usuario us = new Usuario();
        UsuarioController usuarioController = new UsuarioController();
        us = usuarioController.consultarUsuarioPorCedulaAndCodigoRegistro(this.cedulaAcambiar, this.codRegistroAcambiar);
        if (us == null) {
            try {
                FacesContext contex = FacesContext.getCurrentInstance();
                contex.getExternalContext().redirect("/" + nombreApp);
            } catch (IOException ex) {
                Logger.getLogger(CambioContrasenaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

        return formh;
    }

    public void setFormh(HtmlForm formh) {
        this.formh = formh;
    }

    public CambioContrasenaBean() {

    }

    public CommandButton getPbutton() {
        return pbutton;
    }

    public void setPbutton(CommandButton pbutton) {
        this.pbutton = pbutton;
    }

    public String getCedulaAcambiar() {
        return cedulaAcambiar;
    }

    public void setCedulaAcambiar(String cedulaAcambiar) {
        this.cedulaAcambiar = cedulaAcambiar;
    }

    public String getCodRegistroAcambiar() {
        return codRegistroAcambiar;
    }

    public void setCodRegistroAcambiar(String codRegistroAcambiar) {
        this.codRegistroAcambiar = codRegistroAcambiar;
    }

    public String getContraseñaNueva() {
        return contraseñaNueva;
    }

    public void setContraseñaNueva(String contraseñaNueva) {
        this.contraseñaNueva = contraseñaNueva;
    }

    public String getContraseñaNuevaRepetir() {
        return contraseñaNuevaRepetir;
    }

    public void setContraseñaNuevaRepetir(String contraseñaNuevaRepetir) {
        this.contraseñaNuevaRepetir = contraseñaNuevaRepetir;
    }

    public usuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(usuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public void cambiar() {

        if (this.contraseñaNueva.equals("") || this.contraseñaNuevaRepetir.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Las contraseñas no pueden quedar vacias."));
        } else {
            if (this.contraseñaNueva.equals(this.contraseñaNuevaRepetir)) {

                Usuario user = new Usuario();
                UsuarioController usuarioController = new UsuarioController();
                user = usuarioController.consultarUsuarioPorCedulaAndCodigoRegistro(this.cedulaAcambiar, this.codRegistroAcambiar);

                if (user == null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ocurrió un error."));
                } else {
                    Validaciones v = new Validaciones();
                    boolean contrasenaSegura = v.validarPassword(this.contraseñaNuevaRepetir);
                    if (contrasenaSegura == true) {
                        String contraseñaEncriptadaNueva = DigestUtils.sha512Hex(this.contraseñaNuevaRepetir);
                        user.setPassword(contraseñaEncriptadaNueva);
                        String aleatorio = v.getCadenaAlfanumAleatoria(180);
                        user.setCodregistro(aleatorio);
                        usuarioController.updateUsuario(user);

                        //redirecciono
                        try {
                            FacesContext contex = FacesContext.getCurrentInstance();
                            String aleatorio2 = v.getCadenaAlfanumAleatoria(100);
                            usuarioBean.aleatorio2 = aleatorio2;
                            contex.getExternalContext().redirect("/" + nombreApp + "?par=" + aleatorio2);
                        } catch (IOException ex) {
                            Logger.getLogger(FiltroUrl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        String mensajeContraseñaInsegura = "La contraseña debe de contener al menos:\n1 letra mayuscula, 1 letra minuscula, 1 numero y su longuitud de mínimo 8 caracteres.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", mensajeContraseñaInsegura));
                    }
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Las contraseñas no coinciden."));
            }
        }

    }

}
