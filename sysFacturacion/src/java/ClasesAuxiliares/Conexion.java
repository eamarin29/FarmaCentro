package ClasesAuxiliares;

import static ClasesAuxiliares.Statics.cadenaConexion;
import static ClasesAuxiliares.Statics.driver_class;
import static ClasesAuxiliares.Statics.namebd;
import static ClasesAuxiliares.Statics.passbd;
import static ClasesAuxiliares.Statics.usbd;
import java.sql.*;

public class Conexion {

    public String driver;
    public String url;
    public String ip;
    public String bd;
    public String usr;
    public String pass;

    public Connection conexion = null;

    public Connection Conectar() {
        
        driver = driver_class;
        bd = namebd;
        usr = usbd;
        pass = passbd;
        url = new String(cadenaConexion);
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, usr, pass);
            return conexion;
        } catch (Exception exc) {
            return null;
        }
    }

    public Connection CerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }
} 
