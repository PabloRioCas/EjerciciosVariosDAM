
fun main(){

    println("Dime el primer número:")
    var Numero1 : Int = readln().toInt()


    println("Dime el primer número:")
    var Numero2 : Int = readln().toInt()

    println("El resultado de la suma es ${suma(Numero1,Numero2)}")

}

 fun suma(Numero1: Int, Numero2: Int):Int{
     return Numero1+Numero2
 }