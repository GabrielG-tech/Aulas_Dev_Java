package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static java.lang.System.exit;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        String path = "http://localhost:8080/nome?p=";

        JFrame frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JTextField inputField1 = new JTextField();
        JTextField inputField2 = new JTextField();
        JTextField outputField = new JTextField();

        inputField1.setFont((new Font("Arial", Font.PLAIN, 30)));
        inputField2.setFont((new Font("Arial", Font.PLAIN, 30)));

        JLabel label1 = new JLabel("Nome:");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));
        JLabel label2 = new JLabel("Email:");
        label2.setFont((new Font("Arial", Font.BOLD, 30)));


        panel.add(label1);
        panel.add(inputField1);
        panel.add(label2);
        panel.add(inputField2);

        String[] buttonLabels = {"Enviar", "Sair"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        if (label.equals("Enviar")) {
                            String content = inputField1.getText();
                            String url = "http://localhost:8080/nome?p=" + inputField1.getText();
                            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

                            connection.setRequestMethod("GET");
                            int responseCode = connection.getResponseCode();
                            System.out.println("Código de Resposta: " + responseCode);
                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            String linha;
                            StringBuilder resposta = new StringBuilder();
                            while ((linha = reader.readLine()) != null) {
                                resposta.append(linha);
                            }
                            reader.close();
                            System.out.println("Resposta: " + resposta.toString());
                            inputField2.setText(resposta.toString());
                            connection.disconnect();
                        }

                        if (label.equals("Sair")) {
                            System.exit(0);
                        }
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (NumberFormatException ex) {
                        outputField.setText("Erro: Entrada invalida");
                    }
                }
            });
        }
        frame.add(panel);
        frame.setVisible(true);

        port(8080);

        get("/nome", (req, res) -> {
            String nome = req.queryParams("p");
            String email = req.queryParams("p2");
            inputField1.setText(nome);
            inputField2.setText(email);

            outputField.setText(inputField1.getText());

            return "{\n \"" + label1.getText() + "\"\n \"" + inputField1.getText() + "\",\n  \"email\": \"" + inputField2.getText() + "\"\n}\n";
        });

        post("/api", (req, res) -> {
            String corpoRequisicao = req.body();
            System.out.println("Corpo JSON " + corpoRequisicao);

            JsonElement jsonElement = JsonParser.parseString(corpoRequisicao);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            inputField1.setText(jsonObject.get("nome").getAsString());
            inputField2.setText(jsonObject.get("email").getAsString());

            if (inputField1.getText().equals(inputField2.getText()))
                return "{\"ack\":\"1\"}";
            else
                return "{\"ack\":\"0\"}";
        });

        abrirPagWeb("http://localhost:8080/nome?p=Gabriel&p2=gabriel@gmail.com");
    }

    /* https://dontpad.com/071223

 fetch('http://localhost:8080/api', {
 method: 'POST',
 headers: {
 'Content-Type': 'application/json',
 },
 body: JSON.stringify({
 nome: 'Joana',
 email: 'joana@gmail.com',
 }),
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error('Erro:', error));

    */


    // MÉTODO QUE ABRE UMA PÁGINA DA WEB
    public static void abrirPagWeb(String link) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(link));
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println(e);
        }
    }
}
