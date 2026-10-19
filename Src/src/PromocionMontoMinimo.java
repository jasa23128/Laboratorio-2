public class PromocionMontoMinimo implements Promocion {
    private double montoMinimo;
    private double descuentoFijo;

    public PromocionMontoMinimo(double montoMinimo, double descuentoFijo) {
        this.montoMinimo = montoMinimo;
        this.descuentoFijo = descuentoFijo;
    }

    @Override
    public double aplicarDescuento(double totalSinDescuento) {
        if (totalSinDescuento >= montoMinimo) {
            return totalSinDescuento - descuentoFijo;
        }
        return totalSinDescuento;
    }
}