import com.aluracursos.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

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

        Gson gson = new Gson();
        Titulo miTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(miTitulo);
    }
}
