package java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Direccion;
import model.Habitacion;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "trabajadores")//Además de ser una entidad, también es una tabla
@NamedQueries(
        {
          @NamedQuery(name = "Trabajador.findAll", query = "FROM Trabajador"), //Para Queries recurrentes
          @NamedQuery(name ="Trabajador.findByLocalidad", query = "FROM Trabajador WHERE direccion.localidad = :localidad")
        }
)

public class Trabajador implements Serializable {

    //pk en la bade de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "name")
    private String nombre;
    @Column(name= "surname")
    private String apellido;
    @Column
    private String correo;
    @Column(name= "phone")
    private int telefono;
    @Embedded // porque está embebido dentro de otra clase
    private Direccion direccion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_habitacion ")
    private Habitacion habitacion;


    public Trabajador(String nombre,String apellido, String correo,  int telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("correo = " + correo);
        System.out.println("telefono = " + telefono);
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
