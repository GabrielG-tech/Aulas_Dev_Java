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

        JLabel label = new JLabel("Resposta");
        panel.add(label);

        frame.setLayout(new FlowLayout());
        final JPanel contentPanel = (JPanel)frame.getContentPane();
        frame.setVisible(true);

        try {
            while (true) {
                String path = "https://webwebwebsitee.000webhostapp.com/conteudo.txt";
                Document doc = Jsoup.connect(path).get();
                System.out.println(doc);

                label.setText(doc.toString());
                Thread.sleep(2000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* php
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Salvar Conteúdo em Arquivo</title>
</head>
<body>
  <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    <label for="conteudo">Digite o conteúdo:</label>
    <textarea id="conteudo" name="conteudo" rows="4" cols="50"></textarea>
    <br>
    <input type="submit" name="salvar" value="Salvar">
  </form>

  <?php
  if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["salvar"])) {
    $conteudo = $_POST["conteudo"];
    if (!empty($conteudo)) {
      $nomeArquivo = "conteudo.txt";
      $arquivo = fopen($nomeArquivo, "w");
      if ($arquivo === false) {
        echo '<p>Ocorreu um erro ao abrir o arquivo.</p>';
      } else {
        if (fwrite($arquivo, $conteudo) !== false) {
          echo '<p>Conteúdo salvo com sucesso!</p>';
        } else {
          echo '<p>Ocorreu um erro ao salvar o conteúdo.</p>';
        }
        fclose($arquivo);
      }
    } else {
      echo '<p>O campo de conteúdo está vazio. Por favor, insira algum conteúdo.</p>';
    }
  }
  ?>
</body>
</html>

*/