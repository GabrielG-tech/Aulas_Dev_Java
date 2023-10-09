package Aula05;

public class Veiculo {
    private int passageiros;
    private int capacidade;
    private int kml;
    private String tipo;

    Veiculo() {
        passageiros = 5;
        capacidade = 2;
        kml = 5;
    }

    // Constructor parametrizado
    Veiculo(int passageiros, int capacidade, int kml) {
        this.passageiros = passageiros;
        this.capacidade = capacidade;
        this.kml = kml;
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
