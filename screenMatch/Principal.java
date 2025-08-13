import com.aluracursos.screematch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screematch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionMinutos(120);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        //System.out.println(miPelicula.sumaEvaluacion);
        System.out.println(miPelicula.getTotalEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        System.out.println("Mi pelicula es: " + miPelicula.getNombre());
        System.out.println("Su fecha de lanzamineto fue en el " + miPelicula.getLanzamiento());
        System.out.println("Y tiene una duracion de " + miPelicula.getDuracionMinutos() + " minutos");

        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.setDuracionMinutos(100);

        System.out.println("\nMi otra pelicula es: " + otraPelicula.getNombre());
        System.out.println("Su fecha de lanzamineto fue en el " + otraPelicula.getLanzamiento());
        System.out.println("Y tiene una duracion de " + otraPelicula.getDuracionMinutos() + " minutos");

        otraPelicula.muestraFichaTecnica();

        Serie casaDragon = new Serie("La casa del Dragon", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosEpisodio(50);
        casaDragon.setEpisodiosTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionMinutos());
        System.out.println("/****************************************************************/\n");

        CalculadoraDeTiempo caluladora = new CalculadoraDeTiempo();
        caluladora.incluye(miPelicula);
        caluladora.incluye(casaDragon);
        caluladora.incluye(otraPelicula);
        System.out.println("Tiempo estimado para verlos los titulos seleccionados: " + caluladora.getTiempoTotal() + " minutos");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filter(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumeroEpisodio(1);
        episodio.setNombreEpisodio("El primero de los capitulos");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);
        filtroRecomendacion.filter(episodio);

        var peliculaNuevoCurso = new Pelicula("El señor de los anillos", 2001);
        peliculaNuevoCurso.setDuracionMinutos(180);

        ArrayList<Pelicula> listadePeliculas = new ArrayList<>();
        listadePeliculas.add(miPelicula);
        listadePeliculas.add(otraPelicula);
        listadePeliculas.add(peliculaNuevoCurso);

        System.out.println("Tamaño del array: " + listadePeliculas.size());
        System.out.println("La primer pelicula es: " + listadePeliculas.get(0).getNombre());
        System.out.println(listadePeliculas);
        System.out.println("toString de la pelicula: " + listadePeliculas.get(0).toString());


    }
}
