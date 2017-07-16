package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static ClasesAuxiliares.Statics.*;

/**
 * Servlet implementation class ServletActivacionCuenta
 */
public class ServletCambioEmail extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCambioEmail() {
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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


                //mensaje de que todo fue existoso
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter pw = response.getWriter();
                pw.println("<html>\n"
                        + "<head>\n"
                        + "<title>Cuenta Activada con éxito.</title>\n"
                        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                        + "\n"
                        + "</head>\n"
                        + "<body style=\"background: rgba(68, 68, 68, 0.7);\">\n"
                        + "   <section style=\"width: 60%; height: 200px; background: rgba(255, 255, 255, 0.7); margin: 0 auto;\"> \n"
                        + "   		<div style=\"width: 96%; height: 170px; float: left; margin: 15px;\">\n"
                        + "	   		<div style=\"width: 30%; height: 150px; float: left; margin: 10px;\">\n"
                        + "	   			<img style=\"margin: 10px;\" src=\"http://"+direccionIp+":"+puerto+"/"+nombreApp+"/resources/images/chulo.png\" alt=\"cuentaActivada\" width=\"90%;\" height=\"90%;\" ></img>\n"
                        + "	   		</div>\n"
                        + "	   		<div style=\"width: 62%; height: 150px;  float: left; margin: 10px;\">\n"
                        + "	   			<h2 style=\"text-align: center;\">Su cuenta ha cambiado de Email.<h2>\n"
                        + "	   			<h4 style=\"font-size: 16px; text-align: center; text-decoration: none;\">Rebice su correo electrónico para continuar con la validación de su cuenta, luego puede hacer click <a href='http://"+direccionIp+":"+puerto+"/"+nombreApp+"/'>Aquí</a> Y volver a ingresar al Sistema de Facturación Web con sus datos actualizados.</h4>\n"
                        + "	   		</div>\n"
                        + "   		</div>\n"
                        + "    </section>\n"
                        + "</body>\n"
                        + "</html>");
                pw.close();
    }

}
