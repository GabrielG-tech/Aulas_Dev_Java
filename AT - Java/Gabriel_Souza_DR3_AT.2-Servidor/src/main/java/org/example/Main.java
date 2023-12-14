package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Response;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

import static spark.Spark.*;

public class Main {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        Dimension screesize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) screesize.getWidth() / 2, (int) screesize.getHeight() / 3);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JTextField codigoRFIDField = new JTextField("123");
        codigoRFIDField.setFont(new Font("Arial", Font.PLAIN, 30));
        JTextField respostaField = new JTextField();
        respostaField.setEditable(false);
        respostaField.setFont(new Font("Arial", Font.PLAIN, 30));

        JLabel label1 = new JLabel("Código RFID:");
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel label2 = new JLabel("Resposta:");
        label2.setFont(new Font("Arial", Font.BOLD, 30));

        panel.add(label1);
        panel.add(codigoRFIDField);
        panel.add(label2);
        panel.add(respostaField);

        port(8080);

        post("/verificarCodigo", (req, res) -> {
            String codigoRFID = req.body();
            String response;
            if (codigoRFID.equals(codigoRFIDField.getText())) {
                response = "ACK";
            } else {
                response = "NACK";
            }
            respostaField.setText(response);
            return response;
//            JsonObject response = new JsonObject();
//            if (codigoRFID.equals(codigoRFIDField.getText())) {
//                response.addProperty("status", "ACK");
//
//            } else {
//                response.addProperty("status", "NACK");
//            }
//            respostaField.setText(response.toString());
//            return gson.toJson(response);
        });

        String[] buttonLabels = { "Limpar", "Sair" };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codigoRFID = codigoRFIDField.getText();

                    if (codigoRFID.equals(codigoRFIDField.getText())) {
                        respostaField.setText("ACK");
                    } else {
                        respostaField.setText("NACK");
                    }
                    if (label.equals("Limpar")) {
                        codigoRFIDField.setText("");
                        respostaField.setText("");
                    } else if (label.equals("Sair")) {
                        System.exit(0);
                    }
                }
            });
        }
        frame.add(panel);
        frame.setVisible(true);
    }
}