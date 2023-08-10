package Aula6.ClasseConta;

public class Classe2 {
    public static void main(String[] args) {
        
        Conta cliente1 = new Conta();

        cliente1.setDono("João");
        cliente1.setLimite(0);
        cliente1.setNumero(123456);
        cliente1.setSaldo(1000);

        cliente1.printCliente();
        cliente1.saque(500);
        cliente1.printCliente();

    }
}
