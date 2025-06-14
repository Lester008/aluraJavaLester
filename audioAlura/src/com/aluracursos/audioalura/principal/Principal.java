package com.aluracursos.audioalura.principal;

import com.aluracursos.audioalura.modelos.Cancion;
import com.aluracursos.audioalura.modelos.MisFavoritos;
import com.aluracursos.audioalura.modelos.Podcast;

public class Principal {
    public static void main(String[] args){
        Cancion miCancion = new Cancion();
        miCancion.setTitulo("November Rain");
        miCancion.setCantante("Gunds And Roses");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("Gabriela Aguiar");
        miPodcast.setTitulo("Cafe.Tech");
// Canciones
        for (int i = 0; i < 100000; i++) {
            miCancion.meGusta();
        }
        for (int i = 0; i < 500000; i++) {
            miCancion.reproduce();
        }
// Podcast
        for (int i = 0; i < 250; i++) {
            miPodcast.meGusta();
        }

        for (int i = 0; i < 2690; i++) {
            miPodcast.reproduce();
        }

        System.out.println("*************************** Canción ************************************");
        System.out.println("El artista es: " + miCancion.getCantante());
        System.out.println("La cancion elegida fue: " + miCancion.getTitulo());
        System.out.println("Total de reproducciones " + miCancion.getReproducciones());
        System.out.println("Total de megusta " + miCancion.getTotalMegusta());

        System.out.println("\n*************************** Podcast ************************************");
        System.out.println("El presentador es: " + miPodcast.getPresentador());
        System.out.println("El titulo de esta vez fue: " + miPodcast.getTitulo());
        System.out.println("Total de reproducciones: " + miPodcast.getReproducciones());
        System.out.println("Total de megusta: " + miPodcast.getTotalMegusta() + "\n");

        MisFavoritos favoritos = new MisFavoritos();
        favoritos.adiciones(miPodcast);
        favoritos.adiciones(miCancion);
        System.out.println();
    }
}
