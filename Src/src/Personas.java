public class Personas {
        //
        protected String id;
        protected String nombre;
        protected String telf;

        public Personas(String id, String nombre, String telf) {
            this.id = id;
            this.nombre = nombre;
            this.telf = telf;
        }

        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelf() {
            return telf;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Nombre: " + nombre + ", Tel: " + telf;
        }
    }
