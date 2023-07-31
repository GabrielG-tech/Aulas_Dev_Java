package Aula2;

import java.util.Scanner;

public class exemplo2 {

    // Imprima uma matriz
    public static void main(String[] args) {
        int n=3, i, j;
        float[][] matriz=new float[n][n];
        Scanner inp = new Scanner(System.in);

        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.println("Informe o elemento a " + (i+1) + ", " + (j+1));
                matriz[i][j]=inp.nextFloat();
            }
        }

        System.out.println("A matriz é:");
        
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
