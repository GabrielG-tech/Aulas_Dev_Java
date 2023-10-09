package Aula09;

import Aula09.Médico_Filhos.Cardiologista;
import Aula09.Médico_Filhos.Endocrinologista;
import Aula09.Médico_Filhos.Oftamologista;
import Aula09.Médico_Filhos.Pediatria;
import Aula09.Médico_Filhos.Cirurgião;
import Aula09.Médico_Filhos.CirurgiãoPlástico;

public class Classe { 
    // class public
    // class protected
    // class private
    public static void main(String[] args) {
        Cardiologista c1 = new Cardiologista();
        Endocrinologista c2 = new Endocrinologista();
        Oftamologista c3 = new Oftamologista();
        Pediatria c4 = new Pediatria();
        Cirurgião c5 = new Cirurgião();
        // Médico m1 = new Médico(); <- classe abstact
        CirurgiãoPlástico m2 = new CirurgiãoPlástico();

        m2.setAnoFormação(2018);

        c1.setNome("João");
        c1.setCRM("123456");
        c1.setAnoFormação(2010);

        System.out.println(c1.getNome());
        System.out.println(c1.getCRM());
        System.out.println(c1.getAnoFormação());
        
        c2.setNome("Paula");
        c2.setCRM("123457");
        c2.setAnoFormação(2011);

        System.out.println(c2.getNome());
        System.out.println(c2.getCRM());
        System.out.println(c2.getAnoFormação());
        
        c3.setNome("Pedro");
        c3.setCRM("123458");
        c3.setAnoFormação(2012);

        System.out.println(c3.getNome());
        System.out.println(c3.getCRM());
        System.out.println(c3.getAnoFormação());

        c4.setNome("Anna");
        c4.setCRM("123460");
        c4.setAnoFormação(2009);

        System.out.println(c4.getNome());
        System.out.println(c4.getCRM());
        System.out.println(c4.getAnoFormação());
        
        c5.setNome("Henrique");
        c5.setCRM("123465");
        c5.setAnoFormação(2014);

        System.out.println(c5.getNome());
        System.out.println(c5.getCRM());
        System.out.println(c5.getAnoFormação());
    }
}
