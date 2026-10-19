import java.util.Objects;

public class Clientes extends Personas {
    private String mail;
    private String direccionEntrega;

    public Clientes(String id, String nombre, String telf, String direccionEntrega, String mail) {
        super(id, nombre, telf);
        this.direccionEntrega = direccionEntrega;
        this.mail = mail;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getMail() {
        return mail;
    }


    // Crucial para la Condición 1: Dos clientes con el mismo ID son el mismo cliente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes cliente = (Clientes) o;
        // Asumiendo que getId() viene de la clase Persona
        return Objects.equals(getId(), cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Cliente " + super.toString() + ", Dirección: " + direccionEntrega + ", Mail: " + mail;
    }
}

