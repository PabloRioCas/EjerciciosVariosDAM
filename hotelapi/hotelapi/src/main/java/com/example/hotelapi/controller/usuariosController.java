package com.example.hotelapi.controller;


import com.example.hotelapi.model.Usuario;
import com.example.hotelapi.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/usuarios") // Define la ruta base para este controlador. Todas las peticiones que lleguen a /usuarios serán manejadas por este controlador.
public class usuariosController {


    // Aquí puedes definir los métodos que manejarán las peticiones HTTP (GET, POST, PUT, DELETE, etc.)
    // Por ejemplo, un metodo para obtener todos los usuarios podría verse así:

    // @GetMapping
    // public List<Usuario> getAllUsuarios() {
    //     // Lógica para obtener todos los usuarios
    // }

    // @PostMapping
    // public Usuario createUsuario(@RequestBody Usuario usuario) {
    //     // Lógica para crear un nuevo usuario
    // }
    @Autowired
    private UsuariosService usuariosService;
    //Metodo para obtener datos de conexión correcta

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll() {
        // Aquí deberías llamar al servicio que maneja la lógica de negocio para obtener todos los usuarios
        return  new ResponseEntity<>(usuariosService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/info")
    public String conexionCorrecta() {
        return "Conexión exitosa a la API de usuarios";
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> realizarLogin(@RequestBody String email, @RequestBody String pass) {

        return new ResponseEntity<>(usuariosService.getLogin(email, pass), HttpStatus.OK); // Retorna 200 OK con el resultado del login
    }

    @GetMapping("/error")
    public String error() {
        return "Fallo en la consulta a la API de usuarios";
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {

        Usuario usuario1 = usuariosService.getByEmail(usuario.getCorreo()); // Verifica si el usuario ya existe por correo electrónico

        if (usuario1 != null)  {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Retorna 409 Conflict si el usuario ya existe
        }else {
            return new ResponseEntity<Usuario>(usuariosService.addUser(usuario), HttpStatus.CREATED); // Retorna 201 Created con el usuario agregado
        }
    }

    @GetMapping("/email")
    public ResponseEntity<Usuario> getByEmail(@RequestParam String email) {

        Usuario usuario = usuariosService.getByEmail("pablo@ue.com");

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el usuario
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.OK); // Retorna 200 con el usuario encontrado
        }
    }
}
