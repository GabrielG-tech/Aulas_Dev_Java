package Aula2;

import java.util.Scanner;
import java.lang.Math;

public class Desafio1 {
    public static void main(String[] args) {
        double raio, perímetro, área;
        Scanner inp = new Scanner(System.in);

        System.out.println("Informe o raio: ");
        raio = inp.nextFloat();

        perímetro = 2 * Math.PI * raio;
        área = Math.PI * Math.pow(raio, 2);

        System.out.println("Perímetro: " + perímetro);
        System.out.println("Área: " + área);
    }
}
