import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

public class ObjetoFile {

    public void lecturaFicherosRecursiva(String path){
        File file = new File(path);
        File[] LISTADO= file.listFiles();
               
        if(LISTADO!=null){
            for(File item: LISTADO) {
                if (!item.isHidden()){

                    if (item.isDirectory()){
                        System.out.println("CAPERTA: "+item.getName());
                        lecturaFicherosRecursiva(item.getPath());
                    }else System.out.println("\t"+"ARCHIVO: "+item.getName());
                }
            }
        }
    }
}
