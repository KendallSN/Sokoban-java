package sokoban.models;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileTextReader {
        private String ruta ="src\\main\\resources\\levels\\";
        private List<char[]> listaChar = new ArrayList<>();
        
    public FileTextReader() {
        for (int i = 1; i < 6; i++) {
            try (FileReader leer = new FileReader(ruta+"Level"+i+".txt")) {
                int caracter;
                int cont=0;
                char[] vec=new char[121];
                while ((caracter = leer.read()) != -1) {
                    if(caracter=='*'||caracter=='#'||caracter=='.'||caracter==' '||caracter=='@'||caracter=='$'){
                        vec[cont]=(char)caracter;
                        cont++;
                    }
                }
                listaChar.add(vec);
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo: " + ex.getMessage());
            }
        }
    }

    public List<char[]> getListaChar() {
        return listaChar;
    }
}