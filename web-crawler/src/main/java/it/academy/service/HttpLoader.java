package it.academy.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpLoader {

    HttpClient client = HttpClient.newHttpClient();

    public String get(String seed) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://en.wikipedia.org/wiki/Elon_Musk"))
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException  e) {
            e.printStackTrace();
        }
        return "";
    }
}
