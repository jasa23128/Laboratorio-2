public class Clientes extends Personas {
        private String mail; //si hay mail
        private String direccionEntrega;

        public Clientes(String id, String nombre, String telf, String direccionEntrega) {
            super(id, nombre, telf);
            this.direccionEntrega = direccionEntrega;
        }

        public String getDireccionEntrega() {
            return direccionEntrega;
        }

        @Override
        public String toString() {
            return "Cliente " + super.toString() + ", Dirección: " + direccionEntrega;
        }
    }

