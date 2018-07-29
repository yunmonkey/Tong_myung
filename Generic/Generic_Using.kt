package Generic

class MyClass<T>{
    var info: T? = null
}

fun main(args: Array<String>) {
    val obj = MyClass<String>() //제네릭 선언 부분에 String 을 넣었으니 클래스 프로퍼티형도
    obj.info = "taeseong"
    val obj2 = MyClass<Int>()
    obj2.info = 10
}