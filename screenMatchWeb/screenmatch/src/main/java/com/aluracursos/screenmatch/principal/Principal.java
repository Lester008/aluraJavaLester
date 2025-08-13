package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.*;
import com.aluracursos.screenmatch.repository.SerieRepository;
import service.ConsumoAPI;
import service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=504a5966";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosSerie> datosSeries = new ArrayList<>();
    private SerieRepository repositorio;
    private List<Serie> series;
    private Optional<Serie> serieBuscada;

    public Principal(SerieRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {

        var opcion = -1;
        while (opcion != 0){
            var menu = """
                    1 - Buscar Series
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                    4 - Buscar series por titulo
                    5 - Top 5 mejores series
                    6 - Buscar serie por categoria
                    7 - Filtrar series por temporadas
                    8 - Buscar episodios por nombre
                    9 - Top 5 mejores episodios por serie
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriesPorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarSeriePorCategoria();
                    break;
                case 7:
                    filtrarSeriesPorTemporadaYEvaluacion();
                    break;
                case 8:
                    buscarEpisodiosPorTitulo();
                    break;
                case 9:
                    buscarTop5Episodios();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicacion...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }

        /*System.out.println("Por favor escribe el nombre de la serie que deseas buscar:");
        //Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas
        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());

            }
        }

        //funcion lambda
        // temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista datos episodios
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        //Top 5 episodios
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                //.peek(e -> System.out.println("Pasando por el primer filtro (N/A)" + e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                //.peek(e -> System.out.println("Segundo filtro (ordenacion M>m)" + e))
                .map(e -> e.titulo().toUpperCase())
                //.peek(e -> System.out.println("Tercer filtro (Mayusculas m>M)" + e))
                .limit(5)
                .forEach(System.out::println);

        //Convirtiendo los datos a una lista del tipo Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        //Busqueda de episodios apartir de alguna fecha
        System.out.println("Por favor indica el año a partir del cual mdeseas ver los episodios");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada " + e.getTemporada() +
                                "Episodio " + e.getTitulo() +
                                "Fecha de lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
                ));*/

        //Busca episodios por pedazos del titulo
        /*System.out.println("Por favor escriba el titulo que desa ver");
        var pedazoTitulo = teclado.nextLine();

        Optional<Episodio> episodioBuscar = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if(episodioBuscar.isPresent()){
            System.out.println("Episodio encontrado");
            System.out.println("Los datos son: " + episodioBuscar.get());
        }else {
            System.out.println("Episodio no encontrado");
        }*/

       /* Map<Integer, Double> evaluacionesPorTemporadas = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporadas);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media de las evaluaciones: " + est.getAverage());
        System.out.println("Episodio mejor evaluado: " + est.getMax());
        System.out.println("Episodio peor evaluado: " + est.getMin());*/
    }


    private DatosSerie getDatosSerie(){
        System.out.println("Escribe el nombre de la serie que desas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        return datos;
    }

    private void buscarEpisodioPorSerie(){
        //DatosSerie datosSerie = getDatosSerie();
        mostrarSeriesBuscadas();
        System.out.println("Escribe el nombre de la seria de la que quieres ver los episodios");
        var nombreSerie = teclado.nextLine();
        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();

        if(serie.isPresent()){
            var serieEncontrada = serie.get();
            List<DatosTemporadas> temporadas = new ArrayList<>();
            for (int i = 1; i <= serieEncontrada.getTotalDeTemporadas(); i++) {
                var json = consumoApi.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season="+ i + API_KEY);
                DatosTemporadas datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporadas);
            }
            temporadas.forEach(System.out::println);
            List<Episodio> episodios = temporadas.stream()
                    .flatMap( d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());
           serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        }
    }

    private void buscarSerieWeb(){
        DatosSerie datos = getDatosSerie();
        //datosSeries.add(datos);
        Serie serie = new Serie(datos);
        repositorio.save(serie);
        System.out.println(datos);
    }

    private void mostrarSeriesBuscadas() {
        /*List<Serie> series = new ArrayList<>();
        series = datosSeries.stream()
                .map(d -> new Serie(d))
                .collect(Collectors.toList());*/
        series = repositorio.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriesPorTitulo(){
        System.out.println("Escribe el nombre de la seria que deseas buscar");
        var nombreSerie = teclado.nextLine();

        serieBuscada = repositorio.findByTituloContainsIgnoreCase(nombreSerie);
        if(serieBuscada.isPresent()){
            System.out.println("La serie buscada es: " + serieBuscada.get());
        }else{
            System.out.println("La serie que ingresaste no fue encontrada");
        }
    }

    private void buscarTop5Series(){
        List<Serie> topSeries = repositorio.findTop5ByOrderByEvaluacionDesc();
        topSeries.forEach(s -> System.out.println("Seire: " + s.getTitulo() + "Evaluacion: " + s.getEvaluacion()));
    }

    private void buscarSeriePorCategoria(){
        System.out.println("Escribe el genero/categoria de la serie que desas buscar");
        var genero = teclado.nextLine();
        var categoria = Categoria.fromEspanol(genero);
        List<Serie> seriePorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Las series de la categoria " + genero);
        seriePorCategoria.forEach(System.out::println);
    }

    public void filtrarSeriesPorTemporadaYEvaluacion(){
        System.out.println("¿Filtrar series con cuantas temporadas? ");
        var totalTemporadas = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Agrega la evaluacion minima: ");
        var evaluacion = teclado.nextDouble();
        teclado.nextLine();
        //List<Serie> filtroSeries = repositorio.findByTotalDeTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(totalTemporadas, evaluacion);
        List<Serie> filtroSeries = repositorio.seriesPorTemporadaYEvaluacion(totalTemporadas, evaluacion);
        System.out.println("*** Series Filtradas ***");
        filtroSeries.forEach(s -> System.out.println(s.getTitulo() + " - evaluacion: " + s.getEvaluacion()));
    }

    private void buscarEpisodiosPorTitulo(){
        System.out.println("Escribe el nombre del episodio a buscar:");
        var nombreEpisodio = teclado.nextLine();
        List<Episodio> episodiosEncontrados = repositorio.episodiosPorNombre(nombreEpisodio);
        episodiosEncontrados.forEach(e -> System.out.printf("Serie: %s Temporada %s Episodio %s Evaluacion %s\n",
                e.getSerie(), e.getTemporada(), e.getNumeroEpisodio(), e.getEvaluacion()));
    }

    private void buscarTop5Episodios(){
        buscarSeriesPorTitulo();
        if (serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            List<Episodio> topEpisodios = repositorio.top5Episodios(serie);
            topEpisodios.forEach(e -> System.out.printf("Serie: %s Temporada %s Episodio %s Evaluacion %s\n",
                            e.getSerie(), e.getTemporada(), e.getTitulo(), e.getEvaluacion()));
        }
    }

}

/*
package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("TU-API-KEY");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}

//apikey
AIzaSyB0JbM3GAkzBADrffo0t4fYWLStv6OHtic

 */

/*
public class ConsultaGemini {}
public class ConsultaGemini {
    public static String obtenerTraduccion(String texto) {

    }
}
public class ConsultaGemini {
    public static String obtenerTraduccion(String texto) {
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Traduce el siguiente texto al español: " + texto;

        Client cliente = new Client.Builder().apiKey("TU-CLAVE-API").build();
    }
}

public class ConsultaGemini {
    public static String obtenerTraduccion(String texto) {
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Traduce el siguiente texto al español: " + texto;

        Client cliente = new Client.Builder().apiKey("TU-CLAVE-API").build();

        try {
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null // Parámetro para configuraciones adicionales
            );

            if (!respuesta.text().isEmpty()) {
                return respuesta.text();
            }
        } catch (Exception e) {
            System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
        }

        return null;
    }
}
* */
