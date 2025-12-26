package se.gritacademy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClientApplication {

    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Fulköpings Köp & Sälj ---");
            System.out.println("1. Lista alla annonser");
            System.out.println("0. Avsluta");
            System.out.print("Välj ett alternativ: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        HttpClient client = HttpClient.newHttpClient();

                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(BASE_URL + "/annonser"))
                                .GET()
                                .build();

                        HttpResponse<String> response =
                                client.send(request, HttpResponse.BodyHandlers.ofString());

                        System.out.println("\n--- Resultat ---");
                        System.out.println(response.body());

                    } catch (Exception e) {
                        System.out.println("Kunde inte hämta annonser.");
                        e.printStackTrace();
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Programmet avslutas.");
                    break;

                default:
                    System.out.println("Fel val, försök igen.");
            }
        }

        scanner.close();
    }

    private static void listAllAnnons() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/annons"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("\n--- Resultat ---");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Kunde inte hämta annonser.");
            e.printStackTrace();
        }
    }
}
