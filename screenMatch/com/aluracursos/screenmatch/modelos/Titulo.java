package com.aluracursos.screenmatch.modelos;

public class Titulo implements Comparable<Titulo>{

    private String nombre;
    private int lanzamiento;
    private int duracionMinutos;
    private boolean incluidoEnPlan;
    private double sumaEvaluacion;
    private int totalEvaluaciones;

    public Titulo(String nombre, int lanzamiento) {
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
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
}
