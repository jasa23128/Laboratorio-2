import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String idPedido;
    private String clienteDocumento;
    private List<Producto> productos;
    private Promocion promocion; // Patrón Strategy para promociones dinámicas
    private String estado; // Ej: "CREADO", "EN_PREPARACION", "EN_CAMINO"

    public Pedido(String idPedido, String clienteDocumento) {
        this.idPedido = idPedido;
        this.clienteDocumento = clienteDocumento;
        this.productos = new ArrayList<>();
        this.promocion = new SinPromocion(); // Estrategia por defecto
        this.estado = "CREADO";
    }

    // Permite asignar/cambiar la promoción en cualquier momento sin modificar esta clase
    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    // Uso de Wildcards (? extends Producto) para recibir cualquier subclase de Producto (Plato, Bebida, Combo)
    public void agregarProductos(List<? extends Producto> nuevosProductos) {
        this.productos.addAll(nuevosProductos);
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Calcula el subtotal sumando el precio de cada ítem
    public double calcularSubtotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    // Delegación del cálculo final a la estrategia de promoción asignada
    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        return promocion.aplicarDescuento(subtotal);
    }

    // Getters y Setters encapsulados
    public String getIdPedido() { return idPedido; }
    public String getClienteDocumento() { return clienteDocumento; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<Producto> getProductos() { return productos; }
}