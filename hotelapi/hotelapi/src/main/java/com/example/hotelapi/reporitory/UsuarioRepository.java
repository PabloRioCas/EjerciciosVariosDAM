package com.example.hotelapi.reporitory;

import com.example.hotelapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{ // Hay que tipar el tipo de entidad y el tipo de su identificador
    // Aquí puedes definir métodos personalizados si es necesario
    // Por ejemplo, para buscar un usuario por correo electrónico:
    // Optional<Usuario> findByCorreo(String correo);
    Usuario getByCorreo(String correo); // Metodo para obtener un usuario por correo electrónico

    Usuario getByCorreoAndPass(String correo, String pass);
}
