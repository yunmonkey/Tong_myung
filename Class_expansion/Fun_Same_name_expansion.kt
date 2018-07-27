package Class_expansion

class Test{
    fun sayHello(){
        println("Test.... sayHello()")
    }
}

fun Test.sayHello(){//만약 이렇게 확장 함수가 클래스안에 생성된 이름과 같을 경우에는 클래스 안에 선언된 함수가 우선이게 된다.
    println("Test extension.. sayHello()")
}

fun main(args: Array<String>) {
    val obj: Test = Test()
    obj.sayHello()//따라서 여기에서는 Test클래스 안에 sayHello함수 호출된다.
}