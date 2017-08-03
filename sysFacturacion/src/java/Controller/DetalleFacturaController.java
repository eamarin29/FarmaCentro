package Controller;

import Model.DetalleFactura;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class DetalleFacturaController {

    public DetalleFactura obtenerUltimoRegistroDetalle() throws Exception {

        Session session = null;
        DetalleFactura ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM DetalleFactura ORDER BY coddetalle DESC";
            Query q = session.createQuery(hql).setMaxResults(1);
            return (DetalleFactura) q.uniqueResult();

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ret;

    }

    public Long obtenerCuantosRegistrosHayEnDetalle() {

        Session session = null;
        Long ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM DetalleFactura";
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
