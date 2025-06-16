package Modelos;

import java.util.Objects;

public abstract class Empleado {

    private String documento;
    private String nombre;
    private double sueldoHora;
    private Empresa empresa;



    public Empleado() {

    }

    public Empleado(String documento, String nombre, double sueldoHora, Empresa empresa) {
        this.documento = documento;
        this.nombre = nombre;
        this.sueldoHora = sueldoHora;
        this.empresa = empresa;
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {

        return "Empleado [Documento=" + documento + ", Nombre=" + nombre +
                ", Sueldo/Hora=" + sueldoHora +
                ", Empresa=" + (empresa != null ? empresa.getNombre() : "N/A") + "]";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(documento, empleado.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
