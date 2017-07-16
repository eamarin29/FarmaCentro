package ClasesAuxiliares;

public class Statics {
    
    //Conexion a la app
    public static String correoApp = "locotelocote2@gmail.com";
    public static String passCorreoApp = "123456789000";
    
    //Conexion a la app
    public static String direccionIp = "localhost";
    public static String puerto = "8084";
    public static String nombreApp = "MauroMotos";
    
    //Conexion a la bd
    public static String driver_class="oracle.jdbc.OracleDriver";
    public static String motor = "oracle";
    public static String host = "localhost";
    public static String puertobd = "1521";
    public static String namebd = "XE";
    public static String usbd = "FACTURACION";
    public static String passbd = "root";

    @SuppressWarnings("StaticNonFinalUsedInInitialization")
    public static String cadenaConexion = "jdbc:"+motor+":thin:@"+host+":"+puertobd+":"+namebd;
}
