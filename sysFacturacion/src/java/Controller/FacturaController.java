package Controller;

import Model.DetalleFactura;
import Model.Factura;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Util.HibernateUtil;

public class FacturaController {

    public void newFactura(Factura factura) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(factura);
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

    public void newDetalle(DetalleFactura detalle) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(detalle);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("--Error en factura controller newdetalle: "+e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Factura obtenerUltimoCodFactura() throws Exception {

        Session session = null;
        Factura ret = new Factura();
        ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM factura ORDER BY codfactura DESC";
            Query q = session.createQuery(hql).setMaxResults(1);
            session.getTransaction().commit();
            ret = (Factura) q.uniqueResult();
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

    public Long obtenerTotalRegistrosEnFactura() throws Exception {

        Session session = null;
        Long ret = null;
        ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Factura";
            Query q = session.createQuery(hql);
            session.getTransaction().commit();
            ret = (Long) q.uniqueResult();
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
