import com.google.gson.Gson;
import model.Usuario;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        //Si quisieramos que el usuario pueda elegir cuantos resultados quiere y que genero quiere:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que género quieres visualizar");
        String genero =scanner.next();
        System.out.println("Cuantos resultados quieres mostrar");
        int resultados =scanner.nextInt();

        //1. Petición a una URL
        String urlString = "https://randomuser.me/api/?results=%d&gender=%s";
        //al poner las banderas, puedes poner el string.format para recoger la url y los dos valores
        try {
            URL url = new URL(String.format(urlString,resultados,genero)); //Crear un objeto URL y le pasas la dirección
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Esta es la acción, crear un objeto de conexión y con url.openConection() le estás diciendo
            //al navegador, mete está URL que te paso y búscala.
            //2. Flujos -> Stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           //Con esto, nosotros hemos recibido ya la información de la url y la podemos leer a través de
            //un flujo de lectura que proviene del una propiedad de la connection que hemos creado, su Input.
            String linea = bufferedReader.readLine(); //Con esto leemos línea a línea, pero al ser un texto plano
            // se lee toda la petición
            JSONObject response = new JSONObject(linea);
            JSONArray results = response.getJSONArray("results");
            //JSONObject user = results.getJSONObject(0);
            //
            for( Object user : results){ //pones Object en vez de JSONObject porque no podrías asegurar
                // que en results todos los objetos fueran JSONObjets
                if(user instanceof JSONObject) { //Este if se hace para evitar errores y que user siempre
                    //sea un JSONObject, porque en el for coges un Object genérico que podría no serlo
                    String email = ((JSONObject)user).getString("email"); //Tienes que castearlo
                    String phone = ((JSONObject)user).getString("phone");
                    String gender = ((JSONObject)user).getString("gender");

                    //Usuario -> genero, mail, telefono
//                    System.out.println(email);
//                    System.out.println(phone);
//                    System.out.println(gender);
                    Gson gson = new Gson(); //Este objeto que procede de una dependencia externa es capaz de traducir
                    //un objeto JSON a uno Java y viceversa.
                    //Los atributos del objeto Java tienen que llamar identicos a los del JSON para que haca el cambio
                    //Además, los objetos Java tienen que ser Serializables
                    Usuario usuario = gson.fromJson(((JSONObject)user).toString(),Usuario.class);
                    //El toString() es porque nos pide un dato String, por lo que se hace el cambio con el usuario.

                    // USUARIO

                  //  Usuario usuario = new Usuario(gender,email, phone);
                     usuario.mostrarDatos();
                }
            }
            //System.out.println(results);

        } catch (MalformedURLException e) {
            System.out.println("La URL indicada no es válida");
        } catch (IOException e) {
            System.out.println("Error en la conexión");
        }
    }
}
