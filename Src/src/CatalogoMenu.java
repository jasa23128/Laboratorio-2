import java.util.*;
import java.util.stream.Collectors;

public class CatalogoMenu {

    private final GuardadorGenerico<Integer, Producto> repositorio = new GuardadorGenerico<>();

    public void agregarProducto(Producto producto) {
        Objects.requireNonNull(producto, "El producto no puede ser nulo");
        repositorio.guardar(producto.getId_producto(), producto);
    }

    public Optional<Producto> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public double calcularTotalItems(List<? extends Producto> items) {
        return items.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    public List<Producto> obtenerMenuOrdenadoPorPrecioYNombre() {
        Comparator<Producto> comparadorCombinado = Comparator
                .comparingDouble(Producto::getPrecio).reversed()
                .thenComparing(Producto::getNombre_producto);

        // Usamos repositorio.obtenertodos() en lugar de .values()
        return repositorio.obtenerTodos().stream()
                .sorted(comparadorCombinado)
                .toList();
    }

    public List<Platos> obtenerPlatosVeganos() {
        return repositorio.obtenerTodos().stream()
                .filter(p -> p instanceof Platos)
                .map(p -> (Platos) p)
                .filter(Platos::isEsVegano)
                .toList();
    }

    public Map<String, List<Producto>> agruparPorTipo() {
        return repositorio.obtenerTodos().stream()
                .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName()));
    }
}
