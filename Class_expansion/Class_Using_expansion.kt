package Class_expansion

class Super{
    val superData: Int = 10
    fun superFun(){
        println("superFun() called,,,")
    }
}

val Super.subData: Int
    get() = 20

fun Super.subFun(){
    println("subFun() called,,,")
}

fun main(args: Array<String>) {
    val obj: Super = Super()
    println("superData : ${obj.superData} subData : ${obj.superData}")
    obj.superFun()
    obj.subFun()
}