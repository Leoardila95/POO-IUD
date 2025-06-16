package Operaciones;

import Modelos.Empleado;
import Modelos.Empresa;
import java.util.List;

public interface IOperacionEmpleado {

    void agregarEmpleado(Empleado empleado, List<Empleado> todosLosEmpleados);

    Empleado buscarEmpleadoPorDocumento(String documento, List<Empleado> todosLosEmpleados);

    double calcularSueldo(String documento, double horasTrabajadas, List<Empleado> todosLosEmpleados);

    List<Empleado> obtenerTodosLosEmpleados(List<Empleado> todosLosEmpleados);

    int contarEmpleadosEnEmpresa(String nitEmpresa, List<Empresa> listaEmpresas);

    void agregarEmpleado(Empleado empleado);
}