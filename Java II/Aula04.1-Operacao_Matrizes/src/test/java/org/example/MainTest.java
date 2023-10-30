package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void somaMatriz() {
        Calculadora calc = new Calculadora();
        assertEquals(110, calc.somar(60,50));
    }

    @Test
    void subtracaoMatriz() {
        Calculadora calc = new Calculadora();
        assertEquals(10, calc.subtrair(60,50));
    }

    @Test
    void multMatriz() {
        Calculadora calc = new Calculadora();
        assertEquals(41, calc.multiplicar(2,3,5,7));
    }

    @Test
    void escalMatriz() {
        Calculadora calc = new Calculadora();
        assertNotEquals(3, calc.escalar(2, 2));
    }

    @Test
    void teste5() {
        assertTrue(5>4);
        assertTrue(null==null);
    }

    @Test
    void teste6() {
        assertFalse(5>6);
    }

    @Test
    void teste7() {
        Object dog = new Object();
        assertNotNull(dog);
    }

    @Test
    void teste8() {
        Object cat = null;
        assertNull(cat);
    }

    @Test
    void teste9() {
        String str1="India";
        String str2="India";
        assertSame(str1, str2);
    }

    @Test
    void teste10() {
        String str1="índia";
        String str2="India";
        assertNotSame(str1, str2);
    }

    @Test
    void teste11() {
        String str1="India";
        String str2="India";
        assertSame(str1, str2);
    }


}