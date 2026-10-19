public class SinPromocion implements Promocion {
    @Override
    public double aplicarDescuento(double totalSinDescuento) {
        return totalSinDescuento; // No hace ningún descuento
    }
}