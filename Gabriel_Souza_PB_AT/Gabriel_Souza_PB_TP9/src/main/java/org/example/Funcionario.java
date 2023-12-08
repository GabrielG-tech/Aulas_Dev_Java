package org.example;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();
    private String nome;
    private String telefone;
    private String email;
    private String cargo;

    public Funcionario(String nome, String telefone, String email, String cargo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    // Métodos para gerenciamento de funcionários

    public void adicionarFuncionario(Funcionario novoFuncionario) {
        if (novoFuncionario != null) {
            if (!existeFuncionario(novoFuncionario.getNome())) {
                listaFuncionarios.add(novoFuncionario);
                System.out.println("Funcionário adicionado com sucesso!");
            } else {
                System.out.println("O funcionário já existe na lista!");
            }
        }
    }

    public static void removerFuncionario(String nomeFuncionario) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome().equals(nomeFuncionario)) {
                listaFuncionarios.remove(funcionario);
                System.out.println("Funcionário removido com sucesso!");
                break;
            }
        }
        System.out.println("Funcionário não encontrado na lista!");
    }

    public void atualizarFuncionario(String nomeFuncionario, Funcionario novosDadosFuncionario) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome().equals(nomeFuncionario)) {
                funcionario.setTelefone(novosDadosFuncionario.getTelefone());
                funcionario.setEmail(novosDadosFuncionario.getEmail());
                funcionario.setCargo(novosDadosFuncionario.getCargo());
                System.out.println("Dados do funcionário atualizados com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado na lista!");
    }

    public List<Funcionario> listarFuncionarios() {
        return listaFuncionarios;
    }

    private boolean existeFuncionario(String nomeFuncionario) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome().equals(nomeFuncionario)) {
                return true;
            }
        }
        return false;
    }
}