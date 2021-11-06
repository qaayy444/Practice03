package com.haygays

fun main(array: Array<String>) {
//    println("Hello")
//    People().hello()
    //kotlin建構class時不用加new
    val p=People()
    p.hello()

}
class People
{
    fun hello()
    {
        println("Hello~~")
    }
}
