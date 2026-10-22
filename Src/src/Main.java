public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA SABOREXPRESS S.A.S. ===");

        // 1. Instanciamos tus gestores reales
        GestorClientes gestorClientes = new GestorClientes();
        CatalogoMenu catalogoMenu = new CatalogoMenu();

        // 2. Registrar Sede (Declarando correctamente la variable)
        Sedes sedeNorte = new Sedes("Sede Norte", "Calle 100 #15-20");

        // 3. Registrar Clientes (Sin etiquetas de parámetros, usando el orden correcto)
        Clientes cliente1 = new Clientes("10203045", "Carlos Pérez", 31122233, "Calle 45 #20-10", "carlos@mail.com");
        Clientes clienteDuplicado = new Clientes("10203045", "Carlos Pérez App", 31122233, "Calle 45 #20-10", "carlos@app.com");

        gestorClientes.registrarOActualizar(cliente1);
        gestorClientes.registrarOActualizar(clienteDuplicado); // Actualiza si ya existe el documento

        // 4. Agregar Productos al Catálogo del Menú
        Platos bandejaPaisa = new Platos(1, "Bandeja Paisa", 28000.0, CategoriaPlato.PLATO_PRINCIPAL, false);
        Platos limonada = new Platos(2, "Limonada Natural", 6000.0, CategoriaPlato.ACOMPANAMIENTO, true);

        catalogoMenu.agregarProducto(bandejaPaisa);
        catalogoMenu.agregarProducto(limonada);

        // 5. Crear un Pedido asociado al documento del cliente (Pasando el String del documento)
        Pedido pedido = new Pedido(cliente1.getDocumento());
        pedido.agregarProducto(bandejaPaisa);
        pedido.agregarProducto(limonada);

        // 6. Suscribir Observadores (Patrón Observer: Cocina, Repartidores, Clientes)
        Cocina cocinaNorte = new Cocina(sedeNorte.getNumSede());
        Repartidores repartidorJuan = new Repartidores("Juan Reparto", 32099988);

        pedido.agregarObservador(cocinaNorte);
        pedido.agregarObservador(repartidorJuan);
        pedido.agregarObservador(cliente1); // El cliente es observador

        // 7. Aplicar Promoción dinámica (Patrón Strategy)
        System.out.println("\n--- Calculando totales con Promociones ---");
        System.out.println("Subtotal sin promo: $" + pedido.calcularSubtotal());

        // Aplicamos 15% de descuento usando Strategy
        pedido.setPromocion(new PromocionPorcentaje(0.15));
        System.out.println("Total con Promoción del 15%: $" + pedido.calcularTotal());

        // 8. Registrar venta en la sede
        sedeNorte.registrarVenta(pedido.calcularTotal());
        System.out.println(sedeNorte.toString());

        // 9. Cambiar de estado al pedido (Dispara automáticamente las notificaciones a los observadores)
        System.out.println("\n--- Cambiando Estado del Pedido ---");
        pedido.setEstado("EN_PREPARACION");
        pedido.setEstado("EN_CAMINO");
    }
}