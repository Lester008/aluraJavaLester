import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Escribe el nombre de la pelicula: ");
        var pelicula = userInput.nextLine();

        String link = "https://www.omdbapi.com/?t=" +pelicula+ "&apikey=504a5966";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(link))
        .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(response.body());

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        //Titulo miTitulo = gson.fromJson(json, Titulo.class);
        TituloOMDB miTituloOMDB = gson.fromJson(json, TituloOMDB.class);
        System.out.println(miTituloOMDB);
        try{
            Titulo miTitulo = new Titulo(miTituloOMDB);
            System.out.println(miTitulo);
        }catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }
        System.out.println("Finalizó la ejecución del programa");
    }
}
