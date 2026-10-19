import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorIdPedido = 1;
    private int idPedido;
    private int clienteId;
    private List<Producto> productos;
    private Promocion promocion;
    private String estado;

    public Pedido(int clienteId) {
        this.idPedido = contadorIdPedido++;
        this.clienteId = clienteId;
        this.productos = new ArrayList<>();
        this.promocion = new SinPromocion();
        this.estado = "CREADO";
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public void agregarProductos(List<? extends Producto> nuevosProductos) {
        this.productos.addAll(nuevosProductos);
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public double calcularSubtotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        return promocion.aplicarDescuento(subtotal);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}