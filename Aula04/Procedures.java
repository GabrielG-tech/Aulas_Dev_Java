package Aula04;

import java.util.Scanner;

// Procedimentos (Procedures): NÃO RETORNA UM VALOR (diferente da função)

public class Procedures {
    public static void soma(int x, int y) {
        System.out.println(x + " + " + y + " = " + (x+y));
    };
    public static void subtracao(int x, int y) {
        System.out.println(x + " - " + y + " = " + (x-y));
    };
    public static void multiplicacao(int x, int y) {
        System.out.println(x + " x " + y + " = " + (x*y));
    };
    public static void divisao(int x, int y) {
        System.out.println(x + " / " + y + " = " + (x/y));
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
                soma(n1, n2);
                break;
            case "subtracao":
                subtracao(n1, n2);
                break;
            case "multiplicacao":
                multiplicacao(n1, n2);
                break;
            case "divisao":
                divisao(n1, n2);
                break;
            default:
                System.out.println("Entrada inválida.");
        };
        inp.close();
    };
};
