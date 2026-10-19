import java.util.Collection;
import java.util.Optional;

public class GestorClientes {

    // Corregido: solo se pasa el tipo de la clave (Integer) y el tipo del objeto (Clientes)
    private final GuardadorGenerico<Integer, Clientes> repositorio = new GuardadorGenerico<>();

    public void registrarOActualizar(Clientes cliente) {
        if (cliente == null || cliente.getId_cliente() == 0) return;

        int documento = cliente.getId_cliente();

        // Verificamos si ya está guardado usando el repositorio genérico
        Optional<Clientes> existente = repositorio.buscarPorId(documento);

        if (existente.isPresent()) {
            // Si ya existía, actualizamos sus datos de contacto
            Clientes c = existente.get();
            c.setNombre(cliente.getNombre());
            c.setTelf(cliente.getTelf());
            c.setDireccionEntrega(cliente.getDireccionEntrega());
            c.setMail(cliente.getMail());
        } else {
            // Si es completamente nuevo, lo guardamos
            repositorio.guardar(documento, cliente);
        }
    }

    public Optional<Clientes> buscarPorDocumento(int documento) {
        return repositorio.buscarPorId(documento);
    }

    public Collection<Clientes> obtenerTodos() {
        return repositorio.obtenerTodos();
    }
}