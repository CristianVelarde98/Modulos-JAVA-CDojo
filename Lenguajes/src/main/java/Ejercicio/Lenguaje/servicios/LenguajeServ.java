package Ejercicio.Lenguaje.servicios;

import Ejercicio.Lenguaje.modelos.Lenguajes;
import Ejercicio.Lenguaje.repositorios.LenguajeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LenguajeServ {
    private final LenguajeRepo repo;

    public LenguajeServ(LenguajeRepo repo) {
        this.repo = repo;
    }

    // traer todos los lenguajes
    public List<Lenguajes> traerTodos(){
        return repo.findAll();
    }

    // crear un nuevo lenguaje
    public Lenguajes crear(Lenguajes nuevo){
        return repo.save(nuevo);
    }

    // traer un lenguaje por id
    public Lenguajes traerLenguaje(Long id){
        Optional<Lenguajes> Lenguaje = repo.findById(id);

        if(Lenguaje.isPresent()){
            return Lenguaje.get();
        } else {
            return null;
        }
    }

    // editar un lenguaje
    public Lenguajes editarLenguaje(Lenguajes editado){
        Lenguajes editLenguaje = traerLenguaje(editado.getId());

        if(editLenguaje == null){
            return null;
        }

        editLenguaje.setAutor(editado.getAutor());
        editLenguaje.setNombre(editado.getNombre());
        editLenguaje.setVersionActual(editado.getVersionActual());

        return repo.save(editLenguaje);
    }

    // eliminar lenguaje
    public void eliminarLenguaje(Long id){
        repo.deleteById(id);
    }
}
