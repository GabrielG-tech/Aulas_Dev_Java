package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testEncriptografar() {
        Criptografia criptografia = new Criptografia();
        String mensagem = "HELLO";
        int shift = 3;
        String resultado = criptografia.encriptografar(mensagem, shift);
        assertEquals("KHOOR", resultado);
    }

    @Test
    void testDescriptografar() {
        Criptografia criptografia = new Criptografia();
        String mensagem = "KHOOR";
        int shift = 3;
        String resultado = criptografia.descriptografar(mensagem, shift);
        assertEquals("HELLO", resultado);
    }

    @Test
    void testEncriptografarComChaveNegativa() {
        Criptografia criptografia = new Criptografia();
        String mensagem = "HELLO";
        int shift = -3;
        String resultado = criptografia.encriptografar(mensagem, shift);
        assertEquals("EBIIL", resultado);
    }

    @Test
    void testDescriptografarComChaveNegativa() {
        Criptografia criptografia = new Criptografia();
        String mensagem = "EBIIL";
        int shift = -3;
        String resultado = criptografia.descriptografar(mensagem, shift);
        assertEquals("HELLO", resultado);
    }

    @Test
    void testEncriptografarComEspacosEOutrosCaracteres() {
        Criptografia criptografia = new Criptografia();
        String mensagem = "Hello, World!";
        int shift = 3;
        String resultado = criptografia.encriptografar(mensagem, shift);
        assertEquals("Khoor, Zruog!", resultado);
    }

    @Test
    void testDescriptografarComEspacosEOutrosCaracteres() {
        Criptografia criptografia = new Criptografia();
        String mensagem = "Khoor, Zruog!";
        int shift = 3;
        String resultado = criptografia.descriptografar(mensagem, shift);
        assertEquals("Hello, World!", resultado);
    }
}