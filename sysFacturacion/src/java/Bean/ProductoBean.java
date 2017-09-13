package Bean;

import Controller.ProductoController;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Producto;
import java.math.BigDecimal;
import java.util.Date;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable {

    private boolean check1;
    private boolean check2;

    private InputNumber txtCantidadPaquete;
    private InputText txtDescripcionPaquete;
    private InputNumber txtUnidadXPaquete;
    private InputNumber txtCompra;
    private InputNumber txtDescuentoCompra;
    private InputNumber txtCompraReal;
    private InputNumber txtPorcentajeUtilidad;
    private InputNumber txtVentaSugerida;
    private InputNumber txtComision;
    private InputNumber txtVentaReal;
    private InputNumber txtPrecioComision;
    private InputNumber txtStockMinimo;
    private InputText txtCodigoBarras;
    private Date fechaVencimiento;
    private Calendar fechaVencimientoInput;

    private InputNumber txtCantidadPaquete1;
    private InputText txtDescripcionPaquete1;
    private InputNumber txtUnidadXPaquete1;
    private InputNumber txtCompra1;
    private InputNumber txtDescuentoCompra1;
    private InputNumber txtCompraReal1;
    private InputNumber txtPorcentajeUtilidad1;
    private InputNumber txtVentaSugerida1;
    private InputNumber txtComision1;
    private InputNumber txtVentaReal1;
    private InputNumber txtPrecioComision1;
    private InputNumber txtStockMinimo1;
    private InputText txtCodigoBarras1;
    private Date fechaVencimiento1;
    private Calendar fechaVencimientoInput1;

    private InputNumber txtCantidadPaquete2;
    private InputText txtDescripcionPaquete2;
    private InputNumber txtUnidadXPaquete2;
    private InputNumber txtCompra2;
    private InputNumber txtDescuentoCompra2;
    private InputNumber txtCompraReal2;
    private InputNumber txtPorcentajeUtilidad2;
    private InputNumber txtVentaSugerida2;
    private InputNumber txtComision2;
    private InputNumber txtVentaReal2;
    private InputNumber txtPrecioComision2;
    private InputNumber txtStockMinimo2;
    private InputText txtCodigoBarras2;
    private Date fechaVencimiento2;
    private Calendar fechaVencimientoInput2;

    private Producto productoViejo;
    private List<Producto> listaProductos;
    private Producto producto;
    private List<Producto> filtroProductos;
    private List<Producto> listaProductosStockMayorCero;

    private InputNumber txtCantidadPaqueteModificar1;
    private InputText txtDescripcionPaqueteModificar1;
    private InputNumber txtUnidadXPaqueteModificar1;
    private InputNumber txtCompraModificar1;
    private InputNumber txtDescuentoCompraModificar1;
    private InputNumber txtCompraRealModificar1;
    private InputNumber txtPorcentajeUtilidadModificar1;
    private InputNumber txtVentaSugeridaModificar1;
    private InputNumber txtComisionModificar1;
    private InputNumber txtVentaRealModificar1;
    private InputNumber txtPrecioComisionModificar1;
    private InputNumber txtStockMinimoModificar1;
    private InputText txtCodigoBarrasModificar1;

    private InputNumber txtCantidadPaqueteModificar2;
    private InputText txtDescripcionPaqueteModificar2;
    private InputNumber txtUnidadXPaqueteModificar2;
    private InputNumber txtCompraModificar2;
    private InputNumber txtDescuentoCompraModificar2;
    private InputNumber txtCompraRealModificar2;
    private InputNumber txtPorcentajeUtilidadModificar2;
    private InputNumber txtVentaSugeridaModificar2;
    private InputNumber txtComisionModificar2;
    private InputNumber txtVentaRealModificar2;
    private InputNumber txtPrecioComisionModificar2;
    private InputNumber txtStockMinimoModificar2;
    private InputText txtCodigoBarrasModificar2;

    private InputNumber txtCantidadPaqueteModificar3;
    private InputText txtDescripcionPaqueteModificar3;
    private InputNumber txtUnidadXPaqueteModificar3;
    private InputNumber txtCompraModificar3;
    private InputNumber txtDescuentoCompraModificar3;
    private InputNumber txtCompraRealModificar3;
    private InputNumber txtPorcentajeUtilidadModificar3;
    private InputNumber txtVentaSugeridaModificar3;
    private InputNumber txtComisionModificar3;
    private InputNumber txtVentaRealModificar3;
    private InputNumber txtPrecioComisionModificar3;
    private InputNumber txtStockMinimoModificar3;
    private InputText txtCodigoBarrasModificar3;

    private Date fechaVencimientoModificar1;
    private Calendar fechaVencimientoInputModificar1;

    private Date fechaVencimientoModificar2;
    private Calendar fechaVencimientoInputModificar2;

    private Date fechaVencimientoModificar3;
    private Calendar fechaVencimientoInputModificar3;

    private boolean checkModificar1;
    private boolean checkModificar2;

    private Producto productoModificar1;
    private Producto productoModificar2;
    private Producto productoModificar3;

    List<Producto> listaProductosModificarCodComun;

    private boolean checkConservarStock;
    private boolean checkActualizarLinea;

    private List<Producto> listaProductosConsultar;
    private List<Producto> filtroProductosConsultar;

    //-------------
    private InputNumber txtAdicionarProductos;

    private InputNumber txtCantidadPaqueteNuevo;
    private InputText txtDescripcionPaqueteNuevo;
    private InputNumber txtUnidadXPaqueteNuevo;
    private InputNumber txtCompraNuevo;
    private InputNumber txtDescuentoCompraNuevo;
    private InputNumber txtCompraRealNuevo;
    private InputNumber txtPorcentajeUtilidadNuevo;
    private InputNumber txtVentaSugeridaNuevo;
    private InputNumber txtComisionNuevo;
    private InputNumber txtVentaRealNuevo;
    private InputNumber txtPrecioComisionNuevo;
    private InputNumber txtStockMinimoNuevo;

    public ProductoBean() {
    }

    @PostConstruct
    public void Init() {
        producto = null;
        productoViejo = null;
        this.listaProductosModificarCodComun = null;

    }

    public Date getFechaVencimientoModificar1() {
        return fechaVencimientoModificar1;
    }

    public void setFechaVencimientoModificar1(Date fechaVencimientoModificar1) {
        this.fechaVencimientoModificar1 = fechaVencimientoModificar1;
    }

    public Calendar getFechaVencimientoInputModificar1() {
        return fechaVencimientoInputModificar1;
    }

    public void setFechaVencimientoInputModificar1(Calendar fechaVencimientoInputModificar1) {
        this.fechaVencimientoInputModificar1 = fechaVencimientoInputModificar1;
    }

    public Date getFechaVencimientoModificar2() {
        return fechaVencimientoModificar2;
    }

    public void setFechaVencimientoModificar2(Date fechaVencimientoModificar2) {
        this.fechaVencimientoModificar2 = fechaVencimientoModificar2;
    }

    public Calendar getFechaVencimientoInputModificar2() {
        return fechaVencimientoInputModificar2;
    }

    public void setFechaVencimientoInputModificar2(Calendar fechaVencimientoInputModificar2) {
        this.fechaVencimientoInputModificar2 = fechaVencimientoInputModificar2;
    }

    public Date getFechaVencimientoModificar3() {
        return fechaVencimientoModificar3;
    }

    public void setFechaVencimientoModificar3(Date fechaVencimientoModificar3) {
        this.fechaVencimientoModificar3 = fechaVencimientoModificar3;
    }

    public Calendar getFechaVencimientoInputModificar3() {
        return fechaVencimientoInputModificar3;
    }

    public void setFechaVencimientoInputModificar3(Calendar fechaVencimientoInputModificar3) {
        this.fechaVencimientoInputModificar3 = fechaVencimientoInputModificar3;
    }

    public Calendar getFechaVencimientoInput() {
        return fechaVencimientoInput;
    }

    public void setFechaVencimientoInput(Calendar fechaVencimientoInput) {
        this.fechaVencimientoInput = fechaVencimientoInput;
    }

    public Calendar getFechaVencimientoInput1() {
        return fechaVencimientoInput1;
    }

    public void setFechaVencimientoInput1(Calendar fechaVencimientoInput1) {
        this.fechaVencimientoInput1 = fechaVencimientoInput1;
    }

    public Calendar getFechaVencimientoInput2() {
        return fechaVencimientoInput2;
    }

    public void setFechaVencimientoInput2(Calendar fechaVencimientoInput2) {
        this.fechaVencimientoInput2 = fechaVencimientoInput2;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento1() {
        return fechaVencimiento1;
    }

    public void setFechaVencimiento1(Date fechaVencimiento1) {
        this.fechaVencimiento1 = fechaVencimiento1;
    }

    public Date getFechaVencimiento2() {
        return fechaVencimiento2;
    }

    public void setFechaVencimiento2(Date fechaVencimiento2) {
        this.fechaVencimiento2 = fechaVencimiento2;
    }

    public List<Producto> getListaProductosConsultar() {
        ProductoController pDao = new ProductoController();
        listaProductosConsultar = pDao.listarProductos();
        return listaProductosConsultar;

    }

    public void setListaProductosConsultar(List<Producto> listaProductosConsultar) {
        this.listaProductosConsultar = listaProductosConsultar;
    }

    public List<Producto> getFiltroProductosConsultar() {
        return filtroProductosConsultar;
    }

    public void setFiltroProductosConsultar(List<Producto> filtroProductosConsultar) {
        this.filtroProductosConsultar = filtroProductosConsultar;
    }

    public boolean isCheckActualizarLinea() {
        setCheckActualizarLinea(false);
        return checkActualizarLinea;
    }

    public void setCheckActualizarLinea(boolean checkActualizarLinea) {
        this.checkActualizarLinea = checkActualizarLinea;
    }

    public boolean isCheckConservarStock() {
        setCheckConservarStock(true);
        return checkConservarStock;
    }

    public void setCheckConservarStock(boolean checkConservarStock) {
        this.checkConservarStock = checkConservarStock;
    }

    public List<Producto> getListaProductosModificarCodComun() {
        return listaProductosModificarCodComun;
    }

    public void setListaProductosModificarCodComun(List<Producto> listaProductosModificarCodComun) {
        this.listaProductosModificarCodComun = listaProductosModificarCodComun;
    }

    public boolean isCheckModificar1() {
        return checkModificar1;
    }

    public void setCheckModificar1(boolean checkModificar1) {
        this.checkModificar1 = checkModificar1;
    }

    public boolean isCheckModificar2() {
        return checkModificar2;
    }

    public void setCheckModificar2(boolean checkModificar2) {
        this.checkModificar2 = checkModificar2;
    }

    public InputNumber getTxtStockMinimoModificar1() {
        return txtStockMinimoModificar1;
    }

    public void setTxtStockMinimoModificar1(InputNumber txtStockMinimoModificar1) {
        this.txtStockMinimoModificar1 = txtStockMinimoModificar1;
    }

    public InputText getTxtCodigoBarrasModificar1() {
        return txtCodigoBarrasModificar1;
    }

    public void setTxtCodigoBarrasModificar1(InputText txtCodigoBarrasModificar1) {
        this.txtCodigoBarrasModificar1 = txtCodigoBarrasModificar1;
    }

    public InputNumber getTxtStockMinimoModificar2() {
        return txtStockMinimoModificar2;
    }

    public void setTxtStockMinimoModificar2(InputNumber txtStockMinimoModificar2) {
        this.txtStockMinimoModificar2 = txtStockMinimoModificar2;
    }

    public InputText getTxtCodigoBarrasModificar2() {
        return txtCodigoBarrasModificar2;
    }

    public void setTxtCodigoBarrasModificar2(InputText txtCodigoBarrasModificar2) {
        this.txtCodigoBarrasModificar2 = txtCodigoBarrasModificar2;
    }

    public InputNumber getTxtStockMinimoModificar3() {
        return txtStockMinimoModificar3;
    }

    public void setTxtStockMinimoModificar3(InputNumber txtStockMinimoModificar3) {
        this.txtStockMinimoModificar3 = txtStockMinimoModificar3;
    }

    public InputText getTxtCodigoBarrasModificar3() {
        return txtCodigoBarrasModificar3;
    }

    public void setTxtCodigoBarrasModificar3(InputText txtCodigoBarrasModificar3) {
        this.txtCodigoBarrasModificar3 = txtCodigoBarrasModificar3;
    }

    public InputNumber getTxtCantidadPaqueteModificar3() {
        return txtCantidadPaqueteModificar3;
    }

    public void setTxtCantidadPaqueteModificar3(InputNumber txtCantidadPaqueteModificar3) {
        this.txtCantidadPaqueteModificar3 = txtCantidadPaqueteModificar3;
    }

    public InputText getTxtDescripcionPaqueteModificar3() {
        return txtDescripcionPaqueteModificar3;
    }

    public void setTxtDescripcionPaqueteModificar3(InputText txtDescripcionPaqueteModificar3) {
        this.txtDescripcionPaqueteModificar3 = txtDescripcionPaqueteModificar3;
    }

    public InputNumber getTxtUnidadXPaqueteModificar3() {
        return txtUnidadXPaqueteModificar3;
    }

    public void setTxtUnidadXPaqueteModificar3(InputNumber txtUnidadXPaqueteModificar3) {
        this.txtUnidadXPaqueteModificar3 = txtUnidadXPaqueteModificar3;
    }

    public InputNumber getTxtCompraModificar3() {
        return txtCompraModificar3;
    }

    public void setTxtCompraModificar3(InputNumber txtCompraModificar3) {
        this.txtCompraModificar3 = txtCompraModificar3;
    }

    public InputNumber getTxtDescuentoCompraModificar3() {
        return txtDescuentoCompraModificar3;
    }

    public void setTxtDescuentoCompraModificar3(InputNumber txtDescuentoCompraModificar3) {
        this.txtDescuentoCompraModificar3 = txtDescuentoCompraModificar3;
    }

    public InputNumber getTxtCompraRealModificar3() {
        return txtCompraRealModificar3;
    }

    public void setTxtCompraRealModificar3(InputNumber txtCompraRealModificar3) {
        this.txtCompraRealModificar3 = txtCompraRealModificar3;
    }

    public InputNumber getTxtPorcentajeUtilidadModificar3() {
        return txtPorcentajeUtilidadModificar3;
    }

    public void setTxtPorcentajeUtilidadModificar3(InputNumber txtPorcentajeUtilidadModificar3) {
        this.txtPorcentajeUtilidadModificar3 = txtPorcentajeUtilidadModificar3;
    }

    public InputNumber getTxtVentaSugeridaModificar3() {
        return txtVentaSugeridaModificar3;
    }

    public void setTxtVentaSugeridaModificar3(InputNumber txtVentaSugeridaModificar3) {
        this.txtVentaSugeridaModificar3 = txtVentaSugeridaModificar3;
    }

    public InputNumber getTxtComisionModificar3() {
        return txtComisionModificar3;
    }

    public void setTxtComisionModificar3(InputNumber txtComisionModificar3) {
        this.txtComisionModificar3 = txtComisionModificar3;
    }

    public InputNumber getTxtVentaRealModificar3() {
        return txtVentaRealModificar3;
    }

    public void setTxtVentaRealModificar3(InputNumber txtVentaRealModificar3) {
        this.txtVentaRealModificar3 = txtVentaRealModificar3;
    }

    public InputNumber getTxtPrecioComisionModificar3() {
        return txtPrecioComisionModificar3;
    }

    public void setTxtPrecioComisionModificar3(InputNumber txtPrecioComisionModificar3) {
        this.txtPrecioComisionModificar3 = txtPrecioComisionModificar3;
    }

    public InputNumber getTxtCantidadPaqueteModificar2() {
        return txtCantidadPaqueteModificar2;
    }

    public void setTxtCantidadPaqueteModificar2(InputNumber txtCantidadPaqueteModificar2) {
        this.txtCantidadPaqueteModificar2 = txtCantidadPaqueteModificar2;
    }

    public InputText getTxtDescripcionPaqueteModificar2() {
        return txtDescripcionPaqueteModificar2;
    }

    public void setTxtDescripcionPaqueteModificar2(InputText txtDescripcionPaqueteModificar2) {
        this.txtDescripcionPaqueteModificar2 = txtDescripcionPaqueteModificar2;
    }

    public InputNumber getTxtUnidadXPaqueteModificar2() {
        return txtUnidadXPaqueteModificar2;
    }

    public void setTxtUnidadXPaqueteModificar2(InputNumber txtUnidadXPaqueteModificar2) {
        this.txtUnidadXPaqueteModificar2 = txtUnidadXPaqueteModificar2;
    }

    public InputNumber getTxtCompraModificar2() {
        return txtCompraModificar2;
    }

    public void setTxtCompraModificar2(InputNumber txtCompraModificar2) {
        this.txtCompraModificar2 = txtCompraModificar2;
    }

    public InputNumber getTxtDescuentoCompraModificar2() {
        return txtDescuentoCompraModificar2;
    }

    public void setTxtDescuentoCompraModificar2(InputNumber txtDescuentoCompraModificar2) {
        this.txtDescuentoCompraModificar2 = txtDescuentoCompraModificar2;
    }

    public InputNumber getTxtCompraRealModificar2() {
        return txtCompraRealModificar2;
    }

    public void setTxtCompraRealModificar2(InputNumber txtCompraRealModificar2) {
        this.txtCompraRealModificar2 = txtCompraRealModificar2;
    }

    public InputNumber getTxtPorcentajeUtilidadModificar2() {
        return txtPorcentajeUtilidadModificar2;
    }

    public void setTxtPorcentajeUtilidadModificar2(InputNumber txtPorcentajeUtilidadModificar2) {
        this.txtPorcentajeUtilidadModificar2 = txtPorcentajeUtilidadModificar2;
    }

    public InputNumber getTxtVentaSugeridaModificar2() {
        return txtVentaSugeridaModificar2;
    }

    public void setTxtVentaSugeridaModificar2(InputNumber txtVentaSugeridaModificar2) {
        this.txtVentaSugeridaModificar2 = txtVentaSugeridaModificar2;
    }

    public InputNumber getTxtComisionModificar2() {
        return txtComisionModificar2;
    }

    public void setTxtComisionModificar2(InputNumber txtComisionModificar2) {
        this.txtComisionModificar2 = txtComisionModificar2;
    }

    public InputNumber getTxtVentaRealModificar2() {
        return txtVentaRealModificar2;
    }

    public void setTxtVentaRealModificar2(InputNumber txtVentaRealModificar2) {
        this.txtVentaRealModificar2 = txtVentaRealModificar2;
    }

    public InputNumber getTxtPrecioComisionModificar2() {
        return txtPrecioComisionModificar2;
    }

    public void setTxtPrecioComisionModificar2(InputNumber txtPrecioComisionModificar2) {
        this.txtPrecioComisionModificar2 = txtPrecioComisionModificar2;
    }

    public Producto getProductoModificar1() {
        return productoModificar1;
    }

    public void setProductoModificar1(Producto productoModificar1) {
        this.productoModificar1 = productoModificar1;
    }

    public Producto getProductoModificar2() {
        return productoModificar2;
    }

    public void setProductoModificar2(Producto productoModificar2) {
        this.productoModificar2 = productoModificar2;
    }

    public Producto getProductoModificar3() {
        return productoModificar3;
    }

    public void setProductoModificar3(Producto productoModificar3) {
        this.productoModificar3 = productoModificar3;
    }

    public InputText getTxtCodigoBarras() {
        return txtCodigoBarras;
    }

    public void setTxtCodigoBarras(InputText txtCodigoBarras) {
        this.txtCodigoBarras = txtCodigoBarras;
    }

    public InputText getTxtCodigoBarras1() {
        return txtCodigoBarras1;
    }

    public void setTxtCodigoBarras1(InputText txtCodigoBarras1) {
        this.txtCodigoBarras1 = txtCodigoBarras1;
    }

    public InputText getTxtCodigoBarras2() {
        return txtCodigoBarras2;
    }

    public void setTxtCodigoBarras2(InputText txtCodigoBarras2) {
        this.txtCodigoBarras2 = txtCodigoBarras2;
    }

    public InputNumber getTxtCantidadPaqueteNuevo() {
        return txtCantidadPaqueteNuevo;
    }

    public void setTxtCantidadPaqueteNuevo(InputNumber txtCantidadPaqueteNuevo) {
        this.txtCantidadPaqueteNuevo = txtCantidadPaqueteNuevo;
    }

    public InputText getTxtDescripcionPaqueteNuevo() {
        return txtDescripcionPaqueteNuevo;
    }

    public void setTxtDescripcionPaqueteNuevo(InputText txtDescripcionPaqueteNuevo) {
        this.txtDescripcionPaqueteNuevo = txtDescripcionPaqueteNuevo;
    }

    public InputNumber getTxtUnidadXPaqueteNuevo() {
        return txtUnidadXPaqueteNuevo;
    }

    public void setTxtUnidadXPaqueteNuevo(InputNumber txtUnidadXPaqueteNuevo) {
        this.txtUnidadXPaqueteNuevo = txtUnidadXPaqueteNuevo;
    }

    public InputNumber getTxtCompraNuevo() {
        return txtCompraNuevo;
    }

    public void setTxtCompraNuevo(InputNumber txtCompraNuevo) {
        this.txtCompraNuevo = txtCompraNuevo;
    }

    public InputNumber getTxtDescuentoCompraNuevo() {
        return txtDescuentoCompraNuevo;
    }

    public void setTxtDescuentoCompraNuevo(InputNumber txtDescuentoCompraNuevo) {
        this.txtDescuentoCompraNuevo = txtDescuentoCompraNuevo;
    }

    public InputNumber getTxtCompraRealNuevo() {
        return txtCompraRealNuevo;
    }

    public void setTxtCompraRealNuevo(InputNumber txtCompraRealNuevo) {
        this.txtCompraRealNuevo = txtCompraRealNuevo;
    }

    public InputNumber getTxtPorcentajeUtilidadNuevo() {
        return txtPorcentajeUtilidadNuevo;
    }

    public void setTxtPorcentajeUtilidadNuevo(InputNumber txtPorcentajeUtilidadNuevo) {
        this.txtPorcentajeUtilidadNuevo = txtPorcentajeUtilidadNuevo;
    }

    public InputNumber getTxtVentaSugeridaNuevo() {
        return txtVentaSugeridaNuevo;
    }

    public void setTxtVentaSugeridaNuevo(InputNumber txtVentaSugeridaNuevo) {
        this.txtVentaSugeridaNuevo = txtVentaSugeridaNuevo;
    }

    public InputNumber getTxtComisionNuevo() {
        return txtComisionNuevo;
    }

    public void setTxtComisionNuevo(InputNumber txtComisionNuevo) {
        this.txtComisionNuevo = txtComisionNuevo;
    }

    public InputNumber getTxtVentaRealNuevo() {
        return txtVentaRealNuevo;
    }

    public void setTxtVentaRealNuevo(InputNumber txtVentaRealNuevo) {
        this.txtVentaRealNuevo = txtVentaRealNuevo;
    }

    public InputNumber getTxtPrecioComisionNuevo() {
        return txtPrecioComisionNuevo;
    }

    public void setTxtPrecioComisionNuevo(InputNumber txtPrecioComisionNuevo) {
        this.txtPrecioComisionNuevo = txtPrecioComisionNuevo;
    }

    public InputNumber getTxtStockMinimoNuevo() {
        return txtStockMinimoNuevo;
    }

    public void setTxtStockMinimoNuevo(InputNumber txtStockMinimoNuevo) {
        this.txtStockMinimoNuevo = txtStockMinimoNuevo;
    }

    public InputNumber getTxtStockMinimo() {
        return txtStockMinimo;
    }

    public InputNumber getTxtAdicionarProductos() {
        return txtAdicionarProductos;
    }

    public void setTxtAdicionarProductos(InputNumber txtAdicionarProductos) {
        this.txtAdicionarProductos = txtAdicionarProductos;
    }

    public void setTxtStockMinimo(InputNumber txtStockMinimo) {
        this.txtStockMinimo = txtStockMinimo;
    }

    public InputNumber getTxtStockMinimo1() {
        return txtStockMinimo1;
    }

    public void setTxtStockMinimo1(InputNumber txtStockMinimo1) {
        this.txtStockMinimo1 = txtStockMinimo1;
    }

    public InputNumber getTxtStockMinimo2() {
        return txtStockMinimo2;
    }

    public void setTxtStockMinimo2(InputNumber txtStockMinimo2) {
        this.txtStockMinimo2 = txtStockMinimo2;
    }

    public InputNumber getTxtCantidadPaqueteModificar1() {
        return txtCantidadPaqueteModificar1;
    }

    public void setTxtCantidadPaqueteModificar1(InputNumber txtCantidadPaqueteModificar1) {
        this.txtCantidadPaqueteModificar1 = txtCantidadPaqueteModificar1;
    }

    public InputText getTxtDescripcionPaqueteModificar1() {
        return txtDescripcionPaqueteModificar1;
    }

    public void setTxtDescripcionPaqueteModificar1(InputText txtDescripcionPaqueteModificar1) {
        this.txtDescripcionPaqueteModificar1 = txtDescripcionPaqueteModificar1;
    }

    public InputNumber getTxtUnidadXPaqueteModificar1() {
        return txtUnidadXPaqueteModificar1;
    }

    public void setTxtUnidadXPaqueteModificar1(InputNumber txtUnidadXPaqueteModificar1) {
        this.txtUnidadXPaqueteModificar1 = txtUnidadXPaqueteModificar1;
    }

    public InputNumber getTxtCompraModificar1() {
        return txtCompraModificar1;
    }

    public void setTxtCompraModificar1(InputNumber txtCompraModificar1) {
        this.txtCompraModificar1 = txtCompraModificar1;
    }

    public InputNumber getTxtDescuentoCompraModificar1() {
        return txtDescuentoCompraModificar1;
    }

    public void setTxtDescuentoCompraModificar1(InputNumber txtDescuentoCompraModificar1) {
        this.txtDescuentoCompraModificar1 = txtDescuentoCompraModificar1;
    }

    public InputNumber getTxtCompraRealModificar1() {
        return txtCompraRealModificar1;
    }

    public void setTxtCompraRealModificar1(InputNumber txtCompraRealModificar1) {
        this.txtCompraRealModificar1 = txtCompraRealModificar1;
    }

    public InputNumber getTxtPorcentajeUtilidadModificar1() {
        return txtPorcentajeUtilidadModificar1;
    }

    public void setTxtPorcentajeUtilidadModificar1(InputNumber txtPorcentajeUtilidadModificar1) {
        this.txtPorcentajeUtilidadModificar1 = txtPorcentajeUtilidadModificar1;
    }

    public InputNumber getTxtVentaSugeridaModificar1() {
        return txtVentaSugeridaModificar1;
    }

    public void setTxtVentaSugeridaModificar1(InputNumber txtVentaSugeridaModificar1) {
        this.txtVentaSugeridaModificar1 = txtVentaSugeridaModificar1;
    }

    public InputNumber getTxtComisionModificar1() {
        return txtComisionModificar1;
    }

    public void setTxtComisionModificar1(InputNumber txtComisionModificar1) {
        this.txtComisionModificar1 = txtComisionModificar1;
    }

    public InputNumber getTxtVentaRealModificar1() {
        return txtVentaRealModificar1;
    }

    public void setTxtVentaRealModificar1(InputNumber txtVentaRealModificar1) {
        this.txtVentaRealModificar1 = txtVentaRealModificar1;
    }

    public InputNumber getTxtPrecioComisionModificar1() {
        return txtPrecioComisionModificar1;
    }

    public void setTxtPrecioComisionModificar1(InputNumber txtPrecioComisionModificar1) {
        this.txtPrecioComisionModificar1 = txtPrecioComisionModificar1;
    }

    public InputNumber getTxtPrecioComision() {
        return txtPrecioComision;
    }

    public void setTxtPrecioComision(InputNumber txtPrecioComision) {
        this.txtPrecioComision = txtPrecioComision;
    }

    public InputNumber getTxtPrecioComision1() {
        return txtPrecioComision1;
    }

    public void setTxtPrecioComision1(InputNumber txtPrecioComision1) {
        this.txtPrecioComision1 = txtPrecioComision1;
    }

    public InputNumber getTxtPrecioComision2() {
        return txtPrecioComision2;
    }

    public void setTxtPrecioComision2(InputNumber txtPrecioComision2) {
        this.txtPrecioComision2 = txtPrecioComision2;
    }

    public InputNumber getTxtUnidadXPaquete() {
        return txtUnidadXPaquete;
    }

    public void setTxtUnidadXPaquete(InputNumber txtUnidadXPaquete) {
        this.txtUnidadXPaquete = txtUnidadXPaquete;
    }

    public InputNumber getTxtCompra() {
        return txtCompra;
    }

    public void setTxtCompra(InputNumber txtCompra) {
        this.txtCompra = txtCompra;
    }

    public InputNumber getTxtDescuentoCompra() {
        return txtDescuentoCompra;
    }

    public void setTxtDescuentoCompra(InputNumber txtDescuentoCompra) {
        this.txtDescuentoCompra = txtDescuentoCompra;
    }

    public InputNumber getTxtCompraReal() {
        return txtCompraReal;
    }

    public void setTxtCompraReal(InputNumber txtCompraReal) {
        this.txtCompraReal = txtCompraReal;
    }

    public InputNumber getTxtPorcentajeUtilidad() {
        return txtPorcentajeUtilidad;
    }

    public void setTxtPorcentajeUtilidad(InputNumber txtPorcentajeUtilidad) {
        this.txtPorcentajeUtilidad = txtPorcentajeUtilidad;
    }

    public InputNumber getTxtVentaSugerida() {
        return txtVentaSugerida;
    }

    public void setTxtVentaSugerida(InputNumber txtVentaSugerida) {
        this.txtVentaSugerida = txtVentaSugerida;
    }

    public InputNumber getTxtComision() {
        return txtComision;
    }

    public void setTxtComision(InputNumber txtComision) {
        this.txtComision = txtComision;
    }

    public InputNumber getTxtVentaReal() {
        return txtVentaReal;
    }

    public void setTxtVentaReal(InputNumber txtVentaReal) {
        this.txtVentaReal = txtVentaReal;
    }

    public InputNumber getTxtUnidadXPaquete1() {
        return txtUnidadXPaquete1;
    }

    public void setTxtUnidadXPaquete1(InputNumber txtUnidadXPaquete1) {
        this.txtUnidadXPaquete1 = txtUnidadXPaquete1;
    }

    public InputNumber getTxtCompra1() {
        return txtCompra1;
    }

    public void setTxtCompra1(InputNumber txtCompra1) {
        this.txtCompra1 = txtCompra1;
    }

    public InputNumber getTxtDescuentoCompra1() {
        return txtDescuentoCompra1;
    }

    public void setTxtDescuentoCompra1(InputNumber txtDescuentoCompra1) {
        this.txtDescuentoCompra1 = txtDescuentoCompra1;
    }

    public InputNumber getTxtCompraReal1() {
        return txtCompraReal1;
    }

    public void setTxtCompraReal1(InputNumber txtCompraReal1) {
        this.txtCompraReal1 = txtCompraReal1;
    }

    public InputNumber getTxtPorcentajeUtilidad1() {
        return txtPorcentajeUtilidad1;
    }

    public void setTxtPorcentajeUtilidad1(InputNumber txtPorcentajeUtilidad1) {
        this.txtPorcentajeUtilidad1 = txtPorcentajeUtilidad1;
    }

    public InputNumber getTxtVentaSugerida1() {
        return txtVentaSugerida1;
    }

    public void setTxtVentaSugerida1(InputNumber txtVentaSugerida1) {
        this.txtVentaSugerida1 = txtVentaSugerida1;
    }

    public InputNumber getTxtComision1() {
        return txtComision1;
    }

    public void setTxtComision1(InputNumber txtComision1) {
        this.txtComision1 = txtComision1;
    }

    public InputNumber getTxtVentaReal1() {
        return txtVentaReal1;
    }

    public void setTxtVentaReal1(InputNumber txtVentaReal1) {
        this.txtVentaReal1 = txtVentaReal1;
    }

    public InputNumber getTxtUnidadXPaquete2() {
        return txtUnidadXPaquete2;
    }

    public void setTxtUnidadXPaquete2(InputNumber txtUnidadXPaquete2) {
        this.txtUnidadXPaquete2 = txtUnidadXPaquete2;
    }

    public InputNumber getTxtCompra2() {
        return txtCompra2;
    }

    public void setTxtCompra2(InputNumber txtCompra2) {
        this.txtCompra2 = txtCompra2;
    }

    public InputNumber getTxtDescuentoCompra2() {
        return txtDescuentoCompra2;
    }

    public void setTxtDescuentoCompra2(InputNumber txtDescuentoCompra2) {
        this.txtDescuentoCompra2 = txtDescuentoCompra2;
    }

    public InputNumber getTxtCompraReal2() {
        return txtCompraReal2;
    }

    public void setTxtCompraReal2(InputNumber txtCompraReal2) {
        this.txtCompraReal2 = txtCompraReal2;
    }

    public InputNumber getTxtPorcentajeUtilidad2() {
        return txtPorcentajeUtilidad2;
    }

    public void setTxtPorcentajeUtilidad2(InputNumber txtPorcentajeUtilidad2) {
        this.txtPorcentajeUtilidad2 = txtPorcentajeUtilidad2;
    }

    public InputNumber getTxtVentaSugerida2() {
        return txtVentaSugerida2;
    }

    public void setTxtVentaSugerida2(InputNumber txtVentaSugerida2) {
        this.txtVentaSugerida2 = txtVentaSugerida2;
    }

    public InputNumber getTxtComision2() {
        return txtComision2;
    }

    public void setTxtComision2(InputNumber txtComision2) {
        this.txtComision2 = txtComision2;
    }

    public InputNumber getTxtVentaReal2() {
        return txtVentaReal2;
    }

    public void setTxtVentaReal2(InputNumber txtVentaReal2) {
        this.txtVentaReal2 = txtVentaReal2;
    }

    public InputNumber getTxtCantidadPaquete() {
        return txtCantidadPaquete;
    }

    public void setTxtCantidadPaquete(InputNumber txtCantidadPaquete) {
        this.txtCantidadPaquete = txtCantidadPaquete;
    }

    public InputText getTxtDescripcionPaquete() {
        return txtDescripcionPaquete;
    }

    public void setTxtDescripcionPaquete(InputText txtDescripcionPaquete) {
        this.txtDescripcionPaquete = txtDescripcionPaquete;
    }

    public InputText getTxtDescripcionPaquete1() {
        return txtDescripcionPaquete1;
    }

    public void setTxtDescripcionPaquete1(InputText txtDescripcionPaquete1) {
        this.txtDescripcionPaquete1 = txtDescripcionPaquete1;
    }

    public InputText getTxtDescripcionPaquete2() {
        return txtDescripcionPaquete2;
    }

    public void setTxtDescripcionPaquete2(InputText txtDescripcionPaquete2) {
        this.txtDescripcionPaquete2 = txtDescripcionPaquete2;
    }

    public InputNumber getTxtCantidadPaquete1() {
        return txtCantidadPaquete1;
    }

    public void setTxtCantidadPaquete1(InputNumber txtCantidadPaquete1) {
        this.txtCantidadPaquete1 = txtCantidadPaquete1;
    }

    public InputNumber getTxtCantidadPaquete2() {
        return txtCantidadPaquete2;
    }

    public void setTxtCantidadPaquete2(InputNumber txtCantidadPaquete2) {
        this.txtCantidadPaquete2 = txtCantidadPaquete2;
    }

    public boolean isCheck2() {
        return check2;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }

    public boolean isCheck1() {
        return check1;
    }

    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }

    public List<Producto> getListaProductosStockMayorCero() {
        ProductoController pDao = new ProductoController();
        listaProductos = pDao.listarProductosMayorCero();
        return listaProductos;
    }

    public void setListaProductosStockMayorCero(List<Producto> listaProductosStockMayorCero) {
        this.listaProductosStockMayorCero = listaProductosStockMayorCero;
    }

    public Producto getProductoViejo() {
        return productoViejo;
    }

    public void setProductoViejo(Producto productoViejo) {
        this.productoViejo = productoViejo;
    }

    public List<Producto> getListaProductos() {
        ProductoController pDao = new ProductoController();
        listaProductos = pDao.listarProductos();
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getFiltroProductos() {
        return filtroProductos;
    }

    public void setFiltroProductos(List<Producto> filtroProductos) {
        this.filtroProductos = filtroProductos;
    }

    public void prepararNuevoProducto() {
        producto = new Producto();
    }

    public void nuevoProducto() {

        BigDecimal codComun = null;
        RequestContext context = RequestContext.getCurrentInstance();

        if (producto.getNombre() == null || txtCodigoBarras.getValue() == null || txtCantidadPaquete.getValue() == null || txtDescripcionPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCompra.getValue() == null || txtDescuentoCompra.getValue() == null || txtCompraReal.getValue() == null || txtPorcentajeUtilidad.getValue() == null || txtVentaSugerida.getValue() == null || txtVentaReal.getValue() == null || txtComision.getValue() == null || txtPrecioComision.getValue() == null || txtStockMinimo.getValue() == null || fechaVencimientoInput.getValue() == null) {

            context.execute("PF('dialogNuevoProducto').show();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

        } else {

            if (producto.getNombre().equals("") || txtCodigoBarras.getValue().toString().equals("") || txtCantidadPaquete.getValue().equals("0") || txtDescripcionPaquete.getValue().toString().equals("") || txtUnidadXPaquete.getValue().equals("0") || txtCompra.getValue().equals("0") || txtPorcentajeUtilidad.getValue().equals("0") || txtVentaReal.getValue().equals("0") || txtStockMinimo.getValue().equals("0") || fechaVencimientoInput.getValue().toString().equals("")) {

                context.execute("PF('dialogNuevoProducto').show();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

            } else {
                if (check1 == false && check2 == false) {
                    //agregar normal

                    double precio_sugerido = Double.parseDouble(txtVentaSugerida.getValue().toString());
                    double precio_venta_real = Double.parseDouble(txtVentaReal.getValue().toString());

                    if (precio_venta_real < precio_sugerido) {
                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                    } else {

                        try {

                            ProductoController ProductoController = new ProductoController();
                            boolean existe = ProductoController.obtenerProductoPorCodigoBarras(txtCodigoBarras.getValue().toString());

                            if (existe == false) {
                                //agrego primera fila

                                //consecutivo
                                Long cod_producto = 0L;
                                Producto p = new Producto();

                                p = ProductoController.obtenerUltimoRegistro();
                                if (ProductoController.obtenerCuantosRegistrosHayEnProducto() == 0) {
                                    cod_producto = Long.parseLong("1");
                                } else {
                                    Integer num = p.getCodigo().intValue() + 1;
                                    cod_producto = Long.parseLong(num.toString());
                                }

                                BigDecimal cod = new BigDecimal(cod_producto);
                                producto.setCodigo(cod);

                                //cod comun
                                Long cod_comun = 0L;
                                Producto p_comun = new Producto();

                                p_comun = ProductoController.obtenerUltimoRegistroComun();
                                if (ProductoController.obtenerCuantosRegistrosHayEnProductoComun() == 0) {
                                    cod_comun = Long.parseLong("1");
                                } else {
                                    Integer num_comun = p_comun.getCodComun().intValue() + 1;
                                    cod_comun = Long.parseLong(num_comun.toString());
                                }

                                codComun = new BigDecimal(cod_comun);
                                producto.setCodComun(codComun);

                                //orden
                                producto.setOrden(3);

                                //codigo de barras
                                producto.setCodBarras(txtCodigoBarras.getValue().toString());

                                String nombre_producto = producto.getNombre().toUpperCase();
                                producto.setNombre(nombre_producto);

                                producto.setUnidadXPaquete(Long.parseLong(txtUnidadXPaquete.getValue().toString()));

                                producto.setPaquete(txtDescripcionPaquete.getValue().toString().toUpperCase());
                                BigDecimal precio_compra = new BigDecimal(txtCompra.getValue().toString());
                                producto.setPrecioCompra(precio_compra);

                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompra.getValue().toString());
                                producto.setPorcentajeDescuento(prcentaje_descuento);

                                BigDecimal precio_compra_real = new BigDecimal(txtCompraReal.getValue().toString());
                                producto.setPrecioCompraReal(precio_compra_real);

                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidad.getValue().toString());
                                producto.setPorcentajeUtilidad(porcentaje_utilidad);

                                BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                producto.setVentaSugerida(venta_sugerida);

                                BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                producto.setPrecioVentaReal(venta_real);

                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaquete.getValue().toString()));
                                producto.setStockActUni(stock_actual);

                                Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimo.getValue().toString()));
                                producto.setStockMinUni(stock_minimo);

                                BigDecimal comision = new BigDecimal(txtPrecioComision.getValue().toString());
                                producto.setComision(comision);

                                BigDecimal porcentaje_comision = new BigDecimal(txtComision.getValue().toString());
                                producto.setPorcentajeComision(porcentaje_comision);

                                producto.setFechaVencimiento(fechaVencimiento);

                                ProductoController.newProducto(producto);

                                cancelarRegistroProducto();

                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El producto fue agregado exitosamente."));

                            } else {
                                context.execute("PF('dialogNuevoProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                            }

                        } catch (Exception ex) {
                            Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    //agrego primera fila + check 1    
                } else if (check1 == true && check2 == false) {
                    if (producto.getNombre() == null || txtCodigoBarras.getValue() == null || txtCantidadPaquete.getValue() == null || txtDescripcionPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCompra.getValue() == null || txtDescuentoCompra.getValue() == null || txtCompraReal.getValue() == null || txtPorcentajeUtilidad.getValue() == null || txtVentaSugerida.getValue() == null || txtVentaReal.getValue() == null || txtComision.getValue() == null || txtPrecioComision.getValue() == null || txtStockMinimo.getValue() == null || fechaVencimientoInput.getValue() == null || txtCodigoBarras1.getValue() == null || txtCantidadPaquete1.getValue() == null || txtDescripcionPaquete1.getValue() == null || txtUnidadXPaquete1.getValue() == null || txtCompra1.getValue() == null || txtDescuentoCompra1.getValue() == null || txtCompraReal1.getValue() == null || txtPorcentajeUtilidad1.getValue() == null || txtVentaSugerida1.getValue() == null || txtVentaReal1.getValue() == null || txtComision1.getValue() == null || txtPrecioComision1.getValue() == null || txtStockMinimo1.getValue() == null || fechaVencimientoInput1.getValue() == null) {

                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                    } else {

                        if (producto.getNombre().equals("") || txtCodigoBarras.getValue().toString().equals("") || txtCantidadPaquete.getValue().equals("0") || txtDescripcionPaquete.getValue().toString().equals("") || txtUnidadXPaquete.getValue().equals("0") || txtCompra.getValue().equals("0") || txtPorcentajeUtilidad.getValue().equals("0") || txtVentaReal.getValue().equals("0") || txtStockMinimo.getValue().equals("0") || fechaVencimientoInput.getValue().toString().equals("") || txtCodigoBarras1.getValue().toString().equals("") || txtCantidadPaquete1.getValue().equals("0") || txtDescripcionPaquete1.getValue().toString().equals("") || txtUnidadXPaquete1.getValue().equals("0") || txtCompra1.getValue().equals("0") || txtPorcentajeUtilidad1.getValue().equals("0") || txtVentaReal1.getValue().equals("0") || txtStockMinimo1.getValue().equals("0") || fechaVencimientoInput1.getValue().toString().equals("")) {

                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                        } else {
                            //agrego normal + check 1

                            //agregar normal
                            double precio_sugerido = Double.parseDouble(txtVentaSugerida.getValue().toString());
                            double precio_venta_real = Double.parseDouble(txtVentaReal.getValue().toString());

                            if (precio_venta_real < precio_sugerido) {
                                context.execute("PF('dialogNuevoProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                double precio_sugerido1 = Double.parseDouble(txtVentaSugerida1.getValue().toString());
                                double precio_venta_real1 = Double.parseDouble(txtVentaReal1.getValue().toString());

                                if (precio_venta_real1 < precio_sugerido1) {
                                    context.execute("PF('dialogNuevoProducto').show();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 1 no puede ser menor al precio de venta sugerido 1."));
                                } else {
                                    try {

                                        ProductoController ProductoController = new ProductoController();
                                        boolean existe = ProductoController.obtenerProductoPorCodigoBarras(txtCodigoBarras.getValue().toString());
                                        boolean existe2 = ProductoController.obtenerProductoPorCodigoBarras(txtCodigoBarras1.getValue().toString());

                                        if (existe == false && existe2 == false) {
                                            //agrego solo el normal
                                            Long cod_producto = 0L;
                                            Producto p = new Producto();

                                            p = ProductoController.obtenerUltimoRegistro();
                                            if (ProductoController.obtenerCuantosRegistrosHayEnProducto() == 0) {
                                                cod_producto = Long.parseLong("1");
                                            } else {
                                                Integer num = p.getCodigo().intValue() + 1;
                                                cod_producto = Long.parseLong(num.toString());
                                            }

                                            BigDecimal cod = new BigDecimal(cod_producto);
                                            producto.setCodigo(cod);

                                            //cod comun
                                            Long cod_comun = 0L;
                                            Producto p_comun = new Producto();

                                            p_comun = ProductoController.obtenerUltimoRegistroComun();
                                            if (ProductoController.obtenerCuantosRegistrosHayEnProductoComun() == 0) {
                                                cod_comun = Long.parseLong("1");
                                            } else {
                                                Integer num_comun = p_comun.getCodComun().intValue() + 1;
                                                cod_comun = Long.parseLong(num_comun.toString());
                                            }

                                            codComun = new BigDecimal(cod_comun);
                                            producto.setCodComun(codComun);

                                            //orden
                                            producto.setOrden(3);

                                            //codigo de barras
                                            producto.setCodBarras(txtCodigoBarras.getValue().toString());

                                            String nombre_producto = producto.getNombre().toUpperCase();
                                            producto.setNombre(nombre_producto);

                                            producto.setUnidadXPaquete(Long.parseLong(txtUnidadXPaquete.getValue().toString()));

                                            producto.setPaquete(txtDescripcionPaquete.getValue().toString().toUpperCase());
                                            BigDecimal precio_compra = new BigDecimal(txtCompra.getValue().toString());
                                            producto.setPrecioCompra(precio_compra);

                                            BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompra.getValue().toString());
                                            producto.setPorcentajeDescuento(prcentaje_descuento);

                                            BigDecimal precio_compra_real = new BigDecimal(txtCompraReal.getValue().toString());
                                            producto.setPrecioCompraReal(precio_compra_real);

                                            BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidad.getValue().toString());
                                            producto.setPorcentajeUtilidad(porcentaje_utilidad);

                                            BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                            producto.setVentaSugerida(venta_sugerida);

                                            BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                            producto.setPrecioVentaReal(venta_real);

                                            Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaquete.getValue().toString()));
                                            producto.setStockActUni(stock_actual);

                                            Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimo.getValue().toString()));
                                            producto.setStockMinUni(stock_minimo);

                                            BigDecimal comision = new BigDecimal(txtPrecioComision.getValue().toString());
                                            producto.setComision(comision);

                                            BigDecimal porcentaje_comision = new BigDecimal(txtComision.getValue().toString());
                                            producto.setPorcentajeComision(porcentaje_comision);

                                            producto.setFechaVencimiento(fechaVencimiento);

                                            ProductoController.newProducto(producto);

                                            //agrego check1
                                            try {
                                                Long cod_producto1 = 0L;
                                                Producto p1 = new Producto();

                                                p1 = ProductoController.obtenerUltimoRegistro();
                                                if (ProductoController.obtenerCuantosRegistrosHayEnProducto() == 0) {
                                                    cod_producto1 = Long.parseLong("1");
                                                } else {
                                                    Integer num = p1.getCodigo().intValue() + 1;
                                                    cod_producto1 = Long.parseLong(num.toString());
                                                }

                                                BigDecimal cod1 = new BigDecimal(cod_producto1);
                                                p1.setCodigo(cod1);
                                                p1.setCodComun(codComun);
                                                p1.setOrden(2);

                                                p1.setNombre(nombre_producto);
                                                p1.setCodBarras(txtCodigoBarras1.getValue().toString());
                                                p1.setPaquete(txtDescripcionPaquete1.getValue().toString().toUpperCase());
                                                BigDecimal precio_compra1 = new BigDecimal(txtCompra1.getValue().toString());
                                                p1.setPrecioCompra(precio_compra1);

                                                p1.setUnidadXPaquete(Long.parseLong(txtUnidadXPaquete1.getValue().toString()));

                                                BigDecimal porcentaje_descuento1 = new BigDecimal(txtDescuentoCompra1.getValue().toString());
                                                p1.setPorcentajeDescuento(porcentaje_descuento1);

                                                BigDecimal precio_compra_real1 = new BigDecimal(txtCompraReal1.getValue().toString());
                                                p1.setPrecioCompraReal(precio_compra_real1);

                                                BigDecimal porcentaje_utilidad1 = new BigDecimal(txtPorcentajeUtilidad1.getValue().toString());
                                                p1.setPorcentajeUtilidad(porcentaje_utilidad1);

                                                BigDecimal venta_sugerida1 = new BigDecimal(precio_sugerido1);
                                                p1.setVentaSugerida(venta_sugerida1);

                                                BigDecimal venta_real1 = new BigDecimal(precio_venta_real1);
                                                p1.setPrecioVentaReal(venta_real1);

                                                Long stock_actual1 = Long.valueOf(Integer.parseInt(txtCantidadPaquete1.getValue().toString()));
                                                p1.setStockActUni(stock_actual1 * stock_actual);

                                                Long stock_minimo1 = Long.valueOf(Integer.parseInt(txtStockMinimo1.getValue().toString()));
                                                p1.setStockMinUni(stock_minimo1);

                                                BigDecimal comision1 = new BigDecimal(txtPrecioComision1.getValue().toString());
                                                p1.setComision(comision1);

                                                BigDecimal porcentaje_comision1 = new BigDecimal(txtComision1.getValue().toString());
                                                p1.setPorcentajeComision(porcentaje_comision1);

                                                p1.setFechaVencimiento(fechaVencimiento1);

                                                ProductoController.newProducto(p1);

                                                cancelarRegistroProducto();

                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion exitosa:", "Los productos se agregaron correctamente."));

                                            } catch (Exception ex) {
                                                Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                            }

                                        } else {
                                            context.execute("PF('dialogNuevoProducto').show();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                        }
                                    } catch (Exception ex) {
                                        Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }
                } else if (check1 == true && check2 == true) {
                    if (producto.getNombre() == null || txtCodigoBarras.getValue() == null || txtCantidadPaquete.getValue() == null || txtDescripcionPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCompra.getValue() == null || txtDescuentoCompra.getValue() == null || txtCompraReal.getValue() == null || txtPorcentajeUtilidad.getValue() == null || txtVentaSugerida.getValue() == null || txtVentaReal.getValue() == null || txtComision.getValue() == null || txtPrecioComision.getValue() == null || txtStockMinimo.getValue() == null || fechaVencimientoInput.getValue() == null || txtCodigoBarras1.getValue() == null || txtCantidadPaquete1.getValue() == null || txtDescripcionPaquete1.getValue() == null || txtUnidadXPaquete1.getValue() == null || txtCompra1.getValue() == null || txtDescuentoCompra1.getValue() == null || txtCompraReal1.getValue() == null || txtPorcentajeUtilidad1.getValue() == null || txtVentaSugerida1.getValue() == null || txtVentaReal1.getValue() == null || txtComision1.getValue() == null || txtPrecioComision1.getValue() == null || txtStockMinimo1.getValue() == null || fechaVencimientoInput1.getValue() == null || txtCodigoBarras2.getValue() == null || txtCantidadPaquete2.getValue() == null || txtDescripcionPaquete2.getValue() == null || txtUnidadXPaquete2.getValue() == null || txtCompra2.getValue() == null || txtDescuentoCompra2.getValue() == null || txtCompraReal2.getValue() == null || txtPorcentajeUtilidad2.getValue() == null || txtVentaSugerida2.getValue() == null || txtVentaReal2.getValue() == null || txtComision2.getValue() == null || txtPrecioComision2.getValue() == null || txtStockMinimo2.getValue() == null || fechaVencimientoInput2.getValue() == null) {
                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                    } else {

                        if (producto.getNombre().equals("") || txtCodigoBarras.getValue().toString().equals("") || txtCantidadPaquete.getValue().equals("0") || txtDescripcionPaquete.getValue().toString().equals("") || txtUnidadXPaquete.getValue().equals("0") || txtCompra.getValue().equals("0") || txtPorcentajeUtilidad.getValue().equals("0") || txtVentaReal.getValue().equals("0") || txtStockMinimo.getValue().equals("0") || fechaVencimientoInput.getValue().toString().equals("") || txtCodigoBarras1.getValue().toString().equals("") || txtCantidadPaquete1.getValue().equals("0") || txtDescripcionPaquete1.getValue().toString().equals("") || txtUnidadXPaquete1.getValue().equals("0") || txtCompra1.getValue().equals("0") || txtPorcentajeUtilidad1.getValue().equals("0") || txtVentaReal1.getValue().equals("0") || txtStockMinimo1.getValue().equals("0") || fechaVencimientoInput1.getValue().toString().equals("") || txtCodigoBarras2.getValue().toString().equals("") || txtCantidadPaquete2.getValue().equals("0") || txtDescripcionPaquete2.getValue().toString().equals("") || txtUnidadXPaquete2.getValue().equals("0") || txtCompra2.getValue().equals("0") || txtPorcentajeUtilidad2.getValue().equals("0") || txtVentaReal2.getValue().equals("0") || txtStockMinimo2.getValue().equals("0") || fechaVencimientoInput2.getValue().toString().equals("")) {
                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                        } else {
                            //agrego las 3 filas

                            double precio_sugerido = Double.parseDouble(txtVentaSugerida.getValue().toString());
                            double precio_venta_real = Double.parseDouble(txtVentaReal.getValue().toString());

                            if (precio_venta_real < precio_sugerido) {
                                context.execute("PF('dialogNuevoProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                double precio_sugerido1 = Double.parseDouble(txtVentaSugerida1.getValue().toString());
                                double precio_venta_real1 = Double.parseDouble(txtVentaReal1.getValue().toString());

                                if (precio_venta_real1 < precio_sugerido1) {
                                    context.execute("PF('dialogNuevoProducto').show();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 1 no puede ser menor al precio de venta sugerido 1."));
                                } else {

                                    double precio_sugerido2 = Double.parseDouble(txtVentaSugerida2.getValue().toString());
                                    double precio_venta_real2 = Double.parseDouble(txtVentaReal2.getValue().toString());

                                    if (precio_venta_real2 < precio_sugerido2) {
                                        context.execute("PF('dialogNuevoProducto').show();");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 2 no puede ser menor al precio de venta sugerido 2."));
                                    } else {
                                        try {

                                            ProductoController ProductoController = new ProductoController();
                                            boolean existe = ProductoController.obtenerProductoPorCodigoBarras(txtCodigoBarras.getValue().toString());
                                            boolean existe2 = ProductoController.obtenerProductoPorCodigoBarras(txtCodigoBarras1.getValue().toString());
                                            boolean existe3 = ProductoController.obtenerProductoPorCodigoBarras(txtCodigoBarras2.getValue().toString());

                                            if (existe == false && existe2 == false && existe3 == false) {
                                                //agrego solo el normal

                                                Long cod_producto = 0L;
                                                Producto p = new Producto();

                                                p = ProductoController.obtenerUltimoRegistro();
                                                if (ProductoController.obtenerCuantosRegistrosHayEnProducto() == 0) {
                                                    cod_producto = Long.parseLong("1");
                                                } else {
                                                    Integer num = p.getCodigo().intValue() + 1;
                                                    cod_producto = Long.parseLong(num.toString());
                                                }

                                                BigDecimal cod = new BigDecimal(cod_producto);
                                                producto.setCodigo(cod);

                                                //cod comun
                                                Producto p_comun = new Producto();
                                                Long cod_comun = 0L;

                                                p_comun = ProductoController.obtenerUltimoRegistroComun();
                                                if (ProductoController.obtenerCuantosRegistrosHayEnProductoComun() == 0) {
                                                    cod_comun = Long.parseLong("1");
                                                } else {
                                                    Integer num_comun = p_comun.getCodComun().intValue() + 1;
                                                    cod_comun = Long.parseLong(num_comun.toString());
                                                }

                                                codComun = new BigDecimal(cod_comun);
                                                producto.setCodComun(codComun);

                                                //orden
                                                producto.setOrden(3);

                                                //codigo de barras
                                                producto.setCodBarras(txtCodigoBarras.getValue().toString());

                                                String nombre_producto = producto.getNombre().toUpperCase();
                                                producto.setNombre(nombre_producto);

                                                producto.setUnidadXPaquete(Long.parseLong(txtUnidadXPaquete.getValue().toString()));

                                                producto.setPaquete(txtDescripcionPaquete.getValue().toString().toUpperCase());
                                                BigDecimal precio_compra = new BigDecimal(txtCompra.getValue().toString());
                                                producto.setPrecioCompra(precio_compra);

                                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompra.getValue().toString());
                                                producto.setPorcentajeDescuento(prcentaje_descuento);

                                                BigDecimal precio_compra_real = new BigDecimal(txtCompraReal.getValue().toString());
                                                producto.setPrecioCompraReal(precio_compra_real);

                                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidad.getValue().toString());
                                                producto.setPorcentajeUtilidad(porcentaje_utilidad);

                                                BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                                producto.setVentaSugerida(venta_sugerida);

                                                BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                                producto.setPrecioVentaReal(venta_real);

                                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaquete.getValue().toString()));
                                                producto.setStockActUni(stock_actual);

                                                Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimo.getValue().toString()));
                                                producto.setStockMinUni(stock_minimo);

                                                BigDecimal comision = new BigDecimal(txtPrecioComision.getValue().toString());
                                                producto.setComision(comision);

                                                BigDecimal porcentaje_comision = new BigDecimal(txtComision.getValue().toString());
                                                producto.setPorcentajeComision(porcentaje_comision);

                                                producto.setFechaVencimiento(fechaVencimiento);

                                                ProductoController.newProducto(producto);

                                                //agrego check1
                                                try {
                                                    Long cod_producto1 = 0L;
                                                    Producto p1 = new Producto();

                                                    p1 = ProductoController.obtenerUltimoRegistro();
                                                    if (ProductoController.obtenerCuantosRegistrosHayEnProducto() == 0) {
                                                        cod_producto1 = Long.parseLong("1");
                                                    } else {
                                                        Integer num = p1.getCodigo().intValue() + 1;
                                                        cod_producto1 = Long.parseLong(num.toString());
                                                    }

                                                    BigDecimal cod1 = new BigDecimal(cod_producto1);
                                                    p1.setCodigo(cod1);

                                                    //cod comun
                                                    p1.setCodComun(codComun);

                                                    //orden
                                                    p1.setOrden(2);

                                                    //codigo de barras
                                                    p1.setCodBarras(txtCodigoBarras1.getValue().toString());

                                                    p1.setNombre(producto.getNombre().toUpperCase());

                                                    p1.setUnidadXPaquete(Long.parseLong(txtUnidadXPaquete1.getValue().toString()));

                                                    p1.setPaquete(txtDescripcionPaquete1.getValue().toString().toUpperCase());
                                                    BigDecimal precio_compra1 = new BigDecimal(txtCompra1.getValue().toString());
                                                    p1.setPrecioCompra(precio_compra1);

                                                    BigDecimal porcentaje_descuento1 = new BigDecimal(txtDescuentoCompra1.getValue().toString());
                                                    p1.setPorcentajeDescuento(porcentaje_descuento1);

                                                    BigDecimal precio_compra_real1 = new BigDecimal(txtCompraReal1.getValue().toString());
                                                    p1.setPrecioCompraReal(precio_compra_real1);

                                                    BigDecimal porcentaje_utilidad1 = new BigDecimal(txtPorcentajeUtilidad1.getValue().toString());
                                                    p1.setPorcentajeUtilidad(porcentaje_utilidad1);

                                                    BigDecimal venta_sugerida1 = new BigDecimal(precio_sugerido1);
                                                    p1.setVentaSugerida(venta_sugerida1);

                                                    BigDecimal venta_real1 = new BigDecimal(precio_venta_real1);
                                                    p1.setPrecioVentaReal(venta_real1);

                                                    Long stock_actual1 = Long.valueOf(Integer.parseInt(txtCantidadPaquete1.getValue().toString()));
                                                    p1.setStockActUni(stock_actual1 * stock_actual);

                                                    Long stock_minimo1 = Long.valueOf(Integer.parseInt(txtStockMinimo1.getValue().toString()));
                                                    p1.setStockMinUni(stock_minimo1);

                                                    BigDecimal comision1 = new BigDecimal(txtPrecioComision1.getValue().toString());
                                                    p1.setComision(comision1);

                                                    BigDecimal porcentaje_comision1 = new BigDecimal(txtComision1.getValue().toString());
                                                    p1.setPorcentajeComision(porcentaje_comision1);

                                                    p1.setFechaVencimiento(fechaVencimiento1);

                                                    ProductoController.newProducto(p1);

                                                    //agrego check2
                                                    Long cod_producto2 = 0L;
                                                    Producto p2 = new Producto();

                                                    p2 = ProductoController.obtenerUltimoRegistro();
                                                    if (ProductoController.obtenerCuantosRegistrosHayEnProducto() == 0) {
                                                        cod_producto2 = Long.parseLong("1");
                                                    } else {
                                                        Integer num = p2.getCodigo().intValue() + 1;
                                                        cod_producto2 = Long.parseLong(num.toString());
                                                    }

                                                    BigDecimal cod2 = new BigDecimal(cod_producto2);
                                                    p2.setCodigo(cod2);
                                                    p2.setCodComun(codComun);
                                                    p2.setCodBarras(txtCodigoBarras1.getValue().toString());
                                                    p2.setOrden(1);
                                                    p2.setNombre(nombre_producto);

                                                    p2.setUnidadXPaquete(Long.parseLong(txtUnidadXPaquete2.getValue().toString()));

                                                    p2.setPaquete(txtDescripcionPaquete2.getValue().toString().toUpperCase());
                                                    BigDecimal precio_compra2 = new BigDecimal(txtCompra2.getValue().toString());
                                                    p2.setPrecioCompra(precio_compra2);

                                                    BigDecimal porcentaje_descuento2 = new BigDecimal(txtDescuentoCompra2.getValue().toString());
                                                    p2.setPorcentajeDescuento(porcentaje_descuento2);

                                                    BigDecimal precio_compra_real2 = new BigDecimal(txtCompraReal2.getValue().toString());
                                                    p2.setPrecioCompraReal(precio_compra_real2);

                                                    BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidad2.getValue().toString());
                                                    p2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                    BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                    p2.setVentaSugerida(venta_sugerida2);

                                                    BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                    p2.setPrecioVentaReal(venta_real2);

                                                    Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaquete2.getValue().toString()));
                                                    p2.setStockActUni(stock_actual2 * stock_actual);

                                                    Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimo2.getValue().toString()));
                                                    p2.setStockMinUni(stock_minimo2);

                                                    BigDecimal comision2 = new BigDecimal(txtPrecioComision2.getValue().toString());
                                                    p2.setComision(comision2);

                                                    BigDecimal porcentaje_comision2 = new BigDecimal(txtComision2.getValue().toString());
                                                    p2.setPorcentajeComision(porcentaje_comision2);

                                                    p2.setFechaVencimiento(fechaVencimiento2);

                                                    ProductoController.newProducto(p2);

                                                    cancelarRegistroProducto();

                                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion exitosa:", "Los productos se agregaron correctamente."));

                                                } catch (Exception ex) {
                                                    Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                                }

                                            } else {
                                                context.execute("PF('dialogNuevoProducto').show();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                            }
                                        } catch (Exception ex) {
                                            Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void selectCheck1() {

        if (check1 == true) {

            txtCodigoBarras1.setDisabled(false);
            txtCantidadPaquete1.setDisabled(false);
            txtDescripcionPaquete1.setDisabled(false);
            txtUnidadXPaquete1.setDisabled(false);
            txtCompra1.setDisabled(false);
            txtDescuentoCompra1.setDisabled(false);
            txtPorcentajeUtilidad1.setDisabled(false);
            txtComision1.setDisabled(false);
            txtVentaReal1.setDisabled(false);
            txtStockMinimo1.setDisabled(false);
            fechaVencimientoInput1.setDisabled(false);

        } else {

            if (check2 == true) {
                setCheck1(true);
                txtCodigoBarras1.setDisabled(false);
                txtCantidadPaquete1.setDisabled(false);
                txtDescripcionPaquete1.setDisabled(false);
                txtUnidadXPaquete1.setDisabled(false);
                txtCompra1.setDisabled(false);
                txtDescuentoCompra1.setDisabled(false);
                txtPorcentajeUtilidad1.setDisabled(false);
                txtComision1.setDisabled(false);
                txtVentaReal1.setDisabled(false);
                txtStockMinimo1.setDisabled(false);
                fechaVencimientoInput1.setDisabled(false);

            } else {
                txtCodigoBarras1.setValue(null);
                txtCantidadPaquete1.setValue(null);
                txtDescripcionPaquete1.setValue(null);
                txtUnidadXPaquete1.setValue(null);
                txtCompra1.setValue(null);
                txtDescuentoCompra1.setValue(null);
                txtCompraReal1.setValue(null);
                txtPorcentajeUtilidad1.setValue(null);
                txtVentaSugerida1.setValue(null);
                txtVentaReal1.setValue(null);
                txtComision1.setValue(null);
                txtPrecioComision1.setValue(null);
                txtStockMinimo1.setValue(null);
                fechaVencimientoInput1.setValue(null);

                txtCodigoBarras1.setDisabled(true);
                txtCantidadPaquete1.setDisabled(true);
                txtDescripcionPaquete1.setDisabled(true);
                txtUnidadXPaquete1.setDisabled(true);
                txtCompra1.setDisabled(true);
                txtDescuentoCompra1.setDisabled(true);
                txtPorcentajeUtilidad1.setDisabled(true);
                txtComision1.setDisabled(true);
                txtVentaReal1.setDisabled(true);
                txtStockMinimo1.setDisabled(true);
                fechaVencimientoInput1.setDisabled(true);
            }

        }

    }

    public void selectCheck2() {
        if (check2 == true) {

            if (check1 == false) {
                setCheck2(false);
                txtCodigoBarras2.setDisabled(true);
                txtCantidadPaquete2.setDisabled(true);
                txtDescripcionPaquete2.setDisabled(true);
                txtUnidadXPaquete2.setDisabled(true);
                txtCompra2.setDisabled(true);
                txtDescuentoCompra2.setDisabled(true);
                txtPorcentajeUtilidad2.setDisabled(true);
                txtComision2.setDisabled(true);
                txtVentaReal2.setDisabled(true);
                txtStockMinimo2.setDisabled(true);
                fechaVencimientoInput2.setDisabled(true);

            } else {
                txtCodigoBarras2.setDisabled(false);
                txtCantidadPaquete2.setDisabled(false);
                txtDescripcionPaquete2.setDisabled(false);
                txtUnidadXPaquete2.setDisabled(false);
                txtCompra2.setDisabled(false);
                txtDescuentoCompra2.setDisabled(false);
                txtPorcentajeUtilidad2.setDisabled(false);
                txtComision2.setDisabled(false);
                txtVentaReal2.setDisabled(false);
                txtStockMinimo2.setDisabled(false);
                fechaVencimientoInput2.setDisabled(false);
            }

        } else {
            txtCodigoBarras2.setDisabled(true);
            txtCantidadPaquete2.setDisabled(true);
            txtDescripcionPaquete2.setDisabled(true);
            txtUnidadXPaquete2.setDisabled(true);
            txtCompra2.setDisabled(true);
            txtDescuentoCompra2.setDisabled(true);
            txtPorcentajeUtilidad2.setDisabled(true);
            txtComision2.setDisabled(true);
            txtVentaReal2.setDisabled(true);
            txtStockMinimo2.setDisabled(true);
            fechaVencimientoInput2.setDisabled(true);
        }

    }

    public void cambioTxtCompra() {

        if (txtCompra.getValue() == null) {
            txtCompraReal.setValue("0");
        } else {
            if (txtCompra.getValue().equals("0")) {
                txtCompraReal.setValue("0");
            } else {
                if (txtDescuentoCompra.getValue() == null) {
                    txtCompraReal.setValue(txtCompra.getValue());
                } else {
                    if (txtDescuentoCompra.getValue().equals("0")) {
                        txtCompraReal.setValue(txtCompra.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompra.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompra.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraReal.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraReal.getValue() == null) {
            txtVentaSugerida.setValue("0");
        } else {
            if (txtCompraReal.getValue().equals("0")) {
                txtVentaSugerida.setValue("0");
            } else {
                if (txtPorcentajeUtilidad.getValue() == null) {
                    txtVentaSugerida.setValue(txtCompraReal.getValue());
                } else {
                    if (txtPorcentajeUtilidad.getValue().equals("0")) {
                        txtVentaSugerida.setValue(txtCompraReal.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraReal.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidad.getValue().toString());
                        txtVentaSugerida.setValue(compra_real + ((compra_real * utilidad) / 100));
                    }
                }
            }
        }

    }

    public void cambioTxtCompra1() {

        if (txtCompra1.getValue() == null) {
            txtCompraReal1.setValue("0");
        } else {
            if (txtCompra1.getValue().equals("0")) {
                txtCompraReal1.setValue("0");
            } else {
                if (txtDescuentoCompra1.getValue() == null) {
                    txtCompraReal1.setValue(txtCompra1.getValue());
                } else {
                    if (txtDescuentoCompra1.getValue().equals("0")) {
                        txtCompraReal1.setValue(txtCompra1.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompra1.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompra1.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraReal1.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraReal1.getValue() == null) {
            txtVentaSugerida1.setValue("0");
        } else {
            if (txtCompraReal1.getValue().equals("0")) {
                txtVentaSugerida1.setValue("0");
            } else {
                if (txtPorcentajeUtilidad1.getValue() == null) {
                    txtVentaSugerida1.setValue(txtCompraReal1.getValue());
                } else {
                    if (txtPorcentajeUtilidad1.getValue().equals("0")) {
                        txtVentaSugerida1.setValue(txtCompraReal1.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraReal1.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidad1.getValue().toString());
                        txtVentaSugerida1.setValue(compra_real + ((compra_real * utilidad) / 100));
                    }
                }
            }
        }

    }

    public void cambioTxtCompra2() {

        if (txtCompra2.getValue() == null) {
            txtCompraReal2.setValue("0");
        } else {
            if (txtCompra2.getValue().equals("0")) {
                txtCompraReal2.setValue("0");
            } else {
                if (txtDescuentoCompra2.getValue() == null) {
                    txtCompraReal2.setValue(txtCompra2.getValue());
                } else {
                    if (txtDescuentoCompra2.getValue().equals("0")) {
                        txtCompraReal2.setValue(txtCompra2.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompra2.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompra2.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraReal2.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraReal2.getValue() == null) {
            txtVentaSugerida2.setValue("0");
        } else {
            if (txtCompraReal2.getValue().equals("0")) {
                txtVentaSugerida2.setValue("0");
            } else {
                if (txtPorcentajeUtilidad2.getValue() == null) {
                    txtVentaSugerida2.setValue(txtCompraReal2.getValue());
                } else {
                    if (txtPorcentajeUtilidad2.getValue().equals("0")) {
                        txtVentaSugerida2.setValue(txtCompraReal2.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraReal2.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidad2.getValue().toString());
                        txtVentaSugerida2.setValue(compra_real + ((compra_real * utilidad) / 100));
                    }
                }
            }
        }
    }

    public void cambioComision() {

        if (txtVentaReal.getValue() == null || txtComision.getValue() == null) {
        } else {
            if (txtVentaReal.getValue().equals("0") || txtComision.getValue().equals("0")) {
                txtPrecioComision.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaReal.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComision.getValue().toString());
                txtPrecioComision.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }
    }

    public void cambioComision1() {

        if (txtVentaReal1.getValue() == null || txtComision1.getValue() == null) {
        } else {
            if (txtVentaReal1.getValue().equals("0") || txtComision1.getValue().equals("0")) {
                txtPrecioComision1.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaReal1.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComision1.getValue().toString());
                txtPrecioComision1.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }
    }

    public void cambioComision2() {
        if (txtVentaReal2.getValue() == null || txtComision2.getValue() == null) {
        } else {
            if (txtVentaReal2.getValue().equals("0") || txtComision2.getValue().equals("0")) {
                txtPrecioComision2.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaReal2.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComision2.getValue().toString());
                txtPrecioComision2.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }
    }

    public void cambioTxtCompraModificar1() {

        if (txtCompraModificar1.getValue() == null) {
            txtCompraRealModificar1.setValue("0");
        } else {
            if (txtCompraModificar1.getValue().equals("0")) {
                txtCompraRealModificar1.setValue("0");
            } else {
                if (txtDescuentoCompraModificar1.getValue() == null) {
                    txtCompraRealModificar1.setValue(txtCompraModificar1.getValue());
                } else {
                    if (txtDescuentoCompraModificar1.getValue().equals("0")) {
                        txtCompraRealModificar1.setValue(txtCompraModificar1.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompraModificar1.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompraModificar1.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraRealModificar1.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraRealModificar1.getValue() == null) {
            txtVentaSugeridaModificar1.setValue("0");
        } else {
            if (txtCompraRealModificar1.getValue().equals("0")) {
                txtVentaSugeridaModificar1.setValue("0");
            } else {
                if (txtPorcentajeUtilidadModificar1.getValue() == null) {
                    txtVentaSugeridaModificar1.setValue(txtCompraRealModificar1.getValue());
                } else {
                    if (txtPorcentajeUtilidadModificar1.getValue().equals("0")) {
                        txtVentaSugeridaModificar1.setValue(txtCompraRealModificar1.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraRealModificar1.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidadModificar1.getValue().toString());
                        txtVentaSugeridaModificar1.setValue(compra_real + ((compra_real * utilidad) / 100));
                    }
                }
            }
        }

    }

    public void cambioTxtCompraModificar2() {

        if (txtCompraModificar2.getValue() == null) {
            txtCompraRealModificar2.setValue("0");
        } else {
            if (txtCompraModificar2.getValue().equals("0")) {
                txtCompraRealModificar2.setValue("0");
            } else {
                if (txtDescuentoCompraModificar2.getValue() == null) {
                    txtCompraRealModificar2.setValue(txtCompraModificar2.getValue());
                } else {
                    if (txtDescuentoCompraModificar2.getValue().equals("0")) {
                        txtCompraRealModificar2.setValue(txtCompraModificar2.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompraModificar2.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompraModificar2.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraRealModificar2.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraRealModificar2.getValue() == null) {
            txtVentaSugeridaModificar2.setValue("0");
        } else {
            if (txtCompraRealModificar2.getValue().equals("0")) {
                txtVentaSugeridaModificar2.setValue("0");
            } else {
                if (txtPorcentajeUtilidadModificar2.getValue() == null) {
                    txtVentaSugeridaModificar2.setValue(txtCompraRealModificar2.getValue());
                } else {
                    if (txtPorcentajeUtilidadModificar2.getValue().equals("0")) {
                        txtVentaSugeridaModificar2.setValue(txtCompraRealModificar2.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraRealModificar2.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidadModificar2.getValue().toString());
                        txtVentaSugeridaModificar2.setValue(compra_real + ((compra_real * utilidad) / 100));
                    }
                }
            }
        }

    }

    public void cambioTxtCompraModificar3() {

        if (txtCompraModificar3.getValue() == null) {
            txtCompraRealModificar3.setValue("0");
        } else {
            if (txtCompraModificar3.getValue().equals("0")) {
                txtCompraRealModificar3.setValue("0");
            } else {
                if (txtDescuentoCompraModificar3.getValue() == null) {
                    txtCompraRealModificar3.setValue(txtCompraModificar3.getValue());
                } else {
                    if (txtDescuentoCompraModificar3.getValue().equals("0")) {
                        txtCompraRealModificar3.setValue(txtCompraModificar3.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompraModificar3.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompraModificar3.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraRealModificar3.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraRealModificar3.getValue() == null) {
            txtVentaSugeridaModificar3.setValue("0");
        } else {
            if (txtCompraRealModificar3.getValue().equals("0")) {
                txtVentaSugeridaModificar3.setValue("0");
            } else {
                if (txtPorcentajeUtilidadModificar3.getValue() == null) {
                    txtVentaSugeridaModificar3.setValue(txtCompraRealModificar3.getValue());
                } else {
                    if (txtPorcentajeUtilidadModificar3.getValue().equals("0")) {
                        txtVentaSugeridaModificar3.setValue(txtCompraRealModificar3.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraRealModificar3.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidadModificar3.getValue().toString());
                        txtVentaSugeridaModificar3.setValue(compra_real + ((compra_real * utilidad) / 100));
                    }
                }
            }
        }

    }

    public void cambioComisionModificar1() {

        if (txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null) {
        } else {
            if (txtVentaRealModificar1.getValue().equals("0") || txtComisionModificar1.getValue().equals("0")) {
                txtPrecioComisionModificar1.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaRealModificar1.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComisionModificar1.getValue().toString());
                txtPrecioComisionModificar1.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }
    }

    public void cambioComisionModificar2() {

        if (txtVentaRealModificar2.getValue() == null || txtComisionModificar2.getValue() == null) {
        } else {
            if (txtVentaRealModificar2.getValue().equals("0") || txtComisionModificar2.getValue().equals("0")) {
                txtPrecioComisionModificar2.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaRealModificar2.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComisionModificar2.getValue().toString());
                txtPrecioComisionModificar2.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }
    }

    public void cambioComisionModificar3() {

        if (txtVentaRealModificar3.getValue() == null || txtComisionModificar3.getValue() == null) {
        } else {
            if (txtVentaRealModificar3.getValue().equals("0") || txtComisionModificar3.getValue().equals("0")) {
                txtPrecioComisionModificar3.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaRealModificar3.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComisionModificar3.getValue().toString());
                txtPrecioComisionModificar3.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }
    }

    public void prepararModificar() {

        RequestContext context = RequestContext.getCurrentInstance();
        ProductoController ProductoController = new ProductoController();
        this.listaProductosModificarCodComun = null;

        this.listaProductosModificarCodComun = ProductoController.listaDeProductosPorCodComun(producto.getCodComun());

        switch (listaProductosModificarCodComun.size()) {
            case 1:

                productoModificar1 = listaProductosModificarCodComun.get(0);
                txtCodigoBarrasModificar1.setValue(productoModificar1.getCodBarras());
                txtCantidadPaqueteModificar1.setValue(productoModificar1.getStockActUni());
                txtDescripcionPaqueteModificar1.setValue(productoModificar1.getPaquete());
                txtUnidadXPaqueteModificar1.setValue(productoModificar1.getUnidadXPaquete());
                txtCompraModificar1.setValue(productoModificar1.getPrecioCompra());
                txtDescuentoCompraModificar1.setValue(productoModificar1.getPorcentajeDescuento());
                txtCompraRealModificar1.setValue(productoModificar1.getPrecioCompraReal());
                txtPorcentajeUtilidadModificar1.setValue(productoModificar1.getPorcentajeUtilidad());
                txtVentaSugeridaModificar1.setValue(productoModificar1.getVentaSugerida());
                txtVentaRealModificar1.setValue(productoModificar1.getPrecioVentaReal());
                txtComisionModificar1.setValue(productoModificar1.getPorcentajeComision());
                txtPrecioComisionModificar1.setValue(productoModificar1.getComision());
                txtStockMinimoModificar1.setValue(productoModificar1.getStockMinUni());
                fechaVencimientoInputModificar1.setValue(productoModificar1.getFechaVencimiento());

                txtCodigoBarrasModificar1.setDisabled(false);
                txtCantidadPaqueteModificar1.setDisabled(false);
                txtDescripcionPaqueteModificar1.setDisabled(false);
                txtUnidadXPaqueteModificar1.setDisabled(false);
                txtCompraModificar1.setDisabled(false);
                txtDescuentoCompraModificar1.setDisabled(false);
                txtPorcentajeUtilidadModificar1.setDisabled(false);
                txtVentaRealModificar1.setDisabled(false);
                txtComisionModificar1.setDisabled(false);
                txtStockMinimoModificar1.setDisabled(false);
                fechaVencimientoInputModificar1.setDisabled(false);

                context.execute("PF('dialogModificarProducto').show();");

                break;
            case 2:

                if (listaProductosModificarCodComun.get(0).getOrden() == 3) {
                    productoModificar1 = listaProductosModificarCodComun.get(0);
                    txtCodigoBarrasModificar1.setValue(productoModificar1.getCodBarras());
                    txtCantidadPaqueteModificar1.setValue(productoModificar1.getStockActUni());
                    txtDescripcionPaqueteModificar1.setValue(productoModificar1.getPaquete());
                    txtUnidadXPaqueteModificar1.setValue(productoModificar1.getUnidadXPaquete());
                    txtCompraModificar1.setValue(productoModificar1.getPrecioCompra());
                    txtDescuentoCompraModificar1.setValue(productoModificar1.getPorcentajeDescuento());
                    txtCompraRealModificar1.setValue(productoModificar1.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar1.setValue(productoModificar1.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar1.setValue(productoModificar1.getVentaSugerida());
                    txtVentaRealModificar1.setValue(productoModificar1.getPrecioVentaReal());
                    txtComisionModificar1.setValue(productoModificar1.getPorcentajeComision());
                    txtPrecioComisionModificar1.setValue(productoModificar1.getComision());
                    txtStockMinimoModificar1.setValue(productoModificar1.getStockMinUni());
                    fechaVencimientoInputModificar1.setValue(productoModificar1.getFechaVencimiento());

                    productoModificar2 = listaProductosModificarCodComun.get(1);
                    txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                    txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                    txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                    txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                    txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                    txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                    txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                    txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                    txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                    txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                    txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                    fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                } else if (listaProductosModificarCodComun.get(1).getOrden() == 3) {

                    productoModificar1 = listaProductosModificarCodComun.get(1);
                    txtCodigoBarrasModificar1.setValue(productoModificar1.getCodBarras());
                    txtCantidadPaqueteModificar1.setValue(productoModificar1.getStockActUni());
                    txtDescripcionPaqueteModificar1.setValue(productoModificar1.getPaquete());
                    txtUnidadXPaqueteModificar1.setValue(productoModificar1.getUnidadXPaquete());
                    txtCompraModificar1.setValue(productoModificar1.getPrecioCompra());
                    txtDescuentoCompraModificar1.setValue(productoModificar1.getPorcentajeDescuento());
                    txtCompraRealModificar1.setValue(productoModificar1.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar1.setValue(productoModificar1.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar1.setValue(productoModificar1.getVentaSugerida());
                    txtVentaRealModificar1.setValue(productoModificar1.getPrecioVentaReal());
                    txtComisionModificar1.setValue(productoModificar1.getPorcentajeComision());
                    txtPrecioComisionModificar1.setValue(productoModificar1.getComision());
                    txtStockMinimoModificar1.setValue(productoModificar1.getStockMinUni());
                    fechaVencimientoInputModificar1.setValue(productoModificar1.getFechaVencimiento());

                    productoModificar2 = listaProductosModificarCodComun.get(0);
                    txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                    txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                    txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                    txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                    txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                    txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                    txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                    txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                    txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                    txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                    txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                    fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());
                }

                txtCodigoBarrasModificar1.setDisabled(false);
                txtCantidadPaqueteModificar1.setDisabled(false);
                txtDescripcionPaqueteModificar1.setDisabled(false);
                txtUnidadXPaqueteModificar1.setDisabled(false);
                txtCompraModificar1.setDisabled(false);
                txtDescuentoCompraModificar1.setDisabled(false);
                txtPorcentajeUtilidadModificar1.setDisabled(false);
                txtVentaRealModificar1.setDisabled(false);
                txtComisionModificar1.setDisabled(false);
                txtStockMinimoModificar1.setDisabled(false);
                fechaVencimientoInputModificar1.setDisabledWeekends(false);

                txtCodigoBarrasModificar2.setDisabled(false);
                txtCantidadPaqueteModificar2.setDisabled(false);
                txtDescripcionPaqueteModificar2.setDisabled(false);
                txtUnidadXPaqueteModificar2.setDisabled(false);
                txtCompraModificar2.setDisabled(false);
                txtDescuentoCompraModificar2.setDisabled(false);
                txtPorcentajeUtilidadModificar2.setDisabled(false);
                txtVentaRealModificar2.setDisabled(false);
                txtComisionModificar2.setDisabled(false);
                txtStockMinimoModificar2.setDisabled(false);
                fechaVencimientoInputModificar2.setDisabled(false);

                context.execute("PF('dialogModificarProducto').show();");

                break;
            case 3:

                if (listaProductosModificarCodComun.get(0).getOrden() == 3) {

                    productoModificar1 = listaProductosModificarCodComun.get(0);
                    txtCodigoBarrasModificar1.setValue(productoModificar1.getCodBarras());
                    txtCantidadPaqueteModificar1.setValue(productoModificar1.getStockActUni());
                    txtDescripcionPaqueteModificar1.setValue(productoModificar1.getPaquete());
                    txtUnidadXPaqueteModificar1.setValue(productoModificar1.getUnidadXPaquete());
                    txtCompraModificar1.setValue(productoModificar1.getPrecioCompra());
                    txtDescuentoCompraModificar1.setValue(productoModificar1.getPorcentajeDescuento());
                    txtCompraRealModificar1.setValue(productoModificar1.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar1.setValue(productoModificar1.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar1.setValue(productoModificar1.getVentaSugerida());
                    txtVentaRealModificar1.setValue(productoModificar1.getPrecioVentaReal());
                    txtComisionModificar1.setValue(productoModificar1.getPorcentajeComision());
                    txtPrecioComisionModificar1.setValue(productoModificar1.getComision());
                    txtStockMinimoModificar1.setValue(productoModificar1.getStockMinUni());
                    fechaVencimientoInputModificar1.setValue(productoModificar1.getFechaVencimiento());

                    if (listaProductosModificarCodComun.get(1).getOrden() == 2) {

                        productoModificar2 = listaProductosModificarCodComun.get(1);
                        txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                        txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                        txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                        txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                        txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                        txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                        txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                        txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                        txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                        txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                        txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                        fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                        productoModificar3 = listaProductosModificarCodComun.get(2);
                        txtCodigoBarrasModificar3.setValue(productoModificar3.getCodBarras());
                        txtCantidadPaqueteModificar3.setValue(productoModificar3.getStockActUni());
                        txtDescripcionPaqueteModificar3.setValue(productoModificar3.getPaquete());
                        txtUnidadXPaqueteModificar3.setValue(productoModificar3.getUnidadXPaquete());
                        txtCompraModificar3.setValue(productoModificar3.getPrecioCompra());
                        txtDescuentoCompraModificar3.setValue(productoModificar3.getPorcentajeDescuento());
                        txtCompraRealModificar3.setValue(productoModificar3.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar3.setValue(productoModificar3.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar3.setValue(productoModificar3.getVentaSugerida());
                        txtVentaRealModificar3.setValue(productoModificar3.getPrecioVentaReal());
                        txtComisionModificar3.setValue(productoModificar3.getPorcentajeComision());
                        txtPrecioComisionModificar3.setValue(productoModificar3.getComision());
                        txtStockMinimoModificar3.setValue(productoModificar3.getStockMinUni());
                        fechaVencimientoInputModificar3.setValue(productoModificar3.getFechaVencimiento());

                    } else {
                        //la pos 0 es la orden 2

                        productoModificar2 = listaProductosModificarCodComun.get(2);
                        txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                        txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                        txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                        txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                        txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                        txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                        txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                        txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                        txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                        txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                        txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                        fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                        productoModificar3 = listaProductosModificarCodComun.get(1);
                        txtCodigoBarrasModificar3.setValue(productoModificar3.getCodBarras());
                        txtCantidadPaqueteModificar3.setValue(productoModificar3.getStockActUni());
                        txtDescripcionPaqueteModificar3.setValue(productoModificar3.getPaquete());
                        txtUnidadXPaqueteModificar3.setValue(productoModificar3.getUnidadXPaquete());
                        txtCompraModificar3.setValue(productoModificar3.getPrecioCompra());
                        txtDescuentoCompraModificar3.setValue(productoModificar3.getPorcentajeDescuento());
                        txtCompraRealModificar3.setValue(productoModificar3.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar3.setValue(productoModificar3.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar3.setValue(productoModificar3.getVentaSugerida());
                        txtVentaRealModificar3.setValue(productoModificar3.getPrecioVentaReal());
                        txtComisionModificar3.setValue(productoModificar3.getPorcentajeComision());
                        txtPrecioComisionModificar3.setValue(productoModificar3.getComision());
                        txtStockMinimoModificar3.setValue(productoModificar3.getStockMinUni());
                        fechaVencimientoInputModificar3.setValue(productoModificar3.getFechaVencimiento());

                    }

                } else if (listaProductosModificarCodComun.get(1).getOrden() == 3) {

                    productoModificar1 = listaProductosModificarCodComun.get(1);
                    txtCodigoBarrasModificar1.setValue(productoModificar1.getCodBarras());
                    txtCantidadPaqueteModificar1.setValue(productoModificar1.getStockActUni());
                    txtDescripcionPaqueteModificar1.setValue(productoModificar1.getPaquete());
                    txtUnidadXPaqueteModificar1.setValue(productoModificar1.getUnidadXPaquete());
                    txtCompraModificar1.setValue(productoModificar1.getPrecioCompra());
                    txtDescuentoCompraModificar1.setValue(productoModificar1.getPorcentajeDescuento());
                    txtCompraRealModificar1.setValue(productoModificar1.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar1.setValue(productoModificar1.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar1.setValue(productoModificar1.getVentaSugerida());
                    txtVentaRealModificar1.setValue(productoModificar1.getPrecioVentaReal());
                    txtComisionModificar1.setValue(productoModificar1.getPorcentajeComision());
                    txtPrecioComisionModificar1.setValue(productoModificar1.getComision());
                    txtStockMinimoModificar1.setValue(productoModificar1.getStockMinUni());
                    fechaVencimientoInputModificar1.setValue(productoModificar1.getFechaVencimiento());

                    if (listaProductosModificarCodComun.get(0).getOrden() == 2) {

                        productoModificar2 = listaProductosModificarCodComun.get(0);
                        txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                        txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                        txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                        txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                        txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                        txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                        txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                        txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                        txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                        txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                        txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                        fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                        productoModificar3 = listaProductosModificarCodComun.get(2);
                        txtCodigoBarrasModificar3.setValue(productoModificar3.getCodBarras());
                        txtCantidadPaqueteModificar3.setValue(productoModificar3.getStockActUni());
                        txtDescripcionPaqueteModificar3.setValue(productoModificar3.getPaquete());
                        txtUnidadXPaqueteModificar3.setValue(productoModificar3.getUnidadXPaquete());
                        txtCompraModificar3.setValue(productoModificar3.getPrecioCompra());
                        txtDescuentoCompraModificar3.setValue(productoModificar3.getPorcentajeDescuento());
                        txtCompraRealModificar3.setValue(productoModificar3.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar3.setValue(productoModificar3.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar3.setValue(productoModificar3.getVentaSugerida());
                        txtVentaRealModificar3.setValue(productoModificar3.getPrecioVentaReal());
                        txtComisionModificar3.setValue(productoModificar3.getPorcentajeComision());
                        txtPrecioComisionModificar3.setValue(productoModificar3.getComision());
                        txtStockMinimoModificar3.setValue(productoModificar3.getStockMinUni());
                        fechaVencimientoInputModificar3.setValue(productoModificar3.getFechaVencimiento());

                    } else {
                        //la pos 2 es la orden 2
                        productoModificar2 = listaProductosModificarCodComun.get(2);
                        txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                        txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                        txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                        txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                        txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                        txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                        txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                        txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                        txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                        txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                        txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                        fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                        productoModificar3 = listaProductosModificarCodComun.get(0);
                        txtCodigoBarrasModificar3.setValue(productoModificar3.getCodBarras());
                        txtCantidadPaqueteModificar3.setValue(productoModificar3.getStockActUni());
                        txtDescripcionPaqueteModificar3.setValue(productoModificar3.getPaquete());
                        txtUnidadXPaqueteModificar3.setValue(productoModificar3.getUnidadXPaquete());
                        txtCompraModificar3.setValue(productoModificar3.getPrecioCompra());
                        txtDescuentoCompraModificar3.setValue(productoModificar3.getPorcentajeDescuento());
                        txtCompraRealModificar3.setValue(productoModificar3.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar3.setValue(productoModificar3.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar3.setValue(productoModificar3.getVentaSugerida());
                        txtVentaRealModificar3.setValue(productoModificar3.getPrecioVentaReal());
                        txtComisionModificar3.setValue(productoModificar3.getPorcentajeComision());
                        txtPrecioComisionModificar3.setValue(productoModificar3.getComision());
                        txtStockMinimoModificar3.setValue(productoModificar3.getStockMinUni());
                        fechaVencimientoInputModificar3.setValue(productoModificar3.getFechaVencimiento());

                    }

                } else if (listaProductosModificarCodComun.get(2).getOrden() == 3) {

                    productoModificar1 = listaProductosModificarCodComun.get(2);
                    txtCodigoBarrasModificar1.setValue(productoModificar1.getCodBarras());
                    txtCantidadPaqueteModificar1.setValue(productoModificar1.getStockActUni());
                    txtDescripcionPaqueteModificar1.setValue(productoModificar1.getPaquete());
                    txtUnidadXPaqueteModificar1.setValue(productoModificar1.getUnidadXPaquete());
                    txtCompraModificar1.setValue(productoModificar1.getPrecioCompra());
                    txtDescuentoCompraModificar1.setValue(productoModificar1.getPorcentajeDescuento());
                    txtCompraRealModificar1.setValue(productoModificar1.getPrecioCompraReal());
                    txtPorcentajeUtilidadModificar1.setValue(productoModificar1.getPorcentajeUtilidad());
                    txtVentaSugeridaModificar1.setValue(productoModificar1.getVentaSugerida());
                    txtVentaRealModificar1.setValue(productoModificar1.getPrecioVentaReal());
                    txtComisionModificar1.setValue(productoModificar1.getPorcentajeComision());
                    txtPrecioComisionModificar1.setValue(productoModificar1.getComision());
                    txtStockMinimoModificar1.setValue(productoModificar1.getStockMinUni());
                    fechaVencimientoInputModificar1.setValue(productoModificar1.getFechaVencimiento());

                    if (listaProductosModificarCodComun.get(1).getOrden() == 2) {

                        productoModificar2 = listaProductosModificarCodComun.get(1);
                        txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                        txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                        txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                        txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                        txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                        txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                        txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                        txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                        txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                        txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                        txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                        fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                        productoModificar3 = listaProductosModificarCodComun.get(0);
                        txtCodigoBarrasModificar3.setValue(productoModificar3.getCodBarras());
                        txtCantidadPaqueteModificar3.setValue(productoModificar3.getStockActUni());
                        txtDescripcionPaqueteModificar3.setValue(productoModificar3.getPaquete());
                        txtUnidadXPaqueteModificar3.setValue(productoModificar3.getUnidadXPaquete());
                        txtCompraModificar3.setValue(productoModificar3.getPrecioCompra());
                        txtDescuentoCompraModificar3.setValue(productoModificar3.getPorcentajeDescuento());
                        txtCompraRealModificar3.setValue(productoModificar3.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar3.setValue(productoModificar3.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar3.setValue(productoModificar3.getVentaSugerida());
                        txtVentaRealModificar3.setValue(productoModificar3.getPrecioVentaReal());
                        txtComisionModificar3.setValue(productoModificar3.getPorcentajeComision());
                        txtPrecioComisionModificar3.setValue(productoModificar3.getComision());
                        txtStockMinimoModificar3.setValue(productoModificar3.getStockMinUni());
                        fechaVencimientoInputModificar3.setValue(productoModificar3.getFechaVencimiento());

                    } else {
                        //el de la posicion 0 es el orden 2
                        productoModificar2 = listaProductosModificarCodComun.get(0);
                        txtCodigoBarrasModificar2.setValue(productoModificar2.getCodBarras());
                        txtCantidadPaqueteModificar2.setValue(productoModificar2.getStockActUni());
                        txtDescripcionPaqueteModificar2.setValue(productoModificar2.getPaquete());
                        txtUnidadXPaqueteModificar2.setValue(productoModificar2.getUnidadXPaquete());
                        txtCompraModificar2.setValue(productoModificar2.getPrecioCompra());
                        txtDescuentoCompraModificar2.setValue(productoModificar2.getPorcentajeDescuento());
                        txtCompraRealModificar2.setValue(productoModificar2.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar2.setValue(productoModificar2.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar2.setValue(productoModificar2.getVentaSugerida());
                        txtVentaRealModificar2.setValue(productoModificar2.getPrecioVentaReal());
                        txtComisionModificar2.setValue(productoModificar2.getPorcentajeComision());
                        txtPrecioComisionModificar2.setValue(productoModificar2.getComision());
                        txtStockMinimoModificar2.setValue(productoModificar2.getStockMinUni());
                        fechaVencimientoInputModificar2.setValue(productoModificar2.getFechaVencimiento());

                        productoModificar3 = listaProductosModificarCodComun.get(1);
                        txtCodigoBarrasModificar3.setValue(productoModificar3.getCodBarras());
                        txtCantidadPaqueteModificar3.setValue(productoModificar3.getStockActUni());
                        txtDescripcionPaqueteModificar3.setValue(productoModificar3.getPaquete());
                        txtUnidadXPaqueteModificar3.setValue(productoModificar3.getUnidadXPaquete());
                        txtCompraModificar3.setValue(productoModificar3.getPrecioCompra());
                        txtDescuentoCompraModificar3.setValue(productoModificar3.getPorcentajeDescuento());
                        txtCompraRealModificar3.setValue(productoModificar3.getPrecioCompraReal());
                        txtPorcentajeUtilidadModificar3.setValue(productoModificar3.getPorcentajeUtilidad());
                        txtVentaSugeridaModificar3.setValue(productoModificar3.getVentaSugerida());
                        txtVentaRealModificar3.setValue(productoModificar3.getPrecioVentaReal());
                        txtComisionModificar3.setValue(productoModificar3.getPorcentajeComision());
                        txtPrecioComisionModificar3.setValue(productoModificar3.getComision());
                        txtStockMinimoModificar3.setValue(productoModificar3.getStockMinUni());
                        fechaVencimientoInputModificar3.setValue(productoModificar3.getFechaVencimiento());

                    }

                }

                txtCodigoBarrasModificar1.setDisabled(false);
                txtCantidadPaqueteModificar1.setDisabled(false);
                txtDescripcionPaqueteModificar1.setDisabled(false);
                txtUnidadXPaqueteModificar1.setDisabled(false);
                txtCompraModificar1.setDisabled(false);
                txtDescuentoCompraModificar1.setDisabled(false);
                txtPorcentajeUtilidadModificar1.setDisabled(false);
                txtVentaRealModificar1.setDisabled(false);
                txtComisionModificar1.setDisabled(false);
                txtStockMinimoModificar1.setDisabled(false);
                fechaVencimientoInputModificar1.setDisabled(false);

                txtCodigoBarrasModificar2.setDisabled(false);
                txtCantidadPaqueteModificar2.setDisabled(false);
                txtDescripcionPaqueteModificar2.setDisabled(false);
                txtUnidadXPaqueteModificar2.setDisabled(false);
                txtCompraModificar2.setDisabled(false);
                txtDescuentoCompraModificar2.setDisabled(false);
                txtPorcentajeUtilidadModificar2.setDisabled(false);
                txtVentaRealModificar2.setDisabled(false);
                txtComisionModificar2.setDisabled(false);
                txtStockMinimoModificar2.setDisabled(false);
                fechaVencimientoInputModificar2.setDisabled(false);

                txtCodigoBarrasModificar3.setDisabled(false);
                txtCantidadPaqueteModificar3.setDisabled(false);
                txtDescripcionPaqueteModificar3.setDisabled(false);
                txtUnidadXPaqueteModificar3.setDisabled(false);
                txtCompraModificar3.setDisabled(false);
                txtDescuentoCompraModificar3.setDisabled(false);
                txtPorcentajeUtilidadModificar3.setDisabled(false);
                txtVentaRealModificar3.setDisabled(false);
                txtComisionModificar3.setDisabled(false);
                txtStockMinimoModificar3.setDisabled(false);
                fechaVencimientoInputModificar3.setDisabled(false);

                context.execute("PF('dialogModificarProducto').show();");

                break;
            default:
                break;
        }
    }

    public void modificarProductos() {

        BigDecimal codComun = null;

        RequestContext context = RequestContext.getCurrentInstance();
        ProductoController ProductoController = new ProductoController();

        if (checkConservarStock) {
            switch (this.listaProductosModificarCodComun.size()) {
                case 1:
                    //pida la 1 fila
                    if (productoModificar1.getNombre() == null || txtCodigoBarrasModificar1.getValue() == null || txtCantidadPaqueteModificar1.getValue() == null || txtDescripcionPaqueteModificar1.getValue() == null || txtUnidadXPaqueteModificar1.getValue() == null || txtCompraModificar1.getValue() == null || txtDescuentoCompraModificar1.getValue() == null || txtCompraRealModificar1.getValue() == null || txtPorcentajeUtilidadModificar1.getValue() == null || txtVentaSugeridaModificar1.getValue() == null || txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null || txtPrecioComisionModificar1.getValue() == null || txtStockMinimoModificar1.getValue() == null || fechaVencimientoInputModificar1.getValue() == null) {

                        context.execute("PF('dialogModificarProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                    } else {

                        if (productoModificar1.getNombre().equals("") || txtCodigoBarrasModificar1.getValue().toString().equals("") || txtCantidadPaqueteModificar1.getValue().equals("0") || txtDescripcionPaqueteModificar1.getValue().toString().equals("") || txtUnidadXPaqueteModificar1.getValue().equals("0") || txtCompraModificar1.getValue().equals("0") || txtPorcentajeUtilidadModificar1.getValue().equals("0") || txtVentaRealModificar1.getValue().equals("0") || txtStockMinimoModificar1.getValue().equals("0") || fechaVencimientoInputModificar1.getValue().toString().equals("")) {

                            context.execute("PF('dialogModificarProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                        } else {

                            double precio_sugerido = Double.parseDouble(txtVentaSugeridaModificar1.getValue().toString());
                            double precio_venta_real = Double.parseDouble(txtVentaRealModificar1.getValue().toString());

                            if (precio_venta_real < precio_sugerido) {
                                context.execute("PF('dialogModificarProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                try {

                                    //modificó?
                                    boolean modifico = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                    if (modifico == false) {
                                        //modifico el cod de barras 1

                                        boolean existe = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                        if (existe == false) {
                                            //actualizo
                                            productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                            productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                            productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                            productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                            BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompra(precio_compra);

                                            BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                            BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompraReal(precio_compra_real);

                                            BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                            BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                            productoModificar1.setVentaSugerida(venta_sugerida);

                                            BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                            productoModificar1.setPrecioVentaReal(venta_real);

                                            Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setStockActUni(stock_actual);

                                            Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                            productoModificar1.setStockMinUni(stock_minimo);

                                            BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                            productoModificar1.setComision(comision);

                                            BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeComision(porcentaje_comision);
                                            
                                            productoModificar1.setFechaVencimiento(fechaVencimientoModificar1);

                                            ProductoController.updateProducto(productoModificar1);
                                            context.execute("PF('dialogModificarProducto').hide();");
                                            context.execute("PF('parametrosTabla').filter();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El producto se ha actualizado correctamente."));

                                        } else {
                                            context.execute("PF('dialogModificarProducto').show();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                        }
                                    } else {
                                        //no modificó cod de barras, no lo verifique

                                        //actualizo
                                        productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                        productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                        productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                        productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                        productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                        BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                        productoModificar1.setPrecioCompra(precio_compra);

                                        BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                        productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                        BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                        productoModificar1.setPrecioCompraReal(precio_compra_real);

                                        BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                        productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                        BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                        productoModificar1.setVentaSugerida(venta_sugerida);

                                        BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                        productoModificar1.setPrecioVentaReal(venta_real);

                                        Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                        productoModificar1.setStockActUni(stock_actual);

                                        Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                        productoModificar1.setStockMinUni(stock_minimo);

                                        BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                        productoModificar1.setComision(comision);

                                        BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                        productoModificar1.setPorcentajeComision(porcentaje_comision);
                                        
                                        productoModificar1.setFechaVencimiento(fechaVencimientoModificar1);

                                        ProductoController.updateProducto(productoModificar1);
                                        context.execute("PF('dialogModificarProducto').hide();");
                                        context.execute("PF('parametrosTabla').filter();");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El producto se ha actualizado correctamente."));

                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }

                        }

                    }

                    break;
                case 2:
                    //pida la 1 fila
                    if (productoModificar1.getNombre() == null || txtCodigoBarrasModificar1.getValue() == null || txtCantidadPaqueteModificar1.getValue() == null || txtDescripcionPaqueteModificar1.getValue() == null || txtUnidadXPaqueteModificar1.getValue() == null || txtCompraModificar1.getValue() == null || txtDescuentoCompraModificar1.getValue() == null || txtCompraRealModificar1.getValue() == null || txtPorcentajeUtilidadModificar1.getValue() == null || txtVentaSugeridaModificar1.getValue() == null || txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null || txtPrecioComisionModificar1.getValue() == null || txtStockMinimoModificar1.getValue() == null || fechaVencimientoInputModificar1.getValue() == null || productoModificar2.getNombre() == null || txtCodigoBarrasModificar2.getValue() == null || txtCantidadPaqueteModificar2.getValue() == null || txtDescripcionPaqueteModificar2.getValue() == null || txtUnidadXPaqueteModificar2.getValue() == null || txtCompraModificar2.getValue() == null || txtDescuentoCompraModificar2.getValue() == null || txtCompraRealModificar2.getValue() == null || txtPorcentajeUtilidadModificar2.getValue() == null || txtVentaSugeridaModificar2.getValue() == null || txtVentaRealModificar2.getValue() == null || txtComisionModificar2.getValue() == null || txtPrecioComisionModificar2.getValue() == null || txtStockMinimoModificar2.getValue() == null || fechaVencimientoInputModificar2.getValue() == null) {

                        context.execute("PF('dialogModificarProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                    } else {

                        if (productoModificar1.getNombre().equals("") || txtCodigoBarrasModificar1.getValue().toString().equals("") || txtCantidadPaqueteModificar1.getValue().equals("0") || txtDescripcionPaqueteModificar1.getValue().toString().equals("") || txtUnidadXPaqueteModificar1.getValue().equals("0") || txtCompraModificar1.getValue().equals("0") || txtPorcentajeUtilidadModificar1.getValue().equals("0") || txtVentaRealModificar1.getValue().equals("0") || txtStockMinimoModificar1.getValue().equals("0") || fechaVencimientoInputModificar1.getValue().toString().equals("") || productoModificar2.getNombre().equals("") || txtCodigoBarrasModificar2.getValue().toString().equals("") || txtCantidadPaqueteModificar2.getValue().equals("0") || txtDescripcionPaqueteModificar2.getValue().toString().equals("") || txtUnidadXPaqueteModificar2.getValue().equals("0") || txtCompraModificar2.getValue().equals("0") || txtPorcentajeUtilidadModificar2.getValue().equals("0") || txtVentaRealModificar2.getValue().equals("0") || txtStockMinimoModificar2.getValue().equals("0") || fechaVencimientoInputModificar2.getValue().toString().equals("")) {

                            context.execute("PF('dialogModificarProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                        } else {

                            //agregar normal
                            double precio_sugerido1 = Double.parseDouble(txtVentaSugeridaModificar1.getValue().toString());
                            double precio_venta_real1 = Double.parseDouble(txtVentaRealModificar1.getValue().toString());

                            if (precio_venta_real1 < precio_sugerido1) {
                                context.execute("PF('dialogModificarProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                double precio_sugerido2 = Double.parseDouble(txtVentaSugeridaModificar2.getValue().toString());
                                double precio_venta_real2 = Double.parseDouble(txtVentaRealModificar2.getValue().toString());

                                if (precio_venta_real2 < precio_sugerido2) {
                                    context.execute("PF('dialogModificarProducto').show();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 1 no puede ser menor al precio de venta sugerido 1."));
                                } else {
                                    try {

                                        //modificó?
                                        boolean modifico1 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                        boolean modifico2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                        //modifico false = modificó
                                        if (modifico1 == false || modifico2 == false) {
                                            //modifico el cod de barras 1
                                            boolean existe = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                            boolean existe2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                            if (existe == false && existe2 == false) {
                                                //actualizo las dos primeras

                                                //primera fila
                                                productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                                productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                                productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                                BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompra(precio_compra);

                                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                                BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompraReal(precio_compra_real);

                                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                                BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                                productoModificar1.setVentaSugerida(venta_sugerida);

                                                BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                                productoModificar1.setPrecioVentaReal(venta_real);

                                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setStockActUni(stock_actual);

                                                Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                                productoModificar1.setStockMinUni(stock_minimo);

                                                BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                                productoModificar1.setComision(comision);

                                                BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeComision(porcentaje_comision);
                                                
                                                productoModificar1.setFechaVencimiento(fechaVencimientoModificar1);

                                                //la segunda 
                                                //aqui
                                                productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                                productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                                productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                                BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompra(precio_compra2);

                                                BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                                BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                                BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                productoModificar2.setVentaSugerida(venta_sugerida2);

                                                BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                productoModificar2.setPrecioVentaReal(venta_real2);

                                                Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setStockActUni(stock_actual2);

                                                Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                                productoModificar2.setStockMinUni(stock_minimo2);

                                                BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                                productoModificar2.setComision(comision2);

                                                BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeComision(porcentaje_comision2);
                                                
                                                productoModificar2.setFechaVencimiento(fechaVencimientoModificar2);

                                                ProductoController.updateProducto(productoModificar1);
                                                ProductoController.updateProducto(productoModificar2);

                                                context.execute("PF('dialogModificarProducto').hide();");
                                                context.execute("PF('parametrosTabla').filter();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                            } else {
                                                context.execute("PF('dialogModificarProducto').show();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                            }

                                        } else {

                                            //primera fila
                                            productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                            productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                            productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                            productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                            BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompra(precio_compra);

                                            BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                            BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompraReal(precio_compra_real);

                                            BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                            BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                            productoModificar1.setVentaSugerida(venta_sugerida);

                                            BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                            productoModificar1.setPrecioVentaReal(venta_real);

                                            Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setStockActUni(stock_actual);

                                            Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                            productoModificar1.setStockMinUni(stock_minimo);

                                            BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                            productoModificar1.setComision(comision);

                                            BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeComision(porcentaje_comision);
                                            
                                            productoModificar1.setFechaVencimiento(fechaVencimientoModificar1);

                                            //la segunda 
                                            //aqui
                                            productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                            productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                            productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                            productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                            productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                            BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                            productoModificar2.setPrecioCompra(precio_compra2);

                                            BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                            productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                            BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                            productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                            BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                            productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                            BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                            productoModificar2.setVentaSugerida(venta_sugerida2);

                                            BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                            productoModificar2.setPrecioVentaReal(venta_real2);

                                            Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                            productoModificar2.setStockActUni(stock_actual2);

                                            Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                            productoModificar2.setStockMinUni(stock_minimo2);

                                            BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                            productoModificar2.setComision(comision2);

                                            BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                            productoModificar2.setPorcentajeComision(porcentaje_comision2);
                                            
                                            productoModificar2.setFechaVencimiento(fechaVencimientoModificar2);

                                            ProductoController.updateProducto(productoModificar1);
                                            ProductoController.updateProducto(productoModificar2);

                                            context.execute("PF('dialogModificarProducto').hide();");
                                            context.execute("PF('parametrosTabla').filter();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                        }

                                    } catch (Exception ex) {
                                        Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }

                        }

                    }

                    break;
                case 3:
                    if (productoModificar1.getNombre() == null || txtCodigoBarrasModificar1.getValue() == null || txtCantidadPaqueteModificar1.getValue() == null || txtDescripcionPaqueteModificar1.getValue() == null || txtUnidadXPaqueteModificar1.getValue() == null || txtCompraModificar1.getValue() == null || txtDescuentoCompraModificar1.getValue() == null || txtCompraRealModificar1.getValue() == null || txtPorcentajeUtilidadModificar1.getValue() == null || txtVentaSugeridaModificar1.getValue() == null || txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null || txtPrecioComisionModificar1.getValue() == null || txtStockMinimoModificar1.getValue() == null || fechaVencimientoInputModificar1.getValue() == null || productoModificar2.getNombre() == null || txtCodigoBarrasModificar2.getValue() == null || txtCantidadPaqueteModificar2.getValue() == null || txtDescripcionPaqueteModificar2.getValue() == null || txtUnidadXPaqueteModificar2.getValue() == null || txtCompraModificar2.getValue() == null || txtDescuentoCompraModificar2.getValue() == null || txtCompraRealModificar2.getValue() == null || txtPorcentajeUtilidadModificar2.getValue() == null || txtVentaSugeridaModificar2.getValue() == null || txtVentaRealModificar2.getValue() == null || txtComisionModificar2.getValue() == null || txtPrecioComisionModificar2.getValue() == null || txtStockMinimoModificar2.getValue() == null || fechaVencimientoInputModificar2.getValue() == null || productoModificar3.getNombre() == null || txtCodigoBarrasModificar3.getValue() == null || txtCantidadPaqueteModificar3.getValue() == null || txtDescripcionPaqueteModificar3.getValue() == null || txtUnidadXPaqueteModificar3.getValue() == null || txtCompraModificar3.getValue() == null || txtDescuentoCompraModificar3.getValue() == null || txtCompraRealModificar3.getValue() == null || txtPorcentajeUtilidadModificar3.getValue() == null || txtVentaSugeridaModificar3.getValue() == null || txtVentaRealModificar3.getValue() == null || txtComisionModificar3.getValue() == null || txtPrecioComisionModificar3.getValue() == null || txtStockMinimoModificar3.getValue() == null || fechaVencimientoInputModificar3.getValue() == null) {
                        context.execute("PF('dialogModificarProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                    } else {

                        if (productoModificar1.getNombre().equals("") || txtCodigoBarrasModificar1.getValue().toString().equals("") || txtCantidadPaqueteModificar1.getValue().equals("0") || txtDescripcionPaqueteModificar1.getValue().toString().equals("") || txtUnidadXPaqueteModificar1.getValue().equals("0") || txtCompraModificar1.getValue().equals("0") || txtPorcentajeUtilidadModificar1.getValue().equals("0") || txtVentaRealModificar1.getValue().equals("0") || txtStockMinimoModificar1.getValue().equals("0") || fechaVencimientoInputModificar1.getValue().toString().equals("") || productoModificar2.getNombre().equals("") || txtCodigoBarrasModificar2.getValue().toString().equals("") || txtCantidadPaqueteModificar2.getValue().equals("0") || txtDescripcionPaqueteModificar2.getValue().toString().equals("") || txtUnidadXPaqueteModificar2.getValue().equals("0") || txtCompraModificar2.getValue().equals("0") || txtPorcentajeUtilidadModificar2.getValue().equals("0") || txtVentaRealModificar2.getValue().equals("0") || txtStockMinimoModificar2.getValue().equals("0") || fechaVencimientoInputModificar2.getValue().toString().equals("") || productoModificar3.getNombre().equals("") || txtCodigoBarrasModificar3.getValue().toString().equals("") || txtCantidadPaqueteModificar3.getValue().equals("0") || txtDescripcionPaqueteModificar3.getValue().toString().equals("") || txtUnidadXPaqueteModificar3.getValue().equals("0") || txtCompraModificar3.getValue().equals("0") || txtPorcentajeUtilidadModificar3.getValue().equals("0") || txtVentaRealModificar3.getValue().equals("0") || txtStockMinimoModificar3.getValue().equals("0") || fechaVencimientoInputModificar3.getValue().toString().equals("")) {
                            context.execute("PF('dialogModificarProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                        } else {
                            //modifico las 3 filas

                            //modifico 1 fila
                            double precio_sugerido1 = Double.parseDouble(txtVentaSugeridaModificar1.getValue().toString());
                            double precio_venta_real1 = Double.parseDouble(txtVentaRealModificar1.getValue().toString());

                            if (precio_venta_real1 < precio_sugerido1) {
                                context.execute("PF('dialogModificarProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                double precio_sugerido2 = Double.parseDouble(txtVentaSugeridaModificar2.getValue().toString());
                                double precio_venta_real2 = Double.parseDouble(txtVentaRealModificar2.getValue().toString());

                                if (precio_venta_real2 < precio_sugerido2) {
                                    context.execute("PF('dialogModificarProducto').show();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 1 no puede ser menor al precio de venta sugerido 1."));
                                } else {

                                    double precio_sugerido3 = Double.parseDouble(txtVentaSugeridaModificar3.getValue().toString());
                                    double precio_venta_real3 = Double.parseDouble(txtVentaRealModificar3.getValue().toString());

                                    if (precio_venta_real3 < precio_sugerido3) {
                                        context.execute("PF('dialogModificarProducto').show();");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 2 no puede ser menor al precio de venta sugerido 2."));
                                    } else {
                                        try {

                                            //modificó?
                                            boolean modifico1 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                            boolean modifico2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                            boolean modifico3 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar3.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                            if (modifico1 == false || modifico2 == false || modifico3 == false) {
                                                //modificó, valide
                                                boolean existe = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                                boolean existe2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                                boolean existe3 = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar3.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                                if (existe == false && existe2 == false && existe3 == false) {

                                                    //modifico las 3 filas
                                                    //primera fila
                                                    productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                                    productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                                    productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                                    productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                                    productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                                    BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                                    productoModificar1.setPrecioCompra(precio_compra);

                                                    BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                                    productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                                    BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                                    productoModificar1.setPrecioCompraReal(precio_compra_real);

                                                    BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                                    productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                                    BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                                    productoModificar1.setVentaSugerida(venta_sugerida);

                                                    BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                                    productoModificar1.setPrecioVentaReal(venta_real);

                                                    Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                                    productoModificar1.setStockActUni(stock_actual);

                                                    Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                                    productoModificar1.setStockMinUni(stock_minimo);

                                                    BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                                    productoModificar1.setComision(comision);

                                                    BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                                    productoModificar1.setPorcentajeComision(porcentaje_comision);
                                                    
                                                    productoModificar1.setFechaVencimiento(fechaVencimientoModificar1);

                                                    //la segunda 
                                                    //aqui
                                                    productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                                    productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                                    productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                                    productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                                    productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                                    BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                                    productoModificar2.setPrecioCompra(precio_compra2);

                                                    BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                                    productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                                    BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                                    productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                                    BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                                    productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                    BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                    productoModificar2.setVentaSugerida(venta_sugerida2);

                                                    BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                    productoModificar2.setPrecioVentaReal(venta_real2);

                                                    Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                                    productoModificar2.setStockActUni(stock_actual2);

                                                    Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                                    productoModificar2.setStockMinUni(stock_minimo2);

                                                    BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                                    productoModificar2.setComision(comision2);

                                                    BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                                    productoModificar2.setPorcentajeComision(porcentaje_comision2);
                                                    
                                                    productoModificar2.setFechaVencimiento(fechaVencimientoModificar2);

                                                    //la tercera 
                                                    //aqui
                                                    productoModificar3.setNombre(productoModificar1.getNombre().toUpperCase());
                                                    productoModificar3.setCodBarras(txtCodigoBarrasModificar3.getValue().toString());
                                                    productoModificar3.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar3.getValue().toString()));
                                                    productoModificar3.setPaquete(txtDescripcionPaqueteModificar3.getValue().toString().toUpperCase());
                                                    productoModificar3.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar3.getValue().toString()));

                                                    BigDecimal precio_compra3 = new BigDecimal(txtCompraModificar3.getValue().toString());
                                                    productoModificar3.setPrecioCompra(precio_compra3);

                                                    BigDecimal prcentaje_descuento3 = new BigDecimal(txtDescuentoCompraModificar3.getValue().toString());
                                                    productoModificar3.setPorcentajeDescuento(prcentaje_descuento3);

                                                    BigDecimal precio_compra_real3 = new BigDecimal(txtCompraRealModificar3.getValue().toString());
                                                    productoModificar3.setPrecioCompraReal(precio_compra_real3);

                                                    BigDecimal porcentaje_utilidad3 = new BigDecimal(txtPorcentajeUtilidadModificar3.getValue().toString());
                                                    productoModificar3.setPorcentajeUtilidad(porcentaje_utilidad3);

                                                    BigDecimal venta_sugerida3 = new BigDecimal(precio_sugerido3);
                                                    productoModificar3.setVentaSugerida(venta_sugerida3);

                                                    BigDecimal venta_real3 = new BigDecimal(precio_venta_real3);
                                                    productoModificar3.setPrecioVentaReal(venta_real3);

                                                    Long stock_actual3 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar3.getValue().toString()));
                                                    productoModificar3.setStockActUni(stock_actual3);

                                                    Long stock_minimo3 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar3.getValue().toString()));
                                                    productoModificar3.setStockMinUni(stock_minimo3);

                                                    BigDecimal comision3 = new BigDecimal(txtPrecioComisionModificar3.getValue().toString());
                                                    productoModificar3.setComision(comision3);

                                                    BigDecimal porcentaje_comision3 = new BigDecimal(txtComisionModificar3.getValue().toString());
                                                    productoModificar3.setPorcentajeComision(porcentaje_comision3);
                                                    
                                                    productoModificar3.setFechaVencimiento(fechaVencimientoModificar3);

                                                    ProductoController.updateProducto(productoModificar1);
                                                    ProductoController.updateProducto(productoModificar2);
                                                    ProductoController.updateProducto(productoModificar3);

                                                    context.execute("PF('dialogModificarProducto').hide();");
                                                    context.execute("PF('parametrosTabla').filter();");
                                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                                } else {
                                                    context.execute("PF('dialogModificarProducto').show();");
                                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                                }
                                            } else {
                                                //no valide

                                                //modifico las 3 filas
                                                //primera fila
                                                productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                                productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                                productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                                BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompra(precio_compra);

                                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                                BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompraReal(precio_compra_real);

                                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                                BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                                productoModificar1.setVentaSugerida(venta_sugerida);

                                                BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                                productoModificar1.setPrecioVentaReal(venta_real);

                                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setStockActUni(stock_actual);

                                                Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                                productoModificar1.setStockMinUni(stock_minimo);

                                                BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                                productoModificar1.setComision(comision);

                                                BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeComision(porcentaje_comision);
                                                
                                                productoModificar1.setFechaVencimiento(fechaVencimientoModificar1);

                                                //la segunda 
                                                //aqui
                                                productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                                productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                                productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                                BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompra(precio_compra2);

                                                BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                                BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                                BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                productoModificar2.setVentaSugerida(venta_sugerida2);

                                                BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                productoModificar2.setPrecioVentaReal(venta_real2);

                                                Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setStockActUni(stock_actual2);

                                                Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                                productoModificar2.setStockMinUni(stock_minimo2);

                                                BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                                productoModificar2.setComision(comision2);

                                                BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeComision(porcentaje_comision2);
                                                
                                                productoModificar2.setFechaVencimiento(fechaVencimientoModificar2);

                                                //la tercera 
                                                //aqui
                                                productoModificar3.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar3.setCodBarras(txtCodigoBarrasModificar3.getValue().toString());
                                                productoModificar3.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar3.getValue().toString()));
                                                productoModificar3.setPaquete(txtDescripcionPaqueteModificar3.getValue().toString().toUpperCase());
                                                productoModificar3.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar3.getValue().toString()));

                                                BigDecimal precio_compra3 = new BigDecimal(txtCompraModificar3.getValue().toString());
                                                productoModificar3.setPrecioCompra(precio_compra3);

                                                BigDecimal prcentaje_descuento3 = new BigDecimal(txtDescuentoCompraModificar3.getValue().toString());
                                                productoModificar3.setPorcentajeDescuento(prcentaje_descuento3);

                                                BigDecimal precio_compra_real3 = new BigDecimal(txtCompraRealModificar3.getValue().toString());
                                                productoModificar3.setPrecioCompraReal(precio_compra_real3);

                                                BigDecimal porcentaje_utilidad3 = new BigDecimal(txtPorcentajeUtilidadModificar3.getValue().toString());
                                                productoModificar3.setPorcentajeUtilidad(porcentaje_utilidad3);

                                                BigDecimal venta_sugerida3 = new BigDecimal(precio_sugerido3);
                                                productoModificar3.setVentaSugerida(venta_sugerida3);

                                                BigDecimal venta_real3 = new BigDecimal(precio_venta_real3);
                                                productoModificar3.setPrecioVentaReal(venta_real3);

                                                Long stock_actual3 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar3.getValue().toString()));
                                                productoModificar3.setStockActUni(stock_actual3);

                                                Long stock_minimo3 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar3.getValue().toString()));
                                                productoModificar3.setStockMinUni(stock_minimo3);

                                                BigDecimal comision3 = new BigDecimal(txtPrecioComisionModificar3.getValue().toString());
                                                productoModificar3.setComision(comision3);

                                                BigDecimal porcentaje_comision3 = new BigDecimal(txtComisionModificar3.getValue().toString());
                                                productoModificar3.setPorcentajeComision(porcentaje_comision3);

                                                productoModificar3.setFechaVencimiento(fechaVencimientoModificar3);
                                                
                                                ProductoController.updateProducto(productoModificar1);
                                                ProductoController.updateProducto(productoModificar2);
                                                ProductoController.updateProducto(productoModificar3);

                                                context.execute("PF('dialogModificarProducto').hide();");
                                                context.execute("PF('parametrosTabla').filter();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                            }

                                        } catch (Exception ex) {
                                            Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;
                default:
                    break;
            }

        } else {
            //editelo pero con los stock como nuevos productos
            switch (this.listaProductosModificarCodComun.size()) {
                case 1:
                    //pida la 1 fila
                    if (productoModificar1.getNombre() == null || txtCodigoBarrasModificar1.getValue() == null || txtCantidadPaqueteModificar1.getValue() == null || txtDescripcionPaqueteModificar1.getValue() == null || txtUnidadXPaqueteModificar1.getValue() == null || txtCompraModificar1.getValue() == null || txtDescuentoCompraModificar1.getValue() == null || txtCompraRealModificar1.getValue() == null || txtPorcentajeUtilidadModificar1.getValue() == null || txtVentaSugeridaModificar1.getValue() == null || txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null || txtPrecioComisionModificar1.getValue() == null || txtStockMinimoModificar1.getValue() == null) {

                        context.execute("PF('dialogModificarProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                    } else {

                        if (productoModificar1.getNombre().equals("") || txtCodigoBarrasModificar1.getValue().toString().equals("") || txtCantidadPaqueteModificar1.getValue().equals("0") || txtDescripcionPaqueteModificar1.getValue().toString().equals("") || txtUnidadXPaqueteModificar1.getValue().equals("0") || txtCompraModificar1.getValue().equals("0") || txtPorcentajeUtilidadModificar1.getValue().equals("0") || txtVentaRealModificar1.getValue().equals("0") || txtStockMinimoModificar1.getValue().equals("0")) {

                            context.execute("PF('dialogModificarProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                        } else {

                            double precio_sugerido = Double.parseDouble(txtVentaSugeridaModificar1.getValue().toString());
                            double precio_venta_real = Double.parseDouble(txtVentaRealModificar1.getValue().toString());

                            if (precio_venta_real < precio_sugerido) {
                                context.execute("PF('dialogModificarProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                try {

                                    //modificó?
                                    boolean modifico = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                    if (modifico == false) {
                                        //modifico el cod de barras 1
                                        boolean existe = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                        if (existe == false) {
                                            //actualizo
                                            productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                            productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                            productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                            productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                            BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompra(precio_compra);

                                            BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                            BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompraReal(precio_compra_real);

                                            BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                            BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                            productoModificar1.setVentaSugerida(venta_sugerida);

                                            BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                            productoModificar1.setPrecioVentaReal(venta_real);

                                            Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setStockActUni(stock_actual);

                                            Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                            productoModificar1.setStockMinUni(stock_minimo);

                                            BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                            productoModificar1.setComision(comision);

                                            BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeComision(porcentaje_comision);

                                            ProductoController.updateProducto(productoModificar1);
                                            context.execute("PF('dialogModificarProducto').hide();");
                                            context.execute("PF('parametrosTabla').filter();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El producto se ha actualizado correctamente."));

                                        } else {
                                            context.execute("PF('dialogModificarProducto').show();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                        }
                                    } else {
                                        //no modificó cod de barras, no lo verifique

                                        //actualizo
                                        productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                        productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                        productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                        productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                        productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                        BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                        productoModificar1.setPrecioCompra(precio_compra);

                                        BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                        productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                        BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                        productoModificar1.setPrecioCompraReal(precio_compra_real);

                                        BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                        productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                        BigDecimal venta_sugerida = new BigDecimal(precio_sugerido);
                                        productoModificar1.setVentaSugerida(venta_sugerida);

                                        BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                        productoModificar1.setPrecioVentaReal(venta_real);

                                        Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                        productoModificar1.setStockActUni(stock_actual);

                                        Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                        productoModificar1.setStockMinUni(stock_minimo);

                                        BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                        productoModificar1.setComision(comision);

                                        BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                        productoModificar1.setPorcentajeComision(porcentaje_comision);

                                        ProductoController.updateProducto(productoModificar1);
                                        context.execute("PF('dialogModificarProducto').hide();");
                                        context.execute("PF('parametrosTabla').filter();");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El producto se ha actualizado correctamente."));

                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }

                        }

                    }

                    break;
                case 2:
                    //pida la 1 fila
                    if (productoModificar1.getNombre() == null || txtCodigoBarrasModificar1.getValue() == null || txtCantidadPaqueteModificar1.getValue() == null || txtDescripcionPaqueteModificar1.getValue() == null || txtUnidadXPaqueteModificar1.getValue() == null || txtCompraModificar1.getValue() == null || txtDescuentoCompraModificar1.getValue() == null || txtCompraRealModificar1.getValue() == null || txtPorcentajeUtilidadModificar1.getValue() == null || txtVentaSugeridaModificar1.getValue() == null || txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null || txtPrecioComisionModificar1.getValue() == null || txtStockMinimoModificar1.getValue() == null || productoModificar2.getNombre() == null || txtCodigoBarrasModificar2.getValue() == null || txtCantidadPaqueteModificar2.getValue() == null || txtDescripcionPaqueteModificar2.getValue() == null || txtUnidadXPaqueteModificar2.getValue() == null || txtCompraModificar2.getValue() == null || txtDescuentoCompraModificar2.getValue() == null || txtCompraRealModificar2.getValue() == null || txtPorcentajeUtilidadModificar2.getValue() == null || txtVentaSugeridaModificar2.getValue() == null || txtVentaRealModificar2.getValue() == null || txtComisionModificar2.getValue() == null || txtPrecioComisionModificar2.getValue() == null || txtStockMinimoModificar2.getValue() == null) {

                        context.execute("PF('dialogModificarProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                    } else {

                        if (productoModificar1.getNombre().equals("") || txtCodigoBarrasModificar1.getValue().toString().equals("") || txtCantidadPaqueteModificar1.getValue().equals("0") || txtDescripcionPaqueteModificar1.getValue().toString().equals("") || txtUnidadXPaqueteModificar1.getValue().equals("0") || txtCompraModificar1.getValue().equals("0") || txtPorcentajeUtilidadModificar1.getValue().equals("0") || txtVentaRealModificar1.getValue().equals("0") || txtStockMinimoModificar1.getValue().equals("0") || productoModificar2.getNombre().equals("") || txtCodigoBarrasModificar2.getValue().toString().equals("") || txtCantidadPaqueteModificar2.getValue().equals("0") || txtDescripcionPaqueteModificar2.getValue().toString().equals("") || txtUnidadXPaqueteModificar2.getValue().equals("0") || txtCompraModificar2.getValue().equals("0") || txtPorcentajeUtilidadModificar2.getValue().equals("0") || txtVentaRealModificar2.getValue().equals("0") || txtStockMinimoModificar2.getValue().equals("0")) {

                            context.execute("PF('dialogModificarProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

                        } else {

                            //agregar normal
                            double precio_sugerido1 = Double.parseDouble(txtVentaSugeridaModificar1.getValue().toString());
                            double precio_venta_real1 = Double.parseDouble(txtVentaRealModificar1.getValue().toString());

                            if (precio_venta_real1 < precio_sugerido1) {
                                context.execute("PF('dialogModificarProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                double precio_sugerido2 = Double.parseDouble(txtVentaSugeridaModificar2.getValue().toString());
                                double precio_venta_real2 = Double.parseDouble(txtVentaRealModificar2.getValue().toString());

                                if (precio_venta_real2 < precio_sugerido2) {
                                    context.execute("PF('dialogModificarProducto').show();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 1 no puede ser menor al precio de venta sugerido 1."));
                                } else {
                                    try {

                                        //modificó?
                                        boolean modifico1 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                        boolean modifico2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                        //modifico false = modificó
                                        if (modifico1 == false || modifico2 == false) {
                                            //modifico el cod de barras 1
                                            boolean existe = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                            boolean existe2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                            if (existe == false && existe2 == false) {
                                                //actualizo las dos primeras

                                                //primera fila
                                                productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                                productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                                productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                                BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompra(precio_compra);

                                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                                BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompraReal(precio_compra_real);

                                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                                BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                                productoModificar1.setVentaSugerida(venta_sugerida);

                                                BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                                productoModificar1.setPrecioVentaReal(venta_real);

                                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setStockActUni(stock_actual);

                                                Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                                productoModificar1.setStockMinUni(stock_minimo);

                                                BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                                productoModificar1.setComision(comision);

                                                BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeComision(porcentaje_comision);

                                                //la segunda 
                                                //aqui
                                                productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                                productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                                productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                                BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompra(precio_compra2);

                                                BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                                BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                                BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                productoModificar2.setVentaSugerida(venta_sugerida2);

                                                BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                productoModificar2.setPrecioVentaReal(venta_real2);

                                                Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setStockActUni(stock_actual2 * stock_actual);

                                                Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                                productoModificar2.setStockMinUni(stock_minimo2);

                                                BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                                productoModificar2.setComision(comision2);

                                                BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeComision(porcentaje_comision2);

                                                ProductoController.updateProducto(productoModificar1);
                                                ProductoController.updateProducto(productoModificar2);

                                                context.execute("PF('dialogModificarProducto').hide();");
                                                context.execute("PF('parametrosTabla').filter();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                            } else {
                                                context.execute("PF('dialogModificarProducto').show();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                            }

                                        } else {

                                            //primera fila
                                            productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                            productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                            productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                            productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                            BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompra(precio_compra);

                                            BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                            BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                            productoModificar1.setPrecioCompraReal(precio_compra_real);

                                            BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                            BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                            productoModificar1.setVentaSugerida(venta_sugerida);

                                            BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                            productoModificar1.setPrecioVentaReal(venta_real);

                                            Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                            productoModificar1.setStockActUni(stock_actual);

                                            Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                            productoModificar1.setStockMinUni(stock_minimo);

                                            BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                            productoModificar1.setComision(comision);

                                            BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                            productoModificar1.setPorcentajeComision(porcentaje_comision);

                                            //la segunda 
                                            //aqui
                                            productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                            productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                            productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                            productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                            productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                            BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                            productoModificar2.setPrecioCompra(precio_compra2);

                                            BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                            productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                            BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                            productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                            BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                            productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                            BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                            productoModificar2.setVentaSugerida(venta_sugerida2);

                                            BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                            productoModificar2.setPrecioVentaReal(venta_real2);

                                            Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                            productoModificar2.setStockActUni(stock_actual2 * stock_actual);

                                            Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                            productoModificar2.setStockMinUni(stock_minimo2);

                                            BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                            productoModificar2.setComision(comision2);

                                            BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                            productoModificar2.setPorcentajeComision(porcentaje_comision2);

                                            ProductoController.updateProducto(productoModificar1);
                                            ProductoController.updateProducto(productoModificar2);

                                            context.execute("PF('dialogModificarProducto').hide();");
                                            context.execute("PF('parametrosTabla').filter();");
                                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                        }

                                    } catch (Exception ex) {
                                        Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }

                        }

                    }

                    break;
                case 3:
                    if (productoModificar1.getNombre() == null || txtCodigoBarrasModificar1.getValue() == null || txtCantidadPaqueteModificar1.getValue() == null || txtDescripcionPaqueteModificar1.getValue() == null || txtUnidadXPaqueteModificar1.getValue() == null || txtCompraModificar1.getValue() == null || txtDescuentoCompraModificar1.getValue() == null || txtCompraRealModificar1.getValue() == null || txtPorcentajeUtilidadModificar1.getValue() == null || txtVentaSugeridaModificar1.getValue() == null || txtVentaRealModificar1.getValue() == null || txtComisionModificar1.getValue() == null || txtPrecioComisionModificar1.getValue() == null || txtStockMinimoModificar1.getValue() == null || productoModificar2.getNombre() == null || txtCodigoBarrasModificar2.getValue() == null || txtCantidadPaqueteModificar2.getValue() == null || txtDescripcionPaqueteModificar2.getValue() == null || txtUnidadXPaqueteModificar2.getValue() == null || txtCompraModificar2.getValue() == null || txtDescuentoCompraModificar2.getValue() == null || txtCompraRealModificar2.getValue() == null || txtPorcentajeUtilidadModificar2.getValue() == null || txtVentaSugeridaModificar2.getValue() == null || txtVentaRealModificar2.getValue() == null || txtComisionModificar2.getValue() == null || txtPrecioComisionModificar2.getValue() == null || txtStockMinimoModificar2.getValue() == null || productoModificar3.getNombre() == null || txtCodigoBarrasModificar3.getValue() == null || txtCantidadPaqueteModificar3.getValue() == null || txtDescripcionPaqueteModificar3.getValue() == null || txtUnidadXPaqueteModificar3.getValue() == null || txtCompraModificar3.getValue() == null || txtDescuentoCompraModificar3.getValue() == null || txtCompraRealModificar3.getValue() == null || txtPorcentajeUtilidadModificar3.getValue() == null || txtVentaSugeridaModificar3.getValue() == null || txtVentaRealModificar3.getValue() == null || txtComisionModificar3.getValue() == null || txtPrecioComisionModificar3.getValue() == null || txtStockMinimoModificar3.getValue() == null) {
                        context.execute("PF('dialogModificarProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                    } else {

                        if (productoModificar1.getNombre().equals("") || txtCodigoBarrasModificar1.getValue().toString().equals("") || txtCantidadPaqueteModificar1.getValue().equals("0") || txtDescripcionPaqueteModificar1.getValue().toString().equals("") || txtUnidadXPaqueteModificar1.getValue().equals("0") || txtCompraModificar1.getValue().equals("0") || txtPorcentajeUtilidadModificar1.getValue().equals("0") || txtVentaRealModificar1.getValue().equals("0") || txtStockMinimoModificar1.getValue().equals("0") || productoModificar2.getNombre().equals("") || txtCodigoBarrasModificar2.getValue().toString().equals("") || txtCantidadPaqueteModificar2.getValue().equals("0") || txtDescripcionPaqueteModificar2.getValue().toString().equals("") || txtUnidadXPaqueteModificar2.getValue().equals("0") || txtCompraModificar2.getValue().equals("0") || txtPorcentajeUtilidadModificar2.getValue().equals("0") || txtVentaRealModificar2.getValue().equals("0") || txtStockMinimoModificar2.getValue().equals("0") || productoModificar3.getNombre().equals("") || txtCodigoBarrasModificar3.getValue().toString().equals("") || txtCantidadPaqueteModificar3.getValue().equals("0") || txtDescripcionPaqueteModificar3.getValue().toString().equals("") || txtUnidadXPaqueteModificar3.getValue().equals("0") || txtCompraModificar3.getValue().equals("0") || txtPorcentajeUtilidadModificar3.getValue().equals("0") || txtVentaRealModificar3.getValue().equals("0") || txtStockMinimoModificar3.getValue().equals("0")) {
                            context.execute("PF('dialogModificarProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                        } else {
                            //modifico las 3 filas

                            //modifico 1 fila
                            double precio_sugerido1 = Double.parseDouble(txtVentaSugeridaModificar1.getValue().toString());
                            double precio_venta_real1 = Double.parseDouble(txtVentaRealModificar1.getValue().toString());

                            if (precio_venta_real1 < precio_sugerido1) {
                                context.execute("PF('dialogModificarProducto').show();");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                            } else {

                                double precio_sugerido2 = Double.parseDouble(txtVentaSugeridaModificar2.getValue().toString());
                                double precio_venta_real2 = Double.parseDouble(txtVentaRealModificar2.getValue().toString());

                                if (precio_venta_real2 < precio_sugerido2) {
                                    context.execute("PF('dialogModificarProducto').show();");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 1 no puede ser menor al precio de venta sugerido 1."));
                                } else {

                                    double precio_sugerido3 = Double.parseDouble(txtVentaSugeridaModificar3.getValue().toString());
                                    double precio_venta_real3 = Double.parseDouble(txtVentaRealModificar3.getValue().toString());

                                    if (precio_venta_real3 < precio_sugerido3) {
                                        context.execute("PF('dialogModificarProducto').show();");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 2 no puede ser menor al precio de venta sugerido 2."));
                                    } else {
                                        try {

                                            //modificó?
                                            boolean modifico1 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                            boolean modifico2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                            boolean modifico3 = ProductoController.obtenerProductoPorCodigoBarrasAndCodigoComun(txtCodigoBarrasModificar3.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                            if (modifico1 == false || modifico2 == false || modifico3 == false) {
                                                //modificó, valide
                                                boolean existe = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar1.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                                boolean existe2 = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar2.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());
                                                boolean existe3 = ProductoController.obtenerProductoPorCodigoBarrasAndCodComunExiste(txtCodigoBarrasModificar3.getValue().toString(), this.listaProductosModificarCodComun.get(0).getCodComun());

                                                if (existe == false && existe2 == false && existe3 == false) {

                                                    //modifico las 3 filas
                                                    //primera fila
                                                    productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                                    productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                                    productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                                    productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                                    productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                                    BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                                    productoModificar1.setPrecioCompra(precio_compra);

                                                    BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                                    productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                                    BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                                    productoModificar1.setPrecioCompraReal(precio_compra_real);

                                                    BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                                    productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                                    BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                                    productoModificar1.setVentaSugerida(venta_sugerida);

                                                    BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                                    productoModificar1.setPrecioVentaReal(venta_real);

                                                    Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                                    productoModificar1.setStockActUni(stock_actual);

                                                    Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                                    productoModificar1.setStockMinUni(stock_minimo);

                                                    BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                                    productoModificar1.setComision(comision);

                                                    BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                                    productoModificar1.setPorcentajeComision(porcentaje_comision);

                                                    //la segunda 
                                                    //aqui
                                                    productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                                    productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                                    productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                                    productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                                    productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                                    BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                                    productoModificar2.setPrecioCompra(precio_compra2);

                                                    BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                                    productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                                    BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                                    productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                                    BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                                    productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                    BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                    productoModificar2.setVentaSugerida(venta_sugerida2);

                                                    BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                    productoModificar2.setPrecioVentaReal(venta_real2);

                                                    Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                                    productoModificar2.setStockActUni(stock_actual2 * stock_actual);

                                                    Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                                    productoModificar2.setStockMinUni(stock_minimo2);

                                                    BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                                    productoModificar2.setComision(comision2);

                                                    BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                                    productoModificar2.setPorcentajeComision(porcentaje_comision2);

                                                    //la tercera 
                                                    //aqui
                                                    productoModificar3.setNombre(productoModificar1.getNombre().toUpperCase());
                                                    productoModificar3.setCodBarras(txtCodigoBarrasModificar3.getValue().toString());
                                                    productoModificar3.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar3.getValue().toString()));
                                                    productoModificar3.setPaquete(txtDescripcionPaqueteModificar3.getValue().toString().toUpperCase());
                                                    productoModificar3.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar3.getValue().toString()));

                                                    BigDecimal precio_compra3 = new BigDecimal(txtCompraModificar3.getValue().toString());
                                                    productoModificar3.setPrecioCompra(precio_compra3);

                                                    BigDecimal prcentaje_descuento3 = new BigDecimal(txtDescuentoCompraModificar3.getValue().toString());
                                                    productoModificar3.setPorcentajeDescuento(prcentaje_descuento3);

                                                    BigDecimal precio_compra_real3 = new BigDecimal(txtCompraRealModificar3.getValue().toString());
                                                    productoModificar3.setPrecioCompraReal(precio_compra_real3);

                                                    BigDecimal porcentaje_utilidad3 = new BigDecimal(txtPorcentajeUtilidadModificar3.getValue().toString());
                                                    productoModificar3.setPorcentajeUtilidad(porcentaje_utilidad3);

                                                    BigDecimal venta_sugerida3 = new BigDecimal(precio_sugerido3);
                                                    productoModificar3.setVentaSugerida(venta_sugerida3);

                                                    BigDecimal venta_real3 = new BigDecimal(precio_venta_real3);
                                                    productoModificar3.setPrecioVentaReal(venta_real3);

                                                    Long stock_actual3 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar3.getValue().toString()));
                                                    productoModificar3.setStockActUni(stock_actual3 * stock_actual);

                                                    Long stock_minimo3 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar3.getValue().toString()));
                                                    productoModificar3.setStockMinUni(stock_minimo3);

                                                    BigDecimal comision3 = new BigDecimal(txtPrecioComisionModificar3.getValue().toString());
                                                    productoModificar3.setComision(comision3);

                                                    BigDecimal porcentaje_comision3 = new BigDecimal(txtComisionModificar3.getValue().toString());
                                                    productoModificar3.setPorcentajeComision(porcentaje_comision3);

                                                    ProductoController.updateProducto(productoModificar1);
                                                    ProductoController.updateProducto(productoModificar2);
                                                    ProductoController.updateProducto(productoModificar3);

                                                    context.execute("PF('dialogModificarProducto').hide();");
                                                    context.execute("PF('parametrosTabla').filter();");
                                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                                } else {
                                                    context.execute("PF('dialogModificarProducto').show();");
                                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Ya existe un producto con el mismo código de barras."));
                                                }
                                            } else {
                                                //no valide

                                                //modifico las 3 filas
                                                //primera fila
                                                productoModificar1.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar1.setCodBarras(txtCodigoBarrasModificar1.getValue().toString());
                                                productoModificar1.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setPaquete(txtDescripcionPaqueteModificar1.getValue().toString().toUpperCase());
                                                productoModificar1.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar1.getValue().toString()));

                                                BigDecimal precio_compra = new BigDecimal(txtCompraModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompra(precio_compra);

                                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompraModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeDescuento(prcentaje_descuento);

                                                BigDecimal precio_compra_real = new BigDecimal(txtCompraRealModificar1.getValue().toString());
                                                productoModificar1.setPrecioCompraReal(precio_compra_real);

                                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidadModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeUtilidad(porcentaje_utilidad);

                                                BigDecimal venta_sugerida = new BigDecimal(precio_sugerido1);
                                                productoModificar1.setVentaSugerida(venta_sugerida);

                                                BigDecimal venta_real = new BigDecimal(precio_venta_real1);
                                                productoModificar1.setPrecioVentaReal(venta_real);

                                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar1.getValue().toString()));
                                                productoModificar1.setStockActUni(stock_actual);

                                                Long stock_minimo = Long.valueOf(Integer.parseInt(txtStockMinimoModificar1.getValue().toString()));
                                                productoModificar1.setStockMinUni(stock_minimo);

                                                BigDecimal comision = new BigDecimal(txtPrecioComisionModificar1.getValue().toString());
                                                productoModificar1.setComision(comision);

                                                BigDecimal porcentaje_comision = new BigDecimal(txtComisionModificar1.getValue().toString());
                                                productoModificar1.setPorcentajeComision(porcentaje_comision);

                                                //la segunda 
                                                //aqui
                                                productoModificar2.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar2.setCodBarras(txtCodigoBarrasModificar2.getValue().toString());
                                                productoModificar2.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setPaquete(txtDescripcionPaqueteModificar2.getValue().toString().toUpperCase());
                                                productoModificar2.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar2.getValue().toString()));

                                                BigDecimal precio_compra2 = new BigDecimal(txtCompraModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompra(precio_compra2);

                                                BigDecimal prcentaje_descuento2 = new BigDecimal(txtDescuentoCompraModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeDescuento(prcentaje_descuento2);

                                                BigDecimal precio_compra_real2 = new BigDecimal(txtCompraRealModificar2.getValue().toString());
                                                productoModificar2.setPrecioCompraReal(precio_compra_real2);

                                                BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidadModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                BigDecimal venta_sugerida2 = new BigDecimal(precio_sugerido2);
                                                productoModificar2.setVentaSugerida(venta_sugerida2);

                                                BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                productoModificar2.setPrecioVentaReal(venta_real2);

                                                Long stock_actual2 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar2.getValue().toString()));
                                                productoModificar2.setStockActUni(stock_actual2 * stock_actual);

                                                Long stock_minimo2 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar2.getValue().toString()));
                                                productoModificar2.setStockMinUni(stock_minimo2);

                                                BigDecimal comision2 = new BigDecimal(txtPrecioComisionModificar2.getValue().toString());
                                                productoModificar2.setComision(comision2);

                                                BigDecimal porcentaje_comision2 = new BigDecimal(txtComisionModificar2.getValue().toString());
                                                productoModificar2.setPorcentajeComision(porcentaje_comision2);

                                                //la tercera 
                                                //aqui
                                                productoModificar3.setNombre(productoModificar1.getNombre().toUpperCase());
                                                productoModificar3.setCodBarras(txtCodigoBarrasModificar3.getValue().toString());
                                                productoModificar3.setStockActUni(Long.valueOf(txtCantidadPaqueteModificar3.getValue().toString()));
                                                productoModificar3.setPaquete(txtDescripcionPaqueteModificar3.getValue().toString().toUpperCase());
                                                productoModificar3.setUnidadXPaquete(Long.valueOf(txtUnidadXPaqueteModificar3.getValue().toString()));

                                                BigDecimal precio_compra3 = new BigDecimal(txtCompraModificar3.getValue().toString());
                                                productoModificar3.setPrecioCompra(precio_compra3);

                                                BigDecimal prcentaje_descuento3 = new BigDecimal(txtDescuentoCompraModificar3.getValue().toString());
                                                productoModificar3.setPorcentajeDescuento(prcentaje_descuento3);

                                                BigDecimal precio_compra_real3 = new BigDecimal(txtCompraRealModificar3.getValue().toString());
                                                productoModificar3.setPrecioCompraReal(precio_compra_real3);

                                                BigDecimal porcentaje_utilidad3 = new BigDecimal(txtPorcentajeUtilidadModificar3.getValue().toString());
                                                productoModificar3.setPorcentajeUtilidad(porcentaje_utilidad3);

                                                BigDecimal venta_sugerida3 = new BigDecimal(precio_sugerido3);
                                                productoModificar3.setVentaSugerida(venta_sugerida3);

                                                BigDecimal venta_real3 = new BigDecimal(precio_venta_real3);
                                                productoModificar3.setPrecioVentaReal(venta_real3);

                                                Long stock_actual3 = Long.valueOf(Integer.parseInt(txtCantidadPaqueteModificar3.getValue().toString()));
                                                productoModificar3.setStockActUni(stock_actual3 * stock_actual);

                                                Long stock_minimo3 = Long.valueOf(Integer.parseInt(txtStockMinimoModificar3.getValue().toString()));
                                                productoModificar3.setStockMinUni(stock_minimo3);

                                                BigDecimal comision3 = new BigDecimal(txtPrecioComisionModificar3.getValue().toString());
                                                productoModificar3.setComision(comision3);

                                                BigDecimal porcentaje_comision3 = new BigDecimal(txtComisionModificar3.getValue().toString());
                                                productoModificar3.setPorcentajeComision(porcentaje_comision3);

                                                ProductoController.updateProducto(productoModificar1);
                                                ProductoController.updateProducto(productoModificar2);
                                                ProductoController.updateProducto(productoModificar3);

                                                context.execute("PF('dialogModificarProducto').hide();");
                                                context.execute("PF('parametrosTabla').filter();");
                                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Los productos se actualizaron correctamente."));

                                            }

                                        } catch (Exception ex) {
                                            Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;
                default:
                    break;
            }

        }

    }

    public void limpiarAgregarProducto() {

        producto = new Producto();
        productoViejo = null;

        txtCodigoBarras.setValue(null);
        txtCantidadPaquete.setValue(null);
        txtDescripcionPaquete.setValue(null);
        txtUnidadXPaquete.setValue(null);
        txtCompra.setValue(null);
        txtDescuentoCompra.setValue(null);
        txtCompraReal.setValue(null);
        txtPorcentajeUtilidad.setValue(null);
        txtVentaSugerida.setValue(null);
        txtVentaReal.setValue(null);
        txtComision.setValue(null);
        txtPrecioComision.setValue(null);
        txtStockMinimo.setValue(null);
        fechaVencimientoInput.setValue(null);

        txtCodigoBarras1.setValue(null);
        txtCantidadPaquete1.setValue(null);
        txtDescripcionPaquete1.setValue(null);
        txtUnidadXPaquete1.setValue(null);
        txtCompra1.setValue(null);
        txtDescuentoCompra1.setValue(null);
        txtCompraReal1.setValue(null);
        txtPorcentajeUtilidad1.setValue(null);
        txtVentaSugerida1.setValue(null);
        txtVentaReal1.setValue(null);
        txtComision1.setValue(null);
        txtPrecioComision1.setValue(null);
        txtStockMinimo1.setValue(null);
        fechaVencimientoInput1.setValue(null);

        txtCodigoBarras2.setValue(null);
        txtCantidadPaquete2.setValue(null);
        txtDescripcionPaquete2.setValue(null);
        txtUnidadXPaquete2.setValue(null);
        txtCompra2.setValue(null);
        txtDescuentoCompra2.setValue(null);
        txtCompraReal2.setValue(null);
        txtPorcentajeUtilidad2.setValue(null);
        txtVentaSugerida2.setValue(null);
        txtVentaReal2.setValue(null);
        txtComision2.setValue(null);
        txtPrecioComision2.setValue(null);
        txtStockMinimo2.setValue(null);
        fechaVencimientoInput2.setValue(null);

        setCheck1(false);
        setCheck2(false);

        selectCheck1();
        selectCheck2();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogNuevoProducto').show();");

    }

    public void cancelarRegistroProducto() {

        producto = new Producto();
        productoViejo = null;

        txtCodigoBarras.setValue(null);
        txtCantidadPaquete.setValue(null);
        txtDescripcionPaquete.setValue(null);
        txtUnidadXPaquete.setValue(null);
        txtCompra.setValue(null);
        txtDescuentoCompra.setValue(null);
        txtCompraReal.setValue(null);
        txtPorcentajeUtilidad.setValue(null);
        txtVentaSugerida.setValue(null);
        txtVentaReal.setValue(null);
        txtComision.setValue(null);
        txtPrecioComision.setValue(null);
        txtStockMinimo.setValue(null);
        fechaVencimientoInput.setValue(null);

        txtCodigoBarras1.setValue(null);
        txtCantidadPaquete1.setValue(null);
        txtDescripcionPaquete1.setValue(null);
        txtUnidadXPaquete1.setValue(null);
        txtCompra1.setValue(null);
        txtDescuentoCompra1.setValue(null);
        txtCompraReal1.setValue(null);
        txtPorcentajeUtilidad1.setValue(null);
        txtVentaSugerida1.setValue(null);
        txtVentaReal1.setValue(null);
        txtComision1.setValue(null);
        txtPrecioComision1.setValue(null);
        txtStockMinimo1.setValue(null);
        fechaVencimientoInput1.setValue(null);

        txtCodigoBarras2.setValue(null);
        txtCantidadPaquete2.setValue(null);
        txtDescripcionPaquete2.setValue(null);
        txtUnidadXPaquete2.setValue(null);
        txtCompra2.setValue(null);
        txtDescuentoCompra2.setValue(null);
        txtCompraReal2.setValue(null);
        txtPorcentajeUtilidad2.setValue(null);
        txtVentaSugerida2.setValue(null);
        txtVentaReal2.setValue(null);
        txtComision2.setValue(null);
        txtPrecioComision2.setValue(null);
        txtStockMinimo2.setValue(null);
        fechaVencimientoInput2.setValue(null);

        setCheck1(false);
        setCheck2(false);

        selectCheck1();
        selectCheck2();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogNuevoProducto').hide();");
        context.execute("PF('parametrosTabla').filter();");

    }

    public void cancelarAdicionarProductosStock() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAgregarProducto').hide();");
        producto = new Producto();

    }

    public void adicionarProductosStock() {

        if (txtAdicionarProductos.getValue() == null) {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogAgregarProducto').show();");
            context.execute("PF('parametrosTabla').filter();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El valor no puede quedar vacío."));
        } else {
            if (txtAdicionarProductos.getValue().toString().equals("0")) {
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogAgregarProducto').show();");
                context.execute("PF('parametrosTabla').filter();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El valor no puede ser 0."));
            } else {
                //agrega

                if (checkActualizarLinea == false) {

                    BigDecimal number = new BigDecimal("31.545334");
                    long iPart = number.longValue();
                    BigDecimal fraccion = number.remainder(BigDecimal.ONE);

                    System.out.println("Integer part = " + iPart);
                    System.out.println("Fractional part = " + fraccion);

                    if (producto.getStockActUni() != null) {
                        int adicionar = Integer.parseInt(txtAdicionarProductos.getValue().toString());
                        producto.setStockActUni(producto.getStockActUni() + adicionar);
                        ProductoController ProductoController = new ProductoController();
                        ProductoController.updateProducto(producto);

                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dialogAgregarProducto').hide();");
                        context.execute("PF('parametrosTabla').filter();");
                        txtAdicionarProductos.setValue("");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Se actualizó el stock correctamente."));
                        producto = new Producto();
                    } else {
                        Long adicionar = Long.valueOf(txtAdicionarProductos.getValue().toString());
                        producto.setStockActUni(adicionar);
                        ProductoController ProductoController = new ProductoController();
                        ProductoController.updateProducto(producto);

                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dialogAgregarProducto').hide();");
                        context.execute("PF('parametrosTabla').filter();");
                        txtAdicionarProductos.setValue("");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Se actualizó el stock correctamente."));
                        producto = new Producto();
                    }
                } else {

                    //actualizo las lineas
                    ProductoController ProductoController = new ProductoController();
                    List<Producto> listaProductoLineas = null;
                    listaProductoLineas = ProductoController.listaDeProductosPorCodComun(producto.getCodComun());

                    switch (listaProductoLineas.size()) {
                        case 1:

                            producto.setStockActUni(Long.valueOf(txtAdicionarProductos.getValue().toString()));
                            ProductoController.updateProducto(producto);

                            break;
                        case 2:

                            if (listaProductoLineas.get(0).getOrden() == 3) {

                                //pos0 = orden 3
                                //pos1 = orden 2
                                Producto p = new Producto();
                                p.setStockActUni(producto.getStockActUni() * listaProductoLineas.get(1).getStockActUni());
                                producto.setStockActUni(Long.valueOf(txtAdicionarProductos.getValue().toString()));
                                ProductoController.updateProducto(producto);
                                ProductoController.updateProducto(p);

                            } else {
                                //pos0 = orden 2
                                //pos1 = orden 3
                                Producto p = new Producto();
                                p.setStockActUni(producto.getStockActUni() * listaProductoLineas.get(1).getStockActUni());
                                producto.setStockActUni(Long.valueOf(txtAdicionarProductos.getValue().toString()));
                                ProductoController.updateProducto(producto);
                                ProductoController.updateProducto(p);

                                RequestContext context = RequestContext.getCurrentInstance();
                                context.execute("PF('dialogAgregarProducto').hide();");
                                context.execute("PF('parametrosTabla').filter();");
                                txtAdicionarProductos.setValue("");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Se actualizó el stock correctamente."));
                                producto = new Producto();
                            }

                            break;
                        case 3:

                            if (listaProductoLineas.get(0).getOrden() == 3) {

                                if (listaProductoLineas.get(1).getOrden() == 2) {

                                    if (producto.getOrden() == 3) {
                                        //modificó cajas

                                        //pos0 = orden3
                                        //pos1 = orden2
                                        //pos2 = orden1
                                        producto.setStockActUni(producto.getStockActUni() + Long.parseLong(txtAdicionarProductos.getValue().toString()));
                                        Producto p1 = new Producto();
                                        p1 = listaProductoLineas.get(1);
                                        Long sobres = ((Long.parseLong(txtAdicionarProductos.getValue().toString()) * producto.getUnidadXPaquete()) / p1.getUnidadXPaquete());
                                        p1.setStockActUni(p1.getStockActUni() + sobres);

                                        Producto p2 = new Producto();
                                        p2 = listaProductoLineas.get(2);
                                        Long uni = ((Long.parseLong(txtAdicionarProductos.getValue().toString()) * producto.getUnidadXPaquete()) / p2.getUnidadXPaquete());
                                        p2.setStockActUni(p2.getStockActUni() + uni);

                                        ProductoController.updateProducto(producto);
                                        ProductoController.updateProducto(p1);
                                        ProductoController.updateProducto(p2);

                                        RequestContext context = RequestContext.getCurrentInstance();
                                        context.execute("PF('dialogAgregarProducto').hide();");
                                        context.execute("PF('parametrosTabla').filter();");
                                        txtAdicionarProductos.setValue("");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Se actualizó el stock correctamente."));
                                        producto = new Producto();

                                    } else if (producto.getOrden() == 2) {
                                        //modificó sobres

                                        //pos0 = orden3
                                        //pos1 = orden2
                                        //pos2 = orden1
//                                        producto.setStockActUni(producto.getStockActUni() + Long.parseLong(txtAdicionarProductos.getValue().toString()));
//                                        Producto p1 = new Producto();
//                                        p1 = listaProductoLineas.get(0);
//                                        Long cajas = ((Long.parseLong(txtAdicionarProductos.getValue().toString()) * producto.getUnidadXPaquete()) / producto.getUnidadXPaquete());
//                                        p1.setStockActUni(p1.getStockActUni() + cajas);
//
//                                        Producto p2 = new Producto();
//                                        p2 = listaProductoLineas.get(2);
//                                        Long uni = ((Long.parseLong(txtAdicionarProductos.getValue().toString()) * producto.getUnidadXPaquete()) / p2.getUnidadXPaquete());
//                                        p2.setStockActUni(p2.getStockActUni() + uni);
//
//                                        ProductoController.updateProducto(producto);
//                                        ProductoController.updateProducto(p1);
//                                        ProductoController.updateProducto(p2);
//
//                                        RequestContext context = RequestContext.getCurrentInstance();
//                                        context.execute("PF('dialogAgregarProducto').hide();");
//                                        context.execute("PF('parametrosTabla').filter();");
//                                        txtAdicionarProductos.setValue("");
//                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "Se actualizó el stock correctamente."));
//                                        producto = new Producto();
                                    } else {
                                        //modificó unidades

                                        //pos0 = orden3
                                        //pos1 = orden2
                                        //pos2 = orden1
                                    }

                                } else {

                                }

                                if (listaProductoLineas.get(1).getOrden() == 2) {

                                } else {
                                    //la pos 0 es la orden 2

                                }

                            } else if (listaProductoLineas.get(1).getOrden() == 3) {

                                if (listaProductoLineas.get(0).getOrden() == 2) {

                                } else {
                                    //la pos 2 es la orden 2

                                }

                            } else if (listaProductoLineas.get(2).getOrden() == 3) {

                                if (listaProductoLineas.get(1).getOrden() == 2) {

                                } else {
                                    //el de la posicion 0 es el orden 2

                                }

                            }

                            break;
                        default:
                            break;
                    }
                }

            }
        }

    }

    public void eliminarProducto() {

        ProductoController ProductoController = new ProductoController();
        Producto p = new Producto();

        p = ProductoController.verificarProductoEnFactura(producto.getCodigo());
        if (p == null) {
            //se elimina
            List<Producto> listaProductoCodComun = null;
            listaProductoCodComun = ProductoController.listaDeProductosPorCodComun(producto.getCodComun());
            switch (listaProductoCodComun.size()) {
                case 3:
                    switch (producto.getOrden()) {
                        case 3:
                            for (int i = 0; i < listaProductoCodComun.size(); i++) {
                                if (listaProductoCodComun.get(i).getOrden() == 2) {
                                    listaProductoCodComun.get(i).setOrden(3);
                                } else if (listaProductoCodComun.get(i).getOrden() == 1) {
                                    listaProductoCodComun.get(i).setOrden(2);
                                }
                            }
                            for (int i = 0; i < listaProductoCodComun.size(); i++) {
                                ProductoController.updateProducto(listaProductoCodComun.get(i));
                            }
                            break;
                        case 2:
                            if (listaProductoCodComun.get(0).getOrden() == 1) {
                                listaProductoCodComun.get(0).setOrden(2);
                                ProductoController.updateProducto(listaProductoCodComun.get(0));
                            } else if (listaProductoCodComun.get(1).getOrden() == 1) {
                                listaProductoCodComun.get(1).setOrden(2);
                                ProductoController.updateProducto(listaProductoCodComun.get(1));
                            } else {
                                //en la pos2 = orden 1
                                listaProductoCodComun.get(2).setOrden(2);
                                ProductoController.updateProducto(listaProductoCodComun.get(0));
                            }

                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    if (producto.getOrden() == 3) {
                        for (int i = 0; i < listaProductoCodComun.size(); i++) {
                            if (listaProductoCodComun.get(i).getOrden() == 2) {
                                listaProductoCodComun.get(i).setOrden(3);
                            } else if (listaProductoCodComun.get(i).getOrden() == 1) {
                                listaProductoCodComun.get(i).setOrden(2);
                            }
                        }
                        for (int i = 0; i < listaProductoCodComun.size(); i++) {
                            ProductoController.updateProducto(listaProductoCodComun.get(i));
                        }

                    }
                    break;
                default:
                    break;
            }

            ProductoController.deleteProducto(producto);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarProducto').hide();");
            context.execute("PF('parametrosTabla').filter();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa:", "El Producto se eliminó correctamente."));
            producto = new Producto();

        } else {
            //no se elimina
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarProducto').hide();");
            context.execute("PF('parametrosTabla').filter();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Producto no puede eliminarse, puede que este asociado a una factura."));
            producto = new Producto();
        }

    }

    public void cancelarModificar() {

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogModificarProducto').hide();");
        this.listaProductosModificarCodComun = null;
        producto = new Producto();
        context.execute("PF('parametrosTabla').filter();");

        productoModificar1 = null;
        txtCodigoBarrasModificar1.setValue(null);
        txtCantidadPaqueteModificar1.setValue(null);
        txtDescripcionPaqueteModificar1.setValue(null);
        txtUnidadXPaqueteModificar1.setValue(null);
        txtCompraModificar1.setValue(null);
        txtDescuentoCompraModificar1.setValue(null);
        txtCompraRealModificar1.setValue(null);
        txtPorcentajeUtilidadModificar1.setValue(null);
        txtVentaSugeridaModificar1.setValue(null);
        txtVentaRealModificar1.setValue(null);
        txtComisionModificar1.setValue(null);
        txtPrecioComisionModificar1.setValue(null);
        txtStockMinimoModificar1.setValue(null);

        txtCodigoBarrasModificar1.setDisabled(true);
        txtCantidadPaqueteModificar1.setDisabled(true);
        txtDescripcionPaqueteModificar1.setDisabled(true);
        txtUnidadXPaqueteModificar1.setDisabled(true);
        txtCompraModificar1.setDisabled(true);
        txtDescuentoCompraModificar1.setDisabled(true);
        txtCompraRealModificar1.setDisabled(true);
        txtPorcentajeUtilidadModificar1.setDisabled(true);
        txtVentaSugeridaModificar1.setDisabled(true);
        txtVentaRealModificar1.setDisabled(true);
        txtComisionModificar1.setDisabled(true);
        txtPrecioComisionModificar1.setDisabled(true);
        txtStockMinimoModificar1.setDisabled(true);

        productoModificar2 = null;
        txtCodigoBarrasModificar2.setValue(null);
        txtCantidadPaqueteModificar2.setValue(null);
        txtDescripcionPaqueteModificar2.setValue(null);
        txtUnidadXPaqueteModificar2.setValue(null);
        txtCompraModificar2.setValue(null);
        txtDescuentoCompraModificar2.setValue(null);
        txtCompraRealModificar2.setValue(null);
        txtPorcentajeUtilidadModificar2.setValue(null);
        txtVentaSugeridaModificar2.setValue(null);
        txtVentaRealModificar2.setValue(null);
        txtComisionModificar2.setValue(null);
        txtPrecioComisionModificar2.setValue(null);
        txtStockMinimoModificar2.setValue(null);

        txtCodigoBarrasModificar2.setDisabled(true);
        txtCantidadPaqueteModificar2.setDisabled(true);
        txtDescripcionPaqueteModificar2.setDisabled(true);
        txtUnidadXPaqueteModificar2.setDisabled(true);
        txtCompraModificar2.setDisabled(true);
        txtDescuentoCompraModificar2.setDisabled(true);
        txtCompraRealModificar2.setDisabled(true);
        txtPorcentajeUtilidadModificar2.setDisabled(true);
        txtVentaSugeridaModificar2.setDisabled(true);
        txtVentaRealModificar2.setDisabled(true);
        txtComisionModificar2.setDisabled(true);
        txtPrecioComisionModificar2.setDisabled(true);
        txtStockMinimoModificar2.setDisabled(true);

        productoModificar3 = null;
        txtCodigoBarrasModificar3.setValue(null);
        txtCantidadPaqueteModificar3.setValue(null);
        txtDescripcionPaqueteModificar3.setValue(null);
        txtUnidadXPaqueteModificar3.setValue(null);
        txtCompraModificar3.setValue(null);
        txtDescuentoCompraModificar3.setValue(null);
        txtCompraRealModificar3.setValue(null);
        txtPorcentajeUtilidadModificar3.setValue(null);
        txtVentaSugeridaModificar3.setValue(null);
        txtVentaRealModificar3.setValue(null);
        txtComisionModificar3.setValue(null);
        txtPrecioComisionModificar3.setValue(null);
        txtStockMinimoModificar3.setValue(null);

        txtCodigoBarrasModificar3.setDisabled(true);
        txtCantidadPaqueteModificar3.setDisabled(true);
        txtDescripcionPaqueteModificar3.setDisabled(true);
        txtUnidadXPaqueteModificar3.setDisabled(true);
        txtCompraModificar3.setDisabled(true);
        txtDescuentoCompraModificar3.setDisabled(true);
        txtCompraRealModificar3.setDisabled(true);
        txtPorcentajeUtilidadModificar3.setDisabled(true);
        txtVentaSugeridaModificar3.setDisabled(true);
        txtVentaRealModificar3.setDisabled(true);
        txtComisionModificar3.setDisabled(true);
        txtPrecioComisionModificar3.setDisabled(true);
        txtStockMinimoModificar3.setDisabled(true);

    }

    public void inicializar() {
        producto = new Producto();
        productoViejo = null;

        txtCantidadPaquete.setValue(null);
        txtDescripcionPaquete.setValue(null);
        txtUnidadXPaquete.setValue(null);
        txtCompra.setValue(null);
        txtDescuentoCompra.setValue(null);
        txtCompraReal.setValue(null);
        txtPorcentajeUtilidad.setValue(null);
        txtVentaSugerida.setValue(null);
        txtVentaReal.setValue(null);
        txtComision.setValue(null);
        txtPrecioComision.setValue(null);
        txtStockMinimo.setValue(null);

        txtCantidadPaquete1.setValue(null);
        txtDescripcionPaquete1.setValue(null);
        txtUnidadXPaquete1.setValue(null);
        txtCompra1.setValue(null);
        txtDescuentoCompra1.setValue(null);
        txtCompraReal1.setValue(null);
        txtPorcentajeUtilidad1.setValue(null);
        txtVentaSugerida1.setValue(null);
        txtVentaReal1.setValue(null);
        txtComision1.setValue(null);
        txtPrecioComision1.setValue(null);
        txtStockMinimo1.setValue(null);

        txtCantidadPaquete2.setValue(null);
        txtDescripcionPaquete2.setValue(null);
        txtUnidadXPaquete2.setValue(null);
        txtCompra2.setValue(null);
        txtDescuentoCompra2.setValue(null);
        txtCompraReal2.setValue(null);
        txtPorcentajeUtilidad2.setValue(null);
        txtVentaSugerida2.setValue(null);
        txtVentaReal2.setValue(null);
        txtComision2.setValue(null);
        txtPrecioComision2.setValue(null);
        txtStockMinimo2.setValue(null);

        setCheck1(false);
        setCheck2(false);

        selectCheck1();
        selectCheck2();
    }

}
