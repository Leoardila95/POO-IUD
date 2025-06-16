package Modelos;

public class GestorProyectos extends Empleado {
    private String area;

    public GestorProyectos() {
        super();
    }

    public GestorProyectos(String documento, String nombre, double sueldoHora, Empresa empresa, String area) {
        super(documento, nombre, sueldoHora, empresa);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "GestorProyectos " + super.toString() + ", Área=" + area;
    }
}