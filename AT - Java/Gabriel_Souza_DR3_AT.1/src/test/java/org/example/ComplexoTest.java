package org.example;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ComplexoTest {

    @Test
    public void testSoma() {
        Complexo c1 = new Complexo(3.0, 2.0);
        Complexo c2 = new Complexo(1.0, 4.0);
        Complexo resultado = c1.somar(c2);
        assertEquals(4.0, resultado.getReal());
        assertEquals(6.0, resultado.getImaginario());
    }

    @Test
    public void testSubtracao() {
        Complexo c1 = new Complexo(5.0, 7.0);
        Complexo c2 = new Complexo(2.0, 3.0);
        Complexo resultado = c1.subtrair(c2);
        assertEquals(3.0, resultado.getReal());
        assertEquals(4.0, resultado.getImaginario());
    }

    @Test
    public void testModulo() {
        Complexo c = new Complexo(3.0, 4.0);
        double modulo = c.modulo();
        assertEquals(5.0, modulo);
    }
}
