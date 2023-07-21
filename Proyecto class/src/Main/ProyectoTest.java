package Main;
import Proyecto.Proyecto;

public class ProyectoTest {
    static public void main(String[] args){
        Proyecto NuevoProyecto = new Proyecto();

        // sobrecarga del metodo Proyecto
        Proyecto hozpital = new Proyecto("Hozpital Aleman");
        Proyecto hozpitalNuevo = new Proyecto("Santa Isabel", "descripcion del proyecto bla bla bla bla");

        // metodo elevatorPitch
        String infoDelProyecto = hozpital.elevatorPitch();
        System.out.println(infoDelProyecto);

        // getter y setter
        String nombreDelProyecto = hozpital.getNombre();
        System.out.println("Nombre anterior: " + nombreDelProyecto);
        hozpital.setNombre("Hozpital Duran");
        nombreDelProyecto = hozpital.getNombre();
        System.out.println("Nuevo nombre: " +nombreDelProyecto);

        String descripcionDelProyecto = hozpital.getDescripcion();
        System.out.println("Vieja descripcion: "+ descripcionDelProyecto);
        hozpital.setDescripcion("nueva descripcion del proyecto");
        descripcionDelProyecto = hozpital.getDescripcion();
        System.out.println("Nueva descripcion: " +descripcionDelProyecto);
    }
}
