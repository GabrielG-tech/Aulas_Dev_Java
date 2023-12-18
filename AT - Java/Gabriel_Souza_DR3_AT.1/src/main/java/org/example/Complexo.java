package org.example;

public class Complexo {
    private double real;
    private double imaginario;

    public Complexo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public Complexo somar(Complexo outro) {
        return new Complexo(this.real + outro.real, this.imaginario + outro.imaginario);
    }

    public Complexo subtrair(Complexo outro) {
        return new Complexo(this.real - outro.real, this.imaginario - outro.imaginario);
    }

    public double modulo() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginario() {
        return this.imaginario;
    }

    @Override
    public String toString() {
        return "(" + this.real + ") + (" + this.imaginario + ")i";
    }
}
