package Controller;

import Model.Cliente;
import Model.Comision;
import Model.Factura;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComisionController {

    public List<Comision> listarComision() {
        List<Comision> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Comision ORDER BY codigo ASC";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public void newComision(Comision comision) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(comision);
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

    public void updateComision(Comision comision) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(comision);
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

    public int deleteComision(Comision comision) {

        Session session = null;
        int errores = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(comision);
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

    public Comision obtenerUltimoRegistro() throws Exception {

        Session session = null;
        Comision ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Comision ORDER BY codigo DESC";
            Query q = session.createQuery(hql).setMaxResults(1);
            ret = (Comision) q.uniqueResult();

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;
    }

    public Long obtenerCuantosRegistrosHayEnComision() {

        Session session = null;
        Long ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Comision";
            Query q = session.createQuery(hql);
            return (Long) q.uniqueResult();

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
