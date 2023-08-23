package Lookify.Lookify.repositorios;

import Lookify.Lookify.modelos.MusicModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepo extends CrudRepository<MusicModel, Long> {
    List<MusicModel> findAll();

    @Query("SELECT m FROM MusicModel m WHERE LOWER(m.artista) LIKE %:artista%")
    List<MusicModel> buscarPorArtista(@Param("artista") String artista);

    @Query("SELECT m FROM MusicModel m ORDER BY m.clasificacion DESC LIMIT 10")
    List<MusicModel> buscarTopDiez();
}
