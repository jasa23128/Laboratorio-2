public class Bebida extends Producto{
    private final double precio_bebida;
    private final int mililitros;

    public Bebida(String id_producto, String nombre_producto, double precio_bebida, int mililitros){
        super(id_producto, nombre_producto);
        this.precio_bebida = precio_bebida;
        this.mililitros = mililitros;
    }

    @Override
    public Double getPrecio(){
        return precio_bebida;
    }

}
