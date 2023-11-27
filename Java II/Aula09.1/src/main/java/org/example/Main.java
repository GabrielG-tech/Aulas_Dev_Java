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
        static JFrame frame = new JFrame("Cores");

        public static void main(String[] args) throws InterruptedException {
            //https://testeinfnet.000webhostapp.com//arquivo.txt
            try { //https://webwebwebsitee.000webhostapp.com/
                String path = "https://webwebwebsitee.000webhostapp.com/arquivo.txt";
                int value = -1;

                while (true) {
                    Document doc = Jsoup.connect(path).get();
                    int first = Integer.parseInt(doc.body().ownText());

                    if (first != value) {
                        Janela(doc.body().ownText());
                        value = Integer.parseInt(doc.body().ownText());
                    }
                    Thread.sleep(2000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void Janela(String type) {
            //frame.setSize(400, 400);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width / 2;
            int height = screenSize.height / 2;
            frame.setSize(width, height);
            frame.setLocation(0, 0);

            switch (type) {
                case "0":
                    frame.getContentPane().setBackground(Color.GREEN);
                    break;
                case "1":
                    frame.getContentPane().setBackground(Color.YELLOW);
                    break;
                case "2":
                    frame.getContentPane().setBackground(Color.RED);
            }
            frame.setVisible(true);
        }
    }
