package Desafios;

import java.util.Scanner;
import java.lang.Math;

public class Desafio2 {

    // Faça um código que calcule uma equação de segundo grau.
    public static void main(String[] args) {
        double a, b, c, delta, x1, x2;
        Scanner inp = new Scanner(System.in);

        System.out.println("Informe o valor de a: ");
        a = inp.nextDouble();

        System.out.println("Informe o valor de b: ");
        b = inp.nextDouble();

        System.out.println("Informe o valor de c: ");
        c = inp.nextDouble();

        inp.close();

        System.out.println(a + "x² + " + b + "x + " + c + " = 0");

        delta = Math.pow(b, 2) - 4 * a * c;

        if (delta < 0) {
            System.out.println( "Não existe raiz no conjunto dos Reais.");
        } else {
            x1 = ((-1)*b+Math.sqrt(delta))/(2*a);
            x2 = ((-1)*b-Math.sqrt(delta))/(2*a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
