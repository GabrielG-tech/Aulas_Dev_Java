package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel painel = new JPanel();
        frame.add(painel);

        JLabel label = new JLabel("Digite seu nome: ");
        painel.add(label);

        JTextField textField = new JTextField(20);
        painel.add(textField);

        JButton button = new JButton("Saudação");
        painel.add(button);

        JLabel saudacaoLabel = new JLabel();
        painel.add(saudacaoLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obté, p texto inserido na caixa de texto
                String nome = textField.getText();

                // Exibe uma saudação com base no nome inserido
                if (!nome.isEmpty()) {
                    saudacaoLabel.setText("Olá, " + nome + "!");
                } else {
                    saudacaoLabel.setText("Por favor, digite seu nome.");
                }
            }
        });

        frame.setVisible(true);
    }
}