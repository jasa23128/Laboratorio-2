public class Repartidores extends Personas {
    private String cargo; // Ej: Repartidor, Cocinero

    public Repartidores(String id, String nombre, String telf, String cargo) {
        super(id, nombre, telf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Empleado -> [" + super.toString() + ", Cargo: " + cargo + "]";
    }
}

