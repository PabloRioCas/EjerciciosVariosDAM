package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Entity Esta etiqueta con Embeddable no es necesaria ya porque va intrinseco
@Embeddable
public class Direccion  implements Serializable {

    @Column
    private String localidad;
    @Column
    private String provincia;
}
