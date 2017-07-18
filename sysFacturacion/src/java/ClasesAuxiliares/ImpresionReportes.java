package ClasesAuxiliares;

import static ClasesAuxiliares.Statics.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImpresionReportes {

    @SuppressWarnings("CallToPrintStackTrace")
    public void getReporteFactura(String ruta, String codC, String codV, Integer codF) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection conexion;
        Class.forName(driver_class).newInstance();
        conexion = DriverManager.getConnection(cadenaConexion, usbd, passbd);

        //Se definen los parametros que el reporte necesita
        Map parameter = new HashMap();
        parameter.put("codCliente", codC);
        parameter.put("codVendedor", codV);
        parameter.put("codFactura", codF);

        try {
            File file = new File(ruta);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-Type", "application/pdf");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

            JRExporter jrExporter = null;
            jrExporter = new JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void getReporte1(String ruta, String empleado, String fechaFin, String fechaIni) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {

            java.sql.Date fechaInicial;
            java.sql.Date fechaFinal;
            String Empleado = empleado;

            Connection conexion;
            Class.forName(driver_class).newInstance();
            conexion = DriverManager.getConnection(cadenaConexion, usbd, passbd);

            //Se definen los parametros que el reporte necesita
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_inicial = format.parse(fechaIni);
            fechaInicial = new java.sql.Date(fecha_inicial.getTime());

            //Se definen los parametros que el reporte necesita
            Date fecha_final = format.parse(fechaFin);
            fechaFinal = new java.sql.Date(fecha_final.getTime());

            //Se definen los parametros que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("empleado", Empleado);
            parameter.put("fecha_fin", fechaFinal);
            parameter.put("fecha_ini", fechaInicial);

            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(ImpresionReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
