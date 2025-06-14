package com.aluracursos.audioalura.modelos;

public class Audio {
    private String titulo;
    private int reproducciones;
    private int totalMegusta;
    private int clasificacion;
    private double duracion;

    public void meGusta(){
        this.totalMegusta++;
    }

    public void reproduce(){
        this.reproducciones++;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public int getTotalMegusta() {
        return totalMegusta;
    }

    public void setTotalMegusta(int totalMegusta) {
        this.totalMegusta = totalMegusta;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
