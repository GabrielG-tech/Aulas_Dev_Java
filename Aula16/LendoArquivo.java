package Aula16;

import java.io.*;

public class LendoArquivo {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(new File("Aula16\\output.txt")));
        
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
        reader.close();    
    }
}
