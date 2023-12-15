package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Agenda {
    private LocalDateTime dataReservada;
    private Funcionario gerenteAlocado;
    private Cliente clienteReservado;
    private Imovel imovelReservado;
    private List<LocalDateTime> datasOcupadas;

    public Agenda() {
        datasOcupadas = new ArrayList<>();
    }

    public void adicionarDataOcupada(LocalDateTime data) {
        datasOcupadas.add(data);
    }

    public void removerDataOcupada(LocalDateTime data) {
        datasOcupadas.remove(data);
    }

    public List<LocalDateTime> getDatasOcupadas() {
        return datasOcupadas;
    }

    public void listarDatasOcupadas() {
        if (datasOcupadas.isEmpty()) {
            System.out.println("Não há datas ocupadas na agenda.");
        } else {
            System.out.println("Datas ocupadas na agenda:");
            for (LocalDateTime data : datasOcupadas) {
                System.out.println(formatarParaBrasileiro(data));
            }
        }
    }

    public boolean verificarDataDisponivel(LocalDateTime data) {
        return !datasOcupadas.contains(data);
    }
    public void verificarDatasDisponiveis(List<LocalDateTime> datasParaVerificar) {
        for (LocalDateTime data : datasParaVerificar) {
            if (verificarDataDisponivel(data)) {
                System.out.println("Data disponível para agendamento: " + formatarParaBrasileiro(data));
            } else {
                System.out.println("Data ocupada: " + formatarParaBrasileiro(data));
            }
        }
    }

    public void verificarDatasDisponiveisGerente(Funcionario gerente) {
        if (gerente.getCargo().equals("Gerente")) {
            for (LocalDateTime data : datasOcupadas) {
                if (verificarDataDisponivel(data)) {
                    System.out.println("Data disponível para o gerente realizar cotação: " + formatarParaBrasileiro(data));
                } else {
                    System.out.println("Data ocupada para o gerente realizar cotação: " + formatarParaBrasileiro(data));
                }
            }
        } else {
            System.out.println("Apenas o gerente pode verificar datas disponíveis para realizar cotação.");
        }
    }

    public void agendarData(LocalDateTime data) {
        if (verificarDataDisponivel(data)) {
            adicionarDataOcupada(data);
            System.out.println("Data agendada com sucesso para: " + formatarParaBrasileiro(data));
        } else {
            System.out.println("A data " + data + " está ocupada. Escolha outra data.");
        }
    }

    // Método para cancelar uma data agendada
    public void cancelarData(LocalDateTime data) {
        if (datasOcupadas.contains(data)) {
            removerDataOcupada(data);
            System.out.println("Agendamento cancelado para a data: " + formatarParaBrasileiro(data));
        } else {
            System.out.println("A data " + data + " não está agendada.");
        }
    }

    public void apresentarDatasDisponiveis() {
        System.out.println("Datas disponíveis para agendamento:");
        for (LocalDateTime data : datasOcupadas) {
            if (verificarDataDisponivel(data)) {
                System.out.println(formatarParaBrasileiro(data));
            }
        }
    }

    public void selecionarData(LocalDateTime dataSelecionada, Cliente cliente) {
        if (verificarDataDisponivel(dataSelecionada)) {
            System.out.println("Data " + dataSelecionada + " selecionada com sucesso com a concordância do cliente: " + cliente.getNome());
        } else {
            System.out.println("A data " + dataSelecionada + " não está disponível para agendamento.");
        }
    }

    public void reservarDataParaServico(Funcionario gerente, LocalDateTime dataSelecionada) {
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


    public static String formatarParaBrasileiro(LocalDateTime dataHora) {
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm")
                .withLocale(new Locale("pt", "BR"));

        return dataHora.format(formatoBrasileiro);
    }
}