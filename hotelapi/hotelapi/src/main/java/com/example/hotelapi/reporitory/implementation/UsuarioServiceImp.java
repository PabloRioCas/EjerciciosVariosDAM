package com.example.hotelapi.reporitory.implementation;

import com.example.hotelapi.model.Usuario;
import com.example.hotelapi.reporitory.UsuarioRepository;
import com.example.hotelapi.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotación para indicar que esta clase es un servicio de Spring
public class UsuarioServiceImp implements UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Implementación de los métodos definidos en la interfaz UsuariosService

    @Override
    public List<Usuario> getAllUsers() {
        // Lógica para obtener todos los usuarios
        return usuarioRepository.findAll(); // Reemplazar con la lógica real
    }

    @Override
    public Usuario addUser(Usuario usuario) {

      return usuarioRepository.save(usuario); // Lógica para agregar un usuario
    }


    public Usuario getByEmail(String email) {
        // Lógica para obtener un usuario por correo electrónico
        return usuarioRepository.getByCorreo(email); // Reemplazar con la lógica real
    }
    @Override
    public Usuario getLogin(String email, String pass) {

        Usuario usuario = usuarioRepository.getByCorreoAndPass(email, pass);
        // Lógica para verificar las credenciales de inicio de sesión

        return usuario; // Si el usuario no es nulo, las credenciales son correctas
    }

}
