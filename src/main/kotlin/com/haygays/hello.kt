package com.haygays


fun main(array: Array<String>) {
//    println("Hello")
//    People().hello()
    //kotlin建構class時不用加new
    val p=People("SS",18,5.5)
    p.hello()
    //val:不可變;var:可變
    //若之後才要賦予變數值，必須先給定該變數的資料型態才行，不然kotlin無法分辨(如下的標示)
    val age :Int=18
    //kotlin可以把function當作一個變數或值來儲存
    //val hello=Person().Hello();
    //val p2=PeopleAnother(age)
    //第二種建構方式，不一定要依照建構子引數的順序
    val p2=PeopleAnother(s="hello",c=age)
    p2.hello()
    //在print裡跳脫字元時，若是一個方法，則需要加入大括號
    println("answer is ${p.ifTest()}")

    //when test
    //when除了可在->後面加入敘述句外，也可以打入回傳值，當作一個值的運算式
    val p3=when(age)
    {
        in 0..7->"children"
        in 8..18->"young"
        in 19..80->"old"
        else->"error"
    }
    println(p3)
}
//fun可以直接把運算式當作函數
fun tete(a:Int)=if(a==5) 'b' else 'c'
//可在class旁加上引數(constructor keyword可加可不加)，當建構時，必須得先給定引數，實現建構子的功能
//寫在class旁的稱為主建構子
class People constructor(var a:Int,val b:Double)
{
    val sss=52
    //init會在constructor(包括主和副)執行完後才會執行
    init {
        val d=a+b
        println("$d")
        //kotlin可簡化if述句的寫法，還可以將述句的結果當成變數回傳
        //一定要寫else
        //val ifs=if(a>b) "A>B" else "A<B"
        println(if(a>b) "A>B" else "A<B")
    }
    //此為次建構子，除了不能寫val、var外，冒號後必須呼叫主建構子
    //從java角度就像是this()要先寫一樣
    //次建構子可實現多載
    constructor(s: String,a:Int,b:Double):this(a,b)
    {
        println(s)
    }

    fun hello()
    {
        a++
        println("Hello~~\t$a\t$b")
    }
    fun ifTest():Int
    {
        val j=4;
        //在kotlin裡，if else敘述式可以放在等號右邊，記得最後一行必須給得值給max
        //kotlin沒有三元運算式
        val max=if (j<a)
        {
            println("A")
            a
        }
        else
        {
            println("J")
            j
        }
        return 5
    }

}
//當有指定一個以上變數或值的初始值的話，在建構class的時候，不一定要設定它們的值
//請盡量將有設初始值的變數或值放到最後面，除非建構class時，使用(c=某數,s="")的方式，不然會報錯
class PeopleAnother(val c:Int,val s:String="",val _s:String="s")
{
    fun hello()
    {
        if(s=="")
            println("$c")
        else
            println(s)

    }
}
