package com.conversorDeMonedasAlura.servicios;

import com.conversorDeMonedasAlura.modelos.Moneda;
import com.google.gson.Gson;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaApi {
    private static final String API_KEY = "32c78953319e26df504e999c";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public Moneda convertirMoneda(String monedaActual, String monedaObtenida, double cantidad) {

        String url = API_URL + API_KEY + "/pair/" +
                monedaActual + "/" +
                monedaObtenida + "/" +
                cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la solicitud: Código de estado " + response.statusCode());
            }

            return  new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al procesar la solicitud");
        }

    }

}
