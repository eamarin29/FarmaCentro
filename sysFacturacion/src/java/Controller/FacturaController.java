package Controller;

import Model.DetalleFactura;
import Model.Factura;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Util.HibernateUtil;
import java.math.BigDecimal;

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

    public void updateFactura(Factura factura) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
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
            System.out.println("--Error en factura controller newdetalle: " + e.getMessage());
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

    public Factura obtenerUltimoRegistro() throws Exception {

        Session session = null;
        Factura ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Factura ORDER BY codFactura DESC";
            Query q = session.createQuery(hql).setMaxResults(1);
            ret = (Factura) q.uniqueResult();

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;
    }

    public Long obtenerCuantosRegistrosHayEnFactura() {

        Session session = null;
        Long ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Factura";
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

    public Factura consultarFacturaPorCodigo(BigDecimal codfactura) {

        Session session = null;
        Factura ret = new Factura();
        ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Factura WHERE codfactura=:codfactura";
            Query q = session.createQuery(hql);
            q.setParameter("codfactura", codfactura);
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

}
