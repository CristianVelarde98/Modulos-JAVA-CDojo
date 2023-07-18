package Proyecto;

public class Proyecto {
    private String nombre;
    private   String descripcion;

    public String elevatorPitch(){
        return "Nombre: " + nombre + " : " + "Descripcion: " + descripcion;
    }

    public void Proyecto(){
        System.out.println("soy el metodo basico Proyecto");
    }

    public void Proyecto(String name){
        this.nombre = name;
        System.out.println("El nombre de su proyecto es: " + name);
    }

    public void Proyecto(String name, String description){
        this.nombre = name;
        this.descripcion = description;
        System.out.println("El nombre de su proyecto es: " + name);
        System.out.println("Descripcion del proyecto: " + description);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
