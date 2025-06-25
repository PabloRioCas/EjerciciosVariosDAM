
// El primario se escribe en la firma de la clase

//Además, todas las clases en kotlin son de manera implicita final! por lo que no se puede heredar de ellas
//Hay que marcarlas como "open" para que se pueda heredar de ellas
open class Usuario (var nombre :String, var apellido: String){

    //variables
    private var correo: String? = null
    private var telefono: Int? = null
    //constructores -> Existe el constructor primario y los secundarios (estos se basan en el primario de forma obligatoria)

    //algunos usuarios tienen correo

    constructor(nombre: String, apellido: String, correo: String):this(nombre, apellido){
        this.correo = correo
    }
    constructor(nombre: String, apellido: String, telefono: Int):this(nombre, apellido){
        this.telefono = telefono
    }

    //Se puede definir una mezcla de los dos anteriores y si no se pasara uno de los dos últimos valores, este sería null
    constructor(nombre: String, apellido: String, telefono: Int? =null, correo: String? = null):this(nombre, apellido){
        this.telefono = telefono
        this.correo = correo
    }

    //funciones

    //hasta los métodos son también finales por lo que hay que ponerle también el open
    open fun mostrarDatos(){
        println(nombre)
        println(apellido)
        println(telefono)
    }

    fun getTelefono(): Int?{
        return telefono
    }
    fun setTelefono(telefono: Int?){
        this.telefono = telefono
    }

    fun getcorreo(): String?{
        return correo
    }

    fun setCorreoo(correo: String){
        this.correo = correo
    }


}