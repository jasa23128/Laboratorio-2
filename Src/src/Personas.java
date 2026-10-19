public class Personas implements ObservadorPedido{
    protected String nombre;
    protected int telf;

    public Personas(String nombre, int telf) {
        this.nombre = nombre;
        this.telf = telf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return ", Nombre: " + nombre + ", Tel: " + telf;
    }

    @Override
    public void actualizar(Pedido pedido, String nuevoEstado) {

    }
}
