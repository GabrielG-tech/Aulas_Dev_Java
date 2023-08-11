package Aula3.Exercicios;

import java.util.Scanner;
import java.lang.Math;

/*
  2) Faça um programa que solicite do usuário a taxa de juros, a quantidade de meses e o capital inicial. Dado isso, calcule o montante a ser pago ao término do período. Obs: Considere o cálculo de juros compostos.
*/

public class ex2 {
    public static void main(String[] args) {
      double M, C = 0, i = 0; int t = 1;
      Scanner input = new Scanner(System.in);

      // Captura informações da aplicação do usuario
      System.out.print("Digite o capital inicial da aplicaçao: ");
      C = input.nextDouble();
      System.out.print("Digite a taxa de juros (%): ");
      i = input.nextDouble();
      System.out.print("Digite a quantidade de meses de rendimento: ");
      t = input.nextInt();
      input.close();

      // Calculo do Montante
      i = i / 100;
      M = C * Math.pow(1 + i, t);

      // Saída do resultado
      System.out.printf( "O montante gerado dessa aplicaçao será de R$%.2f.", M);
    }
}
