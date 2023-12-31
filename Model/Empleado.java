package Model;

public class Empleado {
    private String nombre;
    private String rut;
    private int sueldo;

    public Empleado(String nombre, String rut, int sueldo){
        this.nombre = nombre;
        this.rut = rut;
        this.sueldo = sueldo;
    }

    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public int getSueldo(){
        return sueldo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setSueldo(int sueldo){
        this.sueldo = sueldo;
    }
    @Override
    public String toString(){
        return nombre + "," + rut + "," + sueldo;
    }
}