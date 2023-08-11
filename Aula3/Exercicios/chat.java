package Aula3.Exercicios;
import java.util.Scanner;

public class chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a taxa de juros (em decimal): ");
        double taxaDeJuros = scanner.nextDouble();

        System.out.print("Informe a quantidade de meses: ");
        int quantidadeDeMeses = scanner.nextInt();

        System.out.print("Informe o capital inicial: ");
        double capitalInicial = scanner.nextDouble();

        scanner.close();

        double montante = calcularMontanteJurosCompostos(capitalInicial, taxaDeJuros, quantidadeDeMeses);

        System.out.println("O montante ao término do período será: " + montante);
    }

    public static double calcularMontanteJurosCompostos(double capitalInicial, double taxaDeJuros, int quantidadeDeMeses) {
        double montante = capitalInicial * Math.pow(1 + taxaDeJuros, quantidadeDeMeses);
        return montante;
    }
}

