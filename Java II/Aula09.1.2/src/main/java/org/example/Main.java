package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Exemplo JComboBox - Cores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JPanel panel = new JPanel();
        frame.add(panel);

        frame.setLayout(new FlowLayout());
        final JPanel contentPanel = (JPanel)frame.getContentPane();
        frame.setVisible(true);
        //https://testeinfnet.000webhostapp.com//arquivo.txt
        //https://webwebwebsitee.000webhostapp.com/
        try {
            while (true) {
                String path = "https://webwebwebsitee.000webhostapp.com//arquivoTexto.txt";
                Document doc = Jsoup.connect(path).get();
                System.out.println(doc);

                String corSelecionada = doc.toString();
                System.out.println(corSelecionada);

                if (corSelecionada.indexOf('2') != -1)
                    contentPanel.setBackground(Color.RED);
                else if (corSelecionada.indexOf('1') != -1)
                    contentPanel.setBackground(Color.YELLOW);
                else if (corSelecionada.indexOf('0') != -1)
                    contentPanel.setBackground(Color.GREEN);
                Thread.sleep(2000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
