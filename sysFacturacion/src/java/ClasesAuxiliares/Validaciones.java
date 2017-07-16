package ClasesAuxiliares;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static ClasesAuxiliares.Statics.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validaciones {

    String from = correoApp; //correo usado para enviar los emails
    String passFrom = passCorreoApp; //contraseña del correo usada para enviar los emails

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validarPassword(String password) {

        char clave;
        byte contNumero = 0, contLetraMay = 0, contLetraMin = 0;
        for (byte i = 0; i < password.length(); i++) {
            clave = password.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[A-Z]")) {
                contLetraMay++;
            } else if (passValue.matches("[a-z]")) {
                contLetraMin++;
            } else if (passValue.matches("[0-9]")) {
                contNumero++;
            }
        }

        if (contLetraMay >= 1 && contLetraMin >= 1 && contNumero >= 1 && password.length()>=8) {
            return true;
        } else {
            return false;
        }
    }

    public void sendMailConfirmacion(String emailDestino, String contenidoMensaje, String asuntoMensaje) {

        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", from);
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            // la persona k tiene k verificar
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDestino));
            message.addHeader("Disposition-Notification-To", emailDestino);
            message.setSubject(asuntoMensaje);
            message.setText(contenidoMensaje, "utf-8", "html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(from, passFrom);
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
        }

    }

    public String getCadenaAlfanumAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            // System.out.println("char:"+c);
            if ((c >= '0' && c <= 9) || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
    
     public static String fechaActual() {

        Date date = new Date(); 
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

        String fechaActual = hourdateFormat.format(date);

        return fechaActual;
    }
    
}
