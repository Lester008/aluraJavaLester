import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda  haceConversion(String valorInicial, String valorComparar, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/346e757d2e7c3cd0384aed16/pair/"+valorInicial+"/"+valorComparar+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Hubo un error con la informacion proporcionada.");
        }

    }
}
