package Biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;
// TESTE GIT VSCODE
public class BibliotecaProg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Livro[] livros = new Livro[4];
        Revista[] revistas = new Revista[4];
        int escolha = 0, escolha2 = 0, NumCadastroLivro = 0, NumCadastroRevista = 0;
        do {
            System.out.println("=".repeat(42));
            System.out.printf("| %-38s |\n","     Sistema de Cadastro de Livros");
            System.out.println("=".repeat(42));
            System.out.println("[1]  - Cadastrar livro/revista");
            System.out.println("[2]  - Procurar livro/revista");
            System.out.println("[3]  - Listar livros/revistas");
            System.out.println("[4]  - Quantidade cadastrada/livre");
            System.out.println("[5]  - Excluir último elemento da lista");
            System.out.println("[6]  - Ordenar livros cadastrados");
            System.out.println("[7]  - Sair");
            System.out.println("[11] - Criar Livro Padrão");
            System.out.println("[12] - Criar Revista Padrão");
            System.out.println("=".repeat(42));

            try {
                System.out.print("Escolha uma das opçoes: ");
                escolha = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite somente um dos números disponiveis.");
                input.next();
                continue;
            }

            switch (escolha) {
                case 1: // Cadastrar
                    try {
                        System.out.println();
                        System.out.println("=".repeat(124));

                        System.out.println("    [1] - Cadastrar livro");
                        System.out.println("    [2] - Cadastrar revista");
                        String nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao;

                        try {
                            System.out.print("Escolha uma das opçoes: ");
                            escolha2 = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Digite somente um dos números disponiveis.");
                            input.next();
                        }

                        System.out.print("Digite o nome da obra: ");
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

                        if (escolha2 == 1) { // Livro
                            System.out.print("Digite o ISBN: ");
                            ISBN = input.next();
                            input.nextLine();
                            livros[NumCadastroLivro] = new Livro(nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao,
                                    ano, secao);
                            NumCadastroLivro++;
                            break;
                        } else if (escolha2 == 2) { // Revista
                            ISBN = "-";
                            System.out.print("Digite o ISSN: ");
                            String ISSN = input.next();
                            input.nextLine();
                            revistas[NumCadastroRevista] = new Revista(nomeLivro, autor, editora, prateleira, ISBN, CDD,
                                    edicao, ano, secao, ISSN);
                            NumCadastroRevista++;
                            break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.print("Erro: Lista cheia. ");
                        break;
                    }

                case 2: // Procurar
                    System.out.println();
                    System.out.println("=".repeat(124));

                    System.out.println("    [1] - Procurar livro");
                    System.out.println("    [2] - Procurar revista");
                    try {
                        System.out.print("Escolha uma das opçoes: ");
                        escolha2 = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Digite somente um dos números disponiveis.");
                        input.next();
                    }

                    if (escolha2 == 1) { // Procurar livro
                        System.out.println("Informe a palavra chave: ");
                        String chaveLivro = input.next();

                        for (int i = 0; i < NumCadastroLivro; i++) {
                            if (livros[i].getNomeLivro().toLowerCase().indexOf(chaveLivro.toLowerCase()) >= 0) {
                                System.out.println("Livros: " + (i + 1));
                                System.out.println("=".repeat(124));
                                System.out.printf(
                                        "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                        "Nome",
                                        "Autor", "ISBN", "Ano", "Editora", "Prateleira", "Secao", "CDD", "Edicao");
                                System.out.print("\n|" + "-".repeat(122) + "|");
                                System.out.println();
                                System.out.printf(
                                        "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                        livros[i].getNomeLivro(), livros[i].getAutor(), livros[i].getISBN(),
                                        livros[i].getAno(), livros[i].getEditora(), livros[i].getPrateleira(),
                                        livros[i].getSecao(), livros[i].getCDD(), livros[i].getEdicao());
                                System.out.println();
                                System.out.println("=".repeat(124));
                            }
                        }
                        break;
                    } else if (escolha2 == 2) { // Procurar revista
                        System.out.println("Informe a palavra chave: ");
                        String chaveRevista = input.next();

                        for (int i = 0; i < NumCadastroLivro; i++) {
                            if (livros[i].getNomeLivro().toLowerCase().indexOf(chaveRevista.toLowerCase()) >= 0) {
                                System.out.println("Livros: " + (i + 1));
                                System.out.println("=".repeat(124));
                                System.out.printf(
                                        "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                        "Nome",
                                        "Autor", "ISBN", "Ano", "Editora", "Prateleira", "Secao", "CDD", "Edicao");
                                System.out.print("\n|" + "-".repeat(122) + "|");
                                System.out.println();
                                System.out.printf(
                                        "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                        revistas[i].getNomeLivro(), revistas[i].getAutor(), revistas[i].getISSN(),
                                        revistas[i].getAno(), revistas[i].getEditora(), revistas[i].getPrateleira(),
                                        revistas[i].getSecao(), revistas[i].getCDD(), revistas[i].getEdicao());
                                System.out.println();
                                System.out.println("=".repeat(124));
                            }
                        }
                        break;
                    } else {
                        try {
                            System.out.print("Escolha uma das opçoes: ");
                            escolha2 = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Digite somente um dos números disponiveis.");
                            input.next();
                        }
                    }

                    break;

                case 3: // Listar
                    System.out.println();
                    System.out.println("=".repeat(124));
                    
                    System.out.println("    [1] - Listar livro");
                    System.out.println("    [2] - Listar revista");
                    try {
                        System.out.print("Escolha uma das opçoes: ");
                        escolha2 = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Digite somente um dos números disponiveis.");
                        input.next();
                    }

                    if (escolha2 == 1) { // Listar livro
                        if (NumCadastroLivro == 0) {
                            System.out.println("Nenhum livro cadastrado ainda.");
                        } else {
                            System.out.println("=".repeat(124));
                            System.out.printf("| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                    "Nome",
                                    "Autor", "ISBN", "Ano", "Editora", "Prateleira", "Secao", "CDD", "Edicao");
                            System.out.print("\n|" + "-".repeat(122) + "|");
                            for (int i = 0; i < NumCadastroLivro; i++) {
                                System.out.println();
                                System.out.printf(
                                        "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                        livros[i].getNomeLivro(), livros[i].getAutor(), livros[i].getISBN(),
                                        livros[i].getAno(), livros[i].getEditora(), livros[i].getPrateleira(),
                                        livros[i].getSecao(), livros[i].getCDD(), livros[i].getEdicao());
    
                            }
                            System.out.println();
                            System.out.println("=".repeat(124));
                        }
                        break;    
                    } else if (escolha2 == 2) { // Listar revista
                        if (NumCadastroRevista == 0) {
                            System.out.println("Nenhuma revista cadastrada ainda.");
                        } else {
                            System.out.println("=".repeat(124));
                            System.out.printf("| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                    "Nome",
                                    "Autor", "ISSN", "Ano", "Editora", "Prateleira", "Secao", "CDD", "Edicao");
                            System.out.print("\n|" + "-".repeat(122) + "|");
                            for (int i = 0; i < NumCadastroRevista; i++) {
                                System.out.println();
                                System.out.printf(
                                        "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
                                        revistas[i].getNomeLivro(), revistas[i].getAutor(), revistas[i].getISSN(),
                                        revistas[i].getAno(), revistas[i].getEditora(), revistas[i].getPrateleira(),
                                        revistas[i].getSecao(), revistas[i].getCDD(), revistas[i].getEdicao());
    
                            }
                            System.out.println();
                            System.out.println("=".repeat(124));
                        }
                    }

                case 4: // Quantidade cadastrada/livre
                    System.out.println("=".repeat(42));
                    System.out.printf("%-40s", "| Quantidade de livros usados: " + NumCadastroLivro);
                    System.out.println(" |");
                    System.out.printf("%-40s", "| Quantidade de revistas usadas: " + NumCadastroRevista);
                    System.out.println(" |");
                    System.out.printf("%-40s",
                            "| Quantidade livre: " + (1000 - (NumCadastroLivro + NumCadastroRevista)));
                    System.out.println(" |");
                    System.out.println("=".repeat(42));
                    break;

                case 5: // Excluir último elemento da lista
                    for (int i = 0; i < NumCadastroLivro; i++) {
                        if (NumCadastroLivro > 0) {
                            NumCadastroLivro--;
                            livros[NumCadastroLivro] = null;
                        }
                    }
                    System.out.println("Último item excluido com sucesso!");
                    break;

                case 6: // Ordenar livros cadastrados
                    System.out.println("Ordenar livros cadastrados em construção... (aguarde proximas versoes)");
                    // for (int i = 0; i < NumCadastroLivro; i++) {
                    // livros[i].sort(getNomeLivro());
                    // }
                    // for (int i = 0; i < NumCadastroLivro; i++) {
                    // System.out.println("- " + livros[i].getNomeLivro());
                    // }
                    break;

                case 7: // Encerrar programa | Sair
                    System.out.println("Programa encerrado");
                    escolha = 7;
                    break;

                case 11: // Cria livro padrão
                    try {
                        livros[NumCadastroLivro] = new Livro("nomeLivro", "autor", "editora", "prateleira", "ISBN", "CDD",
                                "edicao", "ano", "secao");
                        NumCadastroLivro++;
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Erro: Lista cheia. ");
                        break;
                    }

                case 12: // Cria revista padrão
                    try {
                        revistas[NumCadastroRevista] = new Revista("nomeRevista", "autor", "editora", "prateleira", "ISBN",
                                "CDD", "edicao", "ano", "secao", "ISSN");
                        NumCadastroRevista++;
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.print("Erro: Lista cheia. ");
                        escolha = 7;
                        break;
                    }
            }
        } while (escolha != 7);

        input.close();
    }
}