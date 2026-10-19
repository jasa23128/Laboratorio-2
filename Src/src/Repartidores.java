import java.util.Objects;

public class Repartidores extends Personas  {
    private static int contadorId = 1;
    private int id_repartidor;
    private double calificacion;

    public Repartidores(String nombre, int telf) {
        super(nombre, telf);
        this.id_repartidor = contadorId++;
        this.calificacion = 0.0;
    }

    public int getId_repartidor() {
        return id_repartidor;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repartidores that = (Repartidores) o;
        return id_repartidor == that.id_repartidor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_repartidor);
    }

    @Override
    public String toString() {
        return "Repartidor [ID: " + id_repartidor + super.toString() + ", Calificación: " + calificacion + "]";
    }
    @Override
    public void actualizar(Pedido pedido, String nuevoEstado){
        System.out.println("Repartidor: " + nombre + "El Estado del producto es: "+ nuevoEstado);
    }

}

