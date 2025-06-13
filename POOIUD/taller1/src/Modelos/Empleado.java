package Modelos;

public class Empleado {
    private String nombres;
    private int id;
    private double sueldoHora;
    private int telefono;
    private String email;

    public Empleado(String nombres, int id, double sueldoHora, int telefono, String email) {
        this.nombres = nombres;
        this.id = id;
        this.sueldoHora = sueldoHora;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }
    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
