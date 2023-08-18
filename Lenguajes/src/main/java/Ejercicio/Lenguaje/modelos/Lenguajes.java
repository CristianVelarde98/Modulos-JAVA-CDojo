package Ejercicio.Lenguaje.modelos;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lenguajes")
public class Lenguajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 20, message = "El nombre del libro debe tener entre 2 y 20 caracteres")
    private String nombre;

    @Size(min = 2, max = 20, message = "El nombre del autor debe tener entre 2 y 20 caracteres")
    private String autor;

    @NotEmpty
    private String versionActual;

    public Lenguajes(){}

    public Lenguajes(Long id, String nombre, String autor, String versionActual) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.versionActual = versionActual;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersionActual() {
        return versionActual;
    }

    public void setVersionActual(String versionActual) {
        this.versionActual = versionActual;
    }
}
