package com.aluracursos.screematch.calculos;

public class FiltroRecomendacion {
    public void filter(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado en el momento");
        }else if (clasificacion.getClasificacion() >=3 && clasificacion.getClasificacion() < 4){
            System.out.println("Popular en el momento");
        }else {
            System.out.println("Colocalo en tu lista para ver despues");
        }
    }
}
