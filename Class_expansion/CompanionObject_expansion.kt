package Class_expansion

class Test2{
    companion object {
        val objectData: Int = 10
        fun objectFun(){
            println("objectFun(),,,")
        }
    }
}

val Test2.Companion.objectData2: Int
get() = 30;

fun Test2.Companion.myFun2(){
    println("extension myFunr2(),,,")
}

fun main(args: Array<String>) {
    println("data1.. ${Test2.objectData}  data2... ${Test2.objectData2}")
    Test2.objectFun()
    Test2.myFun2()
}