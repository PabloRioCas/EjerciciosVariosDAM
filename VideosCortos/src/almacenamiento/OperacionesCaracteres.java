package almacenamiento;

import java.io.*;

public class OperacionesCaracteres {

    public void leerFicherosASCII(File file){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader= new FileReader(file);
            bufferedReader= new BufferedReader(fileReader);

//            int codigo;
//            while((codigo = bufferedReader.read())!=-1){
//                System.out.println(codigo);
//                System.out.println(Character.toChars(codigo)); // Esto es para sacar los codigos ASCII de cada carácter
//            }
            String linea;
            while ((linea = bufferedReader.readLine())!=null){
                System.out.println(linea);
        }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void traducirFicherosASCII(File file){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader= new FileReader(file);
            bufferedReader= new BufferedReader(fileReader);
//            int codigo;
//            while((codigo = bufferedReader.read())!=-1){
//                System.out.println(codigo);
//                System.out.println(Character.toChars(codigo)); // Esto es para sacar los codigos ASCII de cada carácter
//            }
            String linea;
            while ((linea = bufferedReader.readLine())!=null){
               // int codigoLeido = Integer.valueOf(linea);
                String [] palabras = linea.split(" "); //Metodo propio de los String para separarlos por un indicador
                for (String item : palabras){
                    System.out.println(Character.toChars(Integer.parseInt(item)));
                }
                //System.out.println((char) codigoLeido); //Esto traduce el int en su caracter ASCII asociado
                //Si imprimes codigoLeido solo, imprimirá lo mismo que línea a nivel usuario
                //Sin embargo, la diferencia entre los dos es que uno es String y otro Int
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

