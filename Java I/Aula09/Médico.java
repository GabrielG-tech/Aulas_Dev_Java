package Aula09;

public abstract class Médico {
    String nome, CRM;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public String getCRM() {
        return CRM;
    }
}
