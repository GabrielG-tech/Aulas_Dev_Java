package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<LocalDate> datasOcupadas;

    public Agenda() {
        datasOcupadas = new ArrayList<>();
    }

    public void adicionarDataOcupada(LocalDate data) {
        datasOcupadas.add(data);
    }

    public void removerDataOcupada(LocalDate data) {
        datasOcupadas.remove(data);
    }

    public List<LocalDate> getDatasOcupadas() {
        return datasOcupadas;
    }

    public void listarDatasOcupadas() {
        if (datasOcupadas.isEmpty()) {
            System.out.println("Não há datas ocupadas na agenda.");
        } else {
            System.out.println("Datas ocupadas na agenda:");
            for (LocalDate data : datasOcupadas) {
                System.out.println(data);
            }
        }
    }

    public boolean verificarDataDisponivel(LocalDate data) {
        return !datasOcupadas.contains(data);
    }

    public void verificarDatasDisponiveis(List<LocalDate> datasParaVerificar) {
        for (LocalDate data : datasParaVerificar) {
            if (verificarDataDisponivel(data)) {
                System.out.println("Data disponível para agendamento: " + data);
            } else {
                System.out.println("Data ocupada: " + data);
            }
        }
    }

    public void agendarData(LocalDate data) {
        if (verificarDataDisponivel(data)) {
            adicionarDataOcupada(data);
            System.out.println("Data agendada com sucesso para: " + data);
        } else {
            System.out.println("A data " + data + " está ocupada. Escolha outra data.");
        }
    }

    // Método para cancelar uma data agendada
    public void cancelarData(LocalDate data) {
        if (datasOcupadas.contains(data)) {
            removerDataOcupada(data);
            System.out.println("Agendamento cancelado para a data: " + data);
        } else {
            System.out.println("A data " + data + " não está agendada.");
        }
    }
}
