package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        // https://stackoverflow.com/questions/70393552/component-spacing-using-gridlayout

        JFrame frame = new JFrame("Criptografia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
//        frame.setLocationRelativeTo(null);
        frame.setLocation(980, 350);

        GridLayout layout = new GridLayout(3,2);
        layout.setHgap(10);
        layout.setVgap(10);

        JPanel panel = new JPanel();
        panel.setLayout(layout);

        JTextArea input_txt = new JTextArea(4, 2);
        JTextArea chave = new JTextArea(1,2);
        JTextArea output_txt = new JTextArea(4,2);

        //input_txt.setText("Texto");
        input_txt.setLineWrap(true);
        //output_txt.setText("Resposta");
        input_txt.setLineWrap(true);

        input_txt.setFont(new Font("Arial", Font.PLAIN, 14));
        output_txt.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel titulo1 = new JLabel("Mensagem:");
        titulo1.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel labelChave = new JLabel("Chave:");
        labelChave.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel titulo2 = new JLabel("Resultado:");
        titulo2.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(titulo1);
        panel.add(input_txt);
        panel.add(labelChave);
        panel.add(chave);
        panel.add(titulo2);
        panel.add(output_txt);

        String[] buttonLabels = {
                "Criptografia", "Descriptografia"
        };

        int x = 50;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(button);

            button.setBounds(x, 250, 140, 30);
            x += 150;

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int shift = Integer.parseInt(chave.getText()); // Obtenha o valor da chave do campo de texto

                        if (input_txt.getText() == null || input_txt.getText().trim().equals("")) {
                            output_txt.setText("Seu JTextField está vazio");
                            output_txt.setEnabled(false);
                        } else if (label.equals("Criptografia")) {
                            output_txt.setEnabled(true);
                            Criptografia dado = new Criptografia();
                            output_txt.setText(dado.encriptografar(input_txt.getText(), shift));
                        } else if (label.equals("Descriptografia")) {
                            output_txt.setEnabled(true);
                            Criptografia dado = new Criptografia();
                            output_txt.setText(dado.descriptografar(input_txt.getText(), shift));
                        }
                    } catch (NumberFormatException ex) {
                        output_txt.setText("Erro: Entrada inválida");
                    }
                }
            });
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}