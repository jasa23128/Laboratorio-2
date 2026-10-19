
import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {
    private final int id_producto;
    private final String nombre_producto;

    public Producto(int id_producto, String nombre_producto) {
        if (nombre_producto == null || nombre_producto.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacio.");
        }
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public abstract Double getPrecio();

    @Override
    public int compareTo(Producto otro) {
        return this.nombre_producto.compareToIgnoreCase(otro.nombre_producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id_producto == producto.id_producto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_producto);
    }

    @Override
    public String toString() {
        return "Producto{id=" + id_producto + ", nombre='" + nombre_producto + "'}";
    }
}


