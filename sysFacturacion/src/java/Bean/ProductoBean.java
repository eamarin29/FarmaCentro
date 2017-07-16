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

    public ProductoBean() {
    }

    @PostConstruct
    public void Init() {
        producto = new Producto();
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

        if (producto.getCodbarras().equals("") || producto.getNombreProducto().equals("") || producto.getPrecioCompra().equals(new BigDecimal(0.0)) || producto.getStockMinimo() == 0 || producto.getStockActual() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios, los campos enteros no pueden ser 0."));
        } else {

            producto.setCodbarras(producto.getCodbarras().toUpperCase());
            producto.setNombreProducto(producto.getNombreProducto().toUpperCase());

            try {
                ProductoController productoController = new ProductoController();
                ParametrosController parametrosController = new ParametrosController();
                productoViejo = productoController.obtenerProductoPorCodigoBarras(producto.getCodbarras());

                if (productoViejo == null) {

                    //calculamos el precio de venta segun el iva
                    Double precioCompra = producto.getPrecioCompra().doubleValue();
                    Double iva = Double.parseDouble(parametrosController.obtenerIVA());
                    Double precioVenta = precioCompra + (precioCompra * iva) / 100;
                    BigDecimal precioVentaFinal = new BigDecimal(precioVenta);
                    producto.setPrecioVenta(precioVentaFinal);

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

        if (producto.getNombreProducto().equals("") || producto.getPrecioCompra().equals(new BigDecimal(0.0)) || producto.getStockMinimo() == 0 || producto.getStockActual() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios, los campos enteros no pueden ser 0."));
        } else {

            producto.setNombreProducto(producto.getNombreProducto().toUpperCase());
            
            try {
                //calculamos el precio de venta segun el iva
                ProductoController pDao = new ProductoController();
                ParametrosController parametrosController = new ParametrosController();
                Double precioCompra = producto.getPrecioCompra().doubleValue();
                Double iva = Double.parseDouble(parametrosController.obtenerIVA());
                Double precioVenta = precioCompra + (precioCompra * iva) / 100;
                BigDecimal precioVentaFinal = new BigDecimal(precioVenta);
                producto.setPrecioVenta(precioVentaFinal);

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

        producto.setStockActual(producto.getStockActual() + this.adicionarProductos);
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
}
