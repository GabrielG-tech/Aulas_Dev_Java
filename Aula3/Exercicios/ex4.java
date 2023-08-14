package Aula3.Exercicios;

import java.util.Scanner;

/*
  4) Solicite 3 lados de um triângulo a um usuário e diga se ele é: Triângulo escaleno (todos os lados diferentes), Triângulos isósceles (dois lados com medidas iguais) ou  Triângulo equilátero (todos os lados com iguais).
*/

public class ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o tamanho do primeiro lado do triângulo: ");
        double lado1 = input.nextFloat();

        System.out.print("Digite o tamanho do segundo lado do triângulo: ");
        double lado2 = input.nextFloat();

        System.out.print("Digite o tamanho do terceiro lado do triângulo: ");
        double lado3 = input.nextFloat();

        if (ehTriangulo(lado1, lado2, lado3)) {
            String tipo = tipoTriangulo(lado1, lado2, lado3);
            System.out.println("O triângulo é do tipo: " + tipo);
        } else {
            System.out.println("Os lados fornecidos não formam um triângulo.");
        }

        input.close();
    }

    public static boolean ehTriangulo(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static String tipoTriangulo(double a, double b, double c) {
        if (a == b && b == c) {
            return "Triângulo equilátero";
        } else if (a == b || a == c || b == c) {
            return "Triângulo isósceles";
        } else {
            return "Triângulo escaleno";
        }
    }
}
