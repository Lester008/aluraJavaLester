package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{

    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int lanzamiento;
    private int duracionMinutos;
    private boolean incluidoEnPlan;
    private double sumaEvaluacion;
    private int totalEvaluaciones;

    public Titulo(String nombre, int lanzamiento) {
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
    }

    public Titulo(TituloOMDB miTituloOMDB) {
        this.nombre = miTituloOMDB.title();
        this.lanzamiento = Integer.valueOf(miTituloOMDB.year());
        if (miTituloOMDB.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No se pudo convertir la duración, contiene N/A");
        }
        this.duracionMinutos = Integer.valueOf(miTituloOMDB.runtime().substring(0,3).replace(" ", ""));
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLanzamiento(int lanzamiento){
        this.lanzamiento = lanzamiento;
    }

    public void setDuracionMinutos(int duracionMinutos){
        this.duracionMinutos = duracionMinutos;
    }

    public void setIncluidoEnPlan(boolean incluidoEnPlan){
        this.incluidoEnPlan = incluidoEnPlan;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public boolean isIncluidoEnPlan() {
        return incluidoEnPlan;
    }

    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + lanzamiento);
        System.out.println("Tiene una duracion en minutos de:" + getDuracionMinutos());
    }

    public void evalua(double nota){
        sumaEvaluacion += nota;
        totalEvaluaciones ++;
    }

    public double calculaMedia(){
        return sumaEvaluacion / totalEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", lanzamiento=" + lanzamiento +
                ", duración=" + duracionMinutos;
    }
}
