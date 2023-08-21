package Aula09.Médico_Filhos;

import Aula09.Médico;

public class Endocrinologista extends Médico {
    private int anoFormação;

    public void setAnoFormação(int anoFormação) {
        this.anoFormação = anoFormação;
    }

    public int getAnoFormação() {
        return anoFormação;
    }
}
