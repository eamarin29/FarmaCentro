package Controller;

import Model.Cliente;
import Model.DetalleFactura;
import java.util.List;
import Model.Factura;
import Model.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.Query;

public class FacturasController {

    public List<Factura> listarFacturas() {

        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;

    }

    public void deleteFactura(Factura factura) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
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

    public List<DetalleFactura> listaProductosXfactura(BigDecimal codFactura) {

        List<DetalleFactura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM DetalleFactura WHERE codfactura=:codFactura";
        Query q = session.createQuery(hql);
        q.setParameter("codFactura", codFactura);
        t.commit();

        try {
            lista = q.list();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;

    }

    public boolean consultarFacturaAnulada(BigDecimal codfactura) {
        //true cuando ya esta anulada
        Session session = null;
        Factura ret = new Factura();
        boolean anulada = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM Factura WHERE codfactura=:codfactura AND anulada='S'";
            Query q = session.createQuery(hql);
            q.setParameter("codfactura", codfactura);
            session.getTransaction().commit();
            ret = (Factura) q.uniqueResult();
            if(ret!=null){
                anulada = true;
            }else{
                anulada = false;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return anulada;
    }

}
