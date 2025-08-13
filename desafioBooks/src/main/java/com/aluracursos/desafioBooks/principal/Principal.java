package com.aluracursos.desafioBooks.principal;

import com.aluracursos.desafioBooks.model.Datos;
import com.aluracursos.desafioBooks.model.DatosLibros;
import com.aluracursos.desafioBooks.service.ConsumoAPI;
import com.aluracursos.desafioBooks.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json,Datos.class);
        System.out.println(datos);

        //Top 10 libros mas descargados
        System.out.println("Top 10 libros mas descargados");
        datos.Libros().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros por nombre
        System.out.println("Ingresa el nombre del libro que desa buscar:");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.Libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()){
            System.out.println("Libro encontrado: ");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }

        //Trabajando con estadisticas
        DoubleSummaryStatistics est = datos.Libros().stream()
                .filter(d -> d.numeroDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDescargas));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad maxima de descargas: " + est.getMax());
        System.out.println("Cantidad minima de descargas: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para estadistica: " + est.getCount());
    }
}
