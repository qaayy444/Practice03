package com.haygays

import java.util.*


fun main() {
    //Q:當我們想要避免關鍵字的衝突?
    //例如:in在kotlin為關鍵字，故使用System.in會衝突
    //A:在in兩旁加上``即可
    val scanner=Scanner(System.`in`)
    val s=scanner.next()
    println(s)
    scanner.close()
}