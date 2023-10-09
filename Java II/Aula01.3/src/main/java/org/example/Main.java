package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Capitais");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Dimension tamanhoJanela = Toolkit.getDefaultToolkit().getScreenSize();
        //janela.setBounds(tamanhoJanela.width/2, tamanhoJanela.height/2, 250, 150);
        janela.setSize(250, 150);

        JPanel painel = new JPanel();
        janela.add(painel);

        JButton botaoRJ = new JButton("Botão RJ");
        botaoRJ.setBounds(60, 50, 100, 30);
        painel.add(botaoRJ);
        botaoRJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "A capital do Rio de Janeiro é Rio de Janeiro");
            }
        });

        JButton botaoSP = new JButton("Botão SP");
        botaoSP.setBounds(220, 50, 100, 30);
        painel.add(botaoSP);
        botaoSP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "A capital de São Paulo é São Paulo");
            }
        });

        JButton botaoMG = new JButton("Botão MG");
        botaoMG.setBounds(60, 100, 100, 30);
        painel.add(botaoMG);
        botaoMG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "A capital de Minas Gerais é Belo Horizonte");
            }
        });

        JButton botaoES = new JButton("Botão ES");
        botaoES.setBounds(220, 100, 100, 30);
        painel.add(botaoES);
        botaoES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "A capital do Espírito Santo é Vitória");
            }
        });

        JButton botaoPA = new JButton("Botão PA");
        botaoPA.setBounds(60, 150, 100, 30);
        painel.add(botaoPA);
        botaoPA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "A capital do Pará é Belém");
            }
        });

        JButton botaoBA = new JButton("Botão BA");
        botaoBA.setBounds(220, 150, 100, 30);
        painel.add(botaoBA);
        botaoBA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "A capital da Bahia é Salvador");
            }
        });

        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }
}
