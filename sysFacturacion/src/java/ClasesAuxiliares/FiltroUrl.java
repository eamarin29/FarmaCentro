package ClasesAuxiliares;

import static ClasesAuxiliares.Statics.nombreApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class FiltroUrl implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {

        FacesContext context = event.getFacesContext();

        //capturamos el nombre de la pagina actual
        String currenPagina = context.getViewRoot().getViewId();

        //en una variable booleana capturamos si es la pagina de login (true si es login)
        boolean isPaginaLogin = currenPagina.lastIndexOf("login.xhtml") > -1 ? true : false;
        boolean isCambioContrasena = currenPagina.equals("/Views/cambiarContrasena.xhtml");
        boolean isSolitarRegistro = currenPagina.equals("/Views/solicitarRegistro.xhtml");


        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        Object tipo = session.getAttribute("tipo");

        //si no es la pagina login la que esta intentando acceder y no esta logueado, lo mandamos al login
        if (!isPaginaLogin && tipo == null) {

            if (isCambioContrasena || isSolitarRegistro) {
             
            } else {
                try {
                    //redirecciono a login
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("/" + nombreApp);

                } catch (IOException ex) {
                    Logger.getLogger(FiltroUrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (tipo != null && isPaginaLogin) {
            try {
                //redirecciono a bienvenido 
                FacesContext contex = FacesContext.getCurrentInstance();
                contex.getExternalContext().redirect("/" + nombreApp + "/faces/Views/bienvenido.xhtml");

            } catch (IOException ex) {
                Logger.getLogger(FiltroUrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (tipo != null) {
            int numTipo = (int) tipo;
            if (numTipo == 2) {
                if (currenPagina.equals("/Views/Cliente/Cliente.xhtml") || currenPagina.equals("/Views/Producto/Producto.xhtml") || currenPagina.equals("/Views/Vendedor/Vendedor.xhtml") || currenPagina.equals("/Views/Administrador/Administrador.xhtml") || currenPagina.equals("/Views/Facturas/Facturas.xhtml") || currenPagina.equals("/Views/Parametros/Parametros.xhtml")) {
                    try {
                        //acceso denegado
                        FacesContext contex = FacesContext.getCurrentInstance();
                        contex.getExternalContext().redirect("/" + nombreApp + "/faces/Views/restringido.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(FiltroUrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (numTipo == 1) {
                if (currenPagina.equals("/Views/Venta/Factura.xhtml")) {
                    try {
                        //acceso denegado
                        FacesContext contex = FacesContext.getCurrentInstance();
                        contex.getExternalContext().redirect("/" + nombreApp + "/faces/Views/restringido.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(FiltroUrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
