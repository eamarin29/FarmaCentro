package Controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Model.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import Util.HibernateUtil;


public class ClienteController {

    public List<Cliente> listarClientes() {
        List<Cliente> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Cliente ORDER BY codcliente ASC";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public void newCliente(Cliente cliente) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateCliente(Cliente cliente) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int deleteCliente(Cliente cliente) {

        Session session = null;
        int errores = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            errores++;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return errores;

    }

    public Cliente consultarClientePorCodigo(String codCliente) {

        Session session = null;
        Cliente ret = new Cliente();
        ret=null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Cliente WHERE codcliente=:codCliente";
            Query q = session.createQuery(hql);
            q.setParameter("codCliente", codCliente);
            session.getTransaction().commit();
            ret = (Cliente) q.uniqueResult();
            return ret;
        } catch (Exception e) {
               session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;
    }
    
}
