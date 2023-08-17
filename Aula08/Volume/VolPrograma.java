package Aula08.Volume;

import java.util.Scanner;

public class VolPrograma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolha;
        double volume = 0;
        String nomeVol = "";
        Volume vol = new Volume();

        System.out.println("Informe o tipo de sólido que deseja calcular: ");
        System.out.println("[1] Cubo \n[2] Prisma \n[3] Cilindro \n[4] Esfera \n[5] Cone \n[6] Pirâmide \n");
        escolha = input.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Informe o valor do lado 1: ");
                vol.setLado1(input.nextFloat());
                nomeVol = "do Cubo";
                volume = vol.getCubo();
                break;

            case 2:
                System.out.print("Informe o valor do lado 1: ");
                vol.setLado1(input.nextFloat());

                System.out.print("Informe o valor do lado 2: ");
                vol.setLado2(input.nextFloat());

                System.out.print("Informe o valor do altura: ");
                vol.setAltura(input.nextFloat());
                nomeVol = "do Prisma";
                volume = vol.getPrisma();
                break;

            case 3:
                System.out.print("Informe o valor do altura: ");
                vol.setAltura(input.nextFloat());

                System.out.print("Informe o valor do raio: ");
                vol.setRaio(input.nextFloat());
                nomeVol = "do Cilindro";
                volume = vol.getCilindro();
                break;

            case 4:
                System.out.print("Informe o valor do raio: ");
                vol.setRaio(input.nextFloat());
                nomeVol = "da Esfera";
                volume = vol.getEsfera();
                break;

            case 5:
                System.out.print("Informe o valor do altura: ");
                vol.setAltura(input.nextFloat());

                System.out.print("Informe o valor do raio: ");
                vol.setRaio(input.nextFloat());
                nomeVol = "do Cone";
                volume = vol.getCone();
                break;

            case 6:
                System.out.print("Informe o valor do lado 1: ");
                vol.setLado1(input.nextFloat());

                System.out.print("Informe o valor do altura: ");
                vol.setAltura(input.nextFloat());
                nomeVol = "da Pirâmide";
                volume = vol.getPiramide();
                break;
        }
        input.close();

        System.out.printf("\nVolume %s: %.2f uv", nomeVol, volume);

    }
}
