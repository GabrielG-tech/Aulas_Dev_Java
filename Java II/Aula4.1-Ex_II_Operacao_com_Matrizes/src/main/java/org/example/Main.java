package org.example;

import javax.swing.*;
import  java.awt.*;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.io.IOException;

public class Main { // CALCULADORA MATRIZES
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        JFrame frame = new JFrame("Calculadora de Matrizes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480,280);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null); // panel.setLayout(new GridLayout(6,2))

        JTextField inputA11 = new JTextField(2);
        JTextField inputA21 = new JTextField(2);

        JTextField inputA12 = new JTextField(2);
        JTextField inputA22 = new JTextField(2);

        // ====================================

        JTextField inputB11 = new JTextField(2);
        JTextField inputB21 = new JTextField(2);

        JTextField inputB12 = new JTextField(2);
        JTextField inputB22 = new JTextField(2);

        // ====================================

        JTextField outputC11 = new JTextField(2);
        JTextField outputC21 = new JTextField(2);
        JTextField outputC12 = new JTextField(2);
        JTextField outputC22 = new JTextField(2);
        outputC11.setEnabled(false);
        outputC21.setEnabled(false);
        outputC12.setEnabled(false);
        outputC22.setEnabled(false);

        inputA11.setFont(new Font("Arial", Font.PLAIN, 18));
        inputA21.setFont(new Font("Arial", Font.PLAIN, 18));
        inputA12.setFont(new Font("Arial", Font.PLAIN, 18));
        inputA22.setFont(new Font("Arial", Font.PLAIN, 18));

        inputB11.setFont(new Font("Arial", Font.PLAIN, 18));
        inputB21.setFont(new Font("Arial", Font.PLAIN, 18));
        inputB12.setFont(new Font("Arial", Font.PLAIN, 18));
        inputB22.setFont(new Font("Arial", Font.PLAIN, 18));

        outputC11.setFont(new Font("Arial", Font.PLAIN, 18));
        outputC21.setFont(new Font("Arial", Font.PLAIN, 18));
        outputC12.setFont(new Font("Arial", Font.PLAIN, 18));
        outputC22.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel matrizA = new JPanel();
        JPanel matrizB = new JPanel();
        JPanel matrizC = new JPanel();

        JLabel label1 = new JLabel("Matriz A:");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel label2 = new JLabel("Matriz B:");
        label2.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel label3 = new JLabel("Matriz C:");
        label3.setFont(new Font("Arial", Font.BOLD, 18));

        matrizA.add(label1);
        matrizA.add(inputA11);
        matrizA.add(inputA21);
        matrizA.add(inputA12);
        matrizA.add(inputA22);

        matrizB.add(label2);
        matrizB.add(inputB11);
        matrizB.add(inputB21);
        matrizB.add(inputB12);
        matrizB.add(inputB22);

        matrizC.add(label3);
        matrizC.add(outputC11);
        matrizC.add(outputC21);
        matrizC.add(outputC12);
        matrizC.add(outputC22);

        panel.add(matrizA);
        panel.add(matrizB);
        panel.add(matrizC);

        matrizA.setBounds(50,40,90,90);
        matrizB.setBounds(150,40,90,90);
        matrizC.setBounds(300,40,90,90);

        String[] buttonLabels = {
                "Somar", "Subtrair", "Multiplicar", "Escalar"
        };

        int x = 150;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(button);

            button.setBounds(x, 150, 80, 25); // Ajusta a coordenada y
            x += 120; // Aumenta a coordenada y para o próximo botão

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        double A11 = Double.parseDouble(inputA11.getText());
                        double A21 = Double.parseDouble(inputA21.getText());
                        double A12 = Double.parseDouble(inputA12.getText());
                        double A22 = Double.parseDouble(inputA22.getText());

                        double B11 = Double.parseDouble(inputB11.getText());
                        double B21 = Double.parseDouble(inputB21.getText());
                        double B12 = Double.parseDouble(inputB12.getText());
                        double B22 = Double.parseDouble(inputB22.getText());

                        double C11 = 0, C21 = 0, C12 = 0, C22 = 0;

                        if (label.equals("Somar")) {
                            C11 = calculadora.somar(A11, B11);
                            C21 = calculadora.somar(A21, B21);
                            C12 = calculadora.somar(A12, B12);
                            C22 = calculadora.somar(A22, B22);
                        } else if (label.equals("Subtrair")) {
                            C11 = calculadora.subtrair(A11, B11);
                            C21 = calculadora.subtrair(A21, B21);
                            C12 = calculadora.subtrair(A12, B12);
                            C22 = calculadora.subtrair(A22, B22);
                        } else if (label.equals("Multiplicar")) {
                            C11 = calculadora.multiplicar(A11, B11);
                            C21 = calculadora.multiplicar(A21, B21);
                            C12 = calculadora.multiplicar(A12, B12);
                            C22 = calculadora.multiplicar(A22, B22);
                        } /*else if (label.equals("Dividir")) {
                            if (num2 != 0) {
                                result = calculadora.dividir(num1, num2);
                            } else {
                                outputField.setText("Erro");
                                return;
                            }
                        }*/
                        outputC11.setText(Double.toString(C11));
                        outputC21.setText(Double.toString(C21));
                        outputC12.setText(Double.toString(C12));
                        outputC22.setText(Double.toString(C22));
                    } catch (NumberFormatException ex) {
                        outputC11.setText("Inválido");
                        outputC21.setText("Inválido");
                        outputC12.setText("Inválido");
                        outputC22.setText("Inválido");
                    }
                }
            });
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}