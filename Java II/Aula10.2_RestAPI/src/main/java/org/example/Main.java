package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {
        try {
            // Defina a URL da API REST que você deseja acessar
            String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

            // Crie uma conexão HttpURLConnection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();

            // Configure o método HTTP para GET
            connection.setRequestMethod("GET");

            // Obtenha a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // Leitura da resposta da API
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                reader.close();
                System.out.println(response.toString());

                JsonElement jsonElement = JsonParser.parseString(response.toString());
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                System.out.println("User Id: " + jsonObject.get("userId").getAsString());
                System.out.println("Id: " + jsonObject.get("id").getAsString());
                System.out.println("Title: " + jsonObject.get("title").getAsString());
                System.out.println("Body: " + jsonObject.get("body").getAsString());

            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
