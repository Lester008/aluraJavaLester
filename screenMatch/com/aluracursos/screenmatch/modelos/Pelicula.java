package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screematch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

    public Pelicula(String nombre, int lanzamiento){
        super(nombre, lanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculaMedia() / 2);
    }

    public String toString(){
        return "Pelicula: " + this.getNombre() + " (" + getLanzamiento() + ")";

    }
}

