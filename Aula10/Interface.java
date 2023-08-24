public class Interface implements Regra {
    @Override
    public void metodo1() {

    }
    @Override
    public int metodo2() {
        return(0);
    }

    public static void main(String[] args) {
        CarroH2 carro = new CarroH2();
        carro.setModelo("FIAT MOBI");
        System.out.println(carro.getModelo());
        carro.setModelo("FIAT MOBI", 2025);
        System.out.println(carro.getModelo());
    }
}
