package Null_OR_Exception

fun main(args: Array<String>) {
    var temp: String? = "TaeSeong"
    var length: Int? = temp?.length   //?.연산자를 쓰게되면 따로 표현식 if 문 쓰지않아도 된다.

    println("$length")

    temp = null
    length = temp?.length
    println("$length")
}