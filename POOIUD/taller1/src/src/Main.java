import Modelos.*;
import Operaciones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Empresa> empresas = new ArrayList<>();
    private static List<Empleado> empleados = new ArrayList<>();


    private static IOperacionEmpresa opEmpresa = new OperacionEmpresa();
    private static IOperacionEmpleado opEmpleado = new OperacionEmpleado();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {
                case 1:
                    ingresarEmpresa();
                    break;
                case 2:
                    ingresarEmpleado();
                    break;
                case 3:
                    consultarEmpresas();
                    break;
                case 4:
                    consultarEmpleados();
                    break;
                case 5:
                    consultarEmpleadoPorDocumento();
                    break;
                case 6:
                    calcularSueldoEmpleado();
                    break;
                case 7:
                    contarEmpleadosPorEmpresa();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println("\n--- Presione Enter para continuar ---");
            scanner.nextLine();
        } while (opcion != 0);

        scanner.close();
    }


    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Ingresar Nueva Empresa");
        System.out.println("2. Ingresar Nuevo Empleado");
        System.out.println("3. Consultar Todas las Empresas");
        System.out.println("4. Consultar Todos los Empleados");
        System.out.println("5. Consultar Empleado por Documento");
        System.out.println("6. Calcular Sueldo de Empleado");
        System.out.println("7. Contar Cantidad de Empleados en una Empresa");
        System.out.println("0. Salir");
    }

    private static void ingresarEmpresa() {
        System.out.println("\n--- Ingresar Nueva Empresa ---");
        System.out.print("NIT: ");
        String nit = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();


        Empresa nuevaEmpresa = new Empresa(nit, nombre, direccion, ciudad);
        opEmpresa.agregarEmpresa(nuevaEmpresa, empresas);
    }

    private static void ingresarEmpleado() {
        System.out.println("\n--- Ingresar Nuevo Empleado ---");

        if (empresas.isEmpty()) {
            System.out.println("¡Error! Debe registrar al menos una empresa antes de agregar empleados.");
            return;
        }

        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Sueldo por Hora: ");
        double sueldoHora = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Tipo de Empleado (1: Desarrollador, 2: GestorProyectos, 3: Admin): ");
        int tipoEmpleado = scanner.nextInt();
        scanner.nextLine();

        System.out.print("NIT de la Empresa a la que pertenece: ");
        String nitEmpresa = scanner.nextLine();

        Empresa empresaAsignada = opEmpresa.buscarEmpresaPorNit(nitEmpresa, empresas);

        if (empresaAsignada == null) {
            System.out.println("Empresa con NIT " + nitEmpresa + " no encontrada. Empleado no asignado.");
            return;
        }

        Empleado nuevoEmpleado = null;
        switch (tipoEmpleado) {
            case 1:
                nuevoEmpleado = new Desarrollador(documento, nombre, sueldoHora, empresaAsignada);
                break;
            case 2:
                System.out.print("Área del Gestor de Proyectos: ");
                String area = scanner.nextLine();
                nuevoEmpleado = new GestorProyectos(documento, nombre, sueldoHora, empresaAsignada, area);
                break;
            case 3:
                nuevoEmpleado = new Admin(documento, nombre, sueldoHora, empresaAsignada);
                break;
            default:
                System.out.println("Tipo de empleado no válido.");
                return;
        }

        opEmpleado.agregarEmpleado(nuevoEmpleado, empleados);

    }

    private static void consultarEmpresas() {
        System.out.println("\n--- Todas las Empresas ---");
        List<Empresa> lista = opEmpresa.obtenerTodasLasEmpresas(empresas);
        if (lista.isEmpty()) {
            System.out.println("No hay empresas registradas.");
        } else {
            for (Empresa emp : lista) {
                System.out.println(emp);
            }
        }
    }

    private static void consultarEmpleados() {
        System.out.println("\n--- Todos los Empleados ---");
        List<Empleado> lista = opEmpleado.obtenerTodosLosEmpleados(empleados);
        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : lista) {
                System.out.println(emp); // Usa el toString() del tipo de Empleado (Desarrollador, Gestor, Admin)
            }
        }
    }

    private static void consultarEmpleadoPorDocumento() {
        System.out.println("\n--- Consultar Empleado por Documento ---");
        System.out.print("Ingrese el documento del empleado: ");
        String documento = scanner.nextLine();

        Empleado empleadoEncontrado = opEmpleado.buscarEmpleadoPorDocumento(documento, empleados);
        if (empleadoEncontrado != null) {
            System.out.println("Empleado encontrado: " + empleadoEncontrado);
        } else {
            System.out.println("Empleado con documento " + documento + " no encontrado.");
        }
    }

    private static void calcularSueldoEmpleado() {
        System.out.println("\n--- Calcular Sueldo de Empleado ---");
        System.out.print("Ingrese el documento del empleado: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese las horas trabajadas: ");
        double horasTrabajadas = scanner.nextDouble();
        scanner.nextLine();

        double sueldoCalculado = opEmpleado.calcularSueldo(documento, horasTrabajadas, empleados);
        if (sueldoCalculado > 0) {
            System.out.printf("El sueldo para el empleado con documento %s es: %.2f%n", documento, sueldoCalculado);
        } else {
            System.out.println("No se pudo calcular el sueldo. Empleado no encontrado o datos inválidos.");
        }
    }

    private static void contarEmpleadosPorEmpresa() {
        System.out.println("\n--- Contar Empleados por Empresa ---");
        System.out.print("Ingrese el NIT de la empresa: ");
        String nitEmpresa = scanner.nextLine();

        int cantidad = opEmpleado.contarEmpleadosEnEmpresa(nitEmpresa, empresas);
        if (cantidad > 0) {
            Empresa empresaEncontrada = opEmpresa.buscarEmpresaPorNit(nitEmpresa, empresas);
            if (empresaEncontrada != null) {
                System.out.println("La empresa '" + empresaEncontrada.getNombre() + "' tiene " + cantidad + " empleados.");
            } else {
                System.out.println("La empresa con NIT " + nitEmpresa + " no tiene empleados o no fue encontrada.");
            }

        } else {
            System.out.println("La empresa con NIT " + nitEmpresa + " no fue encontrada o no tiene empleados.");
        }
    }

    private static class OperacionEmpleado implements IOperacionEmpleado {
        @Override
        public void agregarEmpleado(Empleado empleado, List<Empleado> todosLosEmpleados) {

        }

        @Override
        public Empleado buscarEmpleadoPorDocumento(String documento, List<Empleado> todosLosEmpleados) {
            return null;
        }

        @Override
        public double calcularSueldo(String documento, double horasTrabajadas, List<Empleado> todosLosEmpleados) {
            return 0;
        }

        @Override
        public List<Empleado> obtenerTodosLosEmpleados(List<Empleado> todosLosEmpleados) {
            return List.of();
        }

        @Override
        public int contarEmpleadosEnEmpresa(String nitEmpresa, List<Empresa> listaEmpresas) {
            return 0;
        }

        @Override
        public void agregarEmpleado(Empleado empleado) {

        }
    }
}