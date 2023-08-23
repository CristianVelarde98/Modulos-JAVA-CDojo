package Lookify.Lookify.servicios;

import Lookify.Lookify.modelos.MusicModel;
import Lookify.Lookify.repositorios.MusicRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServices {
    private final MusicRepo repo;

    public MusicServices(MusicRepo repo) {
        this.repo = repo;
    }

    // pedir todas las canciones
    public List<MusicModel> traerTodos(){
        return repo.findAll();
    }

    // crear una cancion nueva
    public MusicModel crear(MusicModel nuevo){
        return repo.save(nuevo);
    }

    // traer una cancion por id
    public MusicModel traerPorId(Long id){
        Optional<MusicModel> song = repo.findById(id);

        if(song.isPresent()){
            return song.get();
        } else {
            return null;
        }
    }

    // editar un cancion
    public MusicModel editar(MusicModel songEdit){
        MusicModel song = traerPorId(songEdit.getId());

        if(song == null){
            return null;
        }

        song.setArtista(songEdit.getArtista());
        song.setTitulo(songEdit.getTitulo());
        song.setClasificacion(songEdit.getClasificacion());

        return repo.save(song);
    }

    // eliminar cancion
    public void eliminarCancion(Long id){
        repo.deleteById(id);
    }

    // buscar por artista
    public List<MusicModel> buscarPorArtista(String artista){
        return repo.buscarPorArtista(artista);
    }

    // traer las 10 mejores
    public List<MusicModel> traerTopDiez(){
        return repo.buscarTopDiez();
    }
}
