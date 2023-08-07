package A_Desafios;

import java.util.Scanner;

public class Desafio6 {
    // Solicite ao usuário um valor entre 0 e 360º e converta-o para radianos.
    public static void main(String[] args) {
        double graus;
        int voltas = 0;
        String continuar;
        Scanner inp = new Scanner(System.in);
        do {
            do {
                System.out.print("Informe um valor de ângulo (0° a 360°): ");
                graus = inp.nextDouble();
            } while (graus < 0);

            while (graus > 360) {
                graus -= 360;
                voltas += 1;
            };

            while (graus < 0) {
                graus += 360;
                voltas -= 1;
            };
            
            if (graus % 180 == 0) {
                System.out.print(graus + " para ");
                System.out.printf("radianos: %.0f", Math.toRadians(graus));
            } else {
                System.out.print(graus + " para ");
                System.out.printf("radianos: %.2f", Math.toRadians(graus));
            }
            double grausPi = Math.toRadians(graus)/Math.PI;
            if ( grausPi == (int) grausPi ) {
                System.out.print("\n" + graus + " para ");
                System.out.printf("PI: %.0fπ", grausPi);
            } else {
                System.out.print("\n" + graus + " para ");
                System.out.printf("PI: %.2fπ", grausPi);
            }

            System.out.println("\nNúmero de voltas: " + voltas);

            System.out.print("\nDeseja continuar? (s/n): ");
            continuar = inp.next().toLowerCase();

            while (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.println("Digite 's' para sim ou 'n' para nao: ");
                continuar = inp.next().toLowerCase();
            };
        } while (continuar.equals("s"));
        inp.close();
    }
}
