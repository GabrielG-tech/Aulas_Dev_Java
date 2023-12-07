package org.example;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        // Interface Grafica
//        JFrame janelaCliente = new JFrame("Cliente");
//
//        janelaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        janelaCliente.setSize(450, 400);
//        Dimension screesize = Toolkit.getDefaultToolkit().getScreenSize();
//        janelaCliente.setLocation((int) screesize.getWidth() / 4, (int) screesize.getHeight() / 2);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(5, 2));
//
//        JTextField inputField1 = new JTextField(10);
//
//        JTextField outputField = new JTextField(10);
//        outputField.setEditable(false);
//
//        inputField1.setFont(new Font("Arial", Font.PLAIN, 30));
//        outputField.setFont(new Font("Arial", Font.PLAIN, 30));
//
//        JLabel label1 = new JLabel("Nome:");
//        JLabel label2 = new JLabel("Email:");
//
//        label1.setFont(new Font("Arial", Font.PLAIN, 30));
//        label2.setFont(new Font("Arial", Font.PLAIN, 30));
//
//        panel.add(label1);
//        panel.add(inputField1);
//        panel.add(label2);
//        panel.add(outputField);
//
//        JButton button = new JButton("Enviar");
//        button.setFont(new Font("Arial", Font.PLAIN, 30));
//        panel.add(button);
//
//        janelaCliente.setContentPane(panel);
//        janelaCliente.setVisible(true);

        // Criando um cliente
        Cliente cliente = new Cliente("João", "123456789", "joao@email.com");

        // Criando um funcionário
        Funcionario funcionario = new Funcionario("Maria", "987654321", "maria@email.com", "Atendente");

        // Criando um imóvel
        Imovel imovel = new Imovel("Rua das Flores", "123", "Apto 101", "Centro", "Cidade A", "Estado A", "12345-678");

        // Criando uma agenda
        Agenda agenda = new Agenda();
        agenda.adicionarDataOcupada(LocalDate.of(2023, 12, 1));
        agenda.adicionarDataOcupada(LocalDate.of(2023, 12, 5));
        agenda.adicionarDataOcupada(LocalDate.of(2023, 12, 10));

        // Verificando datas disponíveis na agenda
        List<LocalDate> datasParaVerificar = new ArrayList<>();
        datasParaVerificar.add(LocalDate.of(2023, 12, 1));
        datasParaVerificar.add(LocalDate.of(2023, 12, 3));
        datasParaVerificar.add(LocalDate.of(2023, 12, 15));
        System.out.println("Verificando datas disponíveis:");
        agenda.verificarDatasDisponiveis(datasParaVerificar);

        // Criando um serviço
        Servico servico = new Servico(LocalDateTime.of(2023, 12, 1, 10, 0),
                LocalDateTime.of(2023, 12, 1, 12, 0),
                100.0,
                "Casa do Cliente");

        // Avaliando o serviço
        servico.avaliar(4);

        // Informando observações sobre o serviço
        servico.informarObservacoes("Serviço realizado de forma satisfatória.");

        // Exibindo informações
        System.out.println("\nInformações do Cliente:");
        System.out.println(cliente);

        System.out.println("\nInformações do Funcionário:");
        System.out.println(funcionario);

        System.out.println("\nInformações do Imóvel:");
        System.out.println(imovel);

        System.out.println("\nDatas ocupadas na Agenda:");
        agenda.listarDatasOcupadas();

        System.out.println("\nInformações do Serviço:");
        System.out.println(servico);

        // Frameworok Spark
//        get("/nome", (req, res) -> {
//            String nome = req.queryParams("p");
//            numAcesso++;
//            inputField1.setText(nome);
//            outputField.setText(String.valueOf(numAcesso));
//
//            outputField2.setText(inputField1.getText());
//            outputField3.setText(Integer.toString(numAcesso));
//
//            String content = "{\n  \"nome\": \"" + inputField1.getText() + "\",\n  \"acesso\": \"" + numAcesso + "\"\n}\n";
//            history += content;
//            return history;
//        }); // http://localhost:8080/nome

//        post("/api", (req, tes) -> {
//            String corpoRequisicao = req.body();
//            System.out.println("Corpo JSON " + corpoRequisicao);
//            return "Dados JSON recebidos com sucesso!";
//        });
    }
}
