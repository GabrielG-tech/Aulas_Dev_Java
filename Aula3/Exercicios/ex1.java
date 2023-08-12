package Aula3.Exercicios;

import java.util.Scanner;

// Exercicios:
// https://replit.com/team/INFNET-GRPADS01C1-M2-P1-23E3

/*
  1) Faça um programa que solicite o nome e nota de 6 alunos. Em seguida, calcule a média da turma e parabenize apenas aqueles que ficaram acima da média da turma.
*/

public class ex1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] alunos = new String[6];
    double[] notas = new double[6];
    String alunosAcimaMedia = "";
    double media = 0;

    // Captura nome e nota de cada aluno
    for (int i = 0; i < 6; i++) {
      System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
      alunos[i] = input.nextLine();
      System.out.print("Digite a nota deste de " + alunos[i] + ": ");
      notas[i] = input.nextDouble();
      input.nextLine();
      media += notas[i];
    }
    input.close();

    // Calcula a média do grupo
    media = media / alunos.length;
    System.out.println("\nA média do grupo é " + media);

    // Seleciona os que tiveram nota acima da média
    for (int i = 0; i < 6; i++) {
      if (notas[i] >= media) {
        alunosAcimaMedia += alunos[i] + ", ";
      }
    }

    // Exibe os alunos acima da média
    if (!alunosAcimaMedia.isEmpty()) {
      System.out.println(String.valueOf("=").repeat(43 + alunosAcimaMedia.length()));
      System.out.println("Parabéns " + alunosAcimaMedia + "vocês são alunos acima da média!!!");
      System.out.println(String.valueOf("=").repeat(43 + alunosAcimaMedia.length()));
    } else {
      System.out.println("Nenhum aluno ficou acima da média.");
    }
  }
}
