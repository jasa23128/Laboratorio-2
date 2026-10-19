public class Personas {
    protected String id; // Documento o identificación única
    protected String nombre;
    protected String telf;

    public Personas(String id, String nombre, String telf) {
        this.id = id;
        this.nombre = nombre;
        this.telf = telf;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelf() {
        return telf;
    }

    // Setters (útiles si el cliente actualiza sus datos de contacto)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    // Nota: El ID (documento) por lo general no debe tener setter,
    // ya que es la clave única que identifica a la persona.

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Tel: " + telf;
    }
}
