package Controller;

import ClasesAuxiliares.Conexion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoController {

    public List<Producto> listarProductos() {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto ORDER BY codBarras ASC";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public void newProducto(Producto producto) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
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

    public void updateProducto(Producto producto) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
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

    public int deleteProducto(Producto producto) {

        Session session = null;
        int errores = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
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

    public boolean obtenerProductoPorCodigoBarras(String codBarras) {

        boolean ret = false;
        
        try {

            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE COD_BARRAS=?");
            consulta.setString(1, codBarras);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                ret = true;
                conn.close();
                rs.close();
            } else {
                ret = false;
                conn.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public List<Producto> listarProductosMayorCero() {

        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Producto WHERE stockActual > 0";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    public Producto obtenerUltimoRegistro() throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Producto p = new Producto();
        p = null;

        try {
            String hql = "FROM Producto ORDER BY codigo DESC";
            Query q = session.createQuery(hql).setMaxResults(1);
            p = (Producto) q.uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return p;
    }

    public Long obtenerCuantosRegistrosHayEnProducto() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Long p = 0L;

        try {
            String hql = "SELECT COUNT(*) FROM Producto";
            Query q = session.createQuery(hql);
            p = (Long) q.uniqueResult();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return p;

    }

}
