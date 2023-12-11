package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        criarInterface();
    }

    private static void criarInterface() {
        CalculadoraComplexos calculadora = new CalculadoraComplexos();
        calculadora.getBotaoSoma().addActionListener(e -> realizarOperacao(calculadora, "soma"));
        // Adicione outros listeners para os botões de subtração, módulo, etc., com as operações correspondentes
    }

    private static void realizarOperacao(CalculadoraComplexos calculadora, String operacao) {
        double num1Real = Double.parseDouble(calculadora.getNumero1Real().getText());
        double num1Imag = Double.parseDouble(calculadora.getNumero1Imaginario().getText());
        double num2Real = Double.parseDouble(calculadora.getNumero2Real().getText());
        double num2Imag = Double.parseDouble(calculadora.getNumero2Imaginario().getText());

        Complexo complexo1 = new Complexo(num1Real, num1Imag);
        Complexo complexo2 = new Complexo(num2Real, num2Imag);

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
                // Converte o resultado do módulo para um número complexo com a parte imaginária sendo zero
                resultado = new Complexo(modulo, 0);
                break;

            default:
                break;
        }

        if (resultado != null) {
            calculadora.getResultado().setText(resultado.getReal() + " + " + resultado.getImaginario() + "i");
        }
    }

}
