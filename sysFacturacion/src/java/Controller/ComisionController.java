package Controller;

import ClasesAuxiliares.Conexion;
import Model.Cliente;
import Model.Comision;
import Model.Factura;
import Model.Vendedor;
import Util.HibernateUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Comision consultarComisionXfacturaAndVendedor(BigDecimal codFactura, String codVendedor) {

        Comision ret = new Comision();

        try {

            Conexion c = new Conexion();
            Connection conn = c.Conectar();

            //consultar si cedula existe
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM COMISION WHERE VENDEDOR=? AND FACTURA=?");
            consulta.setString(1, codVendedor);
            consulta.setBigDecimal(2, codFactura);
            ResultSet rs = consulta.executeQuery();

            Vendedor v = new Vendedor();
            v = null;
            VendedorController VendedorController = new VendedorController();

            Factura f = new Factura();
            f = null;
            FacturaController FacturaController = new FacturaController();
            
            if (rs.next()) {

                v = VendedorController.consultarVendedorPorCedula(rs.getString("VENDEDOR"));
                f = FacturaController.consultarFacturaPorCodigo(rs.getBigDecimal("FACTURA"));

                ret.setCodigo(rs.getBigDecimal("CODIGO"));
                ret.setVendedor(v);
                ret.setSaldo(rs.getBigDecimal("SALDO"));
                ret.setFecha(rs.getDate("fecha"));
                ret.setFactura(f);
                
                conn.close();
                rs.close();
            } else {
                ret = null;
                conn.close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
