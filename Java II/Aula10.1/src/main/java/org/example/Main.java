package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Digite o valor para enviar via POST: ");
            String valorPost = reader.readLine();
            String url = "https://webwebwebsitee.000webhostapp.com/index.php?valor_get";

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes("valor_post=" + valorPost);
                wr.flush();
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Resposta do servidor: " + response.toString());

//                Document doc = Jsoup.connect(url).get();
//                System.out.println(doc);
//                label.setText(doc.toString());
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
  <title>Salvar em Arquivo</title>
</head>
<body>

  <?php
  if ($_SERVER["REQUEST_METHOD"] == "POST" {
      if (isset($_POST['valor_post'])) {
        $valorPost = $_POST['valor_post'];
        $arquivo = fopen('dados.txt', 'w');
        fwrite($arquivo, $valorPost);
        fclose($arquivo);
        echo '<p>Valor do médoto POST salvo com sucesso!</p>';
    }
  }

  if ($_SERVER["REQUEST_METHOD"] == "GET") {
    if (isset($_GET['valor_get'])) {
      $valorGet = $_GET['valor_get'];
      $arquivo = fopen('dados.txt', 'w');
      fwrite($arquivo, $valorGet);
      fclose($arquivo);
      echo '<p>Valor do método GET salvo com sucesso!</p>';
    }
  }
  ?>
</body>
</html>
*/