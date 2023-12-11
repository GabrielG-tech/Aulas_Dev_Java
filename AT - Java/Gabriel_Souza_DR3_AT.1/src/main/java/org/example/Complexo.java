package org.example;

public class Complexo {
    private double real;
    private double imaginario;

    public Complexo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public double getReal() {
        return real;
    }

    public double getImaginario() {
        return imaginario;
    }

    public Complexo somar(Complexo outro) {
        double novoReal = this.real + outro.getReal();
        double novoImaginario = this.imaginario + outro.getImaginario();
        return new Complexo(novoReal, novoImaginario);
    }

    public Complexo subtrair(Complexo outro) {
        double novoReal = this.real - outro.getReal();
        double novoImaginario = this.imaginario - outro.getImaginario();
        return new Complexo(novoReal, novoImaginario);
    }

    public double modulo() {
        return Math.sqrt(this.real * this.real + this.imaginario * this.imaginario);
    }
}
