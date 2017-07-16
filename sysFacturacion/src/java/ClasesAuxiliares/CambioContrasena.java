package ClasesAuxiliares;

import Model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import Util.HibernateUtil;

public class CambioContrasena {

    public Usuario consultarUsuario(String usuario, String codRegistro) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "FROM Usuario WHERE (cedula=:codUsuario) or (email=:codUsuario) AND codRegistro=:codRegistro AND validado='S'";
            Query q = session.createQuery(hql);
            q.setParameter("codUsuario", usuario);
            q.setParameter("codRegistro", codRegistro);

            @SuppressWarnings("UnusedAssignment")
            Usuario us = new Usuario();
            us = (Usuario) q.uniqueResult();
            session.getTransaction().commit();
            return us;

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;

    }

    public String cambiarContrasena(String cedula, String codRegistro, String contrasenaNueva) {

        String mensajeRetornar = "holi";
         System.out.println("--la cedula recogida es: "+cedula);
        return mensajeRetornar;
        
    }

}
