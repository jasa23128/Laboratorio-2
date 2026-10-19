import java.util.*;
import java.util.stream.Collectors;
public class CatalogoMenu {

        private final Map<String, Producto> productosPorId = new HashMap<>();

        public void agregarProducto(Producto producto) {
            Objects.requireNonNull(producto, "El producto no puede ser nulo");
            productosPorId.put(producto.getId_producto(), producto);
        }


        public Optional<Producto> buscarPorId(String id) {
            return Optional.ofNullable(productosPorId.get(id));
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

            return productosPorId.values().stream()
                    .sorted(comparadorCombinado)
                .toList();
        }

        public List<Platos> obtenerPlatosVeganos() {
            return productosPorId.values().stream()
                    .filter(p -> p instanceof Platos)
                    .map(p -> (Platos) p)
                .filter(Platos::esVegano)
                .toList();
        }


        public Map<String, List<Producto>> agruparPorTipo() {
            return productosPorId.values().stream()
                    .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName()));
        }
    }

