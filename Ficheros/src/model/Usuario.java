package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario implements Serializable {

    private static long serialVersionUID = 123123L;
    // Nombre, apellido, correo, telefono

    private String nombre, apellido, correo;
    private int telefono;

    //1 constructor -> por defecto el vacio

}
