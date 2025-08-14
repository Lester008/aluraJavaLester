package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
   Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);
   List<Serie> findTop5ByOrderByEvaluacionDesc();
   List<Serie> findByGenero(Categoria categoria);
   List<Serie> findByTotalDeTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);
   //Ejemplo de native Query
   /*@Query(value = "SELECT * FROM series\n" +
                    "WHERE series.total_De_temporadas <= 6\n" +
                    "AND series.evaluacion >= 7.5", nativeQuery = true)*/

   /*"*****************************************************************************************************************************************
    * **************************************************************************************************************************************"*/
   //Ejemplo de JPQL o Java Persistant Query Lenguage
   @Query("SELECT s FROM Serie s\n" +
           "WHERE s.totalDeTemporadas <= :totalTemporadas\n" +
           "AND s.evaluacion >= :evaluacion")
   List<Serie> seriesPorTemporadaYEvaluacion(int totalTemporadas, Double evaluacion);

   @Query("SELECT e FROM Serie s\n" +
            "JOIN s.episodios e\n" +
           "WHERE e.titulo ILIKE %:nombreEpisodio%")
   List<Episodio> episodiosPorNombre(String nombreEpisodio);

   @Query("SELECT e FROM Serie s\n" +
           "JOIN s.episodios e\n" +
           "WHERE s = :serie\n" +
            "ORDER BY e.evaluacion DESC LIMIT 5")
   List<Episodio> top5Episodios(Serie serie);

   @Query("SELECT s FROM Serie s\n" +
           "JOIN s.episodios e\n" +
           "GROUP BY s\n" +
           "ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
   List<Serie> lanzamientosMasRecientes();
}
