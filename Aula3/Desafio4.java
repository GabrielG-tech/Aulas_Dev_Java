package Aula3;

import java.util.Scanner;

public class Desafio4 {

    // Faça um código que peça 9 número de uma matriz 3x3,
    // imprima a matriz e calcule sua determinante.
    public static void main(String[] args) {
        int n=3, i, j;
        float d;
        float[][] matriz=new float[n][n];
        Scanner inp = new Scanner(System.in);

        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.println("Informe o elemento a " + (i+1) + ", " + (j+1));
                matriz[i][j]=inp.nextFloat();
            }
            
        }
        
        inp.close();

        System.out.println("A matriz é:");
        
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
        
        d = (matriz[0][0] * matriz[1][1] * matriz[2][2]) + (matriz[0][1] * matriz[1][2] * matriz[2][0]) + (matriz[0][2] * matriz[1][0] * matriz[2][1]) - 
            (matriz[0][1] * matriz[1][0] * matriz[2][2]) - (matriz[0][0] * matriz[1][2] * matriz[2][1]) - (matriz[0][2] * matriz[1][1] * matriz[2][0]);
             
        System.out.println("Determinante: " + d);
    }
}
