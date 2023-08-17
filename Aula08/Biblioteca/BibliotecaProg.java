package Aula08.Biblioteca;

import java.util.Scanner;

public class BibliotecaProg {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int escolha = 0;
        System.out.println("\n============================\n");
        System.out.println("[1] - Cadastrar livro");
        System.out.println("[2] - Procurar livro"); // por palavra chave
        System.out.println("[3] - Listar livros");
        System.out.println("[4] - Quantidade cadastrada/livre"); // x livros cadastrados | y livre
        System.out.println("[5] - Sair");
        System.out.println("\n============================\n");
        System.out.println("Escolha uma das opções:");
        escolha = input.nextInt();

        switch(escolha) {
            case 1:

            break;

            case 2:
            
            break;

            case 3:

            break;

            case 4:

            break;

            case 5:

            break;
        }

        input.close();
    }
}
