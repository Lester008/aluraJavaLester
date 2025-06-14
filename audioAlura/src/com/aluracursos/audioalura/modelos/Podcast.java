package com.aluracursos.audioalura.modelos;

public class Podcast extends Audio{
    private String presentador;
    private String descripcion;

    @Override
    public int getClasificacion() {
        if (getReproducciones() >= 2000){
            return 9;
        }else {
            return 3;
        }
    }

    public String getPresentador() {
        return presentador;
    }

    public void setPresentador(String presentador) {
        this.presentador = presentador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
