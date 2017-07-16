package Controller;

import java.util.List;
import Model.Factura;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

public class FacturasController {
    
     public List<Factura> listarFacturas() {
         
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura";

        try{
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        }catch(HibernateException e){
            t.rollback();
        }
        return lista;
         
    }
     
     public void deleteFactura(Factura factura) {
        
        Session session = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
            session.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
        
    }
     
}
