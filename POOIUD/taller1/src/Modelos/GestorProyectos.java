package Modelos;

public class GestorProyectos extends Empleado{

    private String area;

    public GestorProyectos(String nombres, int id, double sueldoHora, int telefono, String email, String area) {
        super(nombres, id, sueldoHora, telefono, email);
        this.area = area;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}
