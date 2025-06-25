//clase Entrada{ psvm (Srtring []args) {//Cuerpo}

// fun nombreFunción (NombreArg: TipoDelArgumento ){CUEPRO}
// Si se quiere que la función retorne algún valor:
// fun nombreFunción (NombreArg: TipoDelArgumento, NombreArg: TipoDelArgumento, NombreArg: TipoDelArgumento ):Retorno {CUEPRO}


//fun main(args: Array<String>){
//    println("Primera app Kotlin")
//} //Se puede quitar los Args y sigue siendo el metodo main, en kotlin no es necesario ya que simplifica el lenguaje.

fun main(){
    println("Primera app Kotlin")
    //VARIABLES: VAR: pueden modificar su valor a lo largo de su vida
    //           VAL: Tipos que no puede modificar su valor a lo largo de la vida (final)
    // Construcción de variables
    // TIPO nombreVariable: TIPO = valor
    println("Introduce tu nombre")
    var nombre= readln(); // Para que te lea por consola
    //y si quieres leer otros tipos, casteas de la siguiente forma:
    println("Dime tu edad")
    var edad1: Int = readln().toInt()
    var nombre2: String = "Pablo"
    var altura: Double = 1.71
    var edad= 4.0
    //No son necesario tipar las variables porque los tipos van asociados a la asignación del valor.
    val experiencia = true

    // NULL  es un tipo, por lo que si tipas una variable como string no puede ser NULL
    //para que una variable pueda contener valores null, se le aplica la ? detrás del tipo y así ya puede contenerer ese valor
    var apellido: String? = null //o valores "asdadf"

    // Nullpointerexception: si el valor es nulo y le pedimos que imprima la longitud, saltaría esa excepción
    // Existe el Null safety, lo que te alerta que pueden darse valores nulos con excepciones, te salta un aviso
    //cuando te salta ese aviso, o lo fuerzas a ejecutar con el operador asert -->  !! obliga a que no sean nulas las cosas
    //o la segunda alternativa es el elvis ?: "El mensaje correspòndiente"

     println(apellido?.length ?: "No se encuenta el apellido")

    //Existirá con valor, pero no se cuand se inicia. Para utilizar una variable de este tipo,
    //tengo que inicializarla antes lateinit: inicialización tardía.

    lateinit var correo: String
    correo = "pablorc@hotmail.com"
    println(correo)

    //Variables complejas  --> Primera en Mayuscula en el tipo -> String, Date, ArrayList
    // Simples -> Primera en Minúscula en el tipo -> int, double, float, boolean
                                    // wrapper o envoltorio ->  Integer, Double, Float, Boolean (complejas asociadas a las simples

    // En Kotlin existen las clases wrapper o complejas, no existen las simples o primitivas
    // Las clases primitivas como Int no se pueden poner como lateinit pero si se pueden marcar como
    //posibles nulos

    //sout ("asdasdf"+variable+"asdasdasd"+variable)
    //sout ("asdasdf %s asdasdasdas %s" variable1, variable2) Esto es lo que se conoce como las banderas
    //sout ("asdasdf %s asdasdasdas %s" variable1, variable2) Esto es lo que se conoce como las banderas

    println("Mi nombre es $nombre, mi apellido es ${apellido ?: "sin definir"} y mi altura es $altura")
    //Esto es una impresión mediante String template

    // Para que mediante una impresión por consola, nos coja toda la orden sobre la variable, debe ir entre {}

    //esto son Posicionales
    sumar(5,10)

    // Nominales
    sumar(Operando2 = 50, Operando1 = 20)

    //valores por defecto

    sumar(Operando2 = 50) //10+50
    println("El resultado de doblar es ${doblar(5)}")
    println("El resultado de incrementar es ${incrementar(Operando = null)}")
    dividir(4,2)

    //Para recoger cosas por teclado

    println("dime el nombre de tu amigo")
    var Amigo = readln()
    println("dime la edad de tu amigo")
    var edad2: Int? = readln().toInt() //Conversión de tipos!!

}


//void es lo mismo en java que en kotlin Unit

// El tipado de los arg que le pasas a la función es obligatorio
fun sumar(Operando1: Int=10, Operando2: Int):Unit {
    println("El resultado de la operación es ${Operando1+Operando2}")
}

//Objet de java --> Any de Kotlin

//Para que devuelva un valor hay que indicarselo con el tipo
fun doblar(Operando: Int ): Int{
    return Operando*2
}

//Como son variables complejas, tienen metodos que se aplican sobre las variables
//Al poner ? detrás de la variable, puede ser un valor null, para evitar el error
// ponemos el elvis ?: y le damos el valor que queramos que sea directamente
fun incrementar(Operando: Int?): Int{
    return Operando?.inc() ?: 0
}

//funciones Lambda -> función pero RESUMIDO

//val variable = { arg: TIPO, arg TIPO ->cuerpo}

val dividir ={operando1: Int, operando2: Int ->
    println("El resultado de la división es ${operando1 / operando2}")    }
