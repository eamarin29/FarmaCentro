package Controller;

import Model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import Util.HibernateUtil;

public class UsuarioController {
    
    public void newUsuario(Usuario usuario) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateUsuario(Usuario usuario) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void deleteUsuario(Usuario usuario) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void iniciarSistema() {

        Session session = null;
 
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    } 
    
    public Usuario login(String cedula, String password) {

        Usuario user = new Usuario();
        user = null;
        user = this.consultarUsuarioPorCedula(cedula); //buscamos si la cedula ingresada existe
        if (user != null) {
            //existe un usuario con esa cedula
            String contraseñaIngresadaEncriptada = DigestUtils.sha512Hex(password);

            if (contraseñaIngresadaEncriptada.equals(user.getPassword())) {
                //correcto user y password son correctos
            } else {
                //incorrectos user o password
                user = null;
            }
        
        //si la cedula ingresada no existe consultemos entonces por email
        } else { 
          
            user = this.consultarUsuarioPorEmail(cedula);
            if (user == null) {
                user = null;
            } else {
                //existe un usuario con esa cedula
                String contraseñaIngresadaEncriptada = DigestUtils.sha512Hex(password);

                if (contraseñaIngresadaEncriptada.equals(user.getPassword())) {
                    //correcto 
                } else {
                    //incorrecta
                    user = null;
                }
            }
        }
        return user;
    }

    public Usuario consultarUsuarioPorCedula(String cedula) {

        Session session = null;
        Usuario ret = new Usuario();
        ret=null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Usuario WHERE cedula=:cedula";
            Query q = session.createQuery(hql);
            q.setParameter("cedula", cedula);
            session.getTransaction().commit();
            ret = (Usuario) q.uniqueResult();
            return ret;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;
    } 
    
    public Usuario consultarUsuarioPorEmail(String email) {

        Session session = null;
        Usuario ret = new Usuario();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Usuario WHERE email=:email";
            Query q = session.createQuery(hql);
            q.setParameter("email", email);
            session.getTransaction().commit();
            ret = (Usuario) q.uniqueResult();
            return ret;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;
    }
    
    public Usuario consultarUsuarioPorCedulaAndCodigoRegistro(String cedula, String codRegistro) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "FROM Usuario WHERE cedula=:cedulaIngresada AND codregistro=:codRegistro";
            Query q = session.createQuery(hql);
            q.setParameter("cedulaIngresada", cedula);
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
    
}
