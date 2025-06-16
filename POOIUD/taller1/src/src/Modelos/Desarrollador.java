package Modelos;

public class Desarrollador extends Empleado {

    public Desarrollador() {
        super();
    }

    public Desarrollador(String documento, String nombre, double sueldoHora, Empresa empresa) {
        super(documento, nombre, sueldoHora, empresa);
    }

    @Override
    public String toString() {
        return "Desarrollador " + super.toString();
    }
}

    @Override
    public void setEmpresa(Empresa empresa) {

    }
}
