import java.util.Objects;

public class Clientes extends Personas {
    private static int contadorId = 1; // Contador estático que sube solo
    private int id_cliente;
    private String mail;
    private String direccionEntrega;

    // Ya no se pide el ID en el constructor, se genera solito
    public Clientes(String nombre, int telf, String direccionEntrega, String mail) {
        super(nombre, telf);
        this.id_cliente = contadorId++; // Asigna el número y luego incrementa en 1
        this.direccionEntrega = direccionEntrega;
        this.mail = mail;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes cliente = (Clientes) o;
        return id_cliente == cliente.id_cliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cliente);
    }

    @Override
    public String toString() {
        return "Cliente [ID: " + id_cliente + super.toString() + ", Dirección: " + direccionEntrega + ", Mail: " + mail + "]";
    }
}

