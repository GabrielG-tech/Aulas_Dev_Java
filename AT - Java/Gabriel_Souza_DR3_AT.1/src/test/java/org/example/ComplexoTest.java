package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class ComplexoTest extends TestCase {

    public void testGetReal() {
    }

    public void testGetImaginario() {
    }

    @Test
    public void testSoma() {
        Complexo c1 = new Complexo(2, 3);
        Complexo c2 = new Complexo(1, 4);
        Complexo resultado = c1.somar(c2);
        assertEquals(3, resultado.getReal(), 0.001);
        assertEquals(7, resultado.getImaginario(), 0.001);
    }

    @Test
    public void testSubtracao() {
        Complexo c1 = new Complexo(5, 8);
        Complexo c2 = new Complexo(2, 3);
        Complexo resultado = c1.subtrair(c2);
        assertEquals(3, resultado.getReal(), 0.001);
        assertEquals(5, resultado.getImaginario(), 0.001);
    }

    @Test
    public void testModulo() {
        Complexo c = new Complexo(3, 4);
        double resultado = c.modulo();
        assertEquals(5, resultado, 0.001);
    }
}