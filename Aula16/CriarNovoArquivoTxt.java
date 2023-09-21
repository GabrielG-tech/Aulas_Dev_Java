package Aula16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriarNovoArquivoTxt {
    public static void main(String[] args) throws IOException {
        String str = "FileWriter and FileReader";
        FileWriter arquivo = new FileWriter(new File("Aula16", "output.txt"));
        arquivo.write(str);
        System.out.println("Writing successfull");
        arquivo.close();    
    }
}