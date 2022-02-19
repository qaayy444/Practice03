fun main() {
    //null的測試
    //kotlin的變數在給定值或宣告型態後，不能為null
    //var n=4
    //n=null -->error
    //var:Char=null --> error

    //解決1:宣告型態時，後面打?
    var n:String?="test" //-->代表n允許為null
    //n=null -->可被編譯
    //但n因為可能是null，故編譯器不允許某些必須要非null值才能得到結果的函式執行
    //val l=n.length -->error

    //解決2:在變數後面加入?
    val l1=n?.length //-->若n為null時，kotlin會將值指定為"null"，這並不是真正意義的null，故不會跳出null例外

    //解決3:在變數後面加入!!
    val l2=n!!.length //-->繞過編譯器的null檢查，若n為null時，會跳出Null例外
}