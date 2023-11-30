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
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        JFrame frame = new JFrame("Calculadora");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);

        JTextField outputField = new JTextField(10);
        outputField.setEditable(false);

        inputField1.setFont(new Font("Arial", Font.PLAIN, 30));
        inputField2.setFont(new Font("Arial", Font.PLAIN, 30));
        outputField.setFont(new Font("Arial", Font.PLAIN, 30));

        JLabel label1 = new JLabel("Primeiro número:");
        JLabel label2 = new JLabel("Segundo número:");
        JLabel label3 = new JLabel("Resultado:");

        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        label2.setFont(new Font("Arial", Font.PLAIN, 30));
        label3.setFont(new Font("Arial", Font.PLAIN, 30));

        panel.add(label1);
        panel.add(inputField1);
        panel.add(label2);
        panel.add(inputField2);
        panel.add(label3);
        panel.add(outputField);

        String[] buttonLabels = {
                "Somar", "Subtrair", "Multiplicar", "Dividir"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double num1, num2, result = 0;

                    try {
                        num1 = Double.parseDouble(inputField1.getText());
                        num2 = Double.parseDouble(inputField2.getText());

                        if (label.trim().equalsIgnoreCase("Somar")) {
                            outputField.setText(Double.toString(calc.soma(num1, num2)));
                        } else if (label.trim().equalsIgnoreCase("Subtrair")) {
                            outputField.setText(Double.toString(calc.subtracao(num1, num2)));
                        } else if (label.trim().equalsIgnoreCase("Multiplicar")) {
                            outputField.setText(Double.toString(calc.multi(num1, num2)));
                        } else if (label.trim().equalsIgnoreCase("Dividir")) {
                            if (num2 != 0) {
                                outputField.setText(Double.toString(calc.divisao(num1, num2)));
                            } else {
                                outputField.setText("Erro, divisão por zero");
                                return;
                            }
                        }
                    } catch (NumberFormatException ex) {
                        outputField.setText("Erro: entrada inválida");
                    }
                }
            });
        }

        frame.setContentPane(panel);
        frame.setVisible(true);

        port(8080);

        get("/param1", (req, res) -> {
            String op1 = req.queryParams("p");
            inputField1.setText(op1);
            return "Parâmetro 1: " + op1;
        }); // http://localhost:8080/param1

        get("/param2", (req, res) -> {
            String op2 = req.queryParams("p");
            inputField2.setText(op2);
            return "Parâmetro 2: " + op2;
        }); // http://localhost:8080/param2

        get("/soma", (req, res) -> {
            double soma = Double.parseDouble(inputField1.getText()) + Double.parseDouble(inputField2.getText());
            outputField.setText(Double.toString(soma));
            return "Soma: " + Double.toString(soma);
        }); // http://localhost:8080/soma

        get("/subt", (req, res) -> {
            double subt = Double.parseDouble(inputField1.getText()) - Double.parseDouble(inputField2.getText());
            outputField.setText(Double.toString(subt));
            return "Subtração: " + Double.toString(subt);
        }); // http://localhost:8080/subt

        get("/mult", (req, res) -> {
            double mult = Double.parseDouble(inputField1.getText()) * Double.parseDouble(inputField2.getText());
            outputField.setText(Double.toString(mult));
            return "Multiplicação: " + Double.toString(mult);
        }); // http://localhost:8080/mult

        get("/divi", (req, res) -> {
            double divi = Double.parseDouble(inputField1.getText()) / Double.parseDouble(inputField2.getText());
            outputField.setText(Double.toString(divi));
            return "Divisão: " + Double.toString(divi);
        }); // http://localhost:8080/divi

        get("/json", (req, res) -> {
            double soma, subt, mult, divi;
            soma = Double.parseDouble(inputField1.getText()) + Double.parseDouble(inputField2.getText());
            subt = Double.parseDouble(inputField1.getText()) - Double.parseDouble(inputField2.getText());
            mult = Double.parseDouble(inputField1.getText()) * Double.parseDouble(inputField2.getText());
            divi = Double.parseDouble(inputField1.getText()) / Double.parseDouble(inputField2.getText());

            String content = "{ \"param1\": \" " + inputField1.getText() +
                    "\"param2\": \" " + inputField2.getText() +
                    "\", \"soma\": \"" + Double.toString(soma) +
                    "\", \"subt\": \"" + Double.toString(subt) +
                    "\", \"mult\": \"" + Double.toString(mult) +
                    "\", \"divi\": \"" + Double.toString(divi) + " \"}";
            return content;
        });

        get("/xml", (req, res) -> {
            double soma, subt, mult, divi;
            soma = Double.parseDouble(inputField1.getText()) + Double.parseDouble(inputField2.getText());
            subt = Double.parseDouble(inputField1.getText()) - Double.parseDouble(inputField2.getText());
            mult = Double.parseDouble(inputField1.getText()) * Double.parseDouble(inputField2.getText());
            divi = Double.parseDouble(inputField1.getText()) / Double.parseDouble(inputField2.getText());

            String content = "{ \"param1\": \" " + inputField1.getText() +
                    "\"param2\": \" " + inputField2.getText() +
                    "\", \"soma\": \"" + Double.toString(soma) +
                    "\", \"subt\": \"" + Double.toString(subt) +
                    "\", \"mult\": \"" + Double.toString(mult) +
                    "\", \"divi\": \"" + Double.toString(divi) + " \"}";
            return content;
        });

        abrirPagWeb("http://localhost:8080/param1");
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
