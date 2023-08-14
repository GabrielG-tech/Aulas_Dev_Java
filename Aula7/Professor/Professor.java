package Aula7.Professor;

public class Professor {
    // Atributos:
    String nome;
    int matrícula, cargaHorária;
    Professor(String nome, int matrícula, int cargaHorária) {
        this.nome = "Pedro";
        this.matrícula = 000000;
        this.cargaHorária = 8;
    };
        
    // Métodos: 
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setMatrícula(int matrícula) {
        this.matrícula = matrícula;
    }
    public int getMatrícula() {
        return matrícula;
    }
    public void setCargaHorária(int cargaHorária) {
        this.cargaHorária = cargaHorária;
    }
    public int getCargaHorária() {
        return cargaHorária;
    }
    public int getCargaHoráriaMensal() {
        return cargaHorária;
    }
}
