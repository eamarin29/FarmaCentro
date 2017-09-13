package Bean;

import ClasesAuxiliares.Statics;
import static ClasesAuxiliares.Statics.direccionIp;
import static ClasesAuxiliares.Statics.nombreApp;
import static ClasesAuxiliares.Statics.puerto;
import ClasesAuxiliares.Validaciones;
import Controller.ProductoController;
import Controller.UsuarioController;
import Controller.VendedorController;
import Model.Producto;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import Model.Usuario;
import Model.Vendedor;
import org.primefaces.context.RequestContext;
import java.io.Serializable;
import java.math.BigDecimal;
import org.primefaces.component.commandbutton.CommandButton;

@ManagedBean
@SessionScoped
public class usuarioBean implements Serializable {

    private String username; //input usuario
    private String password; //input password
    private String cambioContrasena; //variable que almacena el valor de par (si el usuario acabo de cambiar su contraseña)
    private CommandButton btnLogin; //btn de iniciar sesion

    //capturar el nombre del usuario logueado
    public String cedulaUsuarioLogueado;
    private String nombreUsuarioLogueado;

    public Integer numeroTipoLogueado = 0; //capturamos el tipo logueado

    public String aleatorio2;  //variable para validar si la pagina viene de un cambio de contraseña

    public Usuario usuario;

    @PostConstruct
    public void Init() {
        this.usuario = new Usuario();
    }

    public usuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAleatorio2() {
        return aleatorio2;
    }

    public void setAleatorio2(String aleatorio2) {
        this.aleatorio2 = aleatorio2;
    }

    public String getCambioContrasena() {
        return cambioContrasena;
    }

    public void setCambioContrasena(String cambioContrasena) {
        this.cambioContrasena = cambioContrasena;
    }

    public CommandButton getBtnLogin() {

        //iniciar sistema
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.iniciarSistema();

        if (this.aleatorio2 == null || this.cambioContrasena == null) {

        } else if (!this.aleatorio2.equals("") && !this.cambioContrasena.equals("")) {
            if (this.aleatorio2.equals(this.cambioContrasena)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Su contraseña se guardó satisfactoriamente."));
                this.aleatorio2 = "";
                this.cambioContrasena = "";
            } else {

            }
        }
        
        //Mensaje de productos vencidos
        ProductoController ProductoController = new ProductoController();
        Producto pVencido = new Producto();
        pVencido = ProductoController.verificarProductosVencidos();
        
        if(pVencido == null){
        }else{
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Existen productos vencidos en el inventario. Consultar reporte"));
        }
        
        return btnLogin;
    }

    public void setBtnLogin(CommandButton btnLogin) {
        this.btnLogin = btnLogin;
    }

    public int getNumeroTipoLogueado() {
        return numeroTipoLogueado;
    }

    public void setNumeroTipoLogueado(int numeroTipoLogueado) {
        this.numeroTipoLogueado = numeroTipoLogueado;
    }

    public String getCedulaUsuarioLogueado() {
        return cedulaUsuarioLogueado;
    }

    public void setCedulaUsuarioLogueado(String cedulaUsuarioLogueado) {
        this.cedulaUsuarioLogueado = cedulaUsuarioLogueado;
    }

    public String getNombreUsuarioLogueado() {
        return nombreUsuarioLogueado;
    }

    public void setNombreUsuarioLogueado(String nombreUsuarioLogueado) {
        this.nombreUsuarioLogueado = nombreUsuarioLogueado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {

        RequestContext context = RequestContext.getCurrentInstance();
        boolean loggedIn = false;

        if (username == null || password == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Usuario y Contraseña son requeridos."));
        } else {

            if (username.equals("") || password.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Usuario y Contraseña son requeridos."));
            } else {
                UsuarioController usuarioController = new UsuarioController();
                VendedorController vendedorController = new VendedorController();

                this.usuario = usuarioController.login(this.username, this.password);
                if (this.usuario != null) {
                    if (usuario.getValidado().equals("S")) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipo", usuario.getTipo().getCodtipo().intValue());
                        setNumeroTipoLogueado(usuario.getTipo().getCodtipo().intValue());
                        setCedulaUsuarioLogueado(usuario.getCedula());
                        System.out.println("--La cedula del usuario logueado es: " + usuario.getCedula());
                        BigDecimal tipo_admin = new BigDecimal(1);
                        if (usuario.getTipo().getCodtipo().equals(tipo_admin)) {
                            try {
                                this.nombreUsuarioLogueado = "Admin";
                                loggedIn = true;
                                FacesContext contex = FacesContext.getCurrentInstance();
                                contex.getExternalContext().redirect("/" + Statics.nombreApp + "/faces/Views/bienvenido.xhtml");
                            } catch (Exception ex) {
                                System.out.println("--Error : " + ex.getMessage());
                            }
                        } else if (usuario.getTipo().getCodtipo().equals(new BigDecimal(2))) {
                            Vendedor vendedorLogueado = new Vendedor();
                            vendedorLogueado = vendedorController.consultarVendedorPorCedula(usuario.getCedula());
                            if (vendedorLogueado != null) {
                                try {
                                    this.nombreUsuarioLogueado = vendedorLogueado.getNombres();
                                    this.cedulaUsuarioLogueado = vendedorLogueado.getUsuario().getCedula();
                                    loggedIn = true;
                                    //redirecciono
                                    FacesContext contex = FacesContext.getCurrentInstance();
                                    contex.getExternalContext().redirect("/" + Statics.nombreApp + "/faces/Views/bienvenido.xhtml");
                                } catch (IOException ex) {
                                    Logger.getLogger(usuarioBean.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                System.out.println("--Error");
                            }
                        }
                    } else {
                        loggedIn = false;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Por favor revise su correo electrónico para continuar con la validación de su cuenta."));
                    }
                } else {
                    loggedIn = false;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Las credenciales son incorrectas."));
                }
                context.addCallbackParam("loggedIn", loggedIn);
            }
        }
    }

    public int añoActual() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        return año;
    }

    public String nombreApp() {
        String nombreApp = Statics.nombreApp;
        return nombreApp;
    }

    public void cerrarSesion() {

        try {
            this.username = null;
            this.password = null;
            this.usuario = null;

            HttpSession httpsession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            httpsession.invalidate();
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/" + Statics.nombreApp + "");
        } catch (IOException ex) {
            Logger.getLogger(usuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void olvideContrasena() {

        if (username == null || username.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ingrese su Usuario para ayudarle a recuperar su contraseña."));
        } else {
            Usuario usu = new Usuario();
            usu = this.emailAenviarOlvideContrasena();

            if (usu == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El usuario ingresado no existe en el sistema."));
            } else {

                String tituloEmail = "Cambio de contraseña Sistema de Facturación Web";
                String contenidoEmail
                        = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                        + " <h3 style='color: black;''>La cuenta del Sistema de Facturación Web " + Statics.nombreApp + " asociada a este email, ha solicitado un cambio de contraseña</h3>\n"
                        + " <p style='color: black;''>Para realizar su cambio de contraseña por favor haga click <a href=\"http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/CambioContrasena?usuario=" + usu.getCedula() + "&aleatorio=" + usu.getCodregistro() + "\">Aqui</a> <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios! </p>   <br>   </div>    </div>";

                Validaciones v = new Validaciones();
                v.sendMailConfirmacion(usu.getEmail(), contenidoEmail, tituloEmail);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa!:", "Ingrese a su correo electrónico y siga los pasos correspondientes."));
            }
        }
    }

    public Usuario emailAenviarOlvideContrasena() {

        Usuario us = new Usuario();
        UsuarioController usuarioController = new UsuarioController();
        us = usuarioController.consultarUsuarioPorCedula(username);

        if (us == null) {
            us = usuarioController.consultarUsuarioPorEmail(username);
            if (us == null) {
                us = null;
            } else {

            }
        } else {

        }

        return us;
    }

    public void cerrarSesionAndRedirigirAServletCambioEmail() {

        try {
            this.username = null;
            this.password = null;
            this.usuario = null;

            HttpSession httpsession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            httpsession.invalidate(); //para borrar la sessioon
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/" + Statics.nombreApp + "/cambio-email");
        } catch (IOException ex) {
            Logger.getLogger(usuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarDatosSesion() {

        this.username = null;
        this.password = null;
        this.usuario = null;

        HttpSession httpsession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpsession.invalidate(); //para borrar la sessioon

    }

    public void solicitarRegistro() {

        try {
            //redirecciono
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/" + Statics.nombreApp + "/faces/Views/solicitarRegistro.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(usuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
