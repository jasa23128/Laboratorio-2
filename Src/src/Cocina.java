public class Cocina implements ObservadorPedido{
    private int Sede_Perteneces;
    public Cocina(int numsede){
        Sede_Perteneces = numsede;
    }
    @Override
    public void actualizar(Pedido pedido, String nuevoEstado){
        System.out.println(nuevoEstado);
    }
}
