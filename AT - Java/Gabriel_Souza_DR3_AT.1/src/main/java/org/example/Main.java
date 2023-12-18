package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Números Complexos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel labelNumero1 = new JLabel("Número Complexo 1:");
        labelNumero1.setBounds(10, 10, 150, 20);

        JTextField inputReal1 = new JTextField();
        inputReal1.setBounds(160, 10, 50, 20);

        JTextField inputImaginario1 = new JTextField();
        inputImaginario1.setBounds(220, 10, 50, 20);

        JLabel labelNumero2 = new JLabel("Número Complexo 2:");
        labelNumero2.setBounds(10, 40, 150, 20);

        JTextField inputReal2 = new JTextField();
        inputReal2.setBounds(160, 40, 50, 20);

        JTextField inputImaginario2 = new JTextField();
        inputImaginario2.setBounds(220, 40, 50, 20);

        JButton buttonSoma = new JButton("Somar");
        buttonSoma.setBounds(10, 80, 80, 30);

        JButton buttonSubtracao = new JButton("Subtrair");
        buttonSubtracao.setBounds(110, 80, 90, 30);

        JButton buttonModulo = new JButton("Módulo");
        buttonModulo.setBounds(220, 80, 80, 30);

        JTextField output = new JTextField();
        output.setEditable(false);
        output.setBounds(10, 120, 300, 30);

        frame.add(labelNumero1);
        frame.add(inputReal1);
        frame.add(inputImaginario1);
        frame.add(labelNumero2);
        frame.add(inputReal2);
        frame.add(inputImaginario2);
        frame.add(buttonSoma);
        frame.add(buttonSubtracao);
        frame.add(buttonModulo);
        frame.add(output);

        buttonSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double real1 = Double.parseDouble(inputReal1.getText());
                    double imag1 = Double.parseDouble(inputImaginario1.getText());
                    double real2 = Double.parseDouble(inputReal2.getText());
                    double imag2 = Double.parseDouble(inputImaginario2.getText());

                    Complexo complexo1 = new Complexo(real1, imag1);
                    Complexo complexo2 = new Complexo(real2, imag2);

                    Complexo resultado = complexo1.soma(complexo2);
                    output.setText(resultado.toString());
                } catch (NumberFormatException ex) {
                    output.setText("Entrada inválida");
                }
            }
        });
        buttonSubtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double real1 = Double.parseDouble(inputReal1.getText());
                    double imag1 = Double.parseDouble(inputImaginario1.getText());
                    double real2 = Double.parseDouble(inputReal2.getText());
                    double imag2 = Double.parseDouble(inputImaginario2.getText());

                    Complexo complexo1 = new Complexo(real1, imag1);
                    Complexo complexo2 = new Complexo(real2, imag2);

                    Complexo resultado = complexo1.subtracao(complexo2);
                    output.setText(resultado.toString());
                } catch (NumberFormatException ex) {
                    output.setText("Entrada inválida");
                }
            }
        });

        buttonModulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double real1 = Double.parseDouble(inputReal1.getText());
                    double imag1 = Double.parseDouble(inputImaginario1.getText());

                    Complexo complexo1 = new Complexo(real1, imag1);

                    double resultado = complexo1.modulo();
                    output.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    output.setText("Entrada inválida");
                }
            }
        });


        frame.setVisible(true);
    }
}