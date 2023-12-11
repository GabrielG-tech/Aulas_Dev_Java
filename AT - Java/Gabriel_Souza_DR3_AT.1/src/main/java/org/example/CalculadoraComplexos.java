package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraComplexos extends JFrame {
    private JTextField numero1Real;
    private JTextField numero1Imaginario;
    private JTextField numero2Real;
    private JTextField numero2Imaginario;
    private JTextField resultado;
    private JButton botaoSoma;

    public CalculadoraComplexos() {
        setTitle("Calculadora de Números Complexos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);

        JLabel labelNumero1 = new JLabel("Número Complexo 1:");
        labelNumero1.setBounds(20, 20, 150, 20);
        add(labelNumero1);

        numero1Real = new JTextField();
        numero1Real.setBounds(20, 50, 50, 20);
        add(numero1Real);

        // Adicione os outros campos de entrada (números complexos 2, botões, etc.)

        botaoSoma = new JButton("Soma");
        botaoSoma.setBounds(20, 150, 80, 30);
        add(botaoSoma);

        resultado = new JTextField();
        resultado.setBounds(20, 200, 200, 30);
        resultado.setEditable(false);
        add(resultado);

        setVisible(true);
    }

    public JButton getBotaoSoma() {
        return botaoSoma;
    }

    public JTextField getNumero1Real() {
        return numero1Real;
    }

    public JTextField getNumero1Imaginario() {
        return numero1Imaginario;
    }

    public JTextField getNumero2Real() {
        return numero2Real;
    }

    public JTextField getNumero2Imaginario() {
        return numero2Imaginario;
    }

    public JTextField getResultado() {
        return resultado;
    }
}
