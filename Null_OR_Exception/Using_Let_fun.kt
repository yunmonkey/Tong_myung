package Null_OR_Exception

fun main(args: Array<String>) {
    val array = arrayOf("kkang",null,"hello")

    array.forEach { if(it !=null) println("$it...${it.length}") }

    array.forEach { it?.let { println("$it...${it.length}") } }
}