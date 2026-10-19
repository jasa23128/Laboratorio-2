import java.util.List;

    public class Combo extends Producto{
        private final List<Producto> items;
        private final double descuentoPorcentaje;

        public Combo (String id_producto, String nombre_producto, List<? extends Producto> items, double descuentoPorcentaje){
            super(id_producto, nombre_producto);
            if (items == null || items.isEmpty()) {
                throw new IllegalArgumentException("Un combo debe tener al menos un producto");
            }
            this.items = List.copyOf(items);
            this.descuentoPorcentaje = descuentoPorcentaje;
        }
        @Override
        public Double getPrecio(){
            double subtotal = items.stream()
                    .mapToDouble(Producto::getPrecio)
                               .sum();
            return subtotal * (1.0 - descuentoPorcentaje);
        }
        public List<Producto> getItems() {
            return items;
        }
}
