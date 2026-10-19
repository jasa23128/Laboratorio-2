public class Repartidores extends Personas {
    private double calificacion; // Útil para el laboratorio (repartidores con mejor calificación)

    public Repartidores(String id, String nombre, String telf, double calificacion) {
        super(id, nombre, telf);
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Repartidor " + super.toString() + ", Calificación: " + calificacion;
    }
}

