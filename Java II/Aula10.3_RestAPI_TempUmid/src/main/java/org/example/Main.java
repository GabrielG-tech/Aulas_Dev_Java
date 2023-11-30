package org.example;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

import com.google.gson.*;

import javax.swing.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Temperatura e Umidade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320,150);
        frame.setLocation(750, 450);

        try {
            String apiKey = "ca0c08d680c3440dadfa5652f84c7388";
            String cidade = "Rio de Janeiro";
            String unidadeDeMedida = "metric"; // Celsius

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

                //System.out.println(response.toString());
                //System.out.println("Resposta da API: " + response.toString());

                JsonElement jsonElement = JsonParser.parseString(response.toString());
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                String cityName = jsonObject.get("name").getAsString();
                JsonObject main = jsonObject.getAsJsonObject("main");
                double temperature = main.get("temp").getAsDouble();
                int humidity = main.get("humidity").getAsInt();
                JsonArray weatherArray = jsonObject.getAsJsonArray("weather");
                JsonObject weather = weatherArray.get(0).getAsJsonObject();
                String weatherDescription = weather.get("description").getAsString();

                frame.setLayout(new GridLayout(4, 1));

                JLabel label1 = new JLabel("Cidade: " + cityName);
                frame.add(label1);

                JLabel label2 = new JLabel("Temperatura: " + temperature + "°C");
                frame.add(label2);

                JLabel label3 = new JLabel("Umidade: " + humidity + "%");
                frame.add(label3);

                JLabel label4 = new JLabel("Descrição do clima: " + weatherDescription);
                frame.add(label4);


                final JPanel contentPanel = (JPanel)frame.getContentPane();
                frame.setVisible(true);

                while (true) {
                    Thread.sleep(5000);
                    label1.setText("Cidade: " + cityName);
                    label2.setText("Temperatura: " + temperature + "°C");
                    label3.setText("Umidade: " + humidity + "%");
                    label4.setText("Descrição do clima: " + weatherDescription);
                }
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}