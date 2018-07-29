package Generic

class MyClass2<T: Number>{//이렇게 Number라고 적어두면 String으로 객체 생성하지 못한다.
    var info: T? = null
    fun plus(arg1: T, arg2: T): Double{
        return arg1.toDouble() + arg2.toDouble()
    }
}

fun main(args: Array<String>) {
    val obj = MyClass2<Int>()
    obj.plus(10,20)

    val obj2 = MyClass2<Double>()
//    val obj3 = MyClass2<String>()//이 부분은 에러가 난다.
}