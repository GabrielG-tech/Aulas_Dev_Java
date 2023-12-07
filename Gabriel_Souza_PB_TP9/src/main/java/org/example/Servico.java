package org.example;

import java.time.LocalDateTime;

public class Servico {
    private LocalDateTime dataHoraCotacao;
    private LocalDateTime dataHoraExecucao;
    private double valor;
    private int avaliacao;
    private String local;
    private String observacoesCliente;

    public Servico(LocalDateTime dataHoraCotacao, LocalDateTime dataHoraExecucao, double valor, String local) {
        this.dataHoraCotacao = dataHoraCotacao;
        this.dataHoraExecucao = dataHoraExecucao;
        this.valor = valor;
        this.local = local;
    }

    // Getters e setters para os atributos

    public LocalDateTime getDataHoraCotacao() {
        return dataHoraCotacao;
    }

    public void setDataHoraCotacao(LocalDateTime dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }

    public LocalDateTime getDataHoraExecucao() {
        return dataHoraExecucao;
    }

    public void setDataHoraExecucao(LocalDateTime dataHoraExecucao) {
        this.dataHoraExecucao = dataHoraExecucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void avaliar(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacoesCliente() {
        return observacoesCliente;
    }

    public void informarObservacoes(String observacoesCliente) {
        this.observacoesCliente = observacoesCliente;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "dataHoraCotacao=" + dataHoraCotacao +
                ", dataHoraExecucao=" + dataHoraExecucao +
                ", valor=" + valor +
                ", avaliacao=" + avaliacao +
                ", local='" + local + '\'' +
                ", observacoesCliente='" + observacoesCliente + '\'' +
                '}';
    }
}
