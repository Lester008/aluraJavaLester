package com.aluracursos.frases_screenmatch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FraseRepository extends JpaRepository<Frase, Long> {
    @Query("SELECT f FROM Frase f\n" +
            "ORDER BY function('RANDOM') LIMIT 1")
    public Frase obtenerFraseAleatoria();
}
