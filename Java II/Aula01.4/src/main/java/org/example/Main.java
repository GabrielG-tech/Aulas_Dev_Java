package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(250, 300);

        JPanel painel = new JPanel();
        janela.add(painel);

        JLabel n1 = new JLabel("Número 1: ");
        painel.add(n1);

        JTextField n1txt = new JTextField(20);
        painel.add(n1txt);

        JLabel n2 = new JLabel("Número 2: ");
        painel.add(n2);

        JTextField n2txt = new JTextField(20);
        painel.add(n2txt);

        JButton soma = new JButton("Soma");
        soma.setSize(100, 30);
        painel.add(soma);

        JButton subtracao = new JButton("Subtração");
        subtracao.setSize(100, 30);
        painel.add(subtracao);

        JButton multiplicacao = new JButton("Multiplicação");
        multiplicacao.setSize(100, 30);
        painel.add(multiplicacao);

        JButton divisao = new JButton("Divisão");
        divisao.setSize(100, 30);
        painel.add(divisao);

        soma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém, número inserido na caixa de texto
                Double n1 = Double.parseDouble(n1txt.getText());
                Double n2 = Double.parseDouble(n2txt.getText());

                // Exibe uma saudação com base no nome inserido
                if (!n1.isNaN() && !n2.isNaN()) {
                    Double resultado = n1 + n2;
                    JOptionPane.showMessageDialog(null, "A soma de " + n1 + " + " + n2 + " é " + resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número.");
                }
            }
        });

        subtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém, número inserido na caixa de texto
                Double n1 = Double.parseDouble(n1txt.getText());
                Double n2 = Double.parseDouble(n2txt.getText());

                // Exibe uma saudação com base no nome inserido
                if (!n1.isNaN() && !n2.isNaN()) {
                    Double resultado = n1 - n2;
                    JOptionPane.showMessageDialog(null, "A subtração de " + n1 + " + " + n2 + " é " + resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número.");
                }
            }
        });

        multiplicacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém, número inserido na caixa de texto
                Double n1 = Double.parseDouble(n1txt.getText());
                Double n2 = Double.parseDouble(n2txt.getText());

                // Exibe uma saudação com base no nome inserido
                if (!n1.isNaN() && !n2.isNaN()) {
                    Double resultado = n1 * n2;
                    JOptionPane.showMessageDialog(null, "A multiplicação de " + n1 + " + " + n2 + " é " + resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número.");
                }
            }
        });

        divisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém, número inserido na caixa de texto
                Double n1 = Double.parseDouble(n1txt.getText());
                Double n2 = Double.parseDouble(n2txt.getText());

                // Exibe uma saudação com base no nome inserido
                if (!n1.isNaN() && !n2.isNaN() && n2 != 0) {
                    Double resultado = n1 / n2;
                    JOptionPane.showMessageDialog(null, "A divisão de " + n1 + " + " + n2 + " é " + resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número.");
                }
            }
        });

        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }
}
