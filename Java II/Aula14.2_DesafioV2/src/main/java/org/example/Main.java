package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        //String path = "http://localhost:8080/massa?p=";

        JFrame frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JTextField inputField1 = new JTextField();
        JTextField inputField2 = new JTextField();
        JTextField outputField = new JTextField();

        inputField1.setFont((new Font("Arial", Font.PLAIN, 30)));
        inputField2.setFont((new Font("Arial", Font.PLAIN, 30)));

        JLabel label1 = new JLabel("Massa:");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));
        JLabel label2 = new JLabel("Altura:");
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
                            try {
                                String url = "http://localhost:4567/api"; // Rota do servidor Spark
                                JSONObject requestData = new JSONObject();
                                requestData.put("altura", inputField2.getText());
                                requestData.put("massa", inputField1.getText());

                                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                                connection.setRequestMethod("POST");
                                connection.setRequestProperty("Content-Type", "application/json");
                                connection.setDoOutput(true);

                                try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                                    outputStream.writeBytes(requestData.toString());
                                    outputStream.flush();
                                }

                                int responseCode = connection.getResponseCode();
                                if (responseCode == HttpURLConnection.HTTP_OK) {
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                                    StringBuilder resposta = new StringBuilder();
                                    String linha;
                                    while ((linha = reader.readLine()) != null) {
                                        resposta.append(linha);
                                    }
                                    reader.close();
                                    JSONObject jsonResponse = new JSONObject(resposta.toString());
                                    double imc = jsonResponse.getDouble("imc");
                                    inputField2.setText(String.valueOf(imc)); // Exibir o IMC retornado no campo altura
                                } else {
                                    System.out.println("Falha na conexão. Código de Resposta: " + responseCode);
                                }

                                connection.disconnect();
                            } catch (IOException | JSONException ex) {
                                ex.printStackTrace();
                            }
                        }

                        if (label.equals("Sair")) {
                            System.exit(0);
                        }
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

        port(4567);

        post("/api", (request, response) -> {
            try {
                JSONObject json = new JSONObject(request.body());
                double altura = json.getDouble("altura");
                double massa = json.getDouble("massa");

                double imc = calcularIMC(altura, massa);

                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("imc", imc);

                response.type("application/json");
                return jsonResponse.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                response.status(400);
                return "Erro ao processar os dados.";
            }
        });

        abrirPagWeb("http://localhost:8080/imc?p=70&p2=1.70");
    }

    private static double calcularIMC(double altura, double massa) {
        return massa / (altura * altura);
    }

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
