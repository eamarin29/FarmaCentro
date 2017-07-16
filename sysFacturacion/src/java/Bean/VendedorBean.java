package Bean;

import ClasesAuxiliares.Statics;
import static ClasesAuxiliares.Statics.*;
import ClasesAuxiliares.Validaciones;
import Controller.UsuarioController;
import Controller.VendedorController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Tipo;
import Model.Usuario;
import Model.Vendedor;
import org.primefaces.context.RequestContext;
import org.apache.commons.codec.digest.DigestUtils;
import javax.faces.bean.ManagedProperty;
import Model.Cliente;

@ManagedBean
@ViewScoped
public class VendedorBean implements Serializable {

    @ManagedProperty("#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private Usuario usuarioViejo;
    private List<Vendedor> filtroVendedores;

    private List<Vendedor> listaVendedores;
    private Vendedor vendedor;
    private Usuario usuario;

    private String password;
    private String verificarPassword;

    private String emailAntiguo;

    public VendedorBean() {
    }

    @PostConstruct
    public void Init() {
        vendedor = new Vendedor();
        usuarioViejo = new Usuario();
        usuario = new Usuario();
    }

    public List<Vendedor> getFiltroVendedores() {
        return filtroVendedores;
    }

    public void setFiltroVendedores(List<Vendedor> filtroVendedores) {
        this.filtroVendedores = filtroVendedores;
    }

    public String getEmailAntiguo() {
        return emailAntiguo;
    }

    public void setEmailAntiguo(String emailAntiguo) {
        this.emailAntiguo = emailAntiguo;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificarPassword() {
        return verificarPassword;
    }

    public void setVerificarPassword(String verificarPassword) {
        this.verificarPassword = verificarPassword;
    }

    public Usuario getUsuario() {
        return usuario;
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

    public List<Vendedor> getListaVendedores() {
        VendedorController vendedorController = new VendedorController();
        listaVendedores = vendedorController.listarVendedores();
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void prepararNuevoVendedor() {
        vendedor = new Vendedor();
    }

    public void nuevoVendedor() {

        //verifico que no esten vacios ninguno de los campos
        if (usuario.getCedula().equals("") || usuario.getEmail().equals("") || vendedor.getNombres().equals("") || vendedor.getApellidos().equals("") || vendedor.getCelular().equals("") || vendedor.getDireccion().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
        } else {

            vendedor.setNombres(vendedor.getNombres().toUpperCase());
            vendedor.setApellidos(vendedor.getApellidos().toUpperCase());
            vendedor.setDireccion(vendedor.getDireccion().toUpperCase());

            try {

                VendedorController vendedorController = new VendedorController();
                UsuarioController usuarioController = new UsuarioController();
                usuarioViejo = usuarioController.consultarUsuarioPorCedula(usuario.getCedula());

                if (usuarioViejo == null) {
                    Validaciones v = new Validaciones();
                    boolean valid = v.validateEmail(usuario.getEmail());
                    if (valid == true) {

                        //valido que el nuevo vendedor no se registre con un email ya registrado
                        Usuario usuarioConEmail = new Usuario();
                        usuarioConEmail = usuarioController.consultarUsuarioPorEmail(usuario.getEmail());

                        if (usuarioConEmail == null) {

                            String encriptSha512 = DigestUtils.sha512Hex(Statics.nombreApp);
                            usuario.setPassword(encriptSha512);
                            Tipo tipo = new Tipo();
                            tipo.setCodtipo(new BigDecimal(2));
                            usuario.setTipo(tipo);
                            usuario.setValidado("N");
                            String aleatorio = v.getCadenaAlfanumAleatoria(180);
                            usuario.setCodregistro(aleatorio);

                            //guardo el usuario
                            usuarioController.newUsuario(usuario);

                            //se guarda vendedor
                            vendedor.setCedula(usuario.getCedula());
                            vendedor.setUsuario(usuario);
                            vendedorController.newVendedor(vendedor);

                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('dialogNuevoVendedor').hide();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El vendedor se ha registrado correctamente."));

                            //envio email
                            String tituloEmail = "Bienvenido al Sistema de Facturación Web";

                            String contenidoEmail
                                    = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                                    + " <h3 style='color: black;''>Activar su cuenta en el Sistema de Facturación Web " + Statics.nombreApp + ".</h3>\n"
                                    + " <p style='color: black;''>Usted se ha registrado como Vendedor del Sistema de Facturación Web " + Statics.nombreApp + ". <br></br>Su nombre de usuarios es: La dirección de su correo electrónico o el número de su cédula <br>Su contraseña es: " + Statics.nombreApp + ". <br> Para activar su cuenta e iniciar sesión, por favor haga click <a href=\"http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/ActivacionCuenta?usuario=" + usuario.getCedula() + "&aleatorio=" + aleatorio + "\">Aqui</a> <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios! </p>   <br>   </div>    </div>";

                            v.sendMailConfirmacion(usuario.getEmail(), contenidoEmail, tituloEmail);

                            //inicializo 
                            vendedor = new Vendedor();
                            usuario = new Usuario();
                            usuarioViejo = new Usuario();
                            password = "";
                            verificarPassword = "";

                        } else {
                            //no se puede agregar
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El email ingresado ya se encuentra registrado en el sistema."));
                        }

                    } else {
                        //email no es valido
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El email no es valido."));
                    }
                } else {
                    //no se guarda
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ya se encuentra un Usuario registrado con la cédula ingresada."));
                }
                vendedor = new Vendedor();
                usuario = new Usuario();
                usuarioViejo = new Usuario();
                password = "";
                verificarPassword = "";
            } catch (Exception ex) {
                vendedor = new Vendedor();
                usuario = new Usuario();
                usuarioViejo = new Usuario();
                password = "";
                verificarPassword = "";
                Logger.getLogger(VendedorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificarVendedor() {

        if (vendedor.getUsuario().getValidado().equals("S")) {
            if (this.emailAntiguo.equals(vendedor.getUsuario().getEmail())) {
                //no hizo cambios en el email
                if (vendedor.getNombres().equals("") || vendedor.getApellidos().equals("") || vendedor.getCelular().equals("") || vendedor.getDireccion().equals("") || vendedor.getUsuario().getEmail().equals("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                } else {

                    vendedor.setNombres(vendedor.getNombres().toUpperCase());
                    vendedor.setApellidos(vendedor.getApellidos().toUpperCase());
                    vendedor.setDireccion(vendedor.getDireccion().toUpperCase());

                    usuario = new Usuario();
                    UsuarioController usuarioController = new UsuarioController();

                    usuario.setCedula(vendedor.getUsuario().getCedula());
                    usuario.setPassword(vendedor.getUsuario().getPassword());
                    usuario.setEmail(vendedor.getUsuario().getEmail());
                    Tipo tipo = new Tipo();
                    tipo.setCodtipo(new BigDecimal(2));
                    usuario.setTipo(tipo);
                    usuario.setValidado("S");
                    usuario.setCodregistro("ggg");

                    //actualizo
                    usuarioController.updateUsuario(usuario);

                    //actualizo vendedor
                    VendedorController vDao = new VendedorController();
                    vDao.updateVendedor(vendedor);

                    //los inicializo de nuevo
                    vendedor = new Vendedor();
                    usuario = new Usuario();
                    password = "";
                    verificarPassword = "";

                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogModificarVendedor').hide();");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El vendedor se ha modificado correctamente."));

                }
                vendedor = new Vendedor();
                usuario = new Usuario();
                usuarioViejo = new Usuario();
                password = "";
                verificarPassword = "";

            } else {
                //hizo cambios en email
                if (vendedor.getNombres().equals("") || vendedor.getApellidos().equals("") || vendedor.getCelular().equals("") || vendedor.getDireccion().equals("") || vendedor.getUsuario().getEmail().equals("")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                } else {

                    //valido email
                    Validaciones v = new Validaciones();
                    boolean valid = v.validateEmail(vendedor.getUsuario().getEmail());

                    if (valid == true) {

                        try {
                            //valido si el email nuevo no se ha registrado
                            Usuario usuarioConEmail = new Usuario();
                            UsuarioController usuarioController = new UsuarioController();
                            usuarioConEmail = usuarioController.consultarUsuarioPorEmail(vendedor.getUsuario().getEmail());

                            if (usuarioConEmail == null) {
                                //continue
                                //el email es valido
                                //actualizo usuario
                                usuario = new Usuario();
                                UsuarioController usuContro = new UsuarioController();
                                usuario.setCedula(vendedor.getUsuario().getCedula());
                                usuario.setPassword(vendedor.getUsuario().getPassword());
                                usuario.setEmail(vendedor.getUsuario().getEmail());
                                Tipo tipo = new Tipo();
                                tipo.setCodtipo(new BigDecimal(2));
                                usuario.setTipo(tipo);
                                usuario.setValidado("N");
                                String aleatorio = v.getCadenaAlfanumAleatoria(180);
                                usuario.setCodregistro(aleatorio);

                                //envio email de cambio de email
                                String tituloMensaje = "Modificación Vendedor del Sistema de Facturación Web";
                                String contenidoEmail
                                        = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                                        + " <h3 style='color: black;''>Activar su cuenta en Sistema de Facturación Web " + Statics.nombreApp + ".</h3>\n"
                                        + " <p style='color: black;''>Se ha modificado el email del Vendedor del Sistema de Facturación Web " + Statics.nombreApp + " con cédula: " + vendedor.getUsuario().getCedula() + " a este email.  <br></br>Para activar su cuenta y poder iniciar sesión con su nuevo correo electrónico por favor haga click <a href=\"http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/ActivacionCuenta?usuario=" + vendedor.getUsuario().getCedula() + "&aleatorio=" + aleatorio + "\">Aqui</a> <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios!  </p>   <br>   </div>    </div>";

                                v.sendMailConfirmacion(usuario.getEmail(), contenidoEmail, tituloMensaje);

                                //actualizo
                                usuContro.updateUsuario(usuario);

                                //actualizo vendedor
                                VendedorController vDao = new VendedorController();
                                vDao.updateVendedor(vendedor);

                                //los inicializo de nuevo
                                vendedor = new Vendedor();
                                usuario = new Usuario();
                                password = "";
                                verificarPassword = "";

                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dialogModificarVendedor').hide();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El vendedor se ha modificado correctamente."));

                                this.vendedor = new Vendedor();
                                this.usuario = new Usuario();
                                this.usuarioViejo = new Usuario();
                                this.password = "";
                                this.verificarPassword = "";

                            } else {
                                //el email nuevo ya está registrado
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Email ingresado ya se encuentra registrado en el sistema."));

                            }
                        } catch (Exception ex) {
                            Logger.getLogger(VendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        //el email no es valido
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Email no es válido."));
                    }
                }
            }
        } else {
            //no lo ha validado
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El vendedor que intenta modificar no ha validado su email."));
        }

    }

    public void eliminarVendedor() {

        if (usuarioBean.cedulaUsuarioLogueado.equals(vendedor.getUsuario().getCedula())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Usuario que intenta eliminar es el usuario logueado en estos momentos, no se puede eliminar."));
        } else {
            //elimino vendedor
            VendedorController vDao = new VendedorController();
            int eliminarVendedor = vDao.deleteVendedor(vendedor);
            if (eliminarVendedor == 0) {
                //se elimina
                //elimino usuario
                UsuarioController usuContro = new UsuarioController();
                usuario.setCedula(vendedor.getUsuario().getCedula());
                usuario.setPassword(vendedor.getUsuario().getPassword());
                usuario.setEmail(vendedor.getUsuario().getEmail());
                Tipo tipo = new Tipo();
                tipo.setCodtipo(new BigDecimal(2));
                usuario.setTipo(tipo);

                if (vendedor.getUsuario().getValidado().equals("S")) {

                    //mando email de aviso de eliminacion
                    Validaciones v = new Validaciones();
                    String tituloEmail = "Cuenta Vendedor del Sistema de Facturación Web Eliminada";
                    String contenidoEmail
                            = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                            + " <h3 style='color: black;''>Su cuenta en Sistema de Facturación Web ha sido eliminada</h3>\n"
                            + " <p style='color: black;''>Se ha eliminado la cuenta del Vendedor del Sistema de Facturación Web con cédula: " + vendedor.getUsuario().getCedula() + ".  <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios!  </p>   <br>   </div>    </div>";

                    v.sendMailConfirmacion(usuario.getEmail(), contenidoEmail, tituloEmail);
                } else {

                }

                //elimino usuario
                usuContro.deleteUsuario(usuario);

                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogEliminarVendedor').hide();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Vendedor se ha eliminado correctamente."));

                //inicializo
                vendedor = new Vendedor();
                usuario = new Usuario();
                password = "";
                verificarPassword = "";
            } else {
                //no se elimina
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogEliminarVendedor').hide();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El vendedor no puede eliminarse, puede que esté asociado a una factura."));

                //inicializo
                vendedor = new Vendedor();
                usuario = new Usuario();
                password = "";
                verificarPassword = "";
            }
        }
    }

    public void prepararModificacionVendedor() {

        if (vendedor.getUsuario().getValidado().equals("S")) {

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogModificarVendedor').show();");
            this.emailAntiguo = vendedor.getUsuario().getEmail();

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El vendedor que intenta modificar no ha validado su email."));

        }

    }
}
