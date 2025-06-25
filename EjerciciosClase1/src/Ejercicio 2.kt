//Se puede importar o directamente poner la expesión en la fórmula
import kotlin.math.PI

fun main (){

    println("Dime el radio del círculo: ")
    var Radio : Double = readln().toDouble()
    areaCirculo(Radio)

}

fun areaCirculo (radio: Double){
    println("El area del círculo es ${radio*radio*PI}")
}