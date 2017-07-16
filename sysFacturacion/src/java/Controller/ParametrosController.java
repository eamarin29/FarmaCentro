package Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Parametro;
import Model.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

public class ParametrosController {
    
        public List<Parametro> listarParametros() {
        List<Parametro> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Parametro";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public void newParametro(Parametro parametro) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(parametro);
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

    public void updateParametro(Parametro parametro) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(parametro);
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

    public int deleteParametro(Parametro parametro) {

        Session session = null;
        int errores = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(parametro);
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
    
    public Parametro consultarParametroPorNombre(String nombreParametro){
        
          Session session = null;
          Parametro ret = new Parametro();
          ret=null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "FROM Parametro WHERE nombreParametro=:nombreParametro"; 
            Query q = session.createQuery(hql);
            q.setParameter("nombreParametro", nombreParametro);
            ret = (Parametro) q.uniqueResult();
            session.getTransaction().commit();
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
    
public String obtenerIVA() throws Exception {

        Session session = null;
          String iva = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "FROM Parametro WHERE nombreParametro='IVA'";
            Query q = session.createQuery(hql);
            Parametro par = new Parametro();
            par = (Parametro) q.uniqueResult();
            iva = par.getValorParametro();
            session.getTransaction().commit();
            return iva;

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return iva;
    }
    
    public void convertirPrecioVentaProductosNuevoIva(){
        
        ProductoController productoController = new ProductoController();
        
        List<Producto> lista = productoController.listarProductos();
        for (int i = 0; i < lista.size(); i++) {
             
            try {
                Double precioCompra = lista.get(i).getPrecioCompra().doubleValue();
                Double iva = Double.parseDouble(obtenerIVA());
                Double precioVenta = precioCompra + (precioCompra * iva) / 100;
                BigDecimal precioVentaFinal = new BigDecimal(precioVenta);
                
                lista.get(i).setPrecioVenta(precioVentaFinal);
                productoController.updateProducto(lista.get(i));
            } catch (Exception ex) {
                Logger.getLogger(ParametrosController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public String obtenerIVAmanoObra() throws Exception {

        Session session = null;
          String iva = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "FROM Parametro WHERE nombreParametro='% MANO DE OBRA'";
            Query q = session.createQuery(hql);
            Parametro par = new Parametro();
            par = (Parametro) q.uniqueResult();
            iva = par.getValorParametro();
            session.getTransaction().commit();
            return iva;

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return iva;
    }
    
    
}
