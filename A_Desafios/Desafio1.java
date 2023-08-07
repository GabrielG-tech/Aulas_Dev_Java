package A_Desafios;

import java.util.Scanner;
import java.lang.Math;

public class Desafio1 {
    // Faça uma equação que informe o perímetro e
    // a área de uma circunferencia.
    public static void main(String[] args) {
        double raio, perímetro, área;
        Scanner inp = new Scanner(System.in);

        System.out.println("Informe o raio: ");
        raio = inp.nextFloat();
        inp.close();

        perímetro = 2 * Math.PI * raio;
        área = Math.PI * Math.pow(raio, 2);

        System.out.println("Perímetro: " + perímetro);
        System.out.println("Area: " + área);
    }
}
