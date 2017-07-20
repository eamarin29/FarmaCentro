package Controller;

import ClasesAuxiliares.Statics;
import ClasesAuxiliares.Validaciones;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Producto;
import Model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

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

    public Producto obtenerProductoPorCodigoBarras(String codBarras) throws Exception {

        Session session = null;
        Producto ret = new Producto();
        ret = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "FROM Producto WHERE codbarras=:codBarras";
            Query q = session.createQuery(hql);
            q.setParameter("codBarras", codBarras);
            ret = (Producto) q.uniqueResult();
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

    public void actualizarStockActual(String codBarras, Long cantVendida) {

        try {
            Producto pre = new Producto();
            pre = obtenerProductoPorCodigoBarras(codBarras);
            if (pre != null) {
                pre.setStockActUni(pre.getStockActUni().intValue() - cantVendida);
                updateProducto(pre);
                if (pre.getStockActUni() <= pre.getStockMinUni()) {
                    
                    //envio email
                     Validaciones v = new Validaciones();
                    String tituloEmail = "Sistema de Facturación Web "+Statics.nombreApp+" - Producto agotado";

                    String contenidoEmail
                            = "<div style='background-color: yellowgreen; width: 100%; height: auto; float: left;'>  <div style='width: 98%; height: auto; background-color: white; float: left; margin: 1% auto; margin-left: 1%; text-align: center;' > \n"
                            + " <h3 style='color: black;''>Sistema de Facturación Web "+Statics.nombreApp+" - Producto Agotado </h3>\n"
                            + " <p style='color: black;''>El producto con código de barras: "+pre.getCodBarras()+" Con nombre: "+pre.getNombre()+". Se ha agotado. <br></br> <br></br> <br></br> Este mensaje es generado automáticamente por el sistema. Favor no Responder. <br></br>  Gracias por utilizar nuestros servicios!</p>   <br>   </div>    </div>";

                    AdministradorController adminController = new AdministradorController();
                    List<Usuario> listaAdmins = adminController.listarAdmin();
                    
                    for (int i = 0; i < listaAdmins.size(); i++) {
                        
                        v.sendMailConfirmacion(listaAdmins.get(i).getEmail(), contenidoEmail, tituloEmail);
                    }
                    
                    
                    
                }
            } else {

            }
        } catch (Exception ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
