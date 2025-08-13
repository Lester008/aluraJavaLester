import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Escribe el  numero de la pelicula de Star Wars a consultar");
        try {
            var bumeroPelicula = Integer.valueOf(teclado.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(bumeroPelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        }catch (NumberFormatException e) {
            System.out.println("Numero no encontrado "+e.getMessage());
        }catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
