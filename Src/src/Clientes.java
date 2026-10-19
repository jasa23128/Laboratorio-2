import java.util.Objects;

public class Clientes extends Personas {
    private String id_cliente; // Su propio ID independiente
    private String mail;
    private String direccionEntrega;

    public Clientes(String id_cliente, String nombre, String telf, String direccionEntrega, String mail) {
        super(nombre, telf); // Solo pasa nombre y telf al padre
        this.id_cliente = id_cliente;
        this.direccionEntrega = direccionEntrega;
        this.mail = mail;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
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
        return Objects.equals(id_cliente, cliente.id_cliente);
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

