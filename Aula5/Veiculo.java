package Aula5;

public class Veiculo {
    private int passageiros;
    private int capacidade;
    private int kml;
    private int autonomia;
    private String tipo;

    // Constructor parametrizado
    Veiculo(int p, int c, int k) {
        passageiros = p;
        capacidade = c;
        kml = k;
    }

    void setPassageiros(int p) {
        passageiros = p;
    };

    int getPassageiros() {
        return passageiros;
    }

    void setCapacidade(int c) {
        capacidade = c;
    };

    int getCapacidade() {
        return capacidade;
    }

    void setAutonomia(int a) {
        autonomia = a;
    };

    void setKml(int k) {
        kml = k;
    };

    int getKml() {
        return kml;
    }

    int getAutonomia() {
        return(kml*capacidade);
    }

    void printAutonomia(String t) {
        System.out.println("Autonomia (Kml*Capacidade) da " + tipo + " é " + getAutonomia() + "km/L");
        tipo = t;
    }

    int getEstimativa() {
        return(kml*capacidade);
    }

    void printEstimativa(int distancia) {
        System.out.println("Estimativa da " + tipo + " para andar " + distancia + " é de " + getEstimativa() + " litros.");
    }
}
