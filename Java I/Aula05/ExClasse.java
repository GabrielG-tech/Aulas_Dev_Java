package Aula05;

public class ExClasse {
    public static void main(String[] args) {
        
        Veiculo minivan = new Veiculo(5, 50, 10); // <-- Criando um objeto
        Veiculo truck = new Veiculo(2, 400, 2);

        // Ao definir as caracteristicas do Objeto como privada
        // só será possível chama-la com métodos
        // minivan.autonomia = 1000; 
        // minivan.capacidade = 50;
        // minivan.passageiros = 5;
        
        // truck.autonomia = 1000;
        // truck.capacidade = 50;
        // truck.passageiros = 5;

        /*minivan.setPassageiros(5);
        System.out.println("Passageiros: " + minivan.getPassageiros());

        minivan.setCapacidade(50);
        System.out.println("Capacidade (Litros): " + minivan.getCapacidade());

        minivan.setKml(15);
        System.out.println("Kml: " + minivan.getKml()); */
        
        minivan.printAutonomia("Minivan");
        minivan.printEstimativa(500);

        truck.printAutonomia("Truck");
        truck.printEstimativa(500);
    }
}
