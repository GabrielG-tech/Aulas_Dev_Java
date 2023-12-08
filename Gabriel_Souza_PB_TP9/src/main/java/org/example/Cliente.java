package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List<Cliente> listaDeClientes = new ArrayList<>();
    private String nome;
    private String telefone;
    private String email;

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Métodos de Gerenciamento de Clientes

    public static void adicionarCliente(Cliente novoCliente) {
        if (novoCliente != null) {
            if (!existeCliente(novoCliente.getNome())) {
                listaDeClientes.add(novoCliente);
                System.out.println("Funcionário adicionado com sucesso!");
            } else {
                System.out.println("O funcionário já existe na lista!");
            }
        }
    }

    public static void removerCliente(String nomeCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                listaDeClientes.remove(cliente);
                System.out.println("Cliente removido com sucesso!");
                break;
            }
        }
        System.out.println("Cliente não encontrado na lista!");
    }

    public static void atualizarCliente(String nomeCliente, Cliente novosDadosCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                cliente.setNome(novosDadosCliente.getNome());
                cliente.setTelefone(novosDadosCliente.getTelefone());
                cliente.setEmail(novosDadosCliente.getEmail());
                System.out.println("Dados do cliente atualizados com sucesso!");
                break;
            }
        }
    }

    public static List<Cliente> listarClientes() {
        return listaDeClientes;
    }

    public static Cliente obterDetalhesCliente(String nomeCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    private static boolean existeCliente(String nomeCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                return true;
            }
        }
        return false;
    }
}