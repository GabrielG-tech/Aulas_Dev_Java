package Aula03.Exercicios;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        // Captura o número de dígitos para a sequência.
        System.out.print("Digite o número de dígitos para a sequência: ");
        n = input.nextInt();
        input.close();

        // Saída do resultado
        System.out.println("Sequência Fibonacci com " + n + " dígitos: ");
        for (int i = 0; i < n; i++) {
            System.out.print("(" + i + "):" + Fibonacci(i) + "\t");
        }
        System.out.println("\nA Razão Áurea é " + calculoRazãoAurea(Fibonacci(n - 2), Fibonacci(n - 1)));
    }

    public static int Fibonacci(int n) {
        // Cálculo da sequência
        if (n < 2) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public static double calculoRazãoAurea(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return (double) (a + b) / b;
    }
}
