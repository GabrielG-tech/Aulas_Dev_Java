package Biblioteca;

import java.util.Scanner;

public class BibliotecaProg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Livro[] livros = new Livro[1000];
        int escolha = 0, NumCadastro = 0;
        do {
            System.out.println("\n=======================================");
            System.out.println("|    Sistema de Cadastro de Livros    |");
            System.out.println("=======================================\n");
            System.out.println("[1] - Cadastrar livro"); // de 0 a 999
            System.out.println("[2] - Procurar livro"); // por palavra chave
            System.out.println("[3] - Listar todos livros");
            System.out.println("[4] - Quantidade cadastrada/livre"); // x livros cadastrados | y livre
            System.out.println("[5] - Excluir último elemento da lista");
            System.out.println("[6] - Ordenar livros cadastrados");
            System.out.println("[7] - Sair");
            System.out.println("\n=======================================\n");
            System.out.print("Escolha uma das opçoes: ");
            escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    String nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao;
                    System.out.println("Digite o nome do livro: ");
                    nomeLivro = input.next();
                    input.nextLine();

                    System.out.println("Digite o nome do autor: ");
                    autor = input.next();
                    input.nextLine();

                    System.out.println("Digite o nome da editora: ");
                    editora = input.next();
                    input.nextLine();

                    System.out.println("Digite a prateleira: ");
                    prateleira = input.next();
                    input.nextLine();

                    System.out.println("Digite o ISBN: ");
                    ISBN = input.next();
                    input.nextLine();

                    System.out.println("Digite o CDD: ");
                    CDD = input.next();
                    input.nextLine();

                    System.out.println("Digite a edicao: ");
                    edicao = input.next();
                    input.nextLine();

                    System.out.println("Digite o ano de lançamento: ");
                    ano = input.next();
                    input.nextLine();

                    System.out.println("Digite a secao: ");
                    secao = input.next();
                    input.nextLine();

                    livros[NumCadastro] = new Livro(nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano,
                            secao);

                    NumCadastro++;
                    break;

                case 2:

                    break;

                case 3:
                    if (NumCadastro == 0) {
                        System.out.println("Nenhum livro cadastrado ainda.");
                    } else {
                        for (int i = 0; i < NumCadastro; i++) {
                            System.out.println("- " + livros[i].getNomeLivro());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=================================");
                    System.out.printf("%-30s %-1s", "| Quantidade cadastrada: " + NumCadastro, " |");
                    System.out.println();
                    System.out.printf("%-30s %-1s", "| Quantidade livre: " + (999 - NumCadastro), " |");
                    System.out.println();
                    System.out.println("=================================\n");
                    break;

                case 5:

                    break;

                case 6:

                    break;
            }

        } while (escolha != 7);

        input.close();
    }
}
