public interface Promocion {
    /**
     * Aplica la lógica de descuento a un valor o pedido.
     * @param totalSinDescuento El monto subtotal sobre el cual evaluar la promoción.
     * @return El monto final a pagar tras aplicar la promoción.
     */
    double aplicarDescuento(double totalSinDescuento);
}