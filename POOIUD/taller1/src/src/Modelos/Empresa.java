package Modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {
    private String nit;
    private String nombre;
    private String direccion;
    private String ciudad;

    private List<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public Empresa(String nit, String nombre, String direccion, String ciudad) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.empleados = new ArrayList<>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null && !this.empleados.contains(empleado)) {
            this.empleados.add(empleado);
            empleado.setEmpresa(this);
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        if (empleado != null && this.empleados.remove(empleado)) {
            empleado.setEmpresa(null);
        }
    }

    @Override
    public String toString() {
        return "Empresa [NIT=" + nit + ", Nombre=" + nombre +
                ", Dirección=" + direccion + ", Ciudad=" + ciudad +
                ", Empleados=" + empleados.size() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nit, empresa.nit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nit);
    }
}