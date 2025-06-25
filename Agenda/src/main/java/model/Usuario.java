package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private String correo;
    private String pass;
    private int telefono;
    private int idPerfil;

    public Usuario(String nombre,String correo,String pass,int telefono, int idPerfil) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.telefono = telefono;
        this.idPerfil = idPerfil;


    }
    public void mostrasDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("correo = " + correo);
        System.out.println("pass = " + pass);
        System.out.println("telefono = " + telefono);
        System.out.println("idPerfil = " + idPerfil);
    }

}
