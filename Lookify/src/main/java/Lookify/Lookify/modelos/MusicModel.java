package Lookify.Lookify.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Songs")
public class MusicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, message = "El titulo debe tener minimo 5 caracteres")
    private String titulo;

    @Size(min = 5, message = "El nombre del artista debe tener minimo 5 caracteres")
    private String artista;

    @Min(value = 1, message = "La clasificacion debe ser estar entre 1 y 10")
    @Max(value = 10, message = "La clasificacion debe ser estar entre 1 y 10")
    private int clasificacion;

    public MusicModel() {}

    public MusicModel(String titulo, String artista, int clasificacion) {
        this.titulo = titulo;
        this.artista = artista;
        this.clasificacion = clasificacion;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

}
