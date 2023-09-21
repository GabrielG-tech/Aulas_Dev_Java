package Biblioteca;

import java.io.FileWriter;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaProg {
    static Scanner input = new Scanner(System.in);
    static Livro[] livros = new Livro[999];
    static Revista[] revistas = new Revista[999];
    static int escolha = 0, escolha2 = 0, NumCadastroLivro = 0, NumCadastroRevista = 0;

    private static void livroOuRevista() {
        System.out.println("=".repeat(42));

        System.out.println("    [1] - Procurar livro");
        System.out.println("    [2] - Procurar revista");
        try {
            System.out.print("Escolha uma das opçoes: ");
            escolha2 = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digite somente um dos números disponiveis.");
            input.next();
        }
    }

    private static void cadastrar() {
        try {
            try {
                String nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao;

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
                    livros[NumCadastroLivro] = new Livro(nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano,
                            secao);
                    NumCadastroLivro++;
                } else if (escolha2 == 2) { // Revista
                    ISBN = "-";
                    System.out.print("Digite o ISSN: ");
                    String ISSN = input.next();
                    input.nextLine();
                    revistas[NumCadastroRevista] = new Revista(nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao, ISSN);
                    NumCadastroRevista++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Erro: Lista cheia. ");
            }
        } catch (Throwable e) {
            System.out.println("Ocorreu um erro de cadastro, porfavor contate o suporte. Erro: " + e.toString());
        }
    }

    private static void procurar() {
        try {
            if (escolha2 == 1) { // Procurar livro
                System.out.print("Informe a palavra chave: ");
                String chaveLivro = input.next();

                for (int i = 0; i < NumCadastroLivro; i++) {
                    if (livros[i].getNomeLivro().toLowerCase().indexOf(chaveLivro.toLowerCase()) >= 0) {
                        System.out.println("\nLivros: " + (i + 1));
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
            }
        } catch (Throwable e) {
            System.out.println(
                    "Ocorreu um erro de procura de livro/revista, porfavor contate o suporte. Erro: " + e.toString());
        }
    }

    private static void listar() {
        try {
            if (escolha2 == 1) { // Listar livro
                if (NumCadastroLivro == 0) {
                    System.out.println("Nenhum livro cadastrado ainda.");
                } else {
                    System.out.println("=".repeat(124));
                    System.out.printf(
                            "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
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
            } else if (escolha2 == 2) { // Listar revista
                if (NumCadastroRevista == 0) {
                    System.out.println("Nenhuma revista cadastrada ainda.");
                } else {
                    System.out.println("=".repeat(124));
                    System.out.printf(
                            "| %-11s | %-11s | %-11s | %-11s | %-11s | %-11s | %-10s | %-10s | %-10s |",
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
        } catch (Throwable e) {
            System.out.println(
                    "Ocorreu um erro de listar de livro/revista, porfavor contate o suporte. Erro: " + e.toString());
        }
    }

    private static void quantidadeCadastrada() {
        try {
            System.out.println("=".repeat(42));
            System.out.printf("%-40s", "| Quantidade de livros usados: " + NumCadastroLivro);
            System.out.println(" |");
            System.out.printf("%-40s", "| Quantidade de revistas usadas: " + NumCadastroRevista);
            System.out.println(" |");
            System.out.printf("%-40s",
                    "| Quantidade livre: " + (1000 - (NumCadastroLivro + NumCadastroRevista)));
            System.out.println(" |");
            System.out.println("=".repeat(42));
        } catch (Throwable e) {
            System.out.println(
                    "Ocorreu um erro ao tentar exibir a quantidade de itens cadastrados, porfavor contate o suporte. Erro: "
                            + e.toString());
        }
    }

    public static String barraQuantidade(int limite) {
        int NumCadastrados = NumCadastroLivro + NumCadastroRevista;
        String barra = "";
        for (int i = (limite - 200); i < limite; i++) {
            if (i < NumCadastrados) {
                barra += "|";
            } else {
                barra += " ";
            }
        }

        return barra;
    }

    /*
     * System.out.println("x " + "=".repeat(200) + " x");
     * System.out.println("| " + placeMemoryGraph(200) + " |");
     * System.out.println("| " + placeMemoryGraph(400) + " |");
     * System.out.println("| " + placeMemoryGraph(600) + " |");
     * System.out.println("| " + placeMemoryGraph(800) + " |");
     * System.out.println("| " + placeMemoryGraph(1000) + " |");
     * System.out.println("x " + "=".repeat(200) + " x");
     * 
     * public static String placeMemoryGraph(int limit) {
     * String a = "";
     * for (int i = (limit - 200); i < limit; i++) {
     * if (i < listaDeLivros.size()) {
     * a += "|";
     * } else {
     * a += " ";
     * }
     * }
     * 
     * return a;
     * }
     */

    // System.out.println("# "+"=".repeat(100)+" #");
    // System.out.println("| "+ barraQuantidade(100) + " |");
    // System.out.println("# " + "=".repeat(100) + " #");
    // }

    private static void ordenar() {
        if (escolha2 == 1) { // Ordenar livro
            for (int i = 0; i < (NumCadastroLivro - 1); i++) {
                for (int j = 0; j < (NumCadastroLivro - 1); j++) {
                    Livro aux = new Livro();
                    Livro aux1 = new Livro();
                    aux = livros[i];
                    aux1 = livros[i + 1];
                    if (aux.getNomeLivro().toLowerCase().compareTo(aux1.getNomeLivro().toLowerCase()) > 0) {
                        livros[i] = aux1;
                        livros[i + 1] = aux;
                    }
                }
            }
            for (int i = 0; i < NumCadastroLivro; i++) {
                System.out.println("- " + livros[i].getNomeLivro());
            }
        } else if (escolha2 == 2) { // Excluir revista
            for (int i = 0; i < (NumCadastroRevista - 1); i++) {
                for (int j = 0; j < (NumCadastroRevista - 1); j++) {
                    Revista aux = new Revista();
                    Revista aux1 = new Revista();
                    aux = revistas[i];
                    aux1 = revistas[i + 1];
                    if (aux.getNomeLivro().toLowerCase().compareTo(aux1.getNomeLivro().toLowerCase()) > 0) {
                        revistas[i] = aux1;
                        revistas[i + 1] = aux;
                    }
                }
            }
            for (int i = 0; i < NumCadastroLivro; i++) {
                System.out.println("- " + livros[i].getNomeLivro());
            }
        }
    }

    private static void excluir() {
        if (escolha2 == 1) { // Excluir livro
            for (int i = 0; i < NumCadastroLivro; i++) {
                if (NumCadastroLivro > 0) {
                    NumCadastroLivro--;
                    livros[NumCadastroLivro] = null;
                }
            }
            System.out.println("Último item excluido de livro com sucesso!");
        } else if (escolha2 == 2) { // Excluir revista
            for (int i = 0; i < NumCadastroRevista; i++) {
                if (NumCadastroRevista > 0) {
                    NumCadastroRevista--;
                    revistas[NumCadastroRevista] = null;
                }
            }
            System.out.println("Último item excluido de revista com sucesso!");
        }
    }

    public static void salvarArquivo() {
        try {
            FileWriter arquivo = new FileWriter(new File("Livros", "livro.txt"));
            int k;

            for (k = 0; k < NumCadastroLivro; k++) {
                arquivo.write(livros[k].getNomeLivro() + ", " + 
                              livros[k].getAutor() + ", " + 
                              livros[k].getEditora() + ", " + 
                              livros[k].getPrateleira() + ", " + 
                              livros[k].getISBN() + ", " + 
                              livros[k].getCDD() + ", " + 
                              livros[k].getEdicao() + ", " + 
                              livros[k].getAno() + ", " + 
                              livros[k].getSecao() + ", " + 
                ",\n");
            }
            arquivo.close();
            
            FileWriter arquivo1 = new FileWriter(new File("Revistas", "revista.txt"));
            
            for (k = 0; k < NumCadastroRevista; k++) {
                //nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao, ISSN
                arquivo1.write(revistas[k].getNomeLivro() + ", " + 
                              revistas[k].getAutor() + ", " + 
                              revistas[k].getEditora() + ", " + 
                              revistas[k].getPrateleira() + ", " + 
                              revistas[k].getISBN() + ", " + 
                              revistas[k].getCDD() + ", " + 
                              revistas[k].getEdicao() + ", " + 
                              revistas[k].getAno() + ", " + 
                              revistas[k].getSecao() + ", " + 
                              revistas[k].getISSN() + ", " + 
                ",\n");
            }
            arquivo1.close();   
        } catch (Throwable e) {
            System.out.println("Ocorreu um erro ao tentar salvar o arquivo contate o suporte. Erro: " + e);
        }
    }

    public static void carregarArquivo() {
        try {
            String str;
            BufferedReader reader, reader1;

            reader = new BufferedReader(new FileReader(new File("Aula08\\Biblioteca\\Livros\\livro.txt")));
            while ((str = reader.readLine()) != null) {
                String[] arrOfStr = str.split(",");
                livros[NumCadastroLivro] = new Livro(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6], arrOfStr[7], arrOfStr[8]);
                NumCadastroLivro++;
            }
            reader.close();

            reader1 = new BufferedReader(new FileReader(new File("Aula08\\Biblioteca\\Revistas\\revista.txt")));
            while ((str = reader1.readLine()) != null) {
                String[] arrOfStr = str.split(",");
                revistas[NumCadastroRevista] = new Revista(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6], arrOfStr[7], arrOfStr[8], arrOfStr[9]);
                NumCadastroRevista++;
            }
            reader1.close();
            
        } catch (Throwable e) {
            System.out.println("Ocorreu um erro ao tentar carregar o arquivo contate o suporte. Erro: " + e);
        }
    }

    public static void main(String[] args) {
        carregarArquivo();

        do {
            System.out.println("=".repeat(42));
            System.out.printf("| %-38s |\n", "     Sistema de Cadastro de revistas");
            System.out.println("=".repeat(42));
            System.out.println("[1]  - Cadastrar livro/revista");
            System.out.println("[2]  - Procurar livro/revista");
            System.out.println("[3]  - Listar livros/revistas");
            System.out.println("[4]  - Quantidade cadastrada/livre");
            System.out.println("[5]  - Excluir livro/revista");
            System.out.println("[6]  - Ordenar cadastrados");
            System.out.println("[7]  - Sair");
            System.out.println("[11] - Criar Livro/Revista de exemplo");
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
                    livroOuRevista();
                    cadastrar();
                    break;

                case 2: // Procurar
                    livroOuRevista();

                    procurar();
                    break;

                case 3: // Listar
                    livroOuRevista();
                    listar();
                    break;

                case 4: // Quantidade cadastrada/livre
                    quantidadeCadastrada();
                    // barraQuantidade();
                    break;

                case 5: // Excluir
                    livroOuRevista();
                    excluir();
                    break;

                case 6: // Ordenar cadastrados
                    livroOuRevista();
                    ordenar();
                    break;

                case 7: // Encerrar programa | Sair
                    System.out.println("Programa encerrado");
                    escolha = 7;
                    break;

                case 11: // Cria livro padrão
                    livroOuRevista();
                    if (escolha2 == 1) {
                        try {
                            System.out.print("Insira a quantidade de livros que deseja adicionar: ");
                            int quantExemplos = input.nextInt();
                            for (int i = 0; i < quantExemplos; i++) {
                                if (NumCadastroRevista % 2 == 0) {
                                    livros[NumCadastroLivro] = new Livro("Livro", "autor", "editora", "prateleira",
                                            "ISBN",
                                            "CDD",
                                            "edicao", "ano", "secao");
                                } else {
                                    livros[NumCadastroLivro] = new Livro("nomeLivro2", "autor2", "editora2",
                                            "prateleira2",
                                            "ISBN2",
                                            "CDD2",
                                            "edicao2", "ano2", "secao2");
                                }
                                NumCadastroLivro++;
                            }
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Erro: Lista cheia. ");
                            break;
                        }
                    } else if (escolha2 == 2) {
                        try {
                            System.out.print("Insira a quantidade de revista que deseja adicionar: ");
                            int quantExemplos = input.nextInt();
                            for (int i = 0; i < quantExemplos; i++) {
                                if (NumCadastroRevista % 2 == 0) {
                                    revistas[NumCadastroRevista] = new Revista("nomeRevista", "autor", "editora",
                                            "prateleira",
                                            "----",
                                            "CDD", "edicao", "ano", "secao", "ISSN");
                                } else {
                                    revistas[NumCadastroRevista] = new Revista("nomeRevista2", "autor2", "editora2",
                                            "prateleira2",
                                            "----",
                                            "CDD2", "edicao2", "ano2", "secao2", "ISSN2");
                                }
                                NumCadastroRevista++;
                            }
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.print("Erro: Lista cheia. ");
                            escolha = 7;
                            break;
                        }
                    }
            }
        } while (escolha != 7);
        input.close();
        salvarArquivo();
    }
}