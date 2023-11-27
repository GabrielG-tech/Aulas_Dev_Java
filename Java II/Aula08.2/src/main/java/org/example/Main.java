package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            /*String path = "https://pt.wikipedia.org/wiki/Wikip%C3%A9dia:P%C3%A1gina_principal";

            Document doc = Jsoup.connect(path).get();
            System.out.println(doc);*/

            //https://webwebwebsitee.000webhostapp.com/
            String path = "https://docs.oracle.com/en/java/javase/11/";
            Document doc = Jsoup.connect(path).get();
            Elements topics = doc.select("ul.topics");
            for (Element topic : topics) {
                for (Element listItem : topic.children()) {
                    for (Element link : listItem.children()) {
                        String url = link.attr("href");
                        String text = link.text();
                        System.out.println(url + " " + text);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
<html>
  <head>
    <title>Escrever em arquivo de texto com PHP e HTML</title>
  </head>
  <body>
    <form method="post">
      <button name="button0">Verde</button>
      <button name="button1">Amarelo</button>
      <button name="button2">Vermelho</button>
    </form>

    <?php
      if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (isset($_POST["button0"])) {
          writeToFile("0");
        } else if (isset($_POST["button1"])) {
          writeToFile("1");
        } else if (isset($_POST["button2"])) {
          writeToFile("2");
        }
      }

      function writeToFile($text) {
        $file = fopen("arquivoTexto.txt", "w");
        fwrite($file, $text.PHP_EOL);
        fclose($file);
      }
    ?>


  <!--
  This script places a badge on your repl's full-browser view back to your repl's cover
  page. Try various colors for the theme: dark, light, red, orange, yellow, lime, green,
  teal, blue, blurple, magenta, pink!
  -->
  <script src="https://replit.com/public/js/replit-badge-v2.js" theme="dark" position="bottom-right"></script>
  </body>
</html>
*/