package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screematch.calculos.Clasificacion;

public class Episodio implements Clasificacion {

    private int numeroEpisodio;
    private String nombreEpisodio;
    private Serie serie;
    private int totalVisualizaciones;

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getNombreEpisodio() {
        return nombreEpisodio;
    }

    public void setNombreEpisodio(String nombreEpisodio) {
        this.nombreEpisodio = nombreEpisodio;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    @Override
    public int getClasificacion() {
        if (totalVisualizaciones > 100){
            return 4;
        }else {
            return 2;
        }
    }
}
