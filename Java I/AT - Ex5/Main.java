import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Interface para calcular o rendimento
interface Rendimento {
    double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic);
}

// Classe abstrata RendaFixa
abstract class RendaFixa {
    private String nome;
    private String cpf;
    private String banco;

    public RendaFixa(String nome, String cpf, String banco) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
    }

    // Método abstrato para calcular o rendimento
    public abstract double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic);

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getBanco() {
        return banco;
    }
}

// Classe CDB
class CDB extends RendaFixa {
    private double juros;

    public CDB(String nome, String cpf, String banco) {
        super(nome, cpf, banco);
        this.juros = 1.20; // 120% CDI
    }

    @Override
    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        // Lógica para calcular o rendimento do CDB com imposto de renda
        // Implemente de acordo com a regra do imposto de renda para CDB
        double rendimento = valorInvestido * Math.pow((1 + (juros / 100)), tempoMeses);
        return rendimento;
    }
}

// Classe LCI
class LCI extends RendaFixa {
    private double juros;

    public LCI(String nome, String cpf, String banco) {
        super(nome, cpf, banco);
        this.juros = 1.00; // 100% CDI
    }

    @Override
    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        double rendimento = valorInvestido * Math.pow((1 + (juros / 100)), tempoMeses);
        return rendimento;
    }
}

// Classe LCA
class LCA extends RendaFixa {
    private double juros;

    public LCA(String nome, String cpf, String banco) {
        super(nome, cpf, banco);
        this.juros = 1.05; // 105% CDI
    }

    @Override
    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        double rendimento = valorInvestido * Math.pow((1 + (juros / 100)), tempoMeses);
        return rendimento;
    }
}

// Classe Poupança
class Poupanca extends RendaFixa {
    private double juros;

    public Poupanca(String nome, String cpf, String banco) {
        super(nome, cpf, banco);
        this.juros = 0.5; // 0.5% a.m.
    }

    @Override
    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        // Lógica para calcular o rendimento da poupança com base na SELIC
        if (taxaSelic >= 8.5) {
            return valorInvestido * Math.pow((1 + (juros / 100)), tempoMeses);
        } else {
            return valorInvestido * Math.pow((1 + (0.7 * taxaSelic / 100)), tempoMeses);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor a ser investido (R$):");
        double valorInvestido = scanner.nextDouble();

        System.out.println("Informe o tempo de investimento (meses):");
        int tempoMeses = scanner.nextInt();

        System.out.println("Informe a taxa SELIC do ano (%):");
        double taxaSelic = scanner.nextDouble();

        // Criar objetos de investimento
        RendaFixa cdb = new CDB("Investidor 1", "123456789", "Banco A");
        RendaFixa lci = new LCI("Investidor 2", "987654321", "Banco B");
        RendaFixa lca = new LCA("Investidor 3", "555555555", "Banco C");
        RendaFixa poupanca = new Poupanca("Investidor 4", "111111111", "Banco D");

        // Calcular rendimentos
        double rendimentoCDB = cdb.calcularRendimento(valorInvestido, tempoMeses, taxaSelic);
        double rendimentoLCI = lci.calcularRendimento(valorInvestido, tempoMeses, taxaSelic);
        double rendimentoLCA = lca.calcularRendimento(valorInvestido, tempoMeses, taxaSelic);
        double rendimentoPoupanca = poupanca.calcularRendimento(valorInvestido, tempoMeses, taxaSelic);

        // Exibir resultados
        System.out.println("Rendimento do CDB: R$" + rendimentoCDB);
        System.out.println("Rendimento do LCI: R$" + rendimentoLCI);
        System.out.println("Rendimento do LCA: R$" + rendimentoLCA);
        System.out.println("Rendimento da Poupança: R$" + rendimentoPoupanca);

        // Escrever resultados em arquivo de texto
        try {
            FileWriter writer = new FileWriter("resultados.txt");
            writer.write("Rendimento do CDB: R$" + rendimentoCDB + "\n");
            writer.write("Rendimento do LCI: R$" + rendimentoLCI + "\n");
            writer.write("Rendimento do LCA: R$" + rendimentoLCA + "\n");
            writer.write("Rendimento da Poupança: R$" + rendimentoPoupanca + "\n");
            writer.close();
            System.out.println("Resultados foram escritos em 'resultados.txt'");
        } catch (IOException e) {
            System.err.println("Erro ao escrever resultados em arquivo.");
            e.printStackTrace();
        }
        scanner.close();
    }
}
