package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        JFrame frame = new JFrame("Calculadora de Matrizes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 260);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextField inputA11 = new JTextField(2);
        JTextField inputA21 = new JTextField(2);
        JTextField inputA12 = new JTextField(2);
        JTextField inputA22 = new JTextField(2);

        JTextField inputB11 = new JTextField(2);
        JTextField inputB21 = new JTextField(2);
        JTextField inputB12 = new JTextField(2);
        JTextField inputB22 = new JTextField(2);

        JTextField inputEscalar = new JTextField(2);

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

        inputEscalar.setFont(new Font("Arial", Font.PLAIN, 18));

        outputC11.setFont(new Font("Arial", Font.PLAIN, 18));
        outputC21.setFont(new Font("Arial", Font.PLAIN, 18));
        outputC12.setFont(new Font("Arial", Font.PLAIN, 18));
        outputC22.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel matrizA = new JPanel();
        JPanel matrizB = new JPanel();
        JPanel escalar = new JPanel();
        JPanel matrizC = new JPanel();

        JLabel label1 = new JLabel("Matriz A");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel label2 = new JLabel("Matriz B");
        label2.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel label3 = new JLabel("Escalar");
        label3.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel label4 = new JLabel("Matriz C");
        label4.setFont(new Font("Arial", Font.BOLD, 18));

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

        escalar.add(label3);
        escalar.add(inputEscalar);

        matrizC.add(label4);
        matrizC.add(outputC11);
        matrizC.add(outputC21);
        matrizC.add(outputC12);
        matrizC.add(outputC22);

        panel.add(matrizA);
        panel.add(matrizB);
        panel.add(escalar);
        panel.add(matrizC);

        matrizA.setBounds(35, 40, 90, 90);
        matrizB.setBounds(135, 40, 90, 90);
        escalar.setBounds(235, 55, 90, 90);
        matrizC.setBounds(335, 40, 90, 90);

        String[] buttonLabels = {
                "Somar", "Subtrair", "Multiplicar", "Escalar"
        };

        int x = 20;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(button);

            button.setBounds(x, 150, 100, 30);
            x += 110;

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int A11 = Integer.parseInt(inputA11.getText());
                        int A21 = Integer.parseInt(inputA21.getText());
                        int A12 = Integer.parseInt(inputA12.getText());
                        int A22 = Integer.parseInt(inputA22.getText());

                        int Escalar = inputEscalar.getText().isEmpty() ? 0 :
                                Integer.parseInt(inputEscalar.getText());

                        int B11 = inputB11.getText().isEmpty() ? 0 :
                                Integer.parseInt(inputB11.getText());
                        int B21 = inputB21.getText().isEmpty() ? 0 :
                                Integer.parseInt(inputB21.getText());
                        int B12 = inputB12.getText().isEmpty() ? 0 :
                                Integer.parseInt(inputB12.getText());
                        int B22 = inputB22.getText().isEmpty() ? 0 :
                                Integer.parseInt(inputB22.getText());

                        int C11 = 0, C21 = 0, C12 = 0, C22 = 0;

                        if (label.equals("Somar")) {
                            inputEscalar.setText("");
                            C11 = calculadora.somar(A11, B11);
                            C21 = calculadora.somar(A21, B21);
                            C12 = calculadora.somar(A12, B12);
                            C22 = calculadora.somar(A22, B22);
                        } else if (label.equals("Subtrair")) {
                            inputEscalar.setText("");
                            C11 = calculadora.subtrair(A11, B11);
                            C21 = calculadora.subtrair(A21, B21);
                            C12 = calculadora.subtrair(A12, B12);
                            C22 = calculadora.subtrair(A22, B22);
                        } else if (label.equals("Multiplicar")) {
                            inputEscalar.setText("");
                            C11 = calculadora.multiplicar(A11, B11, A12, B21);
                            C12 = calculadora.multiplicar(A11, B12, A12, B22);
                            C21 = calculadora.multiplicar(A21, B11, A22, B21);
                            C22 = calculadora.multiplicar(A21, B12, A22, B22);
                        } else if (label.equals("Escalar")) {
                            inputB11.setText("");
                            inputB21.setText("");
                            inputB12.setText("");
                            inputB22.setText("");
                            C11 = calculadora.escalar(A11, Escalar);
                            C21 = calculadora.escalar(A21, Escalar);
                            C12 = calculadora.escalar(A12, Escalar);
                            C22 = calculadora.escalar(A22, Escalar);
                        }

                        /*if (inputEscalar.getText().isEmpty()) {
                            inputB11.setEnabled(true);
                            inputB21.setEnabled(true);
                            inputB12.setEnabled(true);
                            inputB22.setEnabled(true);
                        } else {
                            inputB11.setEnabled(false);
                            inputB21.setEnabled(false);
                            inputB12.setEnabled(false);
                            inputB22.setEnabled(false);
                        }

                        if (inputB11.getText().isEmpty() && inputB21.getText().isEmpty() &&
                                inputB12.getText().isEmpty() && inputB22.getText().isEmpty()) {
                            inputEscalar.setEnabled(false);
                        } else {
                            inputEscalar.setEnabled(true);
                        }*/

                        outputC11.setText(Integer.toString(C11));
                        outputC21.setText(Integer.toString(C21));
                        outputC12.setText(Integer.toString(C12));
                        outputC22.setText(Integer.toString(C22));
                    } catch (NumberFormatException ex) {
                        outputC11.setText("Erro");
                        outputC21.setText("Erro");
                        outputC12.setText("Erro");
                        outputC22.setText("Erro");
                    }
                }
            });
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}