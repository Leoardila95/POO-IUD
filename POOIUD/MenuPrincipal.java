package com.POOIUD;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;



public class MenuPrincipal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("--- Inicio del Programa de Registro de Personas ---");

            int numeroPersonas = 0;
            boolean entradaValida = false;

            while (!entradaValida) {
                System.out.println("Por favor, ingrese el número de personas a registrar:");
                if (sc.hasNextInt()) {
                    numeroPersonas = sc.nextInt();
                    if (numeroPersonas > 0) {
                        entradaValida = true;
                    } else {
                        System.out.println("El número de personas debe ser mayor que cero.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    sc.next();
                }
                sc.nextLine();
            }

            persona[] listaPersonas = new persona[numeroPersonas];
            System.out.println("\nComenzando el registro de " + numeroPersonas + " personas...");

            for (int i = 0; i < numeroPersonas; i++) {
                System.out.println("\n--- Datos para la Persona #" + (i + 1) + " ---");

                System.out.println("Ingrese el nombre:");
                String nombre = sc.nextLine();

                System.out.println("Ingrese el apellido:");
                String apellido = sc.nextLine();

                System.out.println("Ingrese el género (Masculino/Femenino):");
                String genero = sc.nextLine();

                int edad = leerEdadPorFechaNacimiento(sc);

                listaPersonas[i] = new persona(nombre, apellido, genero, edad);
                System.out.println("Persona #" + (i + 1) + " registrada con éxito.");
            }

            System.out.println("\n--- Resumen de todas las personas registradas ---");
            if (listaPersonas.length == 0) {
                System.out.println("No se registraron personas.");
            } else {
                for (int i = 0; i < listaPersonas.length; i++) {
                    persona p = listaPersonas[i];
                    System.out.println("\nDetalles de la Persona #" + (i + 1) + ":");
                    System.out.println("Nombre: " + p.getNombre());
                    System.out.println("Apellido: " + p.getApellido());
                    System.out.println("Género: " + p.getGenero());
                    System.out.println("Edad: " + p.getEdad());
                }

                double promedioEdades = calcularPromedioEdades(listaPersonas);
                System.out.printf("\nEl promedio de edad de las %d personas ingresadas es: %.2f%n", numeroPersonas, promedioEdades);

                int countMasculinas = contarPersonasMasculinas(listaPersonas);
                int countFemeninas = contarPersonasFemeninas(listaPersonas);

                System.out.println("\n--- Conteo por Género ---");
                System.out.println("Número de personas masculinas: " + countMasculinas);
                System.out.println("Número de personas femeninas: " + countFemeninas);
            }

            System.out.println("\nPrograma finalizado. ¡Hasta luego!");

        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para leer la edad a partir de la fecha de nacimiento
    public static int leerEdadPorFechaNacimiento(Scanner sc) {
        while (true) {
            System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
            String fechaInput = sc.nextLine();
            try {
                LocalDate fechaNacimiento = LocalDate.parse(fechaInput);
                LocalDate hoy = LocalDate.now();
                if (fechaNacimiento.isAfter(hoy)) {
                    System.out.println("La fecha de nacimiento no puede ser en el futuro.");
                    continue;
                }
                return Period.between(fechaNacimiento, hoy).getYears();
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Intente de nuevo (ejemplo: 2000-05-21).");
            }
        }
    }

    public static double calcularPromedioEdades(persona[] personas) {
        if (personas == null || personas.length == 0) {
            return 0.0;
        }
        double sumaEdades = 0;
        for (persona p : personas) {
            sumaEdades += p.getEdad();
        }
        return sumaEdades / personas.length;
    }

    public static int contarPersonasMasculinas(persona[] personas) {
        if (personas == null || personas.length == 0) {
            return 0;
        }
        int contador = 0;
        for (persona p : personas) {
            if (p.getGenero().equalsIgnoreCase("masculino")) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarPersonasFemeninas(persona[] personas) {
        if (personas == null || personas.length == 0) {
            return 0;
        }
        int contador = 0;
        for (persona p : personas) {
            if (p.getGenero().equalsIgnoreCase("femenino")) {
                contador++;
            }
        }
        return contador;
    }
}