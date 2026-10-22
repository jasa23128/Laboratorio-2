import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorIdPedido = 1;
    private int idPedido;
    private String clienteDocumento;
    private List<Producto> productos;
    private Promocion promocion;
    private String estado;
    private List<ObservadorPedido> observadores = new ArrayList<>();

    public Pedido(String clienteDocumento) {
        this.idPedido = contadorIdPedido++;
        this.clienteDocumento = clienteDocumento;
        this.productos = new ArrayList<>();
        this.promocion = new SinPromocion(); // Patrón Strategy por defecto
        this.estado = "CREADO";
    }

    public void agregarObservador(ObservadorPedido observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void notificarObservadores() {
        for (ObservadorPedido obs : observadores) {
            obs.actualizar(this, this.estado);
        }
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores(); // Dispara automáticamente las alertas a cocina, cliente y repartidores
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    // Uso de Wildcards (? extends Producto) para recibir cualquier subclase (Platos, Bebida, Combo)
    public void agregarProductos(List<? extends Producto> nuevosProductos) {
        this.productos.addAll(nuevosProductos);
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public double calcularSubtotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public double calcularTotal() {
        return promocion.aplicarDescuento(calcularSubtotal());
    }

    public int getIdPedido() { return idPedido; }
    public String getClienteDocumento() { return clienteDocumento; }
    public String getEstado() { return estado; }
    public List<Producto> getProductos() { return productos; }
}