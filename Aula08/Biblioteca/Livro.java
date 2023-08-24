package Biblioteca;

public class Livro {
    private String nomeLivro;
    private String autor;
    private String editora;
    private String prateleira;
    private String ISBN;
    private String CDD;
    private String edicao;
    private String ano;
    private String secao;

    Livro(String nomeLivro, String autor, String editora, String prateleira, String ISBN, String CDD, String edicao, String ano, String secao) {
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.editora = editora;
        this.prateleira = prateleira;
        this.ISBN = ISBN;
        this.CDD = CDD;
        this.edicao = edicao;
        this.ano = ano;
        this.secao = secao;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setCDD(String CDD) {
        this.CDD = CDD;
    }

    public String getCDD() {
        return CDD;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAno() {
        return ano;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getSecao() {
        return secao;
    }
}
