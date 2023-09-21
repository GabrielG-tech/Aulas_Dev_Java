package Aula06.ClasseCarro;

public class Classe {
    public static void main(String[] args) {
        Carro carl = new Carro();
        Carro caro = new Carro("Ford", "Mustang", "Azul", "HDR2043");
        
        System.out.println(caro.getMarca());
        
        System.out.println("\n============================\n");
        
        System.out.println("Marca: " + carl.getMarca());
        System.out.println("Modelo: " + carl.getModelo());
        System.out.println("Cor: " + carl.getCor());
        System.out.println("Placa: " + carl.getPlaca());

        System.out.println("\n============================\n");
        
        System.out.println("Marca: " + caro.getMarca());
        System.out.println("Modelo: " + caro.getModelo());
        System.out.println("Cor: " + caro.getCor());
        System.out.println("Placa: " + caro.getPlaca());

        System.out.println("\n============================\n");
        
        caro.getAll();
    }
}
