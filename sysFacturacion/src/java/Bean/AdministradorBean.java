package Bean;

import ClasesAuxiliares.Statics;
import static ClasesAuxiliares.Statics.*;
import ClasesAuxiliares.Validaciones;
import Controller.AdministradorController;
import Controller.UsuarioController;
import Model.Producto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Tipo;
import Model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class AdministradorBean implements Serializable {

    @ManagedProperty("#{usuarioBean}")
    private usuarioBean usuarioBean;

    private Usuario usuario;
    private Usuario usuarioViejo;

    private List<Usuario> listaAdmin;

    private String email = "";
    private String contraseñaIngresada = "";
    private String verificarContraseñaIngresada = "";

    private String emailAntiguo;

    private List<Usuario> filtroAdmins;
    
    public AdministradorBean() {
    }

    @PostConstruct
    public void Init() {
        usuario = new Usuario();
    }

    public List<Usuario> getFiltroAdmins() {
        return filtroAdmins;
    }

    public void setFiltroAdmins(List<Usuario> filtroAdmins) {
        this.filtroAdmins = filtroAdmins;
    }

    public String getEmailAntiguo() {
        return emailAntiguo;
    }

    public void setEmailAntiguo(String emailAntiguo) {
        this.emailAntiguo = emailAntiguo;
    }

    public usuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(usuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseñaIngresada() {
        return contraseñaIngresada;
    }

    public void setContraseñaIngresada(String contraseñaIngresada) {
        this.contraseñaIngresada = contraseñaIngresada;
    }

    public String getVerificarContraseñaIngresada() {
        return verificarContraseñaIngresada;
    }

    public void setVerificarContraseñaIngresada(String verificarContraseñaIngresada) {
        this.verificarContraseñaIngresada = verificarContraseñaIngresada;
    }

    public List<Usuario> getListaAdmin() {
        AdministradorController aDao = new AdministradorController();
        listaAdmin = aDao.listarAdmin();
        return listaAdmin;
    }

    public void setListaAdmin(List<Usuario> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioViejo() {
        return usuarioViejo;
    }

    public void setUsuarioViejo(Usuario usuarioViejo) {
        this.usuarioViejo = usuarioViejo;
    }

    public void prepararNuevoAdmin() {
        usuario = new Usuario();
    }

    public void nuevoAdmin() {

        //verifico que no esten vacios ninguno de los campos
        if (usuario.getCedula().equals("") || email.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
        }  else {
            try {

                //verifico que no exista repetido 
                UsuarioController usuarioController = new UsuarioController();
                usuarioViejo = usuarioController.consultarUsuarioPorCedula(usuario.getCedula());

                Usuario usuarioConEmail = new Usuario();
                usuarioConEmail = usuarioController.consultarUsuarioPorEmail(email);

                //verifico que no exista un usuario con esa cedula
                if (usuarioViejo == null) {

                    //valido que el email no esté ya registrado
                    if (usuarioConEmail == null) {
                        //continue registrandolo
                        Validaciones v = new Validaciones();
                        //se guarda usuario
                        //valido email
                        boolean valid = v.validateEmail(email);
                        if (valid == true) {
                            //el email es valido 
                            //verifico que la contraseña cumpla la longuitud de seguridad

                                //cumple

                                //encripto contraseña 
                                String encriptSha512 = DigestUtils.sha512Hex(Statics.nombreApp);
                                usuario.setPassword(encriptSha512);
                                usuario.setEmail(email);
                                Tipo tipo = new Tipo();
                                tipo.setCodtipo(new BigDecimal(1));
                                usuario.setTipo(tipo);
                                usuario.setValidado("N");
                                String aleatorio = v.getCadenaAlfanumAleatoria(180);
                                usuario.setCodregistro(aleatorio);

                                //guardo el usuario
                                UsuarioController usuContro = new UsuarioController();
                                usuContro.newUsuario(usuario);

                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dialogNuevoAdmin').hide();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Administrador se ha registrado correctamente."));

                                //envio email
                                String tituloEmail = "Bienvenido al Sistema de Facturación Web "+Statics.nombreApp;

                                String contenidoEmail
                                        = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                                        + " <h3 style='color: black;''>Activar su cuenta en Sistema de Facturación Web "+Statics.nombreApp+" </h3>\n"
                                        + " <p style='color: black;''>Usted se ha registrado como Administrador del Sistema de Facturación Web "+Statics.nombreApp+". <br></br> Su nombre de Usuario es su número de cédula o su correo electrónico  <br></br> Y su contraseña por defecto es: "+Statics.nombreApp+". <br></br>Para activar su cuenta y poder iniciar sesión con las sus credenciales ingresadas en el proceso de registro <br> o por las credenciales que se le ha proporcionado, por favor haga click <a href=\"http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/ActivacionCuenta?usuario=" + usuario.getCedula() + "&aleatorio=" + aleatorio + "\">Aqui</a> <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios! </p>   <br>   </div>    </div>";

                                v.sendMailConfirmacion(usuario.getEmail(), contenidoEmail, tituloEmail);

                                //reinicio las variables y objetos    
                                usuario = new Usuario();
                                usuarioViejo = new Usuario();
                                contraseñaIngresada = "";
                                verificarContraseñaIngresada = "";
                                email="";
                                emailAntiguo="";


                        } else {
                            //email no es valido
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El email no es valido."));
                        }
                    } else {
                        //no se registra
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El email ingresado ya se encuentra registrado en el sistema."));
                    }

                } else {
                    //no se guarda
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ya se encuentra un Usuario registrado con la cédula ingresada."));

                }

                usuario = new Usuario();
                usuarioViejo = new Usuario();
                contraseñaIngresada = "";
                verificarContraseñaIngresada = "";
            } catch (Exception ex) {
                usuario = new Usuario();
                usuarioViejo = new Usuario();
                contraseñaIngresada = "";
                verificarContraseñaIngresada = "";
                Logger.getLogger(VendedorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificarAdmin() {

        //valido que hizo cambios
        if (this.emailAntiguo.equals(usuario.getEmail())) {
            //no hizo cambios
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogModificarAdmin').hide();");
        } else {
            //Si lo cambió
            if (usuario.getValidado().equals("S")) {

                //actualicelo
                if (usuario.getEmail().equals("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                } else {

                    //valido email
                    Validaciones v = new Validaciones();
                    boolean valid = v.validateEmail(usuario.getEmail());

                    if (valid == true) {

                        try {
                            //valido de que el nuevo email no esté repetido
                            UsuarioController usuarioController = new UsuarioController();
                            Usuario usuarioConEmail = new Usuario();
                            usuarioConEmail = usuarioController.consultarUsuarioPorEmail(usuario.getEmail());
                            if (usuarioConEmail == null) {
                                //puede actualizarlo
                                //el email es valido
                                //actualizo usuario
                                String aleatorio = v.getCadenaAlfanumAleatoria(180);
                                usuario.setValidado("N");
                                usuario.setCodregistro(aleatorio);
                                UsuarioController usuContro = new UsuarioController();
                                usuContro.updateUsuario(usuario);

                                //envio email de cambio de email
                                String tituloEmail = "Modificación Administrador del Sistema de Facturación Web "+nombreApp;
                                String contenidoEmail
                                        = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                                        + " <h3 style='color: black;''>Activar su cuenta en Sistema de Facturación Web "+Statics.nombreApp+" </h3>\n"
                                        + " <p style='color: black;''>Se ha modificado el email del Administrador del Sistema de Facturación Web "+Statics.nombreApp+" con cédula: " + usuario.getCedula() + " a este email.  <br></br>Para activar su cuenta y poder iniciar sesión con sus nuevas credenciales  por favor haga click <a href=\"http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/ActivacionCuenta?usuario=" + usuario.getCedula() + "&aleatorio=" + aleatorio + "\">Aqui</a> <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios! </p>   <br>   </div>    </div>";

                                v.sendMailConfirmacion(usuario.getEmail(), contenidoEmail, tituloEmail);

                                //valido si el cambio de email es el usuario logueado
                                if (usuarioBean.cedulaUsuarioLogueado.equals(usuario.getCedula())) {
                                    //cierro session
                                    usuarioBean.cerrarSesionAndRedirigirAServletCambioEmail();
                                } else {
                                    //no cierro session
                                    RequestContext context = RequestContext.getCurrentInstance();
                                    context.execute("PF('dialogModificarAdmin').hide();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Administrador se ha modificado correctamente."));
                                    usuario = new Usuario();
                                }

                            } else {
                                //no se actualiza
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El email ingresado ya se encuentra registrado en el sistema."));
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(AdministradorBean.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        //el email no es valido
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Email no es válido."));
                    }
                }

            } else {
                //No se puede actualizar
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Este Administrador todavia no ha confirmado su email de registro."));

            }
        }

    }

    public void eliminarAdmin() {

        if (usuarioBean.cedulaUsuarioLogueado.equals(usuario.getCedula())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Usuario que intenta eliminar es el usuario logueado en estos momentos, no se puede eliminar."));
        } else {

            //mando email de aviso de eliminacion
            Validaciones v = new Validaciones();
            String tituloEmail = "Cuenta Administrador del Sistema de Facturación Web "+Statics.nombreApp+" Eliminada";
            String contenidoEmail
                    = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                    + " <h3 style='color: black;''>Su cuenta en Sistema de Facturación Web "+Statics.nombreApp+" ha sido eliminada</h3>\n"
                    + " <p style='color: black;''>Se ha eliminado la cuenta del Administrador del Sistema de Facturación Web "+Statics.nombreApp+" con cédula: " + usuario.getCedula() + ". <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios! </p>   <br>   </div>    </div>";

            v.sendMailConfirmacion(usuario.getEmail(), contenidoEmail, tituloEmail);

            //elimino usuario
            UsuarioController usuContro = new UsuarioController();
            usuContro.deleteUsuario(usuario);

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarAdmin').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Administrador se ha eliminado correctamente."));

            //inicializo
            usuario = new Usuario();
        }
    }

    public void prepararModificacionAdmin() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogModificarAdmin').show();");
        this.emailAntiguo = usuario.getEmail();

    }

}
