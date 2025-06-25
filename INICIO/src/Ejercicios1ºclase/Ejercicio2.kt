package Ejercicios1ºclase

fun main(){
    println("Dime el radio del círculo en cm")
    var radio = readLine()?.toIntOrNull() ?: 0


    println("El área del circulo con radio $radio cm, es ${radio*radio*Math.PI}")

}
