package Aula3.Exercicios;

import java.util.Scanner;

/*
  3) Faça um  código para calcular a sequencia de Fibonacci e encontrar a razão áurea através dos 2 últimos valores da sequência. Solicite ao usuário um valor N para imprimir N elementos da sequência.
*/

public class ex3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n;

    // Captura número de digitos para a sequência.
    System.out.print("Digite o numero de digitos para a sequência: ");
    n = input.nextInt();
    input.close();

    // Saída do resultado
    System.out.println("Sequência Fibonacci com " + n + " digitos: ");
    for (int i = 0; i <= n; i++) {
      System.out.print("(" + i + "):" + Fibonacci(i) + "\t");
    }
    System.out.println("\nA Razão Aurea é " + calculoRazãoAurea((n - 2), (n - 1)));
  }

  public static int Fibonacci(int n) {
    // Calculo da sequência
    if (n < 2) {
      return n;
    } else {
      return (n - 1) + (n - 2);
    }
  }
  public static double calculoRazãoAurea(long a, long b) {
        if (b == 0) {
            return 0;
        }
        return (double) a / b;
    }
  
}
