package Ejercicios1ºclase

fun main(){
    println("Dime un número entero")
    var operando1 = readLine()?.toIntOrNull() ?: 0
    println("Dime el segundo número entero")
    var operando2 = readLine()?.toIntOrNull() ?: 0

    println("El resultado de la suma es ${operando1+operando2}")

}

