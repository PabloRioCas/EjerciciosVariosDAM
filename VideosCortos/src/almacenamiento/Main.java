package almacenamiento;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        OperacionesCaracteres operacionesCaracteres = new OperacionesCaracteres();
        operacionesCaracteres.leerFicherosASCII(new File("src/resources/escrituraASCII.txt"));
        operacionesCaracteres.traducirFicherosASCII(new File("src/resources/escritura.txt"));

    }
}
