package Ejercicios1ºclase

fun main(){
    println("Introduce la temperatura en Grados Celsius")
    var celsius: Double? = readLine()?.toDoubleOrNull() ?: 0.0

    val constante1 = 9.0/5.0
    val constante2 = 32

    println("La temperatura de ${celsius}º Celsius es ${(celsius?.times(constante1) ?: 0.0) + constante2}º Farenheith")

}