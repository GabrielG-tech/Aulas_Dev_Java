package Aula07.Pais;

import java.util.Scanner;

public class Classe {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        Pais[] pais = new Pais[8];

        String nome = "";
        double populacao = 0;

        String paisMaiorPop = "";
        double maiorPop = 0;
        
        // Pais pais1 = new Pais("Brasil", 214.3);
        // Pais pais2 = new Pais("Japao", 125.7);

        for (int i=0; i < 6; i++) {
            System.out.print("Insira o nome do país " + (i+1) + ": ");
            nome = input.next();
            
            System.out.print("Insira o número populacional do país " + (i+1) + " (em milhões): ");
            populacao = input.nextDouble();

            pais[i] = new Pais(nome, populacao);

            if (populacao > maiorPop) {
                paisMaiorPop = nome;
                maiorPop = populacao;
            }
        }
        input.close();
        System.out.printf("O país %s possuí a maior população de %.2f", paisMaiorPop, maiorPop);
    }
}
