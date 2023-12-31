package org.example;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // Define a porta do servidor
        port(8080);

        Gson gson = new Gson();

        // Classes de exemplo
        Cliente cliente = new Cliente("João", "123456789", "joao@email.com", "123.123.123-00");
        Funcionario funcionario = new Funcionario("Maria", "987654321",
                "maria@email.com", "Gerente", "123.123.123-01");
        Agenda agenda = new Agenda();
        Imovel imovel = new Imovel("Rua Principal", "123", "Apto. 715", "Barra da Tijuca",
                "Rio de Janeiro", "RJ", "22620-000");

        // parâmetros de agendamento de um serviço:
        // 8 de dezembro de 2023 às 10:00
        LocalDateTime dataHoraCotacao = LocalDateTime.of(2023, 12, 8, 10, 0);
        // 10 de dezembro de 2023 às 14:30
        LocalDateTime dataHoraExecucao = LocalDateTime.of(2023, 12, 10, 14, 30);

        // Verifica se as datas que o cliente deseja estão disponiveis (mokadas)
        List<LocalDateTime> datasParaVerificar = new ArrayList<>();
        datasParaVerificar.add(dataHoraCotacao);
        datasParaVerificar.add(dataHoraExecucao);
        agenda.verificarDatasDisponiveis(datasParaVerificar);

        agenda.agendarData(dataHoraCotacao);
        agenda.agendarData(dataHoraExecucao);

        // Exemplo de criação de um novo serviço
        Servico servico = new Servico(dataHoraCotacao, dataHoraExecucao, 250.00, imovel);

        // Exemplo de retorno de local no qual serviço foi agendado
        System.out.println("\nLocal no qual serviço foi agenda:\n" + servico.getLocal());

        // ================================ Spark =========================================================

        // http://localhost:8080/cliente
        // adicionar um novo cliente
        post("/cliente", (req, res) -> {
            Cliente novoCliente = gson.fromJson(req.body(), Cliente.class);
            Cliente.adicionarCliente(novoCliente);
            res.status(201); // Cliente adicionado com sucesso
            return "Cliente adicionado com sucesso!";
        });

        // http://localhost:8080//cliente/Gabriel
        // obter informações de um cliente
        get("/cliente/:nome", (req, res) -> {
            String nomeCliente = req.params("nome");
            Cliente clienteEncontrado = Cliente.obterDetalhesCliente(nomeCliente);

            if (clienteEncontrado != null) {
                return gson.toJson(clienteEncontrado);
            } else {
                res.status(404); // Cliente não encontrado
                return "Cliente não encontrado.";
            }
        });

        // http://localhost:8080/funcionario
        // adicionar um novo funcionario
        post("/funcionario", (req, res) -> {
            Funcionario novoFuncionario = gson.fromJson(req.body(), Funcionario.class);
            Funcionario.adicionarFuncionario(novoFuncionario);
            res.status(201); // Funcionario adicionado com sucesso
            return "Funcionario adicionado com sucesso!";
        });

        // http://localhost:8080//funcionario/Joel
        // obter informações de um funcionario
        get("/funcionario/:nome", (req, res) -> {
            String nomeFuncionario = req.params("nome");
            Funcionario funcionarioEncontrado = Funcionario.obterDetalhesFuncionario(nomeFuncionario);

            if (funcionarioEncontrado != null) {
                return gson.toJson(funcionarioEncontrado);
            } else {
                res.status(404); // Funcionario não encontrado
                return "Funcionario não encontrado.";
            }
        });
    }
}