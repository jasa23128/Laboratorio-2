public class Clientes extends Personas {
        private String mail; //si hay mail
        private String direccionEntrega;

        public Clientes(String id, String nombre, String telf, String direccionEntrega, String mail) {
            super(id, nombre, telf);
            this.direccionEntrega = direccionEntrega;
            this.mail = direccionEntrega;
        }

        public String getDireccionEntrega() {
            return direccionEntrega;
        }

        public String getMail() {
            return mail;
        }

        @Override
        public String toString() {
            return "Cliente " + super.toString() + ", Dirección: " + direccionEntrega;
        }
    }

