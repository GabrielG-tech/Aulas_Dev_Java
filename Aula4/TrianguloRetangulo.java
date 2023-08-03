package Aula4;

import java.util.Scanner;

public class TrianguloRetangulo {
    public static void main(String[] args) {
        Float c1, c2, h;
        Scanner inp = new Scanner(System.in);
        System.out.println("Informe o primeiro cateto do triangulo: ");
        c1 = inp.nextFloat();
        System.out.println("Informe o segundo cateto do triangulo: ");
        c2 = inp.nextFloat();
        System.out.println("Informe a hipotenusa do triangulo: ");
        h = inp.nextFloat();
        inp.close();
        
        if (h*h == c1*c1 + c2*c2){
            System.out.println("Este triangulo é retangulo.");
        } else {
            System.out.println("Este triangulo não é retangulo.");
        }
    }
}
