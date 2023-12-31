package Biblioteca;

public class CD {
    private String artistaCompositor, gravadora, album, UPC;
    private int ano;
    
    public CD (String artistaCompositor, String gravadora, String album, int ano, String UPC) {
        this.artistaCompositor = artistaCompositor;
        this.gravadora = gravadora;
        this.album = album;
        this.ano = ano;
        this.UPC = UPC;
    }
    //GETTERS
    public String getArtistaCompositor() {
        return artistaCompositor;
    }
    public String getGravadora() {
        return gravadora;
    }
    public String getAlbum() {
        return album;
    }
    public int getAno() {
        return ano;
    }
    public String getUPC() {
        return UPC;
    }
    //SETTERS
    public void setArtistaCompositor(String artistaCompositor) {
        this.artistaCompositor = artistaCompositor;
    }
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
    }
}
