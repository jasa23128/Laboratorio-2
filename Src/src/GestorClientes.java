import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Collection;

public class GestorClientes {
    private final Map<String, Clientes> clientes;

    public GestorClientes() {
        this.clientes = new HashMap<>();
    }


    public boolean registrarOActualizarCliente(Clientes cliente) {
        if (cliente == null || cliente.getId() == null) {
            throw new IllegalArgumentException("El cliente o su documento no pueden ser nulos.");
        }

        String documento = cliente.getId();

        if (clientes.containsKey(documento)) {
            Clientes existente = clientes.get(documento);
            existente.setNombre(cliente.getNombre());
            existente.setTelf(cliente.getTelf());
            existente.setDireccionEntrega(cliente.getDireccionEntrega());
            existente.setMail(cliente.getMail());
            return false; // Indicamos que ya existía
        }


        clientes.put(documento, cliente);
        return true;
    }


    public Optional<Clientes> buscarPorDocumento(String documento) {
        if (documento == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(clientes.get(documento));
    }

    public Collection<Clientes> obtenerTodos() {
        return clientes.values();
    }

    public int cantidadClientes() {
        return clientes.size();
    }
}