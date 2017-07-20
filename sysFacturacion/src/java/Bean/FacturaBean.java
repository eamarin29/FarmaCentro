package Bean;

import ClasesAuxiliares.ImpresionReportes;
import ClasesAuxiliares.Validaciones;
import java.text.SimpleDateFormat;
import java.util.Date;
import Controller.ClienteController;
import Controller.FacturaController;
import Controller.ParametrosController;
import Controller.ProductoController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import Model.DetalleFactura;
import Model.Factura;
import Model.Producto;
import Model.Vendedor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import Util.HibernateUtil;

@ManagedBean
@ViewScoped
public class FacturaBean implements Serializable {

    @ManagedProperty("#{UsuarioBean}")
    private UsuarioBean usuarioBean;

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



    }

    public String getTotalServicio() {
        return totalServicio;
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

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
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

    public void pedirCantidadProductoSeleccionado(String codBarraProductoSeleccionado) {

        codBarrasProductoSeleccionado = codBarraProductoSeleccionado;
        if (verificarDetalleFactura(codBarrasProductoSeleccionado) == true) {

                try {
                    //se puede agregar
                    this.codBarrasProductoSeleccionado = codBarraProductoSeleccionado;
                    ProductoController productoController = new ProductoController();
                    this.productoSeleccionado = productoController.obtenerProductoPorCodigoBarras(this.codBarrasProductoSeleccionado);
                    if (productoSeleccionado == null) {

                    } else {
                        //compruebo de que el producto seleccionado tenga mas de 0 en el stock actula
                        precioReal = productoSeleccionado.getPrecioVentaReal().toString();
                        setCantidadProductoDigitado("1");
                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dialogPedirCantidadProductos').show();");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
                }
           

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El producto ya se encuentra en la factura, para agregar más producto editele su cantidad."));
        }

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
                            this.producto = contro.obtenerProductoPorCodigoBarras(this.codBarrasProductoSeleccionado);

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

    public void mostrarDialogPedirCantidadProductoPorText() {

        this.cantidadProductoDigitadoxText = "1";

        if (codigoBarras.equals("")) {
            //esta vacio el text 
        } else {

            //consulto si esta repetido 
            if (verificarDetalleFactura(codigoBarras) == true) {
                try {
                    //se puede agregar
                    //consultelo
                    ProductoController contro = new ProductoController();

                    //obtener datos del cliente seleccionado
                    this.producto = contro.obtenerProductoPorCodigoBarras(codigoBarras);

                    if (this.producto == null) {

                    } else {

                        if (this.producto.getCodBarras().equals("1")) {
                            //abrimos el dialog de servicios

                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('dialogServicio').show();");

                        } else {
                            //abrimos el dialog normal
                            this.precioRealText = this.producto.getPrecioVentaReal().toString();
                            RequestContext context = RequestContext.getCurrentInstance();
                            context.execute("PF('dialogPedirCantidadProductosxText').show();");
                        }

                    }
                } catch (Exception ex) {
                    Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                //no se puede agregar
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El producto ya se encuentra en la factura, para agregar más producto editele su cantidad."));
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

    public boolean verificarDetalleFactura(String codBarras) {
        //comprobar si en la lista de detalles existe ese mismo producto, si existe, sacar mensaje de alerta: 
        //que diga ya existe el mismo producto en la factura, editele la cantidad

        //verificar si en la lista existe el codigo de barras de el producto a agregar
        //recorrer la lista
        int tamañoLista = listaDetalleFactura.size();
        int error = 0;

        for (int i = 0; i < tamañoLista; i++) {
            if (listaDetalleFactura.get(i).getProducto().getCodBarras().equals(codBarras)) {
                error++;
            }
        }
        if (error == 0) {
            return true;
        } else {
            return false;
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
                    productoModificarCant = pDao.obtenerProductoPorCodigoBarras(this.codBarrasProductoModificarCantidad);

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

    public void registrarVentaFactura() {

        this.session = null;
        this.tr = null;

        this.session = HibernateUtil.getSessionFactory().openSession();
        this.tr = this.session.beginTransaction();

        try {

            Factura f = new Factura();
            f = obtenerUltimoRegistro(this.session);

            if (obtenerCuantosRegistrosHayEnFactura(this.session) == 0) {
                this.numeroFactura = Long.parseLong("1");
            } else {
                Integer num = f.getCodfactura().intValue() + 1;
                this.numeroFactura = Long.parseLong(num.toString());
            }

            //numero de factura
            System.out.println("--El codigo de la factura es: " + this.numeroFactura);

            //selecciono el cliente
            if (cliente == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Debe de seleccionar un cliente."));
            } else {

                //Cliente
                System.out.println("--El codigo del cliente es: " + this.cliente.getCodcliente());

                //codigo del vendedor
                System.out.println("--El codigo del usuario logueado es: " + this.usuarioBean.cedulaUsuarioLogueado);

                //selecciono total venta factura
                if (this.factura.getTotalVenta().intValue() > 0) {

                    //total factura
                    System.out.println("--Total venta de la factura es: " + this.factura.getTotalVenta());

                    //fecha actual
                    System.out.println("--La fecha actual es: " + this.fechaActual);

                    //guardo el objeto factura
                    Factura facturaGuardar = new Factura();
                    Integer numFact = Integer.parseInt(this.numeroFactura.toString());

                    Vendedor vendedorGuardar = new Vendedor();
                    vendedorGuardar.setCedula(this.usuarioBean.cedulaUsuarioLogueado);

                    FacturaController facturaController = new FacturaController();
                    try {

                        Date date = new Date();
                        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                        String fechaA = hourdateFormat.format(date);

                        Date fecha = null;

                        try {
                            fecha = hourdateFormat.parse(fechaA);

                        } catch (Exception e) {

                        }

                        facturaGuardar.setCodfactura(new BigDecimal(numFact));
                        facturaGuardar.setCliente(this.cliente);
                        facturaGuardar.setVendedor(vendedorGuardar);
                        facturaGuardar.setTotalVenta(this.factura.getTotalVenta());
                        facturaGuardar.setFechaRegistro(fecha);

                        facturaController.newFactura(facturaGuardar);

                    } catch (Exception e) {

                    }

                    //registro en la tabla detalle
                    for (int i = 0; i < listaDetalleFactura.size(); i++) {
                        DetalleFactura detalle = new DetalleFactura();

                        //consulto ultimo registro detalle factura
                        DetalleFactura detalle_ultimo = new DetalleFactura();
                        detalle_ultimo = obtenerUltimoRegistroDetalle(this.session);

                        BigDecimal nDetalle = null;

                        if (obtenerCuantosRegistrosHayEnDetalle(this.session) == 0) {
                            nDetalle = new BigDecimal(1);
                        } else {
                            Integer num = detalle_ultimo.getCoddetalle().intValue() + 1;
                            nDetalle = new BigDecimal(num);
                        }

                        if (listaDetalleFactura.get(i).getProducto().getCodBarras().equals("1")) {

                            //calculamos el precio real del servico (ganacia de la empresa)
                            ParametrosController parametrosController = new ParametrosController();
                            double ventaTotalDetalle = listaDetalleFactura.get(i).getTotalDetalle().doubleValue();
                            Double iva = Double.parseDouble(parametrosController.obtenerIVAmanoObra());
                            Double precioGananciaEmpresa = ventaTotalDetalle - (ventaTotalDetalle * iva) / 100;

                            detalle.setCoddetalle(nDetalle);
                            detalle.setFactura(facturaGuardar);
                            detalle.setProducto(listaDetalleFactura.get(i).getProducto());
                            detalle.setCantidad(listaDetalleFactura.get(i).getCantidad());
                            detalle.setTotalDetalle(listaDetalleFactura.get(i).getTotalDetalle());
                          //  detalle.setPrecioRealUnidad(new BigDecimal(precioGananciaEmpresa));

                            Date date = new Date();
                            DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String fechaA = hourdateFormat.format(date);
                            Date fecha = null;
                            try {
                                fecha = hourdateFormat.parse(fechaA);
                            } catch (ParseException ex) {
                                Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            facturaController.newDetalle(detalle);

                        } else {
                            detalle.setCoddetalle(nDetalle);
                            detalle.setFactura(facturaGuardar);
                            detalle.setProducto(listaDetalleFactura.get(i).getProducto());
                            detalle.setCantidad(listaDetalleFactura.get(i).getCantidad());
                            detalle.setTotalDetalle(listaDetalleFactura.get(i).getTotalDetalle());
                          //  detalle.setPrecioRealUnidad(listaDetalleFactura.get(i).getPrecioRealUni);

                            facturaController.newDetalle(detalle);

                            //actualizar stock del producto
                            ProductoController productoController = new ProductoController();
                            productoController.actualizarStockActual(listaDetalleFactura.get(i).getProducto().getCodBarras(), listaDetalleFactura.get(i).getCantidad().longValue());
                        }

                    }

                    //venta registrada con exito
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "La venta se registró correctamente."));
                    //habilitar impresora
                    this.habilitarImpresora = false;
                    this.habilitarBtnRegistrar = true;
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "No hay productos registrados."));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FacturaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cancelarVenta() {
        this.listaDetalleFactura = new ArrayList<>();
        cliente = null;
        factura = new Factura();
        this.ultimaFactura = new Factura();
        this.habilitarImpresora = true;
        this.habilitarBtnRegistrar = false;
    }

    public Factura obtenerUltimoRegistro(Session session) throws Exception {

        String hql = "FROM Factura ORDER BY codFactura DESC";
        Query q = session.createQuery(hql).setMaxResults(1);
        return (Factura) q.uniqueResult();
    }

    public DetalleFactura obtenerUltimoRegistroDetalle(Session session) throws Exception {

        String hql = "FROM DetalleFactura ORDER BY coddetalle DESC";
        Query q = session.createQuery(hql).setMaxResults(1);
        return (DetalleFactura) q.uniqueResult();
    }

    public Long obtenerCuantosRegistrosHayEnFactura(Session session) {

        String hql = "SELECT COUNT(*) FROM Factura";
        Query q = session.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    public Long obtenerCuantosRegistrosHayEnServicios(Session session) {

        String hql = "SELECT COUNT(*) FROM Servicios";
        Query q = session.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    public Long obtenerCuantosRegistrosHayEnDetalle(Session session) {

        String hql = "SELECT COUNT(*) FROM DetalleFactura";
        Query q = session.createQuery(hql);
        return (Long) q.uniqueResult();
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

        cancelarVenta();
    }

}