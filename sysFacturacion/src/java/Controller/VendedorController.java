package Controller;

import java.util.List;
import Model.Vendedor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

public class VendedorController {

    public List<Vendedor> listarVendedores() {
        List<Vendedor> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Vendedor";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public void newVendedor(Vendedor vendedor) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vendedor);
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

    public void updateVendedor(Vendedor vendedor) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(vendedor);
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

    public int deleteVendedor(Vendedor vendedor) {

        Session session = null;
        int errores = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(vendedor);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            errores++;
            return errores;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return errores;
    }
    
    public Vendedor consultarVendedorPorCedula(String cedula) {

        Session session = null;
        Vendedor ret = new Vendedor();
        ret=null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Vendedor WHERE cedula=:cedula";
            Query q = session.createQuery(hql);
            q.setParameter("cedula", cedula);
            session.getTransaction().commit();
            ret = (Vendedor) q.uniqueResult();
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
    
}
