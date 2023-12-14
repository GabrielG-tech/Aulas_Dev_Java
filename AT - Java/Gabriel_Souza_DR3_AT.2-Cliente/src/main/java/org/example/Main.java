package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main { // CLIENTE
    // Rota para verificar código RFID:
    static final String path = "http://localhost:8080/verificarCodigo";
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        Dimension screesize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) screesize.getWidth() / 4, (int) screesize.getHeight() / 3);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JTextField codigoRFIDField = new JTextField(2);
        codigoRFIDField.setFont(new Font("Arial", Font.PLAIN, 30));
        JTextField respostaField = new JTextField(4);
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

        codigoRFIDField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sendRequest(codigoRFIDField.getText(), respostaField/*, codigoRFIDField*/, panel);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                sendRequest(codigoRFIDField.getText(), respostaField/*, codigoRFIDField*/, panel);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Alterado");
            }
        });

    frame.add(panel);
    frame.setVisible(true);
}

    public static void sendRequest(String codigo, JTextField respostaField/*, JTextField codigoRFID*/, JPanel panel) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(codigo.getBytes());
            os.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String responseBody = response.toString();
                respostaField.setText(responseBody);

                // Muda a cor do painel por 3 segundos
                if (responseBody.equals("ACK")) {
                    panel.setBackground(Color.GREEN);
                    Timer timer = new Timer(3000, e -> {
                        panel.setBackground(UIManager.getColor("TextField.background"));
                        respostaField.setText("");
                        //codigoRFID.setText("");
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (responseBody.equals("NACK")) {
                    panel.setBackground(Color.RED);
                    Timer timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.setBackground(UIManager.getColor("TextField.background"));
                            respostaField.setText("");
                            //codigoRFID.setText("");
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            } else {
                System.out.println("Falha na requisição: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}