public class Cocina implements ObservadorPedido {
    private int sedePertenencia;

    public Cocina(int numSede) {
        this.sedePertenencia = numSede;
    }

    @Override
    public void actualizar(Pedido pedido, String nuevoEstado) {
        System.out.println("[Cocina Sede #" + sedePertenencia + "] Alerta: El pedido #" + pedido.getIdPedido() + " ahora está en estado: " + nuevoEstado);
    }
}