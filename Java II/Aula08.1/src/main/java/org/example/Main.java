package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "https://pt.wikipedia.org/wiki/Ovo_de_Colombo";

            Document doc = Jsoup.connect(path).get();
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}