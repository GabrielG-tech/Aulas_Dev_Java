package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

import com.google.gson.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        try {
            String apiKey = "4c550ba859cc1dd1af453a0e4dcd9124";
            String cidade = "Rio de Janeiro";
            String unidadeDeMedida = "metric"; // Celsius

            try {
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cidade + "&units="
                        + unidadeDeMedida + "&appid=" + apiKey;
                URL obj = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    System.out.println(response.toString());
                    System.out.println("Resposta da API: " + response.toString());
                    JsonElement jsonElement = JsonParser.parseString(response.toString());
                    JsonObject jsonObject = jsonElement.getAsJsonObject();

                    String cityName = jsonObject.get("name").getAsString();
                    JsonObject main = jsonObject.getAsJsonObject("main");
                    double temperature = main.get("temp").getAsDouble();
                    int humidity = main.get("humidity").getAsInt();
                    JsonArray weatherArray = jsonObject.getAsJsonArray("weather");
                    JsonObject weather = weatherArray.get(0).getAsJsonObject();
                    String weatherDescription = weather.get("description").getAsString();

                    System.out.println("City: " + cityName);
                    System.out.println("Temperature: " + temperature + "°C");
                    System.out.println("Humidity: " + humidity + "%");
                    System.out.println("Weather Description: " + weatherDescription);


                } else {
                    System.out.println("Erro na requisição. Código de resposta: " + responseCode);
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}