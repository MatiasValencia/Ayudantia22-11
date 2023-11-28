package Model;

import java.util.*;
import java.io.*;

public class OperacionesCrud {
    private ArrayList<Empleado> listaEmpleados;
    private String nombreArchivo;

    public OperacionesCrud(String nombreArchivo){
        listaEmpleados = new ArrayList<>();
        this.nombreArchivo = "listaEmpleados.csv";
    }
    public ArrayList<String> listaEmpleadosString() {
        ArrayList<String> aux = new ArrayList<>();
        for (Empleado e : listaEmpleados) {
            aux.add(e.toString());
        }
        return aux;
    }
    // Agregar empleados
    public void agregarEmpleados() {
        Scanner entradaEmpleado = new Scanner(System.in);
        System.out.println("Ingrese nombre del empleado: ");
        String nombre = entradaEmpleado.nextLine();
        System.out.println("Ingrese rut del empleado: ");
        String rut = entradaEmpleado.nextLine();
        System.out.println("Ingrese sueldo del empleado: ");
        int sueldo = entradaEmpleado.nextInt();
        entradaEmpleado.close();
        Empleado datosEmpleado = new Empleado(nombre, rut, sueldo);
        listaEmpleados.add(datosEmpleado);
        // Escribir datos al archivo
        ArrayList<String> aux = listaEmpleadosString();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            for (String e : aux) {
                bw.write(e);
            }
            bw.close();
        } catch(Exception e) {
            System.out.println("No se encontró el archivo.");
        }
    }
    // Guardar empleados
    public void guardarEmpleados() {
        ArrayList<String> aux = listaEmpleadosString();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            for (String e : aux) {
                bw.write(e);
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("No se encontró el archivo.");
        }
    }
    // Mostrar una lista de empleados
    public void mostrarListaEmpleados() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo.");
        }
    }
    // Eliminar un empleado
    public void eliminarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el RUT del empleado que desea eliminar: ");
        String rut = scanner.nextLine();
        scanner.close();
        // Buscamos al empleado en la lista por su RUT
        Empleado empleadoPorEliminar = null;
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getRut().equals(rut)) {
                empleadoPorEliminar = empleado;
                break;
            }
        }
        // Eliminamos al empleado de la lista
        if (empleadoPorEliminar != null) {
            listaEmpleados.remove(empleadoPorEliminar);
            // Actualizamos el archivo
            ArrayList<String> aux = listaEmpleadosString();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
                for (String e : aux) {
                    bw.write(e);
                }
                bw.close();
            } catch (Exception e) {
                System.out.println("No se encontró el archivo.");
            }
        } else {
            System.out.println("No se ha encontrado al empleado con el RUT especificado");
        }
    }
    // Modificar un empleado
    public void modificarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el RUT del empleado que desea modificar: ");
        String rut = sc.nextLine();
        // Buscamos al empleado en la lista por su RUT
        Empleado empleadoPorModificar = null;
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getRut().equals(rut)) {
                empleadoPorModificar = empleado;
                break;
            }
        }
        // Modificamos los datos del empleado
        if (empleadoPorModificar != null) {
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            System.out.println("Ingrese su nuevo sueldo: ");
            int nuevoSueldo = sc.nextInt();
            sc.close();
            empleadoPorModificar.setNombre(nuevoNombre);
            empleadoPorModificar.setSueldo(nuevoSueldo);
            // Actualizamos el archivo
            ArrayList<String> aux = listaEmpleadosString();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
                for (String e : aux) {
                    bw.write(e);
                }
                bw.close();
            } catch (Exception e) {
                System.out.println("No se encontró el archivo.");
            }
        }
    }
}