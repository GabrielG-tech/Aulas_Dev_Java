package org.example;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);

        get("/nome", (req, res) -> { // http://localhost:8080/nome?nome=Gabriel&sobrenome=Gomes
            //pega o parâmetro na URL
            String nome = req.queryParams("nome");
            String sobrenome = req.queryParams("sobrenome");
            System.out.println(nome + " " + sobrenome);
            return "Nome cadastrado: " + nome + " " + sobrenome;
        });

        get("/hello", (req, res) -> "Hello World!!!"); // http://localhost:8080/hello
        get("/inicia", (req, res) -> "Iniciando..."); // http://localhost:8080/inicia
        get("/executa", (req, res) -> "Executando..."); // http://localhost:8080/executa
        get("/fim", (req, res) -> "Fim."); // http://localhost:8080/fim

        abrirPagWeb("http://localhost:8080/nome?nome=Gabriel&sobrenome=Gomes");
    }

    // MÉTODO QUE ABRE UMA PÁGINA DA WEB
    public static void abrirPagWeb(String link) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(link));
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println(e);
        }
    }
}