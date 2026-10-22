import java.util.Objects;

public class Clientes extends Personas {
    private String documento; // ID único real del cliente
    private String mail;
    private String direccionEntrega;

    public Clientes(String documento, String nombre, int telf, String direccionEntrega, String mail) {
        super(nombre, telf);
        this.documento = documento;
        this.direccionEntrega = direccionEntrega;
        this.mail = mail;
    }

    public String getDocumento() { return documento; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccion) { this.direccionEntrega = direccion; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    @Override
    public void actualizar(Pedido pedido, String nuevoEstado) {
        System.out.println("[Notificación App/WhatsApp] Hola " + nombre + ", tu pedido #" + pedido.getIdPedido() + " ahora está: " + nuevoEstado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(documento, clientes.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    @Override
    public String toString() {
        return "Cliente [Documento: " + documento + super.toString() + ", Dir: " + direccionEntrega + "]";
    }
}