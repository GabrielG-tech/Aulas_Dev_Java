package Desafios;

import java.util.Scanner;

public class Desafio7 {
    // Solicite ao usuário um valor em graus entre 0 e 360 e calcule o cosseno e seno.
    public static void main(String[] args) {
        double graus; String continuar;
        Scanner inp = new Scanner(System.in);
        do {
            do {
                System.out.print("Informe um valor de ângulo (0° a 360°): ");
                graus = inp.nextDouble();
            } while (graus < 0);

            while (graus > 360) {
                graus -= 360;
            };

            while (graus < 0) {
                graus += 360;
            };
            
            // if (graus % 180 == 0) {
            //     System.out.print(graus + " para ");
            //     System.out.printf("radianos: %.0f", Math.toRadians(graus));
            // } else {
            //     System.out.print(graus + " para ");
            //     System.out.printf("radianos: %.2f", Math.toRadians(graus));
            // }
            // double grausPi = Math.toRadians(graus)/Math.PI;
            // if ( grausPi == (int) grausPi ) {
            //     System.out.print("\n" + graus + " para ");
            //     System.out.printf("PI: %.0fπ", grausPi);
            // } else {
            //     System.out.print("\n" + graus + " para ");
            //     System.out.printf("PI: %.2fπ", grausPi);
            // }

            System.out.println("Seno: ");
            System.out.println("Cosseno: ");

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
