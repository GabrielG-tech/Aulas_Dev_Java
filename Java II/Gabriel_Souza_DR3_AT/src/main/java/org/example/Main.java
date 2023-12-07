package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
    static int numAcesso = 0;
    static String history = "";

    public static void main(String[] args) {
        JFrame janelaCliente = new JFrame("Cliente");

        janelaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCliente.setSize(450, 400);
        Dimension screesize = Toolkit.getDefaultToolkit().getScreenSize();
        janelaCliente.setLocation((int) screesize.getWidth() / 4, (int) screesize.getHeight() / 2);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField inputField1 = new JTextField(10);

        JTextField outputField = new JTextField(10);
        outputField.setEditable(false);

        inputField1.setFont(new Font("Arial", Font.PLAIN, 30));
        outputField.setFont(new Font("Arial", Font.PLAIN, 30));

        JLabel label1 = new JLabel("Nome:");
        JLabel label2 = new JLabel("Acesso:");

        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        label2.setFont(new Font("Arial", Font.PLAIN, 30));

        panel.add(label1);
        panel.add(inputField1);
        panel.add(label2);
        panel.add(outputField);

        JButton button = new JButton("Enviar");
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(button);

        janelaCliente.setContentPane(panel);
        janelaCliente.setVisible(true);

        // SERVIDOR
        JFrame janelaServidor = new JFrame("Servidor");

        janelaServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaServidor.setSize(450, 400);
        janelaServidor.setLocation((int) screesize.getWidth() / 2, (int) screesize.getHeight() / 2);


        JPanel panel_s = new JPanel();
        panel_s.setLayout(new GridLayout(5, 2));

        JTextField outputField2 = new JTextField(10);
        outputField2.setEditable(false);

        JTextField outputField3 = new JTextField(Integer.toString(numAcesso),10);
        outputField3.setEditable(false);

        outputField2.setFont(new Font("Arial", Font.PLAIN, 30));
        outputField3.setFont(new Font("Arial", Font.PLAIN, 30));

        JLabel label1_s = new JLabel("Nome:");
        JLabel label2_s = new JLabel("Acesso:");

        label1_s.setFont(new Font("Arial", Font.PLAIN, 30));
        label2_s.setFont(new Font("Arial", Font.PLAIN, 30));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numAcesso++;
                    outputField.setText(String.valueOf(numAcesso));
                    outputField2.setText(inputField1.getText());
                    outputField3.setText(Integer.toString(numAcesso));
                } catch (NumberFormatException ex) {
                    outputField.setText("Erro");
                }
            }
        });

        panel_s.add(label1_s);
        panel_s.add(outputField2);
        panel_s.add(label2_s);
        panel_s.add(outputField3);

        port(8080);

        get("/nome", (req, res) -> {
            String nome = req.queryParams("p");
            numAcesso++;
            inputField1.setText(nome);
            outputField.setText(String.valueOf(numAcesso));

            outputField2.setText(inputField1.getText());
            outputField3.setText(Integer.toString(numAcesso));

            String content = "{\n  \"nome\": \"" + inputField1.getText() + "\",\n  \"acesso\": \"" + numAcesso + "\"\n}\n";
            history += content;
            return history;
        }); // http://localhost:8080/nome

        janelaServidor.setContentPane(panel_s);
        janelaServidor.setVisible(true);

        //abrirPagWeb("http://localhost:8080/nome?p=Gabriel");
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
