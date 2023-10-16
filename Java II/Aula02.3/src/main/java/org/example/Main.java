package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        // frame.setLocation(970, 600);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("Selecione um mês:");
        panel.add(label); // Adicione o JLabel ao JPanel

        String[] meses = {"Janeiro", "Fevereiro", "Março",
                "Abril", "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro"};

        JComboBox<String> comboBox = new JComboBox<>(meses);
        panel.add(comboBox);

        JButton button = new JButton("Exibir Mês Selecionado");
        panel.add(button);

        JTextField textField = new JTextField(15);
        panel.add(textField);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém o mês selecionado a partir do JComboBox
                String mesSelecionado = (String) comboBox.getSelectedItem();

                // Exibir o mês selecionado na caixa de texto
                textField.setText("Mês Selecionado: " + mesSelecionado);
            }
        });

        frame.setVisible(true);
    }
}
