package Aula3;

import java.util.Scanner;

public class Desafio5 {
    // Calcule com base na taxa SELIC a taxa CDI (CDI = SELIC/252) Selic = 13.75%
    public static void main(String[] args) {

    double SELIC, CDI, Aplicacao, Rendimento, Montante;
    int diasUteis = 252;
    Scanner inp = new Scanner(System.in);

    System.out.println("Informe a atual taxa SELIC: ");
    SELIC = inp.nextFloat();
    System.out.println("Informe o rendimento da conta (com base no CDI): ");
    Rendimento = inp.nextFloat();
    System.out.println("Informe o valor aplicado: ");
    Aplicacao = inp.nextFloat();

    CDI = SELIC / diasUteis;
    System.out.printf("O CDI é: %.2f%% \n", CDI);
    
    CDI = CDI * (Rendimento/100);
    Montante = Aplicacao + Aplicacao * (CDI/100) * 0.775f;
    System.out.printf("Valor 1 dia útil após: %.2f %% \n", Montante);

    inp.close();
    }

}
