package sokoban.models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileTextReader {
        private static String levelsPath = "src\\main\\resources\\levels\\";
        private static String levelSavedPath = "src\\main\\resources\\save\\levelSaved.txt";
        
                
    public static List<char[]> getLevelsList() {
        List<char[]> charList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            try (FileReader read = new FileReader(levelsPath+"Level"+i+".txt")) {
                int character;
                int cont=0;
                char[] vec=new char[121];
                while ((character = read.read()) != -1) {
                    if(character=='*'||character=='#'||character=='.'||character==' '||character=='@'||character=='$'){
                        vec[cont]=(char)character;
                        cont++;
                    }
                }
                charList.add(vec);
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo: " + ex.getMessage());
            }
        }return charList;
    }
    
    public static char[] getSavedLevel() {
            try (FileReader read = new FileReader(levelSavedPath)) {
                int character;
                int cont=0;
                char[] vec=new char[122];
                while ((character = read.read()) != -1) {
                    if(character=='*'||character=='#'||character=='.'||character==' '||character=='@'||character=='$'||(character>48&&character<54)){
                        vec[cont]=(char)character;
                        cont++;
                    }
                }
                return vec;
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo: " + ex.getMessage());
            }
        return null;
    }
    
    public static boolean isLevelSaved(){
        try (FileReader read = new FileReader(levelSavedPath)) {
                int caracter;
                int cont=0;
                while ((caracter = read.read()) != -1) {
                    cont++;
                }
                if(cont==0){
                    return false;
                }
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo: " + ex.getMessage());
            }
        return true;
    }
    public static void saveLevel(ListGrid levelToSave,int IDLevel){
        try (FileWriter write = new FileWriter(levelSavedPath)) {
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    write.write(levelToSave.getElement(i, j).getCharacter());
                }write.write("\n");
            }
            write.write(String.valueOf(IDLevel));
            
            } catch (Exception ex) {
                System.out.println("Error al leer el archivo: " + ex.getMessage());
            }
    }
}