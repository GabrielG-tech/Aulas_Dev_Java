package Aula10;
public class Carro {
    protected String modelo;
    protected int ano;

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    void setModelo(String modelo) {
        this.modelo = modelo;
    }

    void setModelo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    void setAno(int ano) {
        this.ano = ano;
    }
}
