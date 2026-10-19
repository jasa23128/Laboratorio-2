public class Personas {
    protected String nombre;
    protected String telf;

    public Personas(String nombre, String telf) {
        this.nombre = nombre;
        this.telf = telf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return ", Nombre: " + nombre + ", Tel: " + telf;
    }
}
