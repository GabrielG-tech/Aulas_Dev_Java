package org.example;

import javax.swing.*;

public class Calculadora {

    public int somar(int num1, int num2) {
        return num1 + num2;
    }

    public int subtrair(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplicar(int num1, int num2, int num3, int num4) {
        return (num1 * num2) + (num3 * num4);
    }

    public int escalar(int num, int escalar) { return num * escalar; }
}
