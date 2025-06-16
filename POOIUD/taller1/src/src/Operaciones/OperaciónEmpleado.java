package Operaciones;

import Modelos.Empleado;
import Modelos.Empresa;
import java.util.List;

class OperacionEmpleado implements IOperacionEmpleado {


    @Override
    public void agregarEmpleado(Empleado empleado, List<Empleado> todosLosEmpleados) {
        if (empleado != null && !todosLosEmpleados.contains(empleado)) {
            todosLosEmpleados.add(empleado);
            System.out.println("Empleado " + empleado.getNombres() + " agregado con éxito.");
            if (empleado.getEmpresa() != null) {
                empleado.getEmpresa().agregarEmpleado(empleado);
            }
        } else {
            System.out.println("No se pudo agregar el empleado. Ya existe o es nulo.");
        }
    }

    @Override
    public Empleado buscarEmpleadoPorDocumento(String documento, List<Empleado> todosLosEmpleados) {
        for (Empleado emp : todosLosEmpleados) {
            if (emp.getDocumento().equals(documento)) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public double calcularSueldo(String documento, double horasTrabajadas, List<Empleado> todosLosEmpleados) {
        Empleado empleado = buscarEmpleadoPorDocumento(documento, todosLosEmpleados);
        if (empleado != null) {
            return empleado.getSueldoHora() * horasTrabajadas;
        }
        return 0.0;
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados(List<Empleado> todosLosEmpleados) {
        return todosLosEmpleados;
    }

    @Override
    public int contarEmpleadosEnEmpresa(String nitEmpresa, List<Empresa> listaEmpresas) {
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getNit().equals(nitEmpresa)) {
                return empresa.getEmpleados().size();
            }
        }
        return 0;
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {

    }
}
