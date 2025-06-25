package com.example.hotelapi.services;

import com.example.hotelapi.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsuariosService {

    List<Usuario> getAllUsers(); // Metodo para obtener todos los usuarios

    Usuario getByEmail(String email); // Metodo para agregar un usuario por email

    Usuario addUser(Usuario usuario); // Metodo para agregar un usuario

    Usuario getLogin(String email, String pass); // Metodo
}
