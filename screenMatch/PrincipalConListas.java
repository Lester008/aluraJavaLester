import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalConListas {
    public static void main(String[] args){

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        var peliculaNuevoCurso = new Pelicula("El señor de los anillos", 2001);

        Serie casaDragon = new Serie("La casa del Dragon", 2022);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaNuevoCurso);
        lista.add(casaDragon);

        for (Titulo item: lista){
            System.out.println(item);
            if (item instanceof Pelicula pelicula) {
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaArtistas = new ArrayList<>();
        listaArtistas.add("Penelope Cruz");
        listaArtistas.add("Antonio Banderas");
        listaArtistas.add("Ricardo Darin");
        System.out.println("Lista de artistas no ordenada: " + listaArtistas);

        Collections.sort(listaArtistas);
        System.out.println("Lista de artistas ordenada: " + listaArtistas);

        Collections.sort(lista);
        System.out.println("Lista ordenada de Titulos: " + lista);

        lista.sort(Comparator.comparing(Titulo::getLanzamiento));
    }
}
