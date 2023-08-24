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
            System.out.println("[2] - Cadastrar revista"); // por Herança
            System.out.println("[3] - Procurar livro"); // por palavra chave
            System.out.println("[4] - Listar livros");
            System.out.println("[5] - Quantidade cadastrada/livre"); // x livros cadastrados | y livre
            System.out.println("[6] - Excluir último elemento da lista");
            System.out.println("[7] - Ordenar livros cadastrados");
            System.out.println("[8] - Sair");
            System.out.println("\n=======================================\n");
            System.out.print("Escolha uma das opçoes: ");
            escolha = input.nextInt();

            switch (escolha) {
                case 1: // Cadastrar livro
                    String nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao;
                    System.out.print("Digite o nome do livro: ");
                    nomeLivro = input.next();
                    input.nextLine();

                    System.out.print("Digite o nome do autor: ");
                    autor = input.next();
                    input.nextLine();

                    System.out.print("Digite o nome da editora: ");
                    editora = input.next();
                    input.nextLine();

                    System.out.print("Digite a prateleira: ");
                    prateleira = input.next();
                    input.nextLine();

                    System.out.print("Digite o ISBN: ");
                    ISBN = input.next();
                    input.nextLine();

                    System.out.print("Digite o CDD: ");
                    CDD = input.next();
                    input.nextLine();

                    System.out.print("Digite a edicao: ");
                    edicao = input.next();
                    input.nextLine();

                    System.out.print("Digite o ano de lançamento: ");
                    ano = input.next();
                    input.nextLine();

                    System.out.print("Digite a secao: ");
                    secao = input.next();
                    input.nextLine();

                    livros[NumCadastro] = new Livro(nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano,
                            secao);

                    NumCadastro++;
                    break;

                case 2: // Cadastrar revista

                    break;

                case 3: // Procurar livro

                    break;

                case 4: // Listar livros
                    if (NumCadastro == 0) {
                        System.out.println("Nenhum livro cadastrado ainda.");
                    } else {
                        System.out.printf("%9s", "\n==============");
                        System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Nome",
                                "Autor", "ISBN", "Ano", "Editora", "Prateleira", "Secao", "CDD", "Edicao");
                        for (int i = 0; i < NumCadastro; i++) {
                            System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                                    livros[i].getNomeLivro(), livros[i].getAutor(), livros[i].getISBN(),
                                    livros[i].getAno(), livros[i].getEditora(), livros[i].getPrateleira(),
                                    livros[i].getSecao(), livros[i].getCDD(), livros[i].getEdicao());

                        }
                        System.out.printf("%9s", "\n==============");
                    }
                    break;

                case 5: // Quantidade cadastrada/livre
                    System.out.println("\n================================");
                    System.out.printf("%-30s", "| Quantidade usada: " + NumCadastro);
                    System.out.println(" |");
                    System.out.printf("%-30s", "| Quantidade livre: " + (999 - NumCadastro));
                    System.out.println(" |");
                    System.out.println("================================\n");
                    break;

                case 6: // Excluir último elemento da lista
                    for (int i = 0; i < NumCadastro; i++) {
                        if (NumCadastro > 0) {
                            NumCadastro--;
                            livros[NumCadastro] = null;
                        }
                    }
                    System.out.println("Último item excluido com sucesso!");
                    break;

                case 7: // Ordenar livros cadastrados
                    // for (int i = 0; i < NumCadastro; i++) {
                    // livros[i].sort(getNomeLivro());
                    // }
                    // for (int i = 0; i < NumCadastro; i++) {
                    // System.out.println("- " + livros[i].getNomeLivro());
                    // }
                    break;

                case 8: // Encerrar programa | Sair
                    System.out.println("Programa encerrado");
                    escolha = 8;
                    break;
            }

        } while (escolha != 8);

        input.close();
    }
}
