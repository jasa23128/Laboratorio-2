import java.util.*;

public class GuardadorGenerico<K, T> {
    private final Map<K, T> elementos = new HashMap<>();

    public void guardar(K id, T elemento) {
        if (id != null && elemento != null) {
            elementos.put(id, elemento);
        }
    }

    public Optional<T> buscarPorId(K id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(elementos.get(id));
    }

    public Collection<T> obtenerTodos() {
        return elementos.values();
    }

    public void eliminar(K id) {
        elementos.remove(id);
    }
}