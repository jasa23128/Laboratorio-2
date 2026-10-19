import java.util.Objects;

public class Sedes {
    private static int contadorId = 0;
    private final int numSede;
    private String nombre;
    private String direccion;
    private double facturado;

    public Sedes(String nombre, String direccion) {
        this.numSede = ++contadorId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.facturado = 0.0;
    }

    public void registrarVenta(double monto) {
        if (monto > 0) {
            this.facturado += monto;
        }
    }

    public int getNumSede() {
        return numSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getFacturado() {
        return facturado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sedes sede = (Sedes) o;
        return numSede == sede.numSede;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSede);
    }

    @Override
    public String toString() {
        return "Sede #" + numSede + " - " + nombre + " (Facturado: $" + facturado + ")";
    }
}