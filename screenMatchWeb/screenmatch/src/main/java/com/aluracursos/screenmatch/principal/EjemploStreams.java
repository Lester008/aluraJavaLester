package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Locale.filter;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Brenda", "Luis", "Maria Fernanda", "Eric", "Genesys");

        nombres.stream()
                .sorted()
                .limit( 5)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }
}
