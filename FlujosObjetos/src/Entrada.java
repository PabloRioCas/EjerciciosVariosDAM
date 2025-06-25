import resources.Usuario;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

public class Entrada {

    public static void main(String[] args) {
        //File -> ObjetOutputStream
        File file = new File("src/resources/objetos.obj");
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new Usuario("Pablo","Rios","correo@correo.com",1254));
        } catch (IOException e) {
            System.out.println("Fallo en la creación del objeto");
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
//            Usuario usuario = (Usuario) objectInputStream.readObject();
//            En este punto se hace el casteo (Usuario) porque en la igualdad, primero tienes
//            un objeto de tipo Usuario y en el otro es un objeto de tipo Object
//            System.out.println(usuario.getNombre()); //Esto solo imprime 1, pero si hubiera varios Usuarios
            Usuario usuario;
            while ((usuario = (Usuario) objectInputStream.readObject())!=null){
                System.out.println(usuario.getNombre());
            } //De esta forma, entrará a leer todas las veces que haya algo en el fichero y sacará
            //los nombres de todos los objetos Usuario
        } catch (IOException e) {
            System.out.println("Fallo en la creación del objeto");
        } catch (ClassNotFoundException e) { //Este catch hace referencia a que falte el UID y no encuentre la clase
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }


    }
}
