package org.example;

import javax.swing.*;
import java.awt.*;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) { // SERVIDOR
        JFrame frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        Dimension screesize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) screesize.getWidth() / 2, (int) screesize.getHeight() / 3);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

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
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}