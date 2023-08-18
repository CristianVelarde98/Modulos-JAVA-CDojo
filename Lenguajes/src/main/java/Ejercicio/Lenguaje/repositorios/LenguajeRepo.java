package Ejercicio.Lenguaje.repositorios;

import Ejercicio.Lenguaje.modelos.Lenguajes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenguajeRepo extends CrudRepository<Lenguajes, Long> {
    List<Lenguajes> findAll();
}
