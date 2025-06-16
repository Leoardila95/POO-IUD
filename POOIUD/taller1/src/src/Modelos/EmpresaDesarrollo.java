package Modelos;

    public class EmpresaDesarrollo extends Empresa {

        public EmpresaDesarrollo() {
            super();
        }

        public EmpresaDesarrollo(String nit, String nombre, String direccion, String ciudad) {
            super(nit, nombre, direccion, ciudad);
        }

        @Override
        public String toString() {
            return "EmpresaDesarrollo " + super.toString();
        }
    }
