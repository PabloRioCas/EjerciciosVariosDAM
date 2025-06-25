import java.io.Serializable

//Se le pasa los mismos parametros obligatorios que tiene que tener la clase de la que hereda más aquellos
//que se le quieran sumar
//Para la herencia en Kotlin no diferencia entre extends o implements. Con los : puede heredar de ambas a la vez
//(de clase e interfaz)
class UsuarioEspecializado (nombre: String, apellido: String, var nSS: Int) : Usuario(nombre, apellido), Serializable{

    //nombre
    //apellido
    //correo -> null
    //telefono -> null


    override fun mostrarDatos() {
        super.mostrarDatos()
        println(nSS)
    }

}