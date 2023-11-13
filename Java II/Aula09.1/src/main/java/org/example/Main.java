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
        JFrame frame = new JFrame("Exemplo JComboBox");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 2;
        int height = screenSize.height;
        frame.setSize(width, height);
        frame.setLocation(screenSize.width / 2, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new FlowLayout());
        final JPanel contentPanel = (JPanel)frame.getContentPane();
        frame.setVisible(true);

        while(true) {
            try {
                String path = "https://sitetestegabrielsilveira.000webhostapp.com/arquivoTexto.txt";
                Document doc = Jsoup.connect(path).get();

                String corSelecionada = doc.body().ownText();

                if (corSelecionada.equals("0")) {
                    contentPanel.setBackground(Color.GREEN);
                } else if (corSelecionada.equals("1")) {
                    contentPanel.setBackground(Color.YELLOW);
                } else if (corSelecionada.equals("2")) {
                    contentPanel.setBackground(Color.RED);
                }
                Thread.sleep(2000);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

//    public static void Cor() {
//
//    }
}