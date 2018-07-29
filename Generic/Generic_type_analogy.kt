package Generic

class Myclass<T>(no: T){
    var temp: T? = null
}

fun main(args: Array<String>) {
    val obj = Myclass<Int>(20)
    obj.temp = 30
    val obj2 = Myclass("hello")//여기서 객체 생성해줄때 따로 <String>을 적지않고 매개변수만 보고 타입유추가 가능하다.
    obj2.temp = "world"
}