package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private LocalDate dataReservada;
    private Funcionario gerenteAlocado;
    private Cliente clienteReservado;
    private Imovel imovelReservado;
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

    public void verificarDatasDisponiveisGerente(Funcionario gerente) {
        if (gerente.getCargo().equals("Gerente")) {
            for (LocalDate data : datasOcupadas) {
                if (verificarDataDisponivel(data)) {
                    System.out.println("Data disponível para o gerente realizar cotação: " + data);
                } else {
                    System.out.println("Data ocupada para o gerente realizar cotação: " + data);
                }
            }
        } else {
            System.out.println("Apenas o gerente pode verificar datas disponíveis para realizar cotação.");
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

    public void apresentarDatasDisponiveis() {
        System.out.println("Datas disponíveis para agendamento:");
        for (LocalDate data : datasOcupadas) {
            if (verificarDataDisponivel(data)) {
                System.out.println(data);
            }
        }
    }

    public void selecionarData(LocalDate dataSelecionada, Cliente cliente) {
        if (verificarDataDisponivel(dataSelecionada)) {
            System.out.println("Data " + dataSelecionada + " selecionada com sucesso com a concordância do cliente: " + cliente.getNome());
        } else {
            System.out.println("A data " + dataSelecionada + " não está disponível para agendamento.");
        }
    }

    public void reservarDataParaServico(Funcionario gerente, LocalDate dataSelecionada) {
        if (verificarDataDisponivel(dataSelecionada)) {
            dataReservada = dataSelecionada;
            gerenteAlocado = gerente;
            System.out.println("Data reservada com sucesso para a criação do serviço.");
        } else {
            System.out.println("A data selecionada não está disponível para agendamento.");
        }
    }

    public void solicitarCpfCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, informe o CPF do cliente:");
        String cpf = scanner.nextLine();

        visualizarDadosCliente(cpf);
    }

    public void visualizarDadosCliente(String cpf) {
        Cliente clienteEncontrado = encontrarClientePorCpf(cpf);
        if (clienteEncontrado != null) {
            System.out.println("Dados do cliente:");
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private Cliente encontrarClientePorCpf(String cpf) {
        for (Cliente cliente : Cliente.listarClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void visualizarImovelResidencial() {
        System.out.println("Dados do imóvel residencial do cliente:");
        System.out.println(imovelReservado);
    }

    public void confirmarDadosCliente() {
        System.out.println("Dados do cliente confirmados.");
    }

    public void confirmarEnderecoCliente() {
        System.out.println("Endereço do cliente confirmado.");
    }

    public void marcarVisitaParaCotacao(LocalDate dataReservada, Imovel imovelReservado, Funcionario gerenteAlocado) {
        if (dataReservada != null && imovelReservado != null && gerenteAlocado != null) {
            System.out.println("Visita marcada para cotação:");
            System.out.println("Data: " + dataReservada);
            System.out.println("Imóvel: " + imovelReservado.getLogradouro() + ", " + imovelReservado.getNumero());
            System.out.println("Gerente alocado: " + gerenteAlocado.getNome());
        } else {
            System.out.println("Não foi possível marcar a visita para cotação.");
        }
    }

    public void enviarNotificacao(Funcionario gerenteAlocado) {
        if (gerenteAlocado != null) {
            System.out.println("Notificação enviada ao gerente: " + gerenteAlocado.getEmail());
        } else {
            System.out.println("Não foi possível enviar a notificação.");
        }
    }
}