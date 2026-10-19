
import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {

    private final String id_producto;
    private final String nombre_producto;

    public Producto(String id_producto, String nombre_producto){
        if(id_producto == null || id_producto.isBlank()){
            throw new IllegalArgumentException("El ID no puede estar vacio.");
        }
        if (nombre_producto == null || id_producto.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacio.");
        }
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public abstract Double getPrecio();

    public int compareTo(Producto otro){
        return this.id_producto.compareToIgnoreCase(nombre_producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id_producto, producto.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId_producto());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto='" + id_producto + '\'' +
                ", nombre_producto='" + nombre_producto + '\'' +
                '}';
    }
}
