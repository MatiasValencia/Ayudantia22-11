package View;

import Model.OperacionesCrud;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OperacionesCrud archivoEmpleados = new OperacionesCrud("listaEmpleados.csv");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        // Menu
        do {
            System.out.println("--------MENU--------");
            System.out.println("1. Agregar un empleado");
            System.out.println("2. Eliminar un empleado");
            System.out.println("3. Modificar un empleado");
            System.out.println("4. Mostrar lista de empleados");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    archivoEmpleados.agregarEmpleados();
                    break;
                case 2:
                    archivoEmpleados.eliminarEmpleado();
                    break;
                case 3:
                    archivoEmpleados.modificarEmpleado();
                    break;
                case 4:
                    archivoEmpleados.mostrarListaEmpleados();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }
}