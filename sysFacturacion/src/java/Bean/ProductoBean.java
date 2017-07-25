package Bean;

import Controller.ParametrosController;
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
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable {

    private List<Producto> productoViejo;
    private List<Producto> listaProductos;
    private Producto producto;
    private List<Producto> filtroProductos;

    private List<Producto> listaProductosStockMayorCero;
    public Long adicionarProductos = 0L;

    private boolean check1;
    private boolean check2;
    private boolean check3;

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

    private InputNumber txtCantidadPaquete3;
    private InputText txtDescripcionPaquete3;
    private InputNumber txtUnidadXPaquete3;
    private InputNumber txtCompra3;
    private InputNumber txtDescuentoCompra3;
    private InputNumber txtCompraReal3;
    private InputNumber txtPorcentajeUtilidad3;
    private InputNumber txtVentaSugerida3;
    private InputNumber txtComision3;
    private InputNumber txtVentaReal3;
    private InputNumber txtPrecioComision3;

    private OutputLabel x1;
    private OutputLabel x2;
    private OutputLabel x3;

    public ProductoBean() {
    }

    @PostConstruct
    public void Init() {
        producto = null;
        productoViejo = null;

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

    public InputNumber getTxtPrecioComision3() {
        return txtPrecioComision3;
    }

    public void setTxtPrecioComision3(InputNumber txtPrecioComision3) {
        this.txtPrecioComision3 = txtPrecioComision3;
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

    public InputNumber getTxtUnidadXPaquete3() {
        return txtUnidadXPaquete3;
    }

    public void setTxtUnidadXPaquete3(InputNumber txtUnidadXPaquete3) {
        this.txtUnidadXPaquete3 = txtUnidadXPaquete3;
    }

    public InputNumber getTxtCompra3() {
        return txtCompra3;
    }

    public void setTxtCompra3(InputNumber txtCompra3) {
        this.txtCompra3 = txtCompra3;
    }

    public InputNumber getTxtDescuentoCompra3() {
        return txtDescuentoCompra3;
    }

    public void setTxtDescuentoCompra3(InputNumber txtDescuentoCompra3) {
        this.txtDescuentoCompra3 = txtDescuentoCompra3;
    }

    public InputNumber getTxtCompraReal3() {
        return txtCompraReal3;
    }

    public void setTxtCompraReal3(InputNumber txtCompraReal3) {
        this.txtCompraReal3 = txtCompraReal3;
    }

    public InputNumber getTxtPorcentajeUtilidad3() {
        return txtPorcentajeUtilidad3;
    }

    public void setTxtPorcentajeUtilidad3(InputNumber txtPorcentajeUtilidad3) {
        this.txtPorcentajeUtilidad3 = txtPorcentajeUtilidad3;
    }

    public InputNumber getTxtVentaSugerida3() {
        return txtVentaSugerida3;
    }

    public void setTxtVentaSugerida3(InputNumber txtVentaSugerida3) {
        this.txtVentaSugerida3 = txtVentaSugerida3;
    }

    public InputNumber getTxtComision3() {
        return txtComision3;
    }

    public void setTxtComision3(InputNumber txtComision3) {
        this.txtComision3 = txtComision3;
    }

    public InputNumber getTxtVentaReal3() {
        return txtVentaReal3;
    }

    public void setTxtVentaReal3(InputNumber txtVentaReal3) {
        this.txtVentaReal3 = txtVentaReal3;
    }

    public OutputLabel getX1() {
        return x1;
    }

    public void setX1(OutputLabel x1) {
        this.x1 = x1;
    }

    public OutputLabel getX2() {
        return x2;
    }

    public void setX2(OutputLabel x2) {
        this.x2 = x2;
    }

    public OutputLabel getX3() {
        return x3;
    }

    public void setX3(OutputLabel x3) {
        this.x3 = x3;
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

    public InputText getTxtDescripcionPaquete3() {
        return txtDescripcionPaquete3;
    }

    public void setTxtDescripcionPaquete3(InputText txtDescripcionPaquete3) {
        this.txtDescripcionPaquete3 = txtDescripcionPaquete3;
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

    public InputNumber getTxtCantidadPaquete3() {
        return txtCantidadPaquete3;
    }

    public void setTxtCantidadPaquete3(InputNumber txtCantidadPaquete3) {
        this.txtCantidadPaquete3 = txtCantidadPaquete3;
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

    public List<Producto> getProductoViejo() {
        return productoViejo;
    }

    public void setProductoViejo(List<Producto> productoViejo) {
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

        RequestContext context = RequestContext.getCurrentInstance();

        if (producto.getCodBarras().equals("") || producto.getNombre().equals("") || producto.getStockMinUni() == null || txtCantidadPaquete.getValue() == null || txtDescripcionPaquete.getValue().toString().equals("") || txtUnidadXPaquete.getValue() == null || txtCompra.getValue() == null || txtDescuentoCompra.getValue() == null || txtPorcentajeUtilidad.getValue() == null || txtComision.getValue() == null || txtVentaReal.getValue() == null || producto.getStockMinUni() == 0) {

            context.execute("PF('dialogNuevoProducto').show();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

        } else {

            if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCompra.getValue().equals("0") || txtPorcentajeUtilidad.getValue().equals("0") || txtVentaReal.getValue().equals("0")) {

                context.execute("PF('dialogNuevoProducto').show();");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0."));

            } else {
                if (check1 == false && check2 == false && check3 == false) {
                    //agregar normal

                    double precio_sugerido = Double.parseDouble(txtVentaSugerida.getValue().toString());
                    double precio_venta_real = Double.parseDouble(txtVentaReal.getValue().toString());

                    if (precio_venta_real < precio_sugerido) {
                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real no puede ser menor al precio de venta sugerido"));
                    } else {

                        try {

                            ProductoController ProductoController = new ProductoController();
                            productoViejo = ProductoController.obtenerListaProductosPorCodigoBarras(producto.getCodBarras());
                            
                            if (productoViejo == null) {
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

                                String nombre_producto = producto.getNombre().toUpperCase();
                                producto.setNombre(nombre_producto);

                                producto.setPaquete(txtDescripcionPaquete.getValue().toString().toUpperCase());
                                BigDecimal precio_compra = new BigDecimal(txtCompra.getValue().toString());
                                producto.setPrecioCompra(precio_compra);

                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompra.getValue().toString());
                                producto.setPorcentajeDescuento(prcentaje_descuento);

                                BigDecimal precio_compra_real = new BigDecimal(txtCompraReal.getValue().toString());
                                producto.setPrecioCompraReal(precio_compra_real);

                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidad.getValue().toString());
                                producto.setPorcentajeUtilidad(porcentaje_utilidad);

                                BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                producto.setPrecioVentaReal(venta_real);

                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaquete.getValue().toString()) * Integer.parseInt(txtUnidadXPaquete.getValue().toString()));
                                producto.setStockActUni(stock_actual);

                                BigDecimal comision = new BigDecimal(txtPrecioComision.getValue().toString());
                                producto.setComision(comision);

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
                    //agrego normal + check 1    
                } else if (check1 == true && check2 == false && check3 == false) {
                    if (txtCantidadPaquete1.getValue() == null || txtDescripcionPaquete1.getValue().toString().equals("") || txtUnidadXPaquete1.getValue() == null || txtCompra1.getValue() == null || txtDescuentoCompra1.getValue() == null || txtPorcentajeUtilidad1.getValue() == null || txtComision1.getValue() == null || txtVentaReal1.getValue() == null || producto.getStockMinUni() == 0) {

                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                    } else {

                        if (txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCompra1.getValue().equals("0") || txtPorcentajeUtilidad1.getValue().equals("0") || txtVentaReal1.getValue().equals("0")) {

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
                                        productoViejo = ProductoController.obtenerListaProductosPorCodigoBarras(producto.getCodBarras());

                                        if (productoViejo == null) {
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

                                            String nombre_producto = producto.getNombre().toUpperCase();
                                            producto.setNombre(nombre_producto);

                                            producto.setPaquete(txtDescripcionPaquete.getValue().toString().toUpperCase());
                                            BigDecimal precio_compra = new BigDecimal(txtCompra.getValue().toString());
                                            producto.setPrecioCompra(precio_compra);

                                            BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompra.getValue().toString());
                                            producto.setPorcentajeDescuento(prcentaje_descuento);

                                            BigDecimal precio_compra_real = new BigDecimal(txtCompraReal.getValue().toString());
                                            producto.setPrecioCompraReal(precio_compra_real);

                                            BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidad.getValue().toString());
                                            producto.setPorcentajeUtilidad(porcentaje_utilidad);

                                            BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                            producto.setPrecioVentaReal(venta_real);

                                            Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaquete.getValue().toString()) * Integer.parseInt(txtUnidadXPaquete.getValue().toString()));
                                            producto.setStockActUni(stock_actual);

                                            BigDecimal comision = new BigDecimal(txtPrecioComision.getValue().toString());
                                            producto.setComision(comision);

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

                                                p1.setNombre(nombre_producto);

                                                p1.setPaquete(txtDescripcionPaquete1.getValue().toString().toUpperCase());
                                                BigDecimal precio_compra1 = new BigDecimal(txtCompra1.getValue().toString());
                                                p1.setPrecioCompra(precio_compra1);

                                                BigDecimal porcentaje_descuento1 = new BigDecimal(txtDescuentoCompra1.getValue().toString());
                                                p1.setPorcentajeDescuento(porcentaje_descuento1);

                                                BigDecimal precio_compra_real1 = new BigDecimal(txtCompraReal1.getValue().toString());
                                                p1.setPrecioCompraReal(precio_compra_real1);

                                                BigDecimal porcentaje_utilidad1 = new BigDecimal(txtPorcentajeUtilidad1.getValue().toString());
                                                p1.setPorcentajeUtilidad(porcentaje_utilidad1);

                                                BigDecimal venta_real1 = new BigDecimal(precio_venta_real1);
                                                p1.setPrecioVentaReal(venta_real1);

                                                p1.setStockActUni(producto.getStockActUni() + Long.valueOf(Integer.parseInt(txtCantidadPaquete1.getValue().toString()) * Integer.parseInt(txtUnidadXPaquete1.getValue().toString())));
                                                producto.setStockActUni(p1.getStockActUni());
                                                ProductoController.updateProducto(producto);

                                                p1.setStockMinUni(producto.getStockMinUni());

                                                BigDecimal comision1 = new BigDecimal(txtPrecioComision1.getValue().toString());
                                                p1.setComision(comision1);

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

                } else if (check1 == false && check2 == true && check3 == false) {
                    if (txtCantidadPaquete2.getValue() == null || txtDescripcionPaquete2.getValue().toString().equals("") || txtUnidadXPaquete2.getValue() == null || txtCompra2.getValue() == null || txtDescuentoCompra2.getValue() == null || txtPorcentajeUtilidad2.getValue() == null || txtComision2.getValue() == null || txtVentaReal2.getValue() == null || producto.getStockMinUni() == 0) {
                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 2 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                    } else {

                        if (txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0") || txtCompra2.getValue().equals("0") || txtPorcentajeUtilidad2.getValue().equals("0") || txtVentaReal2.getValue().equals("0")) {

                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 2 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                        } else {
                            //agrego normal + check 2

                            //aqui va el codigo
                        }

                    }
                } else if (check1 == false && check2 == false && check3 == true) {
                    if (txtCantidadPaquete3.getValue() == null || txtDescripcionPaquete3.getValue().toString().equals("") || txtUnidadXPaquete3.getValue() == null || txtCompra3.getValue() == null || txtDescuentoCompra3.getValue() == null || txtPorcentajeUtilidad3.getValue() == null || txtComision3.getValue() == null || txtVentaReal3.getValue() == null || producto.getStockMinUni() == 0) {
                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 3 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                    } else {

                        if (txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0") || txtCompra3.getValue().equals("0") || txtPorcentajeUtilidad3.getValue().equals("0") || txtVentaReal3.getValue().equals("0")) {

                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 3 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                        } else {
                            //agrego normal + check 3

                            //aqui va el codigo
                        }

                    }
                    //agrego normal + check 1 y 2                
                } else if (check1 == true && check2 == true && check3 == false) {
                    if (txtCantidadPaquete1.getValue() == null || txtDescripcionPaquete1.getValue().toString().equals("") || txtUnidadXPaquete1.getValue() == null || txtCompra1.getValue() == null || txtDescuentoCompra1.getValue() == null || txtPorcentajeUtilidad1.getValue() == null || txtComision1.getValue() == null || txtVentaReal1.getValue() == null || producto.getStockMinUni() == 0 || txtCantidadPaquete2.getValue() == null || txtDescripcionPaquete2.getValue().toString().equals("") || txtUnidadXPaquete2.getValue() == null || txtCompra2.getValue() == null || txtDescuentoCompra2.getValue() == null || txtPorcentajeUtilidad2.getValue() == null || txtComision2.getValue() == null || txtVentaReal2.getValue() == null || producto.getStockMinUni() == 0) {
                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                    } else {

                        if (txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCompra1.getValue().equals("0") || txtPorcentajeUtilidad1.getValue().equals("0") || txtVentaReal1.getValue().equals("0") || txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0") || txtCompra2.getValue().equals("0") || txtPorcentajeUtilidad2.getValue().equals("0") || txtVentaReal2.getValue().equals("0")) {
                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 2 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));
                        } else {
                            //agrego normal + check 1 y 2  

                            //aqui va el codigo
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

                                    double precio_sugerido2 = Double.parseDouble(txtVentaSugerida2.getValue().toString());
                                    double precio_venta_real2 = Double.parseDouble(txtVentaReal2.getValue().toString());

                                    if (precio_venta_real2 < precio_sugerido2) {
                                        context.execute("PF('dialogNuevoProducto').show();");
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El precio de venta real 2 no puede ser menor al precio de venta sugerido 2."));
                                    } else {
                                        try {

                                            ProductoController ProductoController = new ProductoController();
                                            productoViejo = ProductoController.obtenerListaProductosPorCodigoBarras(producto.getCodBarras());

                                            if (productoViejo == null) {
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

                                                String nombre_producto = producto.getNombre().toUpperCase();
                                                producto.setNombre(nombre_producto);

                                                producto.setPaquete(txtDescripcionPaquete.getValue().toString().toUpperCase());
                                                BigDecimal precio_compra = new BigDecimal(txtCompra.getValue().toString());
                                                producto.setPrecioCompra(precio_compra);

                                                BigDecimal prcentaje_descuento = new BigDecimal(txtDescuentoCompra.getValue().toString());
                                                producto.setPorcentajeDescuento(prcentaje_descuento);

                                                BigDecimal precio_compra_real = new BigDecimal(txtCompraReal.getValue().toString());
                                                producto.setPrecioCompraReal(precio_compra_real);

                                                BigDecimal porcentaje_utilidad = new BigDecimal(txtPorcentajeUtilidad.getValue().toString());
                                                producto.setPorcentajeUtilidad(porcentaje_utilidad);

                                                BigDecimal venta_real = new BigDecimal(precio_venta_real);
                                                producto.setPrecioVentaReal(venta_real);

                                                Long stock_actual = Long.valueOf(Integer.parseInt(txtCantidadPaquete.getValue().toString()) * Integer.parseInt(txtUnidadXPaquete.getValue().toString()));
                                                producto.setStockActUni(stock_actual);

                                                BigDecimal comision = new BigDecimal(txtPrecioComision.getValue().toString());
                                                producto.setComision(comision);

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

                                                    p1.setNombre(nombre_producto);

                                                    p1.setPaquete(txtDescripcionPaquete1.getValue().toString().toUpperCase());
                                                    BigDecimal precio_compra1 = new BigDecimal(txtCompra1.getValue().toString());
                                                    p1.setPrecioCompra(precio_compra1);

                                                    BigDecimal porcentaje_descuento1 = new BigDecimal(txtDescuentoCompra1.getValue().toString());
                                                    p1.setPorcentajeDescuento(porcentaje_descuento1);

                                                    BigDecimal precio_compra_real1 = new BigDecimal(txtCompraReal1.getValue().toString());
                                                    p1.setPrecioCompraReal(precio_compra_real1);

                                                    BigDecimal porcentaje_utilidad1 = new BigDecimal(txtPorcentajeUtilidad1.getValue().toString());
                                                    p1.setPorcentajeUtilidad(porcentaje_utilidad1);

                                                    BigDecimal venta_real1 = new BigDecimal(precio_venta_real1);
                                                    p1.setPrecioVentaReal(venta_real1);

                                                    p1.setStockActUni(producto.getStockActUni() + Long.valueOf(Integer.parseInt(txtCantidadPaquete1.getValue().toString()) * Integer.parseInt(txtUnidadXPaquete1.getValue().toString())));
                                                    producto.setStockActUni(p1.getStockActUni());
                                                    ProductoController.updateProducto(producto);

                                                    p1.setStockMinUni(producto.getStockMinUni());

                                                    BigDecimal comision1 = new BigDecimal(txtPrecioComision1.getValue().toString());
                                                    p1.setComision(comision1);

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

                                                    p2.setNombre(nombre_producto);

                                                    p2.setPaquete(txtDescripcionPaquete2.getValue().toString().toUpperCase());
                                                    BigDecimal precio_compra2 = new BigDecimal(txtCompra2.getValue().toString());
                                                    p2.setPrecioCompra(precio_compra2);

                                                    BigDecimal porcentaje_descuento2 = new BigDecimal(txtDescuentoCompra2.getValue().toString());
                                                    p2.setPorcentajeDescuento(porcentaje_descuento2);

                                                    BigDecimal precio_compra_real2 = new BigDecimal(txtCompraReal2.getValue().toString());
                                                    p2.setPrecioCompraReal(precio_compra_real2);

                                                    BigDecimal porcentaje_utilidad2 = new BigDecimal(txtPorcentajeUtilidad2.getValue().toString());
                                                    p2.setPorcentajeUtilidad(porcentaje_utilidad2);

                                                    BigDecimal venta_real2 = new BigDecimal(precio_venta_real2);
                                                    p2.setPrecioVentaReal(venta_real2);

                                                    p1.setStockActUni((producto.getStockActUni() + (Long.valueOf(Integer.parseInt(txtCantidadPaquete1.getValue().toString())) * Integer.parseInt(txtUnidadXPaquete1.getValue().toString())) +  (Long.valueOf(Integer.parseInt(txtCantidadPaquete2.getValue().toString())) * Integer.parseInt(txtUnidadXPaquete2.getValue().toString())) ));
                                                    producto.setStockActUni(p2.getStockActUni());
                                                    ProductoController.updateProducto(producto);

                                                    p2.setStockMinUni(producto.getStockMinUni());

                                                    BigDecimal comision2 = new BigDecimal(txtPrecioComision2.getValue().toString());
                                                    p2.setComision(comision2);

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
                    //agrego normal + check 1, 2 y 3
                } else if (check1 == true && check2 == true && check3 == true) {
                    if (txtCantidadPaquete1.getValue() == null || txtDescripcionPaquete1.getValue().toString().equals("") || txtUnidadXPaquete1.getValue() == null || txtCompra1.getValue() == null || txtDescuentoCompra1.getValue() == null || txtPorcentajeUtilidad1.getValue() == null || txtComision1.getValue() == null || txtVentaReal1.getValue() == null || producto.getStockMinUni() == 0 || txtCantidadPaquete2.getValue() == null || txtDescripcionPaquete2.getValue().toString().equals("") || txtUnidadXPaquete2.getValue() == null || txtCompra2.getValue() == null || txtDescuentoCompra2.getValue() == null || txtPorcentajeUtilidad2.getValue() == null || txtComision2.getValue() == null || txtVentaReal2.getValue() == null || producto.getStockMinUni() == 0 || txtCantidadPaquete3.getValue() == null || txtDescripcionPaquete3.getValue().toString().equals("") || txtUnidadXPaquete3.getValue() == null || txtCompra3.getValue() == null || txtDescuentoCompra3.getValue() == null || txtPorcentajeUtilidad3.getValue() == null || txtComision3.getValue() == null || txtVentaReal3.getValue() == null || producto.getStockMinUni() == 0) {

                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1, 2 y 3 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                    } else {

                        if (txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCompra1.getValue().equals("0") || txtPorcentajeUtilidad1.getValue().equals("0") || txtVentaReal1.getValue().equals("0") || txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0") || txtCompra2.getValue().equals("0") || txtPorcentajeUtilidad2.getValue().equals("0") || txtVentaReal2.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0") || txtCompra3.getValue().equals("0") || txtPorcentajeUtilidad3.getValue().equals("0") || txtVentaReal3.getValue().equals("0")) {

                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1, 2 y 3 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                        } else {
                            //agrego normal + check 1 + check 2 + check 3

                            //aqui va el codigo
                        }

                    }
//agrego normal + check 1 y 3
                } else if (check1 == true && check2 == false && check3 == true) {
                    if (txtCantidadPaquete1.getValue() == null || txtDescripcionPaquete1.getValue().toString().equals("") || txtUnidadXPaquete1.getValue() == null || txtCompra1.getValue() == null || txtDescuentoCompra1.getValue() == null || txtPorcentajeUtilidad1.getValue() == null || txtComision1.getValue() == null || txtVentaReal1.getValue() == null || producto.getStockMinUni() == 0 || txtCantidadPaquete3.getValue() == null || txtDescripcionPaquete3.getValue().toString().equals("") || txtUnidadXPaquete3.getValue() == null || txtCompra3.getValue() == null || txtDescuentoCompra3.getValue() == null || txtPorcentajeUtilidad3.getValue() == null || txtComision3.getValue() == null || txtVentaReal3.getValue() == null || producto.getStockMinUni() == 0) {

                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 3 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                    } else {

                        if (txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCompra1.getValue().equals("0") || txtPorcentajeUtilidad1.getValue().equals("0") || txtVentaReal1.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0") || txtCompra3.getValue().equals("0") || txtPorcentajeUtilidad3.getValue().equals("0") || txtVentaReal3.getValue().equals("0")) {

                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 1 y 3 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                        } else {
                            //agrego normal + check 1 + check 3

                            //aqui va el codigo
                        }
                    }
//agrego normal + check 2 + check 3
                } else if (check1 == false && check2 == true && check3 == true) {
                    if (txtCantidadPaquete2.getValue() == null || txtDescripcionPaquete2.getValue().toString().equals("") || txtUnidadXPaquete2.getValue() == null || txtCompra2.getValue() == null || txtDescuentoCompra2.getValue() == null || txtPorcentajeUtilidad2.getValue() == null || txtComision2.getValue() == null || txtVentaReal2.getValue() == null || producto.getStockMinUni() == 0 || txtCantidadPaquete3.getValue() == null || txtDescripcionPaquete3.getValue().toString().equals("") || txtUnidadXPaquete3.getValue() == null || txtCompra3.getValue() == null || txtDescuentoCompra3.getValue() == null || txtPorcentajeUtilidad3.getValue() == null || txtComision3.getValue() == null || txtVentaReal3.getValue() == null || producto.getStockMinUni() == 0) {

                        context.execute("PF('dialogNuevoProducto').show();");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 2 y 3 son obligatorios."));
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                    } else {

                        if (txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0") || txtCompra2.getValue().equals("0") || txtPorcentajeUtilidad2.getValue().equals("0") || txtVentaReal2.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0") || txtCompra3.getValue().equals("0") || txtPorcentajeUtilidad3.getValue().equals("0") || txtVentaReal3.getValue().equals("0")) {

                            context.execute("PF('dialogNuevoProducto').show();");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos del check 2 y 3 son obligatorios."));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Los campos marcados con * no pueden ser 0"));

                        } else {
                            //agrego normal + check 2 + check 3

                            //aqui va el codigo
                        }

                    }
                }
            }

        }

    }

    public void selectCheck1() {

        if (check1 == true) {
            txtCantidadPaquete1.setDisabled(false);
            txtDescripcionPaquete1.setDisabled(false);
            txtUnidadXPaquete1.setDisabled(false);
            txtCompra1.setDisabled(false);
            txtDescuentoCompra1.setDisabled(false);
            txtPorcentajeUtilidad1.setDisabled(false);
            txtComision1.setDisabled(false);
            txtVentaReal1.setDisabled(false);

        } else {

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

            cambioTxtCantidadPaquete();

            txtCantidadPaquete1.setDisabled(true);
            txtDescripcionPaquete1.setDisabled(true);
            txtUnidadXPaquete1.setDisabled(true);
            txtCompra1.setDisabled(true);
            txtDescuentoCompra1.setDisabled(true);
            txtPorcentajeUtilidad1.setDisabled(true);
            txtComision1.setDisabled(true);
            txtVentaReal1.setDisabled(true);

        }

    }

    public void selectCheck2() {
        if (check2 == true) {
            txtCantidadPaquete2.setDisabled(false);
            txtDescripcionPaquete2.setDisabled(false);
            txtUnidadXPaquete2.setDisabled(false);
            txtCompra2.setDisabled(false);
            txtDescuentoCompra2.setDisabled(false);
            txtPorcentajeUtilidad2.setDisabled(false);
            txtComision2.setDisabled(false);
            txtVentaReal2.setDisabled(false);

        } else {

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

            cambioTxtCantidadPaquete();

            txtCantidadPaquete2.setDisabled(true);
            txtDescripcionPaquete2.setDisabled(true);
            txtUnidadXPaquete2.setDisabled(true);
            txtCompra2.setDisabled(true);
            txtDescuentoCompra2.setDisabled(true);
            txtPorcentajeUtilidad2.setDisabled(true);
            txtComision2.setDisabled(true);
            txtVentaReal2.setDisabled(true);

        }
    }

    public void selectCheck3() {
        if (check3 == true) {
            txtCantidadPaquete3.setDisabled(false);
            txtDescripcionPaquete3.setDisabled(false);
            txtUnidadXPaquete3.setDisabled(false);
            txtCompra3.setDisabled(false);
            txtDescuentoCompra3.setDisabled(false);
            txtPorcentajeUtilidad3.setDisabled(false);
            txtComision3.setDisabled(false);
            txtVentaReal3.setDisabled(false);

        } else {

            txtCantidadPaquete3.setValue(null);
            txtDescripcionPaquete3.setValue(null);
            txtUnidadXPaquete3.setValue(null);
            txtCompra3.setValue(null);
            txtDescuentoCompra3.setValue(null);
            txtCompraReal3.setValue(null);
            txtPorcentajeUtilidad3.setValue(null);
            txtVentaSugerida3.setValue(null);
            txtVentaReal3.setValue(null);
            txtComision3.setValue(null);
            txtPrecioComision3.setValue(null);

            cambioTxtCantidadPaquete();

            txtCantidadPaquete3.setDisabled(true);
            txtDescripcionPaquete3.setDisabled(true);
            txtUnidadXPaquete3.setDisabled(true);
            txtCompra3.setDisabled(true);
            txtDescuentoCompra3.setDisabled(true);
            txtPorcentajeUtilidad3.setDisabled(true);
            txtComision3.setDisabled(true);
            txtVentaReal3.setDisabled(true);

        }
    }

    public void cambioTxtCantidadPaquete() {

        if (check1 == false && check2 == false && check3 == false) {
            //nromal

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    producto.setStockActUni(Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete));
                }
            }

        } else if (check1 == true && check2 == false && check3 == false) {
            //normal + 1

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete1.getValue() == null || txtUnidadXPaquete1.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0")) {
                } else {

                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Integer stock_normal_integer = txt_cantidad_paquete * txt_unidad_paquete;
                    Long stock_normal = stock_normal_integer.longValue();

                    int txt_cantidad_paquete1 = Integer.parseInt(txtCantidadPaquete1.getValue().toString());
                    int txt_unidad_paquete1 = Integer.parseInt(txtUnidadXPaquete1.getValue().toString());

                    Integer stock_normal_integer1 = txt_cantidad_paquete1 * txt_unidad_paquete1;
                    Long stock_1 = stock_normal_integer1.longValue();

                    producto.setStockActUni(stock_normal + stock_1);
                }
            }

        } else if (check1 == false && check2 == true && check3 == false) {
            //normal + 2

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete2.getValue() == null || txtUnidadXPaquete2.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Long stock_normal = Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete);

                    int txt_cantidad_paquete2 = Integer.parseInt(txtCantidadPaquete2.getValue().toString());
                    int txt_unidad_paquete2 = Integer.parseInt(txtUnidadXPaquete2.getValue().toString());
                    Long stock_2 = Long.valueOf(txt_cantidad_paquete2 * txt_unidad_paquete2);

                    producto.setStockActUni(stock_normal + stock_2);
                }
            }

        } else if (check1 == false && check2 == false && check3 == true) {
            //normal + 3

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete3.getValue() == null || txtUnidadXPaquete3.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Long stock_normal = Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete);

                    int txt_cantidad_paquete3 = Integer.parseInt(txtCantidadPaquete3.getValue().toString());
                    int txt_unidad_paquete3 = Integer.parseInt(txtUnidadXPaquete3.getValue().toString());
                    Long stock_3 = Long.valueOf(txt_cantidad_paquete3 * txt_unidad_paquete3);

                    producto.setStockActUni(stock_normal + stock_3);
                }
            }

        } else if (check1 == true && check2 == true && check3 == false) {
            //normal + 1 y 2

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete1.getValue() == null || txtUnidadXPaquete1.getValue() == null || txtCantidadPaquete2.getValue() == null || txtUnidadXPaquete2.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Long stock_normal = Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete);

                    int txt_cantidad_paquete1 = Integer.parseInt(txtCantidadPaquete1.getValue().toString());
                    int txt_unidad_paquete1 = Integer.parseInt(txtUnidadXPaquete1.getValue().toString());
                    Long stock_1 = Long.valueOf(txt_cantidad_paquete1 * txt_unidad_paquete1);

                    int txt_cantidad_paquete2 = Integer.parseInt(txtCantidadPaquete2.getValue().toString());
                    int txt_unidad_paquete2 = Integer.parseInt(txtUnidadXPaquete2.getValue().toString());
                    Long stock_2 = Long.valueOf(txt_cantidad_paquete2 * txt_unidad_paquete2);

                    producto.setStockActUni(stock_normal + stock_1 + stock_2);
                }
            }

        } else if (check1 == true && check2 == false && check3 == true) {
            //normal + 1 y 3

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete1.getValue() == null || txtUnidadXPaquete1.getValue() == null || txtCantidadPaquete3.getValue() == null || txtUnidadXPaquete3.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Long stock_normal = Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete);

                    int txt_cantidad_paquete1 = Integer.parseInt(txtCantidadPaquete1.getValue().toString());
                    int txt_unidad_paquete1 = Integer.parseInt(txtUnidadXPaquete1.getValue().toString());
                    Long stock_1 = Long.valueOf(txt_cantidad_paquete1 * txt_unidad_paquete1);

                    int txt_cantidad_paquete3 = Integer.parseInt(txtCantidadPaquete3.getValue().toString());
                    int txt_unidad_paquete3 = Integer.parseInt(txtUnidadXPaquete3.getValue().toString());
                    Long stock_3 = Long.valueOf(txt_cantidad_paquete3 * txt_unidad_paquete3);

                    producto.setStockActUni(stock_normal + stock_1 + stock_3);
                }
            }

        } else if (check1 == false && check2 == true && check3 == true) {
            //normal + 2 y 3

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete2.getValue() == null || txtUnidadXPaquete2.getValue() == null || txtCantidadPaquete3.getValue() == null || txtUnidadXPaquete3.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Long stock_normal = Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete);

                    int txt_cantidad_paquete2 = Integer.parseInt(txtCantidadPaquete2.getValue().toString());
                    int txt_unidad_paquete2 = Integer.parseInt(txtUnidadXPaquete2.getValue().toString());
                    Long stock_2 = Long.valueOf(txt_cantidad_paquete2 * txt_unidad_paquete2);

                    int txt_cantidad_paquete3 = Integer.parseInt(txtCantidadPaquete3.getValue().toString());
                    int txt_unidad_paquete3 = Integer.parseInt(txtUnidadXPaquete3.getValue().toString());
                    Long stock_3 = Long.valueOf(txt_cantidad_paquete3 * txt_unidad_paquete3);

                    producto.setStockActUni(stock_normal + stock_2 + stock_3);
                }
            }

        } else if (check1 == true && check2 == true && check3 == true) {
            //normal + 1, 2 y 3

            if (txtCantidadPaquete.getValue() == null || txtUnidadXPaquete.getValue() == null || txtCantidadPaquete1.getValue() == null || txtUnidadXPaquete1.getValue() == null || txtCantidadPaquete2.getValue() == null || txtUnidadXPaquete2.getValue() == null || txtCantidadPaquete3.getValue() == null || txtUnidadXPaquete3.getValue() == null) {
            } else {
                if (txtCantidadPaquete.getValue().equals("0") || txtUnidadXPaquete.getValue().equals("0") || txtCantidadPaquete1.getValue().equals("0") || txtUnidadXPaquete1.getValue().equals("0") || txtCantidadPaquete2.getValue().equals("0") || txtUnidadXPaquete2.getValue().equals("0") || txtCantidadPaquete3.getValue().equals("0") || txtUnidadXPaquete3.getValue().equals("0")) {
                } else {
                    int txt_cantidad_paquete = Integer.parseInt(txtCantidadPaquete.getValue().toString());
                    int txt_unidad_paquete = Integer.parseInt(txtUnidadXPaquete.getValue().toString());
                    Long stock_normal = Long.valueOf(txt_cantidad_paquete * txt_unidad_paquete);

                    int txt_cantidad_paquete1 = Integer.parseInt(txtCantidadPaquete1.getValue().toString());
                    int txt_unidad_paquete1 = Integer.parseInt(txtUnidadXPaquete1.getValue().toString());
                    Long stock_1 = Long.valueOf(txt_cantidad_paquete1 * txt_unidad_paquete1);

                    int txt_cantidad_paquete2 = Integer.parseInt(txtCantidadPaquete2.getValue().toString());
                    int txt_unidad_paquete2 = Integer.parseInt(txtUnidadXPaquete2.getValue().toString());
                    Long stock_2 = Long.valueOf(txt_cantidad_paquete2 * txt_unidad_paquete2);

                    int txt_cantidad_paquete3 = Integer.parseInt(txtCantidadPaquete3.getValue().toString());
                    int txt_unidad_paquete3 = Integer.parseInt(txtUnidadXPaquete3.getValue().toString());
                    Long stock_3 = Long.valueOf(txt_cantidad_paquete3 * txt_unidad_paquete3);

                    producto.setStockActUni(stock_normal + stock_1 + stock_2 + stock_3);
                }
            }

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

    public void cambioTxtCompra3() {

        if (txtCompra3.getValue() == null) {
            txtCompraReal3.setValue("0");
        } else {
            if (txtCompra3.getValue().equals("0")) {
                txtCompraReal3.setValue("0");
            } else {
                if (txtDescuentoCompra3.getValue() == null) {
                    txtCompraReal3.setValue(txtCompra3.getValue());
                } else {
                    if (txtDescuentoCompra3.getValue().equals("0")) {
                        txtCompraReal3.setValue(txtCompra3.getValue());
                    } else {
                        double txt_compra = Double.parseDouble(txtCompra3.getValue().toString());
                        double txt_descuento = Double.parseDouble(txtDescuentoCompra3.getValue().toString());
                        double descuento = (txt_compra * txt_descuento) / 100;
                        txtCompraReal3.setValue(txt_compra - descuento);
                    }
                }
            }
        }

        if (txtCompraReal3.getValue() == null) {
            txtVentaSugerida3.setValue("0");
        } else {
            if (txtCompraReal3.getValue().equals("0")) {
                txtVentaSugerida3.setValue("0");
            } else {
                if (txtPorcentajeUtilidad3.getValue() == null) {
                    txtVentaSugerida3.setValue(txtCompraReal3.getValue());
                } else {
                    if (txtPorcentajeUtilidad3.getValue().equals("0")) {
                        txtVentaSugerida3.setValue(txtCompraReal3.getValue());
                    } else {
                        double compra_real = Double.parseDouble(txtCompraReal3.getValue().toString());
                        double utilidad = Double.parseDouble(txtPorcentajeUtilidad3.getValue().toString());
                        txtVentaSugerida3.setValue(compra_real + ((compra_real * utilidad) / 100));
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

    public void cambioComision3() {

        if (txtVentaReal3.getValue() == null || txtComision3.getValue() == null) {
        } else {
            if (txtVentaReal3.getValue().equals("0") || txtComision3.getValue().equals("0")) {
                txtPrecioComision3.setValue("0");
            } else {
                double txt_venta_real = Double.parseDouble(txtVentaReal3.getValue().toString());
                double txt_porcentaje_comision = Double.parseDouble(txtComision3.getValue().toString());
                txtPrecioComision3.setValue((txt_venta_real * txt_porcentaje_comision) / 100);
            }
        }

    }

    public void limpiarAgregarProducto() {

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

        txtCantidadPaquete3.setValue(null);
        txtDescripcionPaquete3.setValue(null);
        txtUnidadXPaquete3.setValue(null);
        txtCompra3.setValue(null);
        txtDescuentoCompra3.setValue(null);
        txtCompraReal3.setValue(null);
        txtPorcentajeUtilidad3.setValue(null);
        txtVentaSugerida3.setValue(null);
        txtVentaReal3.setValue(null);
        txtComision3.setValue(null);
        txtPrecioComision3.setValue(null);

        setCheck1(false);
        setCheck2(false);
        setCheck3(false);

        selectCheck1();
        selectCheck2();
        selectCheck3();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogNuevoProducto').show();");

    }

    public void cancelarRegistroProducto() {

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

        txtCantidadPaquete3.setValue(null);
        txtDescripcionPaquete3.setValue(null);
        txtUnidadXPaquete3.setValue(null);
        txtCompra3.setValue(null);
        txtDescuentoCompra3.setValue(null);
        txtCompraReal3.setValue(null);
        txtPorcentajeUtilidad3.setValue(null);
        txtVentaSugerida3.setValue(null);
        txtVentaReal3.setValue(null);
        txtComision3.setValue(null);
        txtPrecioComision3.setValue(null);

        setCheck1(false);
        setCheck2(false);
        setCheck3(false);

        selectCheck1();
        selectCheck2();
        selectCheck3();

        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogNuevoProducto').hide();");

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

        txtCantidadPaquete3.setValue(null);
        txtDescripcionPaquete3.setValue(null);
        txtUnidadXPaquete3.setValue(null);
        txtCompra3.setValue(null);
        txtDescuentoCompra3.setValue(null);
        txtCompraReal3.setValue(null);
        txtPorcentajeUtilidad3.setValue(null);
        txtVentaSugerida3.setValue(null);
        txtVentaReal3.setValue(null);
        txtComision3.setValue(null);
        txtPrecioComision3.setValue(null);

        setCheck1(false);
        setCheck2(false);
        setCheck3(false);

        selectCheck1();
        selectCheck2();
        selectCheck3();
    }

    public void cancelarAdicionarProductosStock() {

        this.adicionarProductos = 0L;
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAgregarProducto').hide();");
    }

    public void adicionarProductosStock() {

        producto.setStockActUni(producto.getStockActUni() + this.adicionarProductos);
        ProductoController pDao = new ProductoController();

        pDao.updateProducto(producto);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAgregarProducto').hide();");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa:", "El Stock Actual se ha modificado correctamente."));
        producto = new Producto();
        this.adicionarProductos = 0L;

    }

    public void eliminarProducto() {

        ProductoController pDao = new ProductoController();
        int eliminarProducto = pDao.deleteProducto(producto);
        if (eliminarProducto == 0) {
            //se elimina
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarProducto').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa:", "El Producto se ha eliminado correctamente."));
            producto = new Producto();
        } else {
            //no se elimina
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarProducto').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Producto no puede eliminarse, puede que este asociado a una factura."));
            producto = new Producto();
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Exitosa:", "El Producto se ha modificado correctamente."));
                producto = new Producto();
            } catch (Exception ex) {
                Logger.getLogger(ProductoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
