package Aula6.ClasseCarro;

public class Carro {
    private String marca, modelo, cor, placa;

    Carro() {
        marca = "Muito";
        modelo = "Foda";
        cor = "Azul";
        placa = "H20V2";
    }

    // Constructor parametrizado
    Carro(String marca, String modelo, String cor, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    void liga() {
        System.out.printf("*Som de um %s %s ligando*", marca, modelo);
    }

    void desligar() {
        System.out.printf("*Som de um %s %s desligando*", marca, modelo);
    }

    void acelerar() {
        System.out.printf("*%s %s : VRUUUUUUUUUM*", marca, modelo);
    }

    void frear() {
        System.out.printf("*%s %s SKRRRRRRRRRR som de drift*", marca, modelo);
    }

    void setMarca(String mc) {
        marca = mc;
    };

    String getMarca() {
        return marca;
    }

    void setModelo(String modelo) {
        this.modelo = modelo;
    };

    String getModelo() {
        return modelo;
    }

    void setCor(String c) {
        cor = c;
    };

    String getCor() {
        return cor;
    }

    void setPlaca(String p) {
        placa = p;
    };

    String getPlaca() {
        return placa;
    }

    void getAll() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Placa: " + placa);
    }
}
