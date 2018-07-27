package Class_expansion

/*
원래라면 보통 이렇게 알고있듯이
open 키워드를 써서 클래스를 상속한다
하지만 상속을 쓰지않고 확장을 통해서 이용 하는 방법이 있다.
 */
open class Super{
    val superData: Int = 10
    fun superFun(){
        println("superFun(),,,")
    }
}

class Sub: Super(){
    val subData: Int = 20
    fun subFun(){
        println("subFun(),,,")
    }
}

fun main(args: Array<String>) {
    val obj: Sub = Sub()
    println("${obj.subData}")
    println("${obj.superData}")
    obj.subFun()
    obj.superFun()
}