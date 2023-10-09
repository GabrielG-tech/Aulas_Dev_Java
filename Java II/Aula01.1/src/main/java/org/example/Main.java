package org.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello IJ!");

        JFrame janela = new JFrame("Exemplo Swing") ;
        janela.setSize(400, 200);

        JButton botao = new JButton("Clique-me");

        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World!");
                System.out.println("Botão foi clicado!");
            }
        });

        janela.add(botao);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}