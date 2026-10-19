import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Collection;

public class GestorClientes {
    private final Map<Integer, Clientes> clientes;

    public GestorClientes() {
        this.clientes = new HashMap<>();
    }

    public boolean registrarOActualizarCliente(Clientes cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }

        int documento = cliente.getId_cliente();

        if (clientes.containsKey(documento)) {
            Clientes existente = clientes.get(documento);
            existente.setNombre(cliente.getNombre());
            existente.setTelf(cliente.getTelf());
            existente.setDireccionEntrega(cliente.getDireccionEntrega());
            existente.setMail(cliente.getMail());
            return false; // Ya existía y se actualizó
        }

        clientes.put(documento, cliente);
        return true;
    }

    public Optional<Clientes> buscarPorDocumento(int documento) {
        return Optional.ofNullable(clientes.get(documento));
    }

    public Collection<Clientes> obtenerTodos() {
        return clientes.values();
    }

    public int cantidadClientes() {
        return clientes.size();
    }
}