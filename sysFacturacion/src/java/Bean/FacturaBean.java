package Bean;

import ClasesAuxiliares.ImpresionReportes;
import ClasesAuxiliares.Validaciones;
import java.text.SimpleDateFormat;
import java.util.Date;
import Controller.ClienteController;
import Controller.ComisionController;
import Controller.DetalleFacturaController;
import Controller.FacturaController;
import Controller.ProductoController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import Model.Cliente;
import Model.Comision;
import Model.DetalleFactura;
import Model.Factura;
import Model.Producto;
import Model.Vendedor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import Util.HibernateUtil;
import org.primefaces.component.inputnumber.InputNumber;

@ManagedBean
@ViewScoped
public class FacturaBean implements Serializable {

    @ManagedProperty("#{usuarioBean}")
    private usuarioBean usuarioBean;

    Session session = null;
    Transaction tr = null;

    private Cliente cliente;
    private String codigoCliente;  //INPUTTEXT DONDE SE VA A BUSCAR EL CLIENTE (VALUE) 

    private Producto producto;
    private String codigoBarras;

    private List<DetalleFactura> listaDetalleFactura;
    private String codBarrasProductoEliminarDetalle;
    private String codBarrasProductoModificarCantidad;

    private String cantidadProductoDigitado;
    private String cantidadProductoDigitadoxText;
    private String CantidadProductoModificar;

    private String codBarrasProductoSeleccionado;

    private Factura factura;
    private Factura ultimaFactura;

    private String cantidadModificar;
    private Long numeroFactura;

    private String fechaActual = Validaciones.fechaActual();

    private boolean habilitarImpresora = true;
    private boolean habilitarBtnRegistrar = false;

    private Producto productoSeleccionado;
    private String precioReal;
    private String precioRealText;
    private String totalServicio;

    private Producto pSeleccionado;
    private List<Producto> listaProductosBuscar;

    private InputNumber cantidad;

    private List<Producto> listaProductosSecundario1;
    private List<Producto> listaProductosSecundario2;
    private List<Producto> listaProductosSecundario3;

    private Producto productoSecundario1;
    private Producto productoSecundario2;
    private Producto productoSecundario3;

    private int unidades_faltantes1;
    private int unidades_faltantes2;
    private int unidades_faltantes3;

    private List<Producto> listaActualizarStock = new ArrayList();

    private int posListaActualizarStock = -1;

    public FacturaBean() {
    }

    @PostConstruct
    public void Init() {
        this.listaDetalleFactura = new ArrayList<>();
        cliente = null;
        factura = new Factura();
        ultimaFactura = new Factura();

        this.cantidadProductoDigitado = "1";
        this.cantidadProductoDigitadoxText = "1";
        this.CantidadProductoModificar = "1";

        this.codigoBarras = "";

        limpiarFactura();
    }

    public List<Producto> getListaProductosSecundario3() {
        return listaProductosSecundario3;
    }

    public void setListaProductosSecundario3(List<Producto> listaProductosSecundario3) {
        this.listaProductosSecundario3 = listaProductosSecundario3;
    }

    public Producto getProductoSecundario3() {
        return productoSecundario3;
    }

    public void setProductoSecundario3(Producto productoSecundario3) {
        this.productoSecundario3 = productoSecundario3;
    }

    public int getUnidades_faltantes3() {
        return unidades_faltantes3;
    }

    public void setUnidades_faltantes3(int unidades_faltantes3) {
        this.unidades_faltantes3 = unidades_faltantes3;
    }

    public List<Producto> getListaProductosSecundario2() {
        return listaProductosSecundario2;
    }

    public void setListaProductosSecundario2(List<Producto> listaProductosSecundario2) {
        this.listaProductosSecundario2 = listaProductosSecundario2;
    }

    public int getUnidades_faltantes2() {
        return unidades_faltantes2;
    }

    public void setUnidades_faltantes2(int unidades_faltantes2) {
        this.unidades_faltantes2 = unidades_faltantes2;
    }

    public Producto getProductoSecundario2() {
        return productoSecundario2;
    }

    public void setProductoSecundario2(Producto productoSecundario2) {
        this.productoSecundario2 = productoSecundario2;
    }

    public List<Producto> getListaActualizarStock() {
        return listaActualizarStock;
    }

    public int getPosListaActualizarStock() {
        return posListaActualizarStock;
    }

    public void setPosListaActualizarStock(int posListaActualizarStock) {
        this.posListaActualizarStock = posListaActualizarStock;
    }

    public void setListaActualizarStock(List<Producto> listaActualizarStock) {
        this.listaActualizarStock = listaActualizarStock;
    }

    public int getUnidades_faltantes1() {
        return unidades_faltantes1;
    }

    public void setUnidades_faltantes1(int unidades_faltantes1) {
        this.unidades_faltantes1 = unidades_faltantes1;
    }

    public Producto getProductoSecundario1() {
        return productoSecundario1;
    }

    public void setProductoSecundario1(Producto productoSecundario1) {
        this.productoSecundario1 = productoSecundario1;
    }

    public List<Producto> getListaProductosSecundario1() {
        return listaProductosSecundario1;
    }

    public void setListaProductosSecundario1(List<Producto> listaProductosSecundario1) {
        this.listaProductosSecundario1 = listaProductosSecundario1;
    }

    public InputNumber getCantidad() {
        return cantidad;
    }

    public void setCantidad(InputNumber cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto> getListaProductosBuscar() {
        return listaProductosBuscar;
    }

    public void setListaProductosBuscar(List<Producto> listaProductosBuscar) {
        this.listaProductosBuscar = listaProductosBuscar;
    }

    public String getTotalServicio() {
        return totalServicio;
    }

    public Producto getpSeleccionado() {
        return pSeleccionado;
    }

    public void setpSeleccionado(Producto pSeleccionado) {
        this.pSeleccionado = pSeleccionado;
    }

    public void setTotalServicio(String totalServicio) {
        this.totalServicio = totalServicio;
    }

    public String getPrecioRealText() {
        return precioRealText;
    }

    public void setPrecioRealText(String precioRealText) {
        this.precioRealText = precioRealText;
    }

    public String getPrecioReal() {
        return precioReal;
    }

    public void setPrecioReal(String precioReal) {
        this.precioReal = precioReal;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public usuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(usuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public boolean isHabilitarImpresora() {
        return habilitarImpresora;
    }

    public void setHabilitarImpresora(boolean habilitarImpresora) {
        this.habilitarImpresora = habilitarImpresora;
    }

    public boolean isHabilitarBtnRegistrar() {
        return habilitarBtnRegistrar;
    }

    public void setHabilitarBtnRegistrar(boolean habilitarBtnRegistrar) {
        this.habilitarBtnRegistrar = habilitarBtnRegistrar;
    }

    public Factura getUltimaFactura() {
        return ultimaFactura;
    }

    public void setUltimaFactura(Factura ultimaFactura) {
        this.ultimaFactura = ultimaFactura;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCodBarrasProductoEliminarDetalle() {
        return codBarrasProductoEliminarDetalle;
    }

    public void setCodBarrasProductoEliminarDetalle(String codBarrasProductoEliminarDetalle) {
        this.codBarrasProductoEliminarDetalle = codBarrasProductoEliminarDetalle;
    }

    public String getCantidadModificar() {
        return cantidadModificar;
    }

    public String getCodBarrasProductoModificarCantidad() {
        return codBarrasProductoModificarCantidad;
    }

    public void setCodBarrasProductoModificarCantidad(String codBarrasProductoModificarCantidad) {
        this.codBarrasProductoModificarCantidad = codBarrasProductoModificarCantidad;
    }

    public void setCantidadModificar(String cantidadModificar) {
        this.cantidadModificar = cantidadModificar;
    }

    public String getCantidadProductoModificar() {
        return CantidadProductoModificar;
    }

    public void setCantidadProductoModificar(String CantidadProductoModificar) {
        this.CantidadProductoModificar = CantidadProductoModificar;
    }

    public String getCantidadProductoDigitadoxText() {
        return cantidadProductoDigitadoxText;
    }

    public void setCantidadProductoDigitadoxText(String cantidadProductoDigitadoxText) {
        this.cantidadProductoDigitadoxText = cantidadProductoDigitadoxText;
    }

    public String getCantidadProductoDigitado() {
        return cantidadProductoDigitado;
    }

    public void setCantidadProductoDigitado(String cantidadProductoDigitado) {
        this.cantidadProductoDigitado = cantidadProductoDigitado;
    }

    public String getCodBarrasProductoSeleccionado() {
        return codBarrasProductoSeleccionado;
    }

    public void setCodBarrasProductoSeleccionado(String codBarrasProductoSeleccionado) {
        this.codBarrasProductoSeleccionado = codBarrasProductoSeleccionado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public Session getSession() {
        return session;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTr() {
        return tr;
    }

    public void setTr(Transaction tr) {
        this.tr = tr;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public void agregarDatosClienteAfactura(String codCliente) {

        try {
            //obtener datos del cliente seleccionado
            ClienteController clienteController = new ClienteController();
            this.cliente = clienteController.consultarClientePorCodigo(codCliente);
        } catch (Exception ex) {
            Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void agregarDatosClienteAfacturaPorText() {

        if (codigoCliente.equals("")) {
            cliente = null;
        } else {
            try {
                //consultelo
                ClienteController clienteController = new ClienteController();

                //obtener datos del cliente seleccionado
                this.cliente = clienteController.consultarClientePorCodigo(codigoCliente);

            } catch (Exception ex) {
                Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void mostrarDialogPedirCantidadProductoPorText() {

        if (codigoBarras.equals("")) {
            //esta vacio el text 
        } else {
            ProductoController ProductoController = new ProductoController();

            List<Producto> lista = null;

            lista = ProductoController.listaDeProductosPorCodBarras(codigoBarras);

            if (lista.size() > 0) {

                listaProductosBuscar = lista;
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogMostrarTodosProdutos').show();");

            } else {

            }
        }

    }

    public void verificarExistenciaDetalle() {

        RequestContext context = RequestContext.getCurrentInstance();

        if (verificarDetalleFactura(productoSeleccionado.getCodigo())) {
            //hagale 
            context.execute("PF('dialogMostrarTodosProdutos').show();");
            context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");

        } else {
            context.execute("PF('dialogMostrarTodosProdutos').show();");
            context.execute("PF('dialogPedirCantidadProductoSeleccionado').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Este producto ya se encuentra en la factura."));

        }

    }

    public void seleccionarCantidad() {

        RequestContext context = RequestContext.getCurrentInstance();

        if (cantidad.getValue() == null) {
            context.execute("PF('dialogMostrarTodosProdutos').show();");
            context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "La cantidad no puede ser vacía ó 0."));
        } else {
            if (cantidad.getValue().equals("0")) {
                context.execute("PF('dialogMostrarTodosProdutos').show();");
                context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "La cantidad no puede ser vacía ó 0."));
            } else {
                int cantidad_ingresada = Integer.parseInt(this.cantidad.getValue().toString());
                int unidades_a_vender = cantidad_ingresada * this.productoSeleccionado.getUnidadXPaquete().intValue();
                int cantidades_total_producto = 0;

                for (int i = 0; i < listaProductosBuscar.size(); i++) {
                    cantidades_total_producto += listaProductosBuscar.get(i).getStockActUni() * listaProductosBuscar.get(i).getUnidadXPaquete();
                }

                if (cantidad_ingresada > this.productoSeleccionado.getStockActUni()) {

                    if (unidades_a_vender > cantidades_total_producto) {
                        context.execute("PF('dialogMostrarTodosProdutos').show();");
                        context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No hay unidades suficientes para la cantidad requerida."));
                    } else {

                        if (cantidad_ingresada > productoSeleccionado.getStockActUni()) {
                            int paquetes_que_faltan = cantidad_ingresada - productoSeleccionado.getStockActUni().intValue();
                            if (paquetes_que_faltan > 0) {
                                //faltan unidades

                                if (this.listaProductosBuscar.size() > 0) {
                                    this.unidades_faltantes1 = paquetes_que_faltan * this.productoSeleccionado.getUnidadXPaquete().intValue();
                                    listaProductosSecundario1 = listaProductosBuscar;
                                    listaProductosSecundario1.remove(productoSeleccionado);
                                    totalPagarFactura();
                                    context.execute("PF('dialogMostrarTodosProdutos').show();");
                                    context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");
                                    context.execute("PF('dialogMostrarProductosSecundario1').show();");
                                }
                            }
                        }
                    }
                } else {
                    //vende el producto normalmente 
                    double ventaTotalDetalle = cantidad_ingresada * productoSeleccionado.getPrecioVentaReal().doubleValue();
                    this.listaDetalleFactura.add(new DetalleFactura(null, null, productoSeleccionado, new BigDecimal(cantidad_ingresada), new BigDecimal(ventaTotalDetalle)));

                    productoSeleccionado.setStockActUni(productoSeleccionado.getStockActUni() - cantidad_ingresada);

                    this.posListaActualizarStock++;
                    this.listaActualizarStock.add(this.posListaActualizarStock, productoSeleccionado);
                    totalPagarFactura();
                    context.execute("PF('dialogMostrarTodosProdutos').hide();");
                    context.execute("PF('dialogPedirCantidadProductoSeleccionado').hide();");

                }
            }
        }

    }

    public void seleccionarProductoSecundario1() {

        RequestContext context = RequestContext.getCurrentInstance();

        ProductoController ProductoController = new ProductoController();
        int unidades_producto_secundario_1 = this.productoSecundario1.getStockActUni().intValue() * productoSecundario1.getUnidadXPaquete().intValue();

        if (unidades_producto_secundario_1 >= this.unidades_faltantes1) {
            //con esta basta
            double paquete_restante = (unidades_producto_secundario_1 - this.unidades_faltantes1) / this.productoSecundario1.getUnidadXPaquete().doubleValue();

            String str = String.valueOf(paquete_restante);

            int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
            float decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));

            productoSeleccionado.setStockActUni(0L);
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSeleccionado);

            productoSecundario1.setStockActUni(Long.valueOf(intNumber));
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSecundario1);

            //aumento unidades donde el producto sean unidades
            Double unidades_aumentar = Double.parseDouble(String.valueOf(decNumbert)) * productoSecundario1.getUnidadXPaquete();

            Producto p = new Producto();

            p = ProductoController.actualizarProductosDondeSeaUnidades(productoSeleccionado.getCodBarras());

            if (p != null) {

                if (productoSeleccionado.getCodigo().toString().equals(p.getCodigo().toString())) {
                    p.setStockActUni(unidades_aumentar.longValue());
                    this.posListaActualizarStock++;
                    this.listaActualizarStock.add(this.posListaActualizarStock, p);
                } else {

                    if (p.getCodigo().toString().equals(productoSecundario1.getCodigo().toString())) {

                    } else {
                        p.setStockActUni(p.getStockActUni() + unidades_aumentar.longValue());
                        this.posListaActualizarStock++;
                        this.listaActualizarStock.add(this.posListaActualizarStock, p);
                    }

                }

            } else {
            }

            //vende el producto normalmente 
            int cantidad_ingresada = Integer.parseInt(this.cantidad.getValue().toString());
            double ventaTotalDetalle = cantidad_ingresada * productoSeleccionado.getPrecioVentaReal().doubleValue();
            this.listaDetalleFactura.add(new DetalleFactura(null, null, productoSeleccionado, new BigDecimal(cantidad_ingresada), new BigDecimal(ventaTotalDetalle)));

            totalPagarFactura();

        } else {
            //pedir el 2 producto

            if (this.listaProductosBuscar.size() >= 2) {
                this.unidades_faltantes2 = this.unidades_faltantes1 - unidades_producto_secundario_1;
                listaProductosSecundario2 = listaProductosBuscar;
                listaProductosSecundario2.remove(productoSecundario1);
                totalPagarFactura();
                context.execute("PF('dialogMostrarTodosProdutos').show();");
                context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");
                context.execute("PF('dialogMostrarProductosSecundario1').show();");
                context.execute("PF('dialogMostrarProductosSecundario2').show();");
            }

        }

    }

    public void seleccionarProductoSecundario2() {

        RequestContext context = RequestContext.getCurrentInstance();

        ProductoController ProductoController = new ProductoController();
        int unidades_producto_secundario_2 = this.productoSecundario2.getStockActUni().intValue() * productoSecundario2.getUnidadXPaquete().intValue();

        if (unidades_producto_secundario_2 >= this.unidades_faltantes2) {

            //con esta basta
            double paquete_restante = (unidades_producto_secundario_2 - this.unidades_faltantes2) / this.productoSecundario2.getUnidadXPaquete().doubleValue();

            String str = String.valueOf(paquete_restante);

            int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
            float decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));

            productoSeleccionado.setStockActUni(0L);
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSeleccionado);

            productoSecundario1.setStockActUni(0L);
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSecundario1);

            productoSecundario2.setStockActUni(Long.valueOf(intNumber));
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSecundario2);

            //aumento unidades donde el producto sean unidades
            Double unidades_aumentar = Double.parseDouble(String.valueOf(decNumbert)) * productoSecundario2.getUnidadXPaquete();

            Producto p = new Producto();

            p = ProductoController.actualizarProductosDondeSeaUnidades(productoSeleccionado.getCodBarras());

            if (p != null) {

                if (productoSeleccionado.getCodigo().toString().equals(p.getCodigo().toString())) {
                    p.setStockActUni(unidades_aumentar.longValue());
                    this.posListaActualizarStock++;
                    this.listaActualizarStock.add(this.posListaActualizarStock, p);
                } else {

                    if (p.getCodigo().toString().equals(productoSecundario1.getCodigo().toString())) {
                        p.setStockActUni(unidades_aumentar.longValue());
                        this.posListaActualizarStock++;
                        this.listaActualizarStock.add(this.posListaActualizarStock, p);
                    } else {

                        if (p.getCodigo().toString().equals(productoSecundario1.getCodigo().toString())) {

                        } else {
                            p.setStockActUni(p.getStockActUni() + unidades_aumentar.longValue());
                            this.posListaActualizarStock++;
                            this.listaActualizarStock.add(this.posListaActualizarStock, p);
                        }
                    }
                }
            } else {
            }

            //vende el producto normalmente 
            int cantidad_ingresada = Integer.parseInt(this.cantidad.getValue().toString());
            double ventaTotalDetalle = cantidad_ingresada * productoSeleccionado.getPrecioVentaReal().doubleValue();
            this.listaDetalleFactura.add(new DetalleFactura(null, null, productoSeleccionado, new BigDecimal(cantidad_ingresada), new BigDecimal(ventaTotalDetalle)));

            totalPagarFactura();

        } else {
            //pido el ultimo producto

            if (this.listaProductosBuscar.size() >= 1) {
                this.unidades_faltantes3 = this.unidades_faltantes2 - unidades_producto_secundario_2;
                listaProductosSecundario3 = listaProductosBuscar;
                listaProductosSecundario2.remove(productoSecundario2);
                totalPagarFactura();
                context.execute("PF('dialogMostrarTodosProdutos').show();");
                context.execute("PF('dialogPedirCantidadProductoSeleccionado').show();");
                context.execute("PF('dialogMostrarProductosSecundario1').show();");
                context.execute("PF('dialogMostrarProductosSecundario2').show();");
                context.execute("PF('dialogMostrarProductosSecundario3').show();");
            }

        }

    }

    public void seleccionarProductoSecundario3() {

        RequestContext context = RequestContext.getCurrentInstance();

        ProductoController ProductoController = new ProductoController();
        int unidades_producto_secundario_3 = this.productoSecundario3.getStockActUni().intValue() * productoSecundario3.getUnidadXPaquete().intValue();

        if (unidades_producto_secundario_3 >= this.unidades_faltantes3) {

            double paquete_restante = (unidades_producto_secundario_3 - this.unidades_faltantes3) / this.productoSecundario3.getUnidadXPaquete().doubleValue();

            String str = String.valueOf(paquete_restante);

            int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
            float decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));

            productoSeleccionado.setStockActUni(0L);
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSeleccionado);

            productoSecundario1.setStockActUni(0L);
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSecundario1);

            productoSecundario2.setStockActUni(0L);
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSecundario2);

            productoSecundario3.setStockActUni(Long.valueOf(intNumber));
            this.posListaActualizarStock++;
            this.listaActualizarStock.add(this.posListaActualizarStock, productoSecundario3);

            //aumento unidades donde el producto sean unidades
            Double unidades_aumentar = Double.parseDouble(String.valueOf(decNumbert)) * productoSecundario3.getUnidadXPaquete();

            Producto p = new Producto();

            p = ProductoController.actualizarProductosDondeSeaUnidades(productoSeleccionado.getCodBarras());

            if (p != null) {

                if (productoSeleccionado.getCodigo().toString().equals(p.getCodigo().toString())) {
                    p.setStockActUni(unidades_aumentar.longValue());
                    this.posListaActualizarStock++;
                    this.listaActualizarStock.add(this.posListaActualizarStock, p);
                } else {

                    if (p.getCodigo().toString().equals(productoSecundario1.getCodigo().toString())) {
                        p.setStockActUni(unidades_aumentar.longValue());
                        this.posListaActualizarStock++;
                        this.listaActualizarStock.add(this.posListaActualizarStock, p);
                    } else {

                        if (p.getCodigo().toString().equals(productoSecundario1.getCodigo().toString())) {

                        } else {

                            if (p.getCodigo().toString().equals(productoSecundario2.getCodigo().toString())) {

                            }

                            p.setStockActUni(p.getStockActUni() + unidades_aumentar.longValue());
                            this.posListaActualizarStock++;
                            this.listaActualizarStock.add(this.posListaActualizarStock, p);
                        }
                    }
                }
            } else {
            }

            //vende el producto normalmente 
            int cantidad_ingresada = Integer.parseInt(this.cantidad.getValue().toString());
            double ventaTotalDetalle = cantidad_ingresada * productoSeleccionado.getPrecioVentaReal().doubleValue();
            this.listaDetalleFactura.add(new DetalleFactura(null, null, productoSeleccionado, new BigDecimal(cantidad_ingresada), new BigDecimal(ventaTotalDetalle)));

            totalPagarFactura();

        } else {
            //paila       
        }

    }

    public boolean verificarDetalleFactura(BigDecimal codigo) {
        //true = no existe el producto en el detalle
        int tamañoLista = listaDetalleFactura.size();
        int error = 0;
        String codigo_llega = codigo.toString();

        for (int i = 0; i < tamañoLista; i++) {
            if (listaDetalleFactura.get(i).getProducto().getCodigo().toString().equals(codigo_llega)) {
                error++;
            }
        }
        if (error == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void totalPagarFactura() {

        double totalPagarFactura = 0;

        try {
            for (DetalleFactura item : listaDetalleFactura) {
                double totalVentaxDetalle = item.getTotalDetalle().intValue();
                totalPagarFactura += totalVentaxDetalle;
            }
        } catch (Exception e) {
            System.out.println("--Error metodo: totalPagarFactura:facturaBean: " + e.getMessage());
        }
        factura.setTotalVenta(new BigDecimal(totalPagarFactura));
    }

    public void registrarVentaFactura() {

        FacturaController FacturaController = new FacturaController();

        try {

            Factura f = new Factura();
            f = FacturaController.obtenerUltimoRegistro();

            if (FacturaController.obtenerCuantosRegistrosHayEnFactura() == 0) {
                this.numeroFactura = Long.parseLong("1");
            } else {
                Integer num = f.getCodfactura().intValue() + 1;
                this.numeroFactura = Long.parseLong(num.toString());
            }

            if (cliente == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Debe de seleccionar un cliente."));
            } else {

                if (this.factura.getTotalVenta().intValue() > 0) {

                    Date date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    String fechaA = hourdateFormat.format(date);

                    Date fecha = null;

                    try {
                        fecha = hourdateFormat.parse(fechaA);

                    } catch (Exception e) {

                    }

                    //guardo el objeto factura
                    Factura facturaGuardar = new Factura();
                    Integer numFact = Integer.parseInt(this.numeroFactura.toString());

                    Vendedor vendedorGuardar = new Vendedor();
                    vendedorGuardar.setCedula(this.usuarioBean.cedulaUsuarioLogueado);

                    FacturaController facturaController = new FacturaController();
                    try {

                        facturaGuardar.setCodfactura(new BigDecimal(numFact));
                        facturaGuardar.setCliente(this.cliente);
                        facturaGuardar.setVendedor(vendedorGuardar);
                        facturaGuardar.setTotalVenta(this.factura.getTotalVenta());
                        facturaGuardar.setFechaRegistro(fecha);

                        facturaController.newFactura(facturaGuardar);

                    } catch (Exception e) {

                    }

                    DetalleFacturaController DetalleFacturaController = new DetalleFacturaController();

                    //registro en la tabla detalle
                    for (int i = 0; i < listaDetalleFactura.size(); i++) {
                        DetalleFactura detalle = new DetalleFactura();

                        //consulto ultimo registro detalle factura
                        DetalleFactura detalle_ultimo = new DetalleFactura();
                        detalle_ultimo = DetalleFacturaController.obtenerUltimoRegistroDetalle();

                        BigDecimal nDetalle = null;

                        if (DetalleFacturaController.obtenerCuantosRegistrosHayEnDetalle() == 0) {
                            nDetalle = new BigDecimal(1);
                        } else {
                            Integer num = detalle_ultimo.getCoddetalle().intValue() + 1;
                            nDetalle = new BigDecimal(num);
                        }

                        detalle.setCoddetalle(nDetalle);
                        detalle.setFactura(facturaGuardar);
                        detalle.setProducto(listaDetalleFactura.get(i).getProducto());
                        detalle.setCantidad(listaDetalleFactura.get(i).getCantidad());
                        detalle.setTotalDetalle(listaDetalleFactura.get(i).getTotalDetalle());

                        facturaController.newDetalle(detalle);

                        //comision
                        Comision c = new Comision();
                        Comision comisionGuardar = new Comision();
                        ComisionController ComisionController = new ComisionController();
                        int n_codigo = 0;

                        c = ComisionController.obtenerUltimoRegistro();

                        if (c == null) {
                            n_codigo = 1;
                        } else {
                            n_codigo = c.getCodigo().intValue() + 1;
                        }

                        comisionGuardar.setCodigo(new BigDecimal(n_codigo));
                        comisionGuardar.setSaldo(new BigDecimal(this.listaDetalleFactura.get(i).getProducto().getComision().doubleValue() * this.listaDetalleFactura.get(i).getCantidad().doubleValue()));
                        comisionGuardar.setFecha(fecha);
                        comisionGuardar.setVendedor(vendedorGuardar);

                        ComisionController.newComision(comisionGuardar);

                    }

                    //venta registrada con exito
                    //habilitar impresora
                    this.habilitarImpresora = false;
                    this.habilitarBtnRegistrar = true;

                    //actualizamos los stoks
                    for (int i = 0; i < this.listaActualizarStock.size(); i++) {
                        ProductoController ProductoController = new ProductoController();
                        ProductoController.updateProducto(this.listaActualizarStock.get(i));
                    }

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "La venta se registró correctamente."));

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No hay productos registrados."));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void limpiarFactura() {

        this.listaProductosSecundario1 = new ArrayList<>();
        this.listaProductosSecundario2 = new ArrayList<>();
        this.listaProductosSecundario3 = new ArrayList<>();

        listaDetalleFactura = new ArrayList<>();

        productoSecundario1 = new Producto();
        productoSecundario2 = new Producto();
        productoSecundario3 = new Producto();

        listaActualizarStock = new ArrayList<>();

        productoSeleccionado = new Producto();

        unidades_faltantes1 = 0;
        unidades_faltantes2 = 0;
        unidades_faltantes3 = 0;

        listaProductosBuscar = new ArrayList<>();

        totalPagarFactura();

        cliente = null;
        factura = new Factura();
        this.ultimaFactura = new Factura();
        this.codigoCliente = "";
        this.codigoBarras = "";
        this.posListaActualizarStock = -1;
        InputNumber n = new InputNumber();
        n.setValue("0");
        setCantidad(n);

    }

    public void reiniciarVenta() {
        limpiarFactura();
        this.habilitarImpresora = true;
        this.habilitarBtnRegistrar = false;
    }

    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            //Metodo para invocar el reporte y enviarle los parametros
            
            String cc = this.cliente.getCodcliente();
            String cv = this.usuarioBean.cedulaUsuarioLogueado;
            int cf = (int) (long) this.numeroFactura;
            
            //Instancia hacia la clase ImpresionReportes
            ImpresionReportes rFactura = new ImpresionReportes();
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("/Reportes/Factura/factura.jasper");
            
            rFactura.getReporteFactura(ruta, cc, cv, cf);
            FacesContext.getCurrentInstance().responseComplete();

            
            reiniciarVenta();

    }

    public void pedirCantidadProductoSeleccionado(String codBarraProductoSeleccionado) {

//        codBarrasProductoSeleccionado = codBarraProductoSeleccionado;
//        if (verificarDetalleFactura(codBarrasProductoSeleccionado) == true) {
//
//            try {
//                //se puede agregar
//                this.codBarrasProductoSeleccionado = codBarraProductoSeleccionado;
//                ProductoController productoController = new ProductoController();
//                //    this.productoSeleccionado = productoController.obtenerProductoPorCodigoBarras(this.codBarrasProductoSeleccionado);
//                if (productoSeleccionado == null) {
//
//                } else {
//                    //compruebo de que el producto seleccionado tenga mas de 0 en el stock actula
//                    precioReal = productoSeleccionado.getPrecioVentaReal().toString();
//                    setCantidadProductoDigitado("1");
//                    RequestContext context = RequestContext.getCurrentInstance();
//                    context.execute("PF('dialogPedirCantidadProductos').show();");
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El producto ya se encuentra en la factura, para agregar más producto editele su cantidad."));
//        }
    }

    public void agregarDatosProductoAfactura() {

        this.session = null;
        this.tr = null;
        Double precio_Real = null;
        int cantidadIngresada;

        System.out.println("--el precio real es: " + this.precioReal);

        if (this.precioReal == null) {

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogBuscarProducto').show();");
            context.execute("PF('dialogPedirCantidadProductos').show();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio no debe quedar vacío."));

        } else {

            try {

                //verifico que la cantidad sea entera
                int error = 0;
                try {
                    cantidadIngresada = Integer.parseInt(this.cantidadProductoDigitado);
                    precio_Real = Double.parseDouble(this.precioReal);
                } catch (NumberFormatException e) {
                    error = 1;
                }

                //verifico que sea un numero y que no esté vacío
                if (error > 0 || this.cantidadProductoDigitado.equals("") || this.cantidadProductoDigitado.equals("0")) {
                    error = 0;
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogBuscarProducto').show();");
                    context.execute("PF('dialogPedirCantidadProductos').show();");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "La cantidad es incorrecta"));

                } else {

                    if (this.precioReal.equals("")) {
                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dialogBuscarProducto').show();");
                        context.execute("PF('dialogPedirCantidadProductos').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio a vender no puede ser menor o igual al precio de compra del producto"));
                    } else {
                        if (productoSeleccionado.getPrecioCompra().doubleValue() >= precio_Real) {
                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('dialogBuscarProducto').show();");
                            context.execute("PF('dialogPedirCantidadProductos').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio a vender no puede ser menor o igual al precio de compra del producto"));

                        } else {
                            //verificar si el producto ya se encuentra en los detalles
                            //true=ya se encuentra en los detalle
                            //consultelo
                            this.session = HibernateUtil.getSessionFactory().openSession();
                            this.tr = this.session.beginTransaction();
                            ProductoController contro = new ProductoController();

                            //obtener datos del producto seleccionado
                            //  this.producto = contro.obtenerProductoPorCodigoBarras(this.codBarrasProductoSeleccionado);
                            //consulto si el stock actual es mayor a la cantidad ingresada
                            int cantidadProdutoDigitado = Integer.parseInt(this.cantidadProductoDigitado);
                            if (cantidadProdutoDigitado <= this.producto.getStockActUni().intValue()) {
                                //se puede registrar
                                double ventaTotalDetalle = Integer.parseInt(this.cantidadProductoDigitado) * Double.parseDouble(this.precioReal);
                                //  this.listaDetalleFactura.add(new DetalleFactura(null, null, producto, null, new BigDecimal(this.cantidadProductoDigitado), new BigDecimal(ventaTotalDetalle), new BigDecimal(this.precioReal)));

                                this.tr.commit();

                                //llamar metodo que calcula el total
                                totalPagarFactura();

                                //cerrar los dialogos
                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dialogPedirCantidadProductos').hide();");
                                context.execute("PF('dialogBuscarProducto').hide();");

                                setCantidadProductoDigitado("1");
                                producto = new Producto();
                            } else {
                                //no se puede registrar
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No hay suficientes productos para la cantidad requerida."));
                                //no se agrega
                                setCantidadProductoDigitado("1");
                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dialogBuscarProducto').show();");
                                context.execute("PF('dialogPedirCantidadProductos').show();");
                            }
                        }
                    }

                }
            } catch (Exception e) {
                if (this.tr != null) {
                    System.out.println("---Error beanFactura agregarDatosClienteAfactura: " + e.getMessage());
                    tr.rollback();
                    setCantidadProductoDigitado("1");
                }
            } finally {
                if (this.session != null) {
                    this.session.close();
                }
            }
        }

    }

    public void agregarDatosProductoAfacturaPorText() {

        Double precio_Real = null;
        int cantidadIngresada = 0;

        if (this.precioRealText == null) {

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogPedirCantidadProductosxText').show();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio no debe quedar vacío."));

        } else {
            int error = 0;
            try {
                cantidadIngresada = Integer.parseInt(this.cantidadProductoDigitadoxText);
                precio_Real = Double.parseDouble(this.precioRealText);
            } catch (Exception e) {
                error = 1;

            }
            //verifico que sea un numero y que no esté vacío
            if (error > 0 || this.cantidadProductoDigitadoxText.equals("") || this.cantidadProductoDigitadoxText.equals("0")) {
                error = 1;

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "La cantidad es incorrecta"));
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogPedirCantidadProductosxText').show();");
            } else {

                if (this.precioRealText.equals("")) {
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogBuscarProducto').show();");
                    context.execute("PF('dialogPedirCantidadProductosxText').show();");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio a vender no puede ser menor o igual al precio de compra del producto"));
                } else {

                    if (this.producto.getPrecioCompra().doubleValue() >= precio_Real) {
                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dialogBuscarProducto').show();");
                        context.execute("PF('dialogPedirCantidadProductosxText').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio a vender no puede ser menor o igual al precio de compra del producto"));

                    } else {
                        //consulto el sotock
                        int cantidadProdutoDigitado = Integer.parseInt(this.cantidadProductoDigitadoxText);
                        if (cantidadProdutoDigitado <= this.producto.getStockActUni().intValue()) {
                            //se puede agregar
                            //obtener datos del producto seleccionado
                            double ventaTotalDetalle = Integer.parseInt(this.cantidadProductoDigitadoxText) * Double.parseDouble(this.precioRealText);
                            // this.listaDetalleFactura.add(new DetalleFactura(null, producto, null, null, new BigDecimal(this.cantidadProductoDigitadoxText), new BigDecimal(ventaTotalDetalle), new BigDecimal(this.precioRealText)));

                            //cerramos el dialog
                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('dialogPedirCantidadProductosxText').hide();");
                            context.execute("PF('dialogBuscarProducto').hide();");

                            //llamar metodo que calcula el total
                            totalPagarFactura();
                        } else {
                            //no se puede agrgar
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No hay suficientes productos en el stock para la cantidad solicitada."));
                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('dialogPedirCantidadProductosxText').show();");
                        }
                    }

                }

            }
            setCantidadProductoDigitadoxText("1");
        }

    }

    public void eliminarDetalleFactura() {

        int tamañoLista = listaDetalleFactura.size();
        int error = 0;

        for (int i = 0; i < tamañoLista; i++) {
            if (listaDetalleFactura.get(i).getProducto().getCodBarras().equals(this.codBarrasProductoEliminarDetalle)) {
                //eliminelo de la lista
                listaDetalleFactura.remove(i);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El detalle se ha eliminado."));

                //actualizar total a pagar
                totalPagarFactura();
            }
        }
    }

    public void modificarCantidadProductoDetalle() {

        if (this.codBarrasProductoModificarCantidad.equals("1")) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No se puede modificar este servicio."));

        } else {
            int error = 0;
            try {
                int cantidadIngresada = Integer.parseInt(this.CantidadProductoModificar);
            } catch (Exception e) {
                error = 1;
            }

            //verifico que sea un numero y que no esté vacío
            if (error > 0 || this.CantidadProductoModificar.equals("") || this.CantidadProductoModificar.equals("0")) {
                error = 1;
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogModificarCantidad').show();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "La cantidad es incorrecta"));

            } else {
                try {
                    //verifico el stock
                    this.session = null;
                    this.tr = null;
                    this.session = HibernateUtil.getSessionFactory().openSession();
                    this.tr = this.session.beginTransaction();

                    Producto productoModificarCant = new Producto();
                    ProductoController pDao = new ProductoController();
                    //   productoModificarCant = pDao.obtenerProductoPorCodigoBarras(this.codBarrasProductoModificarCantidad);

                    int CantidadAModificar = Integer.parseInt(this.CantidadProductoModificar);
                    if (CantidadAModificar <= productoModificarCant.getStockActUni().intValue()) {
                        //se puede agregar
                        //cambio la cantidad en la posicion de la lista
                        int tamañoLista = listaDetalleFactura.size();
                        for (int i = 0; i < tamañoLista; i++) {
                            if (listaDetalleFactura.get(i).getProducto().getCodBarras().equals(this.codBarrasProductoModificarCantidad)) {
                                //eliminelo de la lista
                                listaDetalleFactura.get(i).setCantidad(new BigDecimal(this.CantidadProductoModificar));

                                //  double ventaTotalDetalle = Integer.parseInt(this.CantidadProductoModificar) * listaDetalleFactura.get(i).getPreci.doubleValue();
                                //  listaDetalleFactura.get(i).setTotalDetalle(new BigDecimal(ventaTotalDetalle));
                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dialogModificarCantidad').hide();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "La cantidad se ha modificado con éxito."));

                                //actualizar total a pagar
                                totalPagarFactura();
                            }
                        }
                    } else {
                        //no se puede agregar
                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dialogModificarCantidad').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No hay suficientes productos para la cantidad solicitada."));
                    }

                } catch (Exception ex) {
                    Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setCantidadProductoModificar("1");
        }

    }

    public void generarNumeroFactura() {
        this.session = null;
        this.tr = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.tr = this.session.beginTransaction();

            FacturaController facturaController = new FacturaController();
            //verificar si la tabla esta vacia
            this.numeroFactura = facturaController.obtenerTotalRegistrosEnFactura(); //cuantos registros existen en la tabla factura

            if (this.numeroFactura < 0 || this.numeroFactura == null) {
                this.numeroFactura = Long.parseLong("1");
            } else {
                //poner el ultimo numero
                this.ultimaFactura = facturaController.obtenerUltimoCodFactura();
                this.numeroFactura = Long.valueOf(this.ultimaFactura.getCodfactura().intValue() + 1);
            }
            this.tr.commit();

        } catch (Exception e) {
            if (this.tr != null) {
                this.tr.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            this.session.close();
        }
    }

}
