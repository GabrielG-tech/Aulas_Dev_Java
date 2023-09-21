package Aula10;
public class CarroH2 {
    String modelo; int ano;

    public void setModelo(String modelo) {
        this.modelo = modelo + " H2";
    }

    public void setModelo(String modelo, int ano) {
        this.modelo = modelo + " H2";
        this.ano = ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}
