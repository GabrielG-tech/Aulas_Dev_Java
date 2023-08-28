package Biblioteca;

public class Revista extends Livro {
    private String ISSN;

    Revista(String nomeLivro, String autor, String editora, String prateleira, String ISBN, String CDD, String edicao, String ano, String secao, String ISSN) {
        super(nomeLivro, autor, editora, prateleira, ISBN, CDD, edicao, ano, secao);
        this.ISSN = ISSN;
    }
    
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getISSN() {
        return ISSN;
    }

}
