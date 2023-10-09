package Aula06.ClasseConta;

public class Conta {
    private int numero;
    private String dono;
    private double saldo;
    private double limite;

    Conta() {
        numero = 25696969;
        dono = "José Paulo";
        saldo = 6500.50;
        limite = 8000;
    }

    void setNumero(int numero) {
        this.numero = numero;
    }

    int getNumero() {
        return numero;
    }

    void setDono(String dono) {
        this.dono = dono;
    }

    String getDono() {
        return dono;
    }

    void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    double getSaldo() {
        return saldo;
    }

    void setLimite(double limite) {
        this.limite = limite;
    }

    double getLimite() {
        return limite;
    }

    void depositar(double valor) {
        saldo += valor;
    }

    boolean saque(double valor) {
        if (saldo >= valor)
            return true;
        else
            return false;
    }

    void printCliente() {
        System.out.println("Dono: " + dono);
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("Limite: " + limite);
    }

}
