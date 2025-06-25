import model.Usuario;

import java.io.*;

public class GestionFicheros {

    public void TrabajoFicherosBase(){
        //SIEMPRE HAY QUE TRABAJAR CON UNA CLASE FILE ->rutas (absolutas (desde el inicio) o relativas (desde \\ en adelante)
        // Si se trabaja en WINDOWS -> C: \\asasd\\aSSSAa\\asasa

        File file = new File("src/Resources/Ejemplo1.txt");

        File carpeta =new File("src/Resources/ficheros");
        if (!file.exists()){
            //Crearlo
            try {
                file.createNewFile();  // pasa el fichero de Logico --> físico
                System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
                System.out.println(file.canRead());
                System.out.println(file.canWrite());
                System.out.println(file.isFile());
                System.out.println(file.isHidden());
            } catch (IOException e) {
                System.out.println("error en la creación del Fichero");
            }
        }

        if (!carpeta.exists()){
            //Crearlo
                carpeta.mkdir();  //Aquí no me está pidiendo excepciones con la creación de carpetas
                                //No las pide las excepciones, es simplemente una reserva en memoria.
            }

        //carpeta.list(); //String [] nombre de los ficheros que están dentro
        for ( String item :carpeta.list() ){
            System.out.println(item);
        }
        //carpeta.listFiles(); // Nos da un array File [] con los ficheros que están dentro

        //System.out.println(carpeta.list());
        for (File item: carpeta.listFiles()){
            System.out.println(item.getName());
        }

        File carpetaGradoSuperiorDam = new File("C:\\Users\\Nitropc1\\OneDrive\\Escritorio\\GRADO SUPERIOR DAM");

            for ( File item: carpetaGradoSuperiorDam.listFiles()){ //De esta forma saca todas las carpetas que tiene un directorio o carpeta
                if(!carpetaGradoSuperiorDam.isHidden()) { //Así evitas que muestre los archivos ocultos
                    System.out.println(item.getName());
                }
            }

        for ( File item: carpetaGradoSuperiorDam.listFiles()){
            if(!carpetaGradoSuperiorDam.isHidden()) {
               if (item.isDirectory()) {
                     System.out.println(item.getName());
                     for( File item2: item.listFiles() ){
                         System.out.println("\t"+item2.getName());
                       }
               }
               else {
                   System.out.println(item.getName());
               }
            }
        } // El ejercicio interesante es hacer esto de manera recursiva para que
        //imprima todas las carpetas y ficheros en una ruta, hasta el final.
        // sino se hace de manera recursiva, no sabes cuantas veces tienes que anidar bucles


    }

    public void lecturaFicherosRecursiva(String path){
        File file = new File(path);
        for(File item: file.listFiles()) {
            if (!file.isHidden()){
                if (file.isDirectory()){
                    System.out.println(item.getName());
                    for(File item2 : item.listFiles()){
                      lecturaFicherosRecursiva(item2.getPath());
                    }
                }else System.out.println(item.getName());
            }
        }
    }

    public void flujoEscritura(String path){
        // File -> Filewrite -> BufferedWriter
        // File -> Filewrite -> PrintWriter

        File file = new File(path);

        FileWriter fw =null; //no lo puedo inicializar directamente
        BufferedWriter bf =null;
        PrintWriter pw =null;

        try {
            //si no encuentra la ruta lo crearía -> como sí fuera a través createNewFile() ->está sería FileNotFoundExcecption
            fw = new FileWriter(file, true); // Lo malo del FileWrite es que tienes que ir Bite a Bite escribiendo lineas
            // Además, si quieres un salto de línea tienes que forzalos con  \n
            fw.write("w\n");
            fw.write("Esto es otra línea");

            bf =new BufferedWriter(new FileWriter(file, true));
            bf.write(123);
            bf.newLine();
            bf.write(234);

            pw = new PrintWriter(new FileWriter(file, true) ); // Con este el IO Exception no lo fuerza ni lo pide porque no puede darse
            pw.println(" Esto es una linea nueva den el fichero a través de PrintWriter");
            pw.println(" Esto es una linea otra den el fichero a través de PrintWriter");

        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
        }
        finally {
            try {
                fw.close();
                bf.close();
                pw.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
                //el NullPointerException es porque si no entra en el primer try,
                //fw será nulo
            }
        }

    }

    public void flujoLectura (String path){
        //File -> FileReader (caracter a caracter)-> BufferedReader (lee línea a línea)

        File file = new File(path);

        //FileReader fileReader =null;
        BufferedReader bufferedReader = null;


        try {
            /*fileReader = new FileReader(file);
            int numeroASCI =-1;
            while ((numeroASCI=fileReader.read())>-1){
                System.out.println( (char) numeroASCI); //Los parseos son cambios de tipos que pueden no entrar en otros tipos, por lo que se hace un casteo que cambias directamente del int al char
            } //De esta manera se realiza una lectura recurrente de todos los caracteres de un texto plano
            */

            /*int numeroASCI = fileReader.read(); // Nos devuelve el número ASCII del caracter leído
            System.out.println(numeroASCI);
            int numeroASCI = fileReader.read(); // Nos devuelve el número ASCII del caracter leído
            System.out.println(numeroASCI);
            int numeroASCI = fileReader.read(); // Nos devuelve el número ASCII del caracter leído
            System.out.println(numeroASCI);*/

            bufferedReader = new BufferedReader(new FileReader(file));
            /*String linea = bufferedReader.readLine();
            System.out.println(linea);*/
            String linea = null;
            while ((linea = bufferedReader.readLine())!= null){
                System.out.println(linea);
            }


        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
               // fileReader.close();
                bufferedReader.close();

            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void flujoEscrituraObjetos(String path){
       // File -> FileOutputStream -> ObjectOutputStream

        File file = new File (path);
        ObjectOutputStream oos = null;


        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new Usuario("Pablo","Rios","correo@ue.com", 123123 ));
        } catch (IOException e) {
            System.out.println("Error en la escritura del Fichero");
        }

        try {
            oos.close();
        } catch (IOException | NullPointerException e) {
            System.out.println("Error en el cerrado");
        }


        Usuario usuario = new Usuario();
        usuario.getNombre();



    }

}
