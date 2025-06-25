package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private String correo;
    private String pass;
    private int telefono;
    private int id_perfiles;

    public Usuario(String nombre, String correo, String pass, int telefono, int id_perfiles) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.telefono = telefono;
        this.id_perfiles = id_perfiles;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("correo = " + correo);
        System.out.println("pass = " + pass);
        System.out.println("telefono = " + telefono);
        System.out.println("id_perfiles = " + id_perfiles);
    }
}
