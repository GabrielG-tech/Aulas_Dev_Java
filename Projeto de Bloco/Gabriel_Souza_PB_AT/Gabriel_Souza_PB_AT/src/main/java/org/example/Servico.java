package org.example;

import java.time.LocalDateTime;

public class Servico {
    private LocalDateTime dataHoraCotacao;
    private LocalDateTime dataHoraExecucao;
    private double valor;
    private int avaliacao;
    private String local;
    private String observacoesCliente;

    public Servico(LocalDateTime dataHoraCotacao, LocalDateTime dataHoraExecucao, double valor, Imovel local) {
        this.dataHoraCotacao = dataHoraCotacao;
        this.dataHoraExecucao = dataHoraExecucao;
        this.valor = valor;
        this.local =  "Endereço: " + local.getLogradouro() +
                ", " + local.getNumero() +
                ", " + local.getComplemento() +
                ", " + local.getBairro() +
                ", " + local.getCidade() +
                ", " + local.getEstado() +
                "\nCEP: " + local.getCep();
    }

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

    public void atualizarServico(LocalDateTime novaDataHoraExecucao, double novoValor, String novoLocal) {
        this.dataHoraExecucao = novaDataHoraExecucao;
        this.valor = novoValor;
        this.local = novoLocal;
    }

    // adicionar uma avaliação ao serviço
    public void adicionarAvaliacao(int novaAvaliacao) {
        if (novaAvaliacao >= 1 && novaAvaliacao <= 5) {
            this.avaliacao = novaAvaliacao;
        } else {
            System.out.println("Avaliação inválida. A avaliação deve estar entre 1 e 5.");
        }
    }

    public void adicionarObservacoes(String novasObservacoes) {
        this.observacoesCliente = novasObservacoes;
    }

    public String obterDetalhesServico() {
        return "Data e hora de execução: " + dataHoraExecucao +
                "\nValor: " + valor +
                "\nLocal: " + local +
                "\nAvaliação: " + avaliacao +
                "\nObservações do cliente: " + observacoesCliente;
    }
}