package Aula4;

import java.util.Scanner;

// Procedimentos (Procedures): NÃO RETORNA UM VALOR (diferente da função)

public class Função {
    public static int soma(int x, int y) {
        return x + y;
    };
    public static int subtracao(int x, int y) {
        return x - y;
    };
    public static int multiplicacao(int x, int y) {
        return x * y;
    };
    public static int divisao(int x, int y) {
        return x / y;
    };
    public static void main(String args[]) {
        int n1, n2; String operacao;
        Scanner inp = new Scanner(System.in);
        System.out.println("Informe o primeiro número: ");
        n1 = inp.nextInt();
        System.out.println("Informe o segundo número: ");
        n2 = inp.nextInt();
        System.out.println("Informe a operaçao: ");
        operacao = inp.next().toLowerCase();
        
        switch (operacao){
            case "soma":
                System.out.println(n1 + " + " + n2 + " = " + soma(n1, n2));
                break;
            case "subtracao":
                System.out.println(n1 + " - " + n2 + " = " + subtracao(n1, n2));
                break;
            case "multiplicacao":
                System.out.println(n1 + " x " + n2 + " = " + multiplicacao(n1, n2));
                break;
            case "divisao":
                System.out.println(n1 + " / " + n2 + " = " + divisao(n1, n2));
                break;
            default:
                System.out.println("Entrada inválida.");
        };
        inp.close();
    };
};
