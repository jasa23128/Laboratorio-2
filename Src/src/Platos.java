public class Platos extends Producto {
    private final Double precio_plato;
    private final CategoriaPlato categoria;
    private final boolean esVegano;

    public Platos(int id_producto, String nombre_producto, Double precio_plato, CategoriaPlato categoria, boolean esVegano) {
        super(id_producto, nombre_producto);
        this.precio_plato = precio_plato;
        this.categoria = categoria;
        this.esVegano = esVegano;
    }

    public CategoriaPlato getCategoria() {
        return categoria;
    }

    public boolean isEsVegano() {
        return esVegano;
    }

    @Override
    public Double getPrecio() {
        return precio_plato;
    }
}
