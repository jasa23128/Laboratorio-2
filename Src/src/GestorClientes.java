import java.util.Collection;
import java.util.Optional;

public class GestorClientes {
    private final GuardadorGenerico<String, Clientes> repositorio = new GuardadorGenerico<>();

    public void registrarOActualizar(Clientes cliente) {
        if (cliente == null || cliente.getDocumento() == null) return;

        String doc = cliente.getDocumento();
        Optional<Clientes> existente = repositorio.buscarPorId(doc);

        if (existente.isPresent()) {
            Clientes c = existente.get();
            c.setNombre(cliente.getNombre());
            c.setTelf(cliente.getTelf());
            c.setDireccionEntrega(cliente.getDireccionEntrega());
            c.setMail(cliente.getMail());
        } else {
            repositorio.guardar(doc, cliente);
        }
    }

    public Optional<Clientes> buscarPorDocumento(String documento) {
        return repositorio.buscarPorId(documento);
    }

    public Collection<Clientes> obtenerTodos() {
        return repositorio.obtenerTodos();
    }
}