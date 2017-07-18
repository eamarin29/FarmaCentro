package Servlet;

import Bean.CambioContrasenaBean;
import java.io.IOException;
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
import javax.faces.bean.ManagedProperty;

/**
 * Servlet implementation class ServletActivacionCuenta
 */
public class ServletCambioContrasena extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{cambioContrasenaBean}")
    private CambioContrasenaBean cambioContrasenaBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCambioContrasena() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CambioContrasenaBean getCambioContrasenaBean() {
        return cambioContrasenaBean;
    }

    public void setCambioContrasenaBean(CambioContrasenaBean cambioContrasenaBean) {
        this.cambioContrasenaBean = cambioContrasenaBean;
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

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        try {
            String cedula = request.getParameter("usuario");
            String codRegistro = request.getParameter("aleatorio");

            //realizo la consulta
            String hql = "FROM Usuario WHERE cedula=:codUsuario AND codRegistro=:codRegistro AND validado='S'";
            Query q = session.createQuery(hql);
            q.setParameter("codUsuario", cedula);
            q.setParameter("codRegistro", codRegistro);
            @SuppressWarnings("UnusedAssignment")
            Usuario us = new Usuario();
            us = (Usuario) q.uniqueResult();
            if (us != null) {
                response.sendRedirect("http://" + direccionIp + ":" + puerto + "/" + nombreApp + "/faces/Views/cambiarContrasena.xhtml?cedula=" + cedula + "&codRegistro=" + codRegistro);
            } else {
            }
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }
}
