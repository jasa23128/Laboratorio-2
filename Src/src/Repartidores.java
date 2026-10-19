public class Repartidores extends Personas {
    private double calificacion;
    private int id_rept;
    public Repartidores(int id_rept, String nombre, String telf, double calificacion) {
        super(nombre, telf);
        this.calificacion = calificacion;
        this.id_rept = id_rept;

    }

    public int getId_rept() {
        return id_rept;
    }

    public void setId_rept(int id_rept) {
        this.id_rept = id_rept;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Repartidor " + ", ID: " + id_rept + super.toString() + ", Calificación: " + calificacion;
    }
}

