package Bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import Controller.ClienteController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import Model.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private Cliente clienteViejo;
    private List<Cliente> listaCliente;
    private List<Cliente> filtroClientes;

    public ClienteBean() {
    }

    @PostConstruct
    public void Init() {
        cliente = new Cliente();
        clienteViejo = new Cliente();
    }

    public List<Cliente> getFiltroClientes() {
        return filtroClientes;
    }

    public void setFiltroClientes(List<Cliente> filtroClientes) {
        this.filtroClientes = filtroClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteViejo() {
        return clienteViejo;
    }

    public void setClienteViejo(Cliente clienteViejo) {
        this.clienteViejo = clienteViejo;
    }

    public List<Cliente> getListaCliente() {
        ClienteController cDao = new ClienteController();
        listaCliente = cDao.listarClientes();
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public void prepararNuevoCliente() {
        cliente = new Cliente();
    }

    public void nuevoCliente() {

        if (cliente.getCodcliente().equals("") || cliente.getNombres().equals("") || cliente.getApellidos().equals("") || cliente.getDireccion().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
        } else {

            cliente.setNombres(cliente.getNombres().toUpperCase());
            cliente.setApellidos(cliente.getApellidos().toUpperCase());
            cliente.setDireccion(cliente.getDireccion().toUpperCase());

            try {
                ClienteController clienteController = new ClienteController();
                clienteViejo = clienteController.consultarClientePorCodigo(cliente.getCodcliente());

                if (clienteViejo == null) {
                    //se guarda 
                    clienteController.newCliente(cliente);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('dialogNuevoCliente').hide();");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Cliente se ha registrado correctamente."));
                } else {
                    //no se guarda
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ya existe un Cliente con la cédula ingresada."));
                }
                cliente = new Cliente();
            } catch (Exception ex) {
                cliente = new Cliente();
                Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificarCliente() {

        if (cliente.getNombres().equals("") || cliente.getApellidos().equals("") || cliente.getDireccion().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "Todos los campos son obligatorios."));
        } else {
            cliente.setNombres(cliente.getNombres().toUpperCase());
            cliente.setApellidos(cliente.getApellidos().toUpperCase());
            cliente.setDireccion(cliente.getDireccion().toUpperCase());

            ClienteController clienteController = new ClienteController();
            clienteController.updateCliente(cliente);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogModificarCliente').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Cliente se ha modificado correctamente."));
        }
        cliente = new Cliente();
    }

    public void eliminarCliente() {

        ClienteController clienteController = new ClienteController();
        int eliminarCliente = clienteController.deleteCliente(cliente);

        if (eliminarCliente == 0) {
            //se eliminó
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarCliente').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación Exitosa:", "El Cliente se ha eliminado correctamente."));
            cliente = new Cliente();
        } else {
            //error el cliente no puede eliminarse
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogEliminarCliente').hide();");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia:", "El Cliente no puede eliminarse, puede que esté asociado a una factura."));
            cliente = new Cliente();
        }
    }

}
