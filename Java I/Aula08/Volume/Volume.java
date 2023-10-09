package Volume;

public class Volume {
    private double lado1, lado2, raio, altura;

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public double getCubo() {
        return Math.pow(lado1, 3);
    }

    public double getPrisma() {
        return lado1 * lado2 * altura;
    }

    public double getCilindro() {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    public double getEsfera() {
        return 4.0 / 3.0 * Math.PI * Math.pow(raio, 3); 
    }

    public double getCone() {
        return 1.0 / 3.0 * Math.PI * Math.pow(raio, 2) * altura;
    }

    public double getPiramide() {
        return 1.0 / 3.0 * Math.pow(lado1, 2) * altura;
    }
    
}
