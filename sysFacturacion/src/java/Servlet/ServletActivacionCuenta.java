package Servlet;

import ClasesAuxiliares.Statics;
import Controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import static ClasesAuxiliares.Statics.*;

/**
 * Servlet implementation class ServletActivacionCuenta
 */
public class ServletActivacionCuenta extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActivacionCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @SuppressWarnings("ConvertToTryWithResources")
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        try {
            String cedula = request.getParameter("usuario");
            String codRegistro = request.getParameter("aleatorio");

            //realizo la consulta
            String hql = "FROM Usuario WHERE cedula=:codUsuario AND codRegistro=:codRegistro AND validado='N'";
            Query q = session.createQuery(hql);

            q.setParameter("codUsuario", cedula);
            q.setParameter("codRegistro", codRegistro);

            @SuppressWarnings("UnusedAssignment")
            Usuario us = new Usuario();
            us = (Usuario) q.uniqueResult();

            if (us != null) {
                //exitoso, se cambia la N por S
                UsuarioController uc = new UsuarioController();
                us.setValidado("S");
                uc.updateUsuario(us);

                //mensaje de que todo fue existoso
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter pw = response.getWriter();
                pw.println("<html>\n"
                        + "<head>\n"
                        + "<title>Cuenta Activada con éxito.</title>\n"
                        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                        + "\n"
                        + "</head>\n"
                        + "<body style=\"background-image: url('http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/resources/images/fondo.jpg');\">\n"
                        + "   <section style=\"width: 60%; height: 320px;  background-color:rgba(10, 10, 10, 0.8); margin: 0 auto;\"> \n"
                        + "   		<div style=\"width: 96%; height: 170px; float: left; margin: 15px;\">\n"
                        + "	   		<div style=\"width: 30%; height: 150px; float: left; margin: 10px;\">\n"
                        + "	   			<img style=\"margin: 10px;\" src=\"http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/resources/images/chulo.png\" alt=\"cuentaActivada\" width=\"90%;\" height=\"90%;\" ></img>\n"
                        + "	   		</div>\n"
                        + "	   		<div style=\"width: 62%; height: 150px;  float: left; margin: 10px;\">\n"
                        + "	   			<h2 style=\"text-align: center; color: white;\">Su cuenta se activó exitosamente.<h2>\n"
                        + "	   			<h4 style=\"font-size: 16px; color: white; text-align: center; text-decoration: none;\">Ahora puede <a style=\"color: red;\" href='http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/'>Ingresar</a> al sistema de Facturación Web " + Statics.nombreApp + " con las credenciales que le han proporcionado en el correo electrónico de verificación. <br></br> ATENCION! SI USTED ES UN NUEVO USUARIO SE RECOMIENDA CAMBIAR SU CONTRASEÑA EN LA PAGINA DE LOGIN, YA QUE EL SISTEMA LE ASIGNA UNA CONTRASEÑA POR DEFECTO EN EL PROCESO DE REGISTRO </h4>\n"
                        + "	   		</div>\n"
                        + "   		</div>\n"
                        + "    </section>\n"
                        + "</body>\n"
                        + "</html>");
                pw.close();
            } else {
            }
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }
}
