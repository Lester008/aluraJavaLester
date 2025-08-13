package com.aluracursos.audioalura.modelos;

public class MisFavoritos {

    public void adiciones(Audio audio){
        if (audio.getClasificacion() >= 8){
            System.out.println(audio.getTitulo() + " Es uno de los favoritos del momento");
        }else {
            System.out.println(audio.getTitulo() + " Es uno de los menos escuchados");
        }
    }
}
