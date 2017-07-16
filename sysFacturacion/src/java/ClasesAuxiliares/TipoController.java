package ClasesAuxiliares;

import java.util.List;
import Model.Tipo;
import Model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

public class TipoController {
    
        public List<Tipo> listarTipos() {
        List<Tipo> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Tipo";

        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }
    
    
}
