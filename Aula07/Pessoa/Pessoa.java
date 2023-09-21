package Aula07.Pessoa;

public class Pessoa {
    // Atributos:
    String nome, gentílico;
    int idade, cargaHorária;
    double altura, peso;
    Pessoa(String nome, int idade, String gentílico) {
        this.nome = "Gabriel";
        this.idade = 20;
        this.gentílico = "Brasiliano";
    };
        
    // Métodos: 
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }
    public void setGentílico(String gentílico) {
        this.gentílico = gentílico;
    }
    public String getGentílico() {
        return gentílico;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public double getAltura() {
        return altura;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
}
