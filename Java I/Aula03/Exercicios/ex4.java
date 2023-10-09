package Aula03.Exercicios;

import java.util.Scanner;

/*
  4) Solicite 3 lados de um triângulo a um usuário e diga se ele é: Triângulo escaleno (todos os lados diferentes), Triângulos isósceles (dois lados com medidas iguais) ou  Triângulo equilátero (todos os lados com iguais).
*/

public class ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o tamanho do primeiro lado do triângulo: ");
        float lado1 = input.nextFloat();

        System.out.print("Digite o tamanho do segundo lado do triângulo: ");
        float lado2 = input.nextFloat();

        System.out.print("Digite o tamanho do terceiro lado do triângulo: ");
        float lado3 = input.nextFloat();

        if (ehTriangulo(lado1, lado2, lado3)) {
            String tipo = tipoTriangulo(lado1, lado2, lado3);
            System.out.println("O triângulo é do tipo: " + tipo);
        } else {
            System.out.println("Os lados fornecidos não formam um triângulo.");
        }

        input.close();
    }

    public static boolean ehTriangulo(float a, float b, float c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static String tipoTriangulo(float a, float b, float c) {
        if (a == b && b == c) {
            return "Triângulo equilátero";
        } else if (a == b || a == c || b == c) {
            return "Triângulo isósceles";
        } else {
            return "Triângulo escaleno";
        }
    }
}
