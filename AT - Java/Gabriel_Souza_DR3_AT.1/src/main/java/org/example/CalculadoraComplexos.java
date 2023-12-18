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
    private JButton botaoSubtracao;
    private JButton botaoModulo;

    public CalculadoraComplexos() {
        setTitle("Calculadora de Números Complexos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);

        JLabel labelNumero1 = new JLabel("Número Complexo 1:");
        labelNumero1.setBounds(20, 20, 150, 20);
        add(labelNumero1);

        numero1Real = new JTextField();
        numero1Real.setBounds(20, 50, 50, 20);
        add(numero1Real);

        numero1Imaginario = new JTextField();
        numero1Imaginario.setBounds(90, 50, 50, 20);
        add(numero1Imaginario);

        JLabel labelNumero2 = new JLabel("Número Complexo 2:");
        labelNumero2.setBounds(20, 80, 150, 20);
        add(labelNumero2);

        numero2Real = new JTextField();
        numero2Real.setBounds(20, 110, 50, 20);
        add(numero2Real);

        numero2Imaginario = new JTextField();
        numero2Imaginario.setBounds(90, 110, 50, 20);
        add(numero2Imaginario);

        botaoSoma = new JButton("Soma");
        botaoSoma.setBounds(20, 150, 80, 30);
        add(botaoSoma);

        botaoSubtracao = new JButton("Subtração");
        botaoSubtracao.setBounds(110, 150, 100, 30);
        add(botaoSubtracao);

        botaoModulo = new JButton("Módulo");
        botaoModulo.setBounds(220, 150, 80, 30);
        add(botaoModulo);

        resultado = new JTextField();
        resultado.setBounds(20, 200, 300, 30);
        resultado.setEditable(false);
        add(resultado);

        botaoSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacao("soma");
            }
        });

        botaoSubtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacao("subtracao");
            }
        });

        botaoModulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacao("modulo");
            }
        });

        setVisible(true);
    }

    private void realizarOperacao(String operacao) {
        double real1 = Double.parseDouble(numero1Real.getText());
        double imag1 = Double.parseDouble(numero1Imaginario.getText());
        double real2 = Double.parseDouble(numero2Real.getText());
        double imag2 = Double.parseDouble(numero2Imaginario.getText());

        Complexo complexo1 = new Complexo(real1, imag1);
        Complexo complexo2 = new Complexo(real2, imag2);

        Complexo resultado = null;
        switch (operacao) {
            case "soma":
                resultado = complexo1.somar(complexo2);
                break;
            case "subtracao":
                resultado = complexo1.subtrair(complexo2);
                break;
            case "modulo":
                double modulo = complexo1.modulo();
                resultado = new Complexo(modulo, 0);
                break;
            default:
                break;
        }

        if (resultado != null) {
            this.resultado.setText(resultado.getReal() + " + " + resultado.getImaginario() + "i");
        }
    }

    public JButton getBotaoSoma() {
        return botaoSoma;
    }

    public JButton getBotaoSubtracao() {
        return botaoSubtracao;
    }

    public JButton getBotaoModulo() {
        return botaoModulo;
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
