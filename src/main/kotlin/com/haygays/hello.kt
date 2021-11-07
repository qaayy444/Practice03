package com.haygays

fun main(array: Array<String>) {
//    println("Hello")
//    People().hello()
    //kotlin建構class時不用加new
    val p=People()
    p.hello()
    //val:不可變;var:可變
    //若之後才要賦予變數值，必須先給定該變數的資料型態才行，不然kotlin無法分辨(如下的標示)
    val age :Int=18

}
class People
{
    fun hello()
    {
        println("Hello~~")
    }
}
