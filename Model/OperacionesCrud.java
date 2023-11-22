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
        System.out.println("Ingrese datos del empleado (nombre, rut y sueldo): ");
        String nuevoEmpleado = entradaEmpleado.nextLine();
        entradaEmpleado.close();
        String[] empleadoString = nuevoEmpleado.split(",");
        Empleado datosEmpleado = new Empleado(empleadoString[0], empleadoString[1], Integer.valueOf(empleadoString[2]));
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
}