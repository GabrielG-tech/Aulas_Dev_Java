package Aula1;

import java.util.Scanner;
// import java.lang.Math;

public class aula1 {
    public static void main(String[] args) {
        /* String dado = "Hello World!";
        System.out.println("Padrão:" + dado);
        System.out.println("Upper:" + dado.toUpperCase());
        System.out.println("Lower:" + dado.toLowerCase());
        System.out.println("Tamanho:" + dado.length());
        System.out.println("SubString:" + dado.substring(6,11));
        System.out.println("Replace:" + dado.replaceAll("World", "Hello"));
         */
        // Olá Mundo!
        /*
        Olá
        Mundo
         */
        /* byte x;
        x = 25;
        System.out.println(x);
        
        int i;
        i = 999999999;
        System.out.println(i);
        
        char c = 'a';
        System.out.println(c);
        
        char q = '\u0058';
        System.out.println(q);
        
        float f = 1.5;
        System.out.println(f);
         */
 /*    
        int number1 = 71;
        char chars1 = (char)number1;
        
        int number2 = 65;
        char chars2 = (char)number2;
        
        int number3 = 66;
        char chars3 = (char)number3;
        
        int number4 = 82;
        char chars4 = (char)number4;
        
        int number5 = 73;
        char chars5 = (char)number5;
        
        int number6 = 69;
        char chars6 = (char)number6;
        
        int number7 = 76;
        char chars7 = (char)number7;
        
        System.out.println(chars1);
        System.out.println(chars2);
        System.out.println(chars3);
        System.out.println(chars4);
        System.out.println(chars5);
        System.out.println(chars6);
        System.out.println(chars7);              
        
        
        boolean y = true;
        System.out.println(y);
        
        y = false;
        
        if (y) {
            System.out.println("Yes");
        } else {
            System.out.println("No");     
        }
    }
         */
 /*
        int x = 10;
        
        x += 4;
        System.out.println("Soma: " + x);
        
        x -= 4;
        System.out.println("Subtracao: " + x);
        
        x *= 4;
        System.out.println("Produto: " + x);
        
        x /= 4;
        System.out.println("Divisao: " + x);
         */
 /*
        int x=10, y=20;
        boolean z;
         
        z = x==y;
         
        z = x==y;
        System.out.println("x==y = " + z );
         
        z = x!=y;
        System.out.println("x!=y = " + z );
         
        int t=10;
        System.out.println(t++);
        System.out.println(++t);
        System.out.println(t--);
        System.out.println(--t);
        System.out.println(t);
         */
 /*
        byte x = 0b00001011;
        System.out.println(x);
        System.out.println("Binario: " + Integer.toString(x,2)); // Binario
        System.out.println("Oct: " + Integer.toString(x,8)); // Oct
        System.out.println("Dec: " + Integer.toString(x,10)); // Dec
        System.out.println("Hexa: " + Integer.toString(x,16)); // Hexa
         */

        /*
        String nome;
        Scanner inp = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        nome = inp.nextLine();
        System.out.println("Ola " + nome + " seja muito bem-vindo ao Java!");
        */
        
        float a, b;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um numero:");
        a = entrada.nextFloat();
        System.out.println("Digite outro numero:");
        b = entrada.nextFloat();
        
        System.out.println("Soma: " + (a + b));
        
        entrada.close();     
    }
}
