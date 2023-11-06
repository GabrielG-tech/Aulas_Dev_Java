package org.example;

public class Criptografia {
    public String encripotografar(String msg, int shift) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            ch = (char) (ch + shift);
            resultado.append(ch);
        }
        return resultado.toString();

    }

    public String descripotografar(String msg, int shift) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            ch = (char) (ch - shift);
            resultado.append(ch);
        }
        return resultado.toString();

    }
}
