package Bean;

import Controller.ParametrosController;
import Controller.ProductoController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import Model.Producto;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable {

    private Producto productoViejo;

    private List<Producto> listaProductos;
    private Producto producto;

    //lista filtro de productos (buscar productos en factura)
    private List<Producto> filtroProductos;

    private List<Producto> listaProductosStockMayorCero;
    public Long adicionarProductos = 0L;

    private boolean check1;
    private boolean check2;
    private boolean check3;

    private InputText txtCantidadPaquete;
    private InputText txtDescripcionPaquete;
    private InputText txtUnidadXPaquete;
    private InputText txtCompra;
    private InputText txtDescuentoCompra;
    private InputText txtCompraReal;
    private InputText txtPorcentajeUtilidad;
    private InputText txtVentaSugerida;
    private InputText txtVentaReal;

    private InputText txtCantidadPaquete1;
    private InputText txtDescripcionPaquete1;
    private InputText txtUnidadXPaquete1;
    private InputText txtCompra1;
    private InputText txtDescuentoCompra1;
    private InputText txtCompraReal1;
    private InputText txtPorcentajeUtilidad1;
    private InputText txtVentaSugerida1;
    private InputText txtVentaReal1;

    private InputText txtCantidadPaquete2;
    private InputText txtDescripcionPaquete2;
    private InputText txtUnidadXPaquete2;
    private InputText txtCompra2;
    private InputText txtDescuentoCompra2;
    private InputText txtCompraReal2;
    private InputText txtPorcentajeUtilidad2;
    private InputText txtVentaSugerida2;
    private InputText txtVentaReal2;

    private InputText txtCantidadPaquete3;
    private InputText txtDescripcionPaquete3;
    private InputText txtUnidadXPaquete3;
    private InputText txtCompra3;
    private InputText txtDescuentoCompra3;
    private InputText txtCompraReal3;
    private InputText txtPorcentajeUtilidad3;
    private InputText txtVentaSugerida3;
    private InputText txtVentaReal3;

    public ProductoBean() {
    }

    @PostConstruct
    public void Init() {
        producto = new Producto();
        
    }

    public InputText getTxtCantidadPaquete() {
        return txtCantidadPaquete;
    }

    public void setTxtCantidadPaquete(InputText txtCantidadPaquete) {
        this.txtCantidadPaquete = txtCantidadPaquete;
    }

    public InputText getTxtDescripcionPaquete() {
        return txtDescripcionPaquete;
    }

    public void setTxtDescripcionPaquete(InputText txtDescripcionPaquete) {
        this.txtDescripcionPaquete = txtDescripcionPaquete;
    }

    public InputText getTxtUnidadXPaquete() {
        return txtUnidadXPaquete;
    }

    public void setTxtUnidadXPaquete(InputText txtUnidadXPaquete) {
        this.txtUnidadXPaquete = txtUnidadXPaquete;
    }

    public InputText getTxtCompra() {
        return txtCompra;
    }

    public void setTxtCompra(InputText txtCompra) {
        this.txtCompra = txtCompra;
    }

    public InputText getTxtDescuentoCompra() {
        return txtDescuentoCompra;
    }

    public void setTxtDescuentoCompra(InputText txtDescuentoCompra) {
        this.txtDescuentoCompra = txtDescuentoCompra;
    }

    public InputText getTxtCompraReal() {
        return txtCompraReal;
    }

    public void setTxtCompraReal(InputText txtCompraReal) {
        this.txtCompraReal = txtCompraReal;
    }

    public InputText getTxtPorcentajeUtilidad() {
        return txtPorcentajeUtilidad;
    }

    public void setTxtPorcentajeUtilidad(InputText txtPorcentajeUtilidad) {
        this.txtPorcentajeUtilidad = txtPorcentajeUtilidad;
    }

    public InputText getTxtVentaSugerida() {
        return txtVentaSugerida;
    }

    public void setTxtVentaSugerida(InputText txtVentaSugerida) {
        this.txtVentaSugerida = txtVentaSugerida;
    }

    public InputText getTxtVentaReal() {
        return txtVentaReal;
    }

    public void setTxtVentaReal(InputText txtVentaReal) {
        this.txtVentaReal = txtVentaReal;
    }

    public InputText getTxtCantidadPaquete1() {
        return txtCantidadPaquete1;
    }

    public void setTxtCantidadPaquete1(InputText txtCantidadPaquete1) {
        this.txtCantidadPaquete1 = txtCantidadPaquete1;
    }

    public InputText getTxtDescripcionPaquete1() {
        return txtDescripcionPaquete1;
    }

    public void setTxtDescripcionPaquete1(InputText txtDescripcionPaquete1) {
        this.txtDescripcionPaquete1 = txtDescripcionPaquete1;
    }

    public InputText getTxtUnidadXPaquete1() {
        return txtUnidadXPaquete1;
    }

    public void setTxtUnidadXPaquete1(InputText txtUnidadXPaquete1) {
        this.txtUnidadXPaquete1 = txtUnidadXPaquete1;
    }

    public InputText getTxtCompra1() {
        return txtCompra1;
    }

    public void setTxtCompra1(InputText txtCompra1) {
        this.txtCompra1 = txtCompra1;
    }

    public InputText getTxtDescuentoCompra1() {
        return txtDescuentoCompra1;
    }

    public void setTxtDescuentoCompra1(InputText txtDescuentoCompra1) {
        this.txtDescuentoCompra1 = txtDescuentoCompra1;
    }

    public InputText getTxtCompraReal1() {
        return txtCompraReal1;
    }

    public void setTxtCompraReal1(InputText txtCompraReal1) {
        this.txtCompraReal1 = txtCompraReal1;
    }

    public InputText getTxtPorcentajeUtilidad1() {
        return txtPorcentajeUtilidad1;
    }

    public void setTxtPorcentajeUtilidad1(InputText txtPorcentajeUtilidad1) {
        this.txtPorcentajeUtilidad1 = txtPorcentajeUtilidad1;
    }

    public InputText getTxtVentaSugerida1() {
        return txtVentaSugerida1;
    }

    public void setTxtVentaSugerida1(InputText txtVentaSugerida1) {
        this.txtVentaSugerida1 = txtVentaSugerida1;
    }

    public InputText getTxtVentaReal1() {
        return txtVentaReal1;
    }

    public void setTxtVentaReal1(InputText txtVentaReal1) {
        this.txtVentaReal1 = txtVentaReal1;
    }

    public InputText getTxtCantidadPaquete2() {
        return txtCantidadPaquete2;
    }

    public void setTxtCantidadPaquete2(InputText txtCantidadPaquete2) {
        this.txtCantidadPaquete2 = txtCantidadPaquete2;
    }

    public InputText getTxtDescripcionPaquete2() {
        return txtDescripcionPaquete2;
    }

    public void setTxtDescripcionPaquete2(InputText txtDescripcionPaquete2) {
        this.txtDescripcionPaquete2 = txtDescripcionPaquete2;
    }

    public InputText getTxtUnidadXPaquete2() {
        return txtUnidadXPaquete2;
    }

    public void setTxtUnidadXPaquete2(InputText txtUnidadXPaquete2) {
        this.txtUnidadXPaquete2 = txtUnidadXPaquete2;
    }

    public InputText getTxtCompra2() {
        return txtCompra2;
    }

    public void setTxtCompra2(InputText txtCompra2) {
        this.txtCompra2 = txtCompra2;
    }

    public InputText getTxtDescuentoCompra2() {
        return txtDescuentoCompra2;
    }

    public void setTxtDescuentoCompra2(InputText txtDescuentoCompra2) {
        this.txtDescuentoCompra2 = txtDescuentoCompra2;
    }

    public InputText getTxtCompraReal2() {
        return txtCompraReal2;
    }

    public void setTxtCompraReal2(InputText txtCompraReal2) {
        this.txtCompraReal2 = txtCompraReal2;
    }

    public InputText getTxtPorcentajeUtilidad2() {
        return txtPorcentajeUtilidad2;
    }

    public void setTxtPorcentajeUtilidad2(InputText txtPorcentajeUtilidad2) {
        this.txtPorcentajeUtilidad2 = txtPorcentajeUtilidad2;
    }

    public InputText getTxtVentaSugerida2() {
        return txtVentaSugerida2;
    }

    public void setTxtVentaSugerida2(InputText txtVentaSugerida2) {
        this.txtVentaSugerida2 = txtVentaSugerida2;
    }

    public InputText getTxtVentaReal2() {
        return txtVentaReal2;
    }

    public void setTxtVentaReal2(InputText txtVentaReal2) {
        this.txtVentaReal2 = txtVentaReal2;
    }

    public InputText getTxtCantidadPaquete3() {
        return txtCantidadPaquete3;
    }

    public void setTxtCantidadPaquete3(InputText txtCantidadPaquete3) {
        this.txtCantidadPaquete3 = txtCantidadPaquete3;
    }

    public InputText getTxtDescripcionPaquete3() {
        return txtDescripcionPaquete3;
    }

    public void setTxtDescripcionPaquete3(InputText txtDescripcionPaquete3) {
        this.txtDescripcionPaquete3 = txtDescripcionPaquete3;
    }

    public InputText getTxtUnidadXPaquete3() {
        return txtUnidadXPaquete3;
    }

    public void setTxtUnidadXPaquete3(InputText txtUnidadXPaquete3) {
        this.txtUnidadXPaquete3 = txtUnidadXPaquete3;
    }

    public InputText getTxtCompra3() {
        return txtCompra3;
    }

    public void setTxtCompra3(InputText txtCompra3) {
        this.txtCompra3 = txtCompra3;
    }

    public InputText getTxtDescuentoCompra3() {
        return txtDescuentoCompra3;
    }

    public void setTxtDescuentoCompra3(InputText txtDescuentoCompra3) {
        this.txtDescuentoCompra3 = txtDescuentoCompra3;
    }

    public InputText getTxtCompraReal3() {
        return txtCompraReal3;
    }

    public void setTxtCompraReal3(InputText txtCompraReal3) {
        this.txtCompraReal3 = txtCompraReal3;
    }

    public InputText getTxtPorcentajeUtilidad3() {
        return txtPorcentajeUtilidad3;
    }

    public void setTxtPorcentajeUtilidad3(InputText txtPorcentajeUtilidad3) {
        this.txtPorcentajeUtilidad3 = txtPorcentajeUtilidad3;
    }

    public InputText getTxtVentaSugerida3() {
        return txtVentaSugerida3;
    }

    public void setTxtVentaSugerida3(InputText txtVentaSugerida3) {
        this.txtVentaSugerida3 = txtVentaSugerida3;
    }

    public InputText getTxtVentaReal3() {
        return txtVentaReal3;
    }

    public void setTxtVentaReal3(InputText txtVentaReal3) {
        this.txtVentaReal3 = txtVentaReal3;
    }

    
    
    public boolean isCheck2() {
        return check2;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }

    public boolean isCheck3() {
        return check3;
    }

    public void setCheck3(boolean check3) {
        this.check3 = check3;
    }

    public boolean isCheck1() {
        return check1;
    }

    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }

    public Long getAdicionarProductos() {
        return adicionarProductos;
    }

    public void setAdicionarProductos(Long adicionarProductos) {
        this.adicionarProductos = adicionarProductos;
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

    public void prepararNuevoProdcuto() {
        producto = new Producto();
    }

    public List<Producto> getFiltroProductos() {
        return filtroProductos;
    }

    public void setFiltroProductos(List<Producto> filtroProductos) {
        this.filtroProductos = filtroProductos;
    }

    public void nuevoProducto() {

        if (producto.getCodBarras().equals("") || producto.getNombre().equals("") || producto.getPrecioCompra().equals(new BigDecimal(0.0)) || producto.getStockMinUni() == 0 || producto.getStockActUni() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios, los campos enteros no pueden ser 0."));
        } else {

            producto.setCodBarras(producto.getCodBarras().toUpperCase());
            producto.setNombre(producto.getNombre().toUpperCase());

            try {
                ProductoController productoController = new ProductoController();
                ParametrosController parametrosController = new ParametrosController();
                productoViejo = productoController.obtenerProductoPorCodigoBarras(producto.getCodBarras());

                if (productoViejo == null) {

                    //calculamos el precio de venta segun el iva
                    Double precioCompra = producto.getPrecioCompra().doubleValue();
                    Double iva = Double.parseDouble(parametrosController.obtenerIVA());
                    Double precioVenta = precioCompra + (precioCompra * iva) / 100;
                    BigDecimal precioVentaFinal = new BigDecimal(precioVenta);
                    producto.setPrecioVentaReal(precioVentaFinal);

                    productoController.newProducto(producto);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogNuevoProducto').hide();");

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Producto se ha registrado correctamente."));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ya existe un Producto con el código de barras ingresado."));
                }
                producto = new Producto();
            } catch (Exception ex) {
                producto = new Producto();
                Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void modificarProducto() {

        if (producto.getNombre().equals("") || producto.getPrecioCompra().equals(new BigDecimal(0.0)) || producto.getStockMinUni() == 0 || producto.getStockActUni() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios, los campos enteros no pueden ser 0."));
        } else {

            producto.setNombre(producto.getNombre().toUpperCase());

            try {
                //calculamos el precio de venta segun el iva
                ProductoController pDao = new ProductoController();
                ParametrosController parametrosController = new ParametrosController();
                Double precioCompra = producto.getPrecioCompra().doubleValue();
                Double iva = Double.parseDouble(parametrosController.obtenerIVA());
                Double precioVenta = precioCompra + (precioCompra * iva) / 100;
                BigDecimal precioVentaFinal = new BigDecimal(precioVenta);
                producto.setPrecioVentaReal(precioVentaFinal);

                pDao.updateProducto(producto);
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogModificarProducto').hide();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Producto se ha modificado correctamente."));
                producto = new Producto();
            } catch (Exception ex) {
                Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void eliminarProducto() {

        ProductoController pDao = new ProductoController();
        int eliminarProducto = pDao.deleteProducto(producto);
        if (eliminarProducto == 0) {
            //se elimina
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarProducto').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Producto se ha eliminado correctamente."));
            producto = new Producto();
        } else {
            //no se elimina
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarProducto').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Producto no puede eliminarse, puede que esté asociado a una factura."));
            producto = new Producto();
        }
    }

    public void adicionarProductosStock() {

        producto.setStockActUni(producto.getStockActUni() + this.adicionarProductos);
        ProductoController pDao = new ProductoController();

        pDao.updateProducto(producto);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAgregarProducto').hide();");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Stock Actual se ha modificado correctamente."));
        producto = new Producto();
        this.adicionarProductos = 0L;

    }

    public void cancelarAdicionarProductosStock() {

        this.adicionarProductos = 0L;
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAgregarProducto').hide();");
    }

    public void selectCheck1() {
        System.out.println("--cambio a " + check1);
    }

    public void selectCheck2() {
        System.out.println("--cambio a " + check2);
    }

    public void selectCheck3() {
        System.out.println("--cambio a " + check3);
    }

}
