package Aula7.Pais;

public class Pais {
    // Atributos:
    String nome;
    double populacao;
    Pais(String nome, double populacao) {
        this.nome = "Pais";
        this.populacao = 0;
    };
        
    // Métodos: 
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }
    public double getPopulacao() {
        return populacao;
    }
}
