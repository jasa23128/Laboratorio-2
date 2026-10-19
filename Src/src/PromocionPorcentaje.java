public class PromocionPorcentaje implements Promocion {
    private double porcentaje; // Ej: 0.15 para el 15%

    public PromocionPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicarDescuento(double totalSinDescuento) {
        return totalSinDescuento * (1 - porcentaje);
    }
}