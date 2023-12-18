package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplexoTest {

    @Test
    public void testSoma() {
        Complexo complexo1 = new Complexo(2, 3);
        Complexo complexo2 = new Complexo(1, 4);

        Complexo resultado = complexo1.soma(complexo2);

        assertEquals(3.0, resultado.getReal(), 0.0001);
        assertEquals(7.0, resultado.getImaginario(), 0.0001);
    }

    @Test
    public void testSubtracao() {
        Complexo complexo1 = new Complexo(5, 6);
        Complexo complexo2 = new Complexo(2, 3);

        Complexo resultado = complexo1.subtracao(complexo2);

        assertEquals(3.0, resultado.getReal(), 0.0001);
        assertEquals(3.0, resultado.getImaginario(), 0.0001);
    }

    @Test
    public void testModulo() {
        Complexo complexo = new Complexo(3, 4);

        double modulo = complexo.modulo();

        assertEquals(5.0, modulo, 0.0001);
    }
}