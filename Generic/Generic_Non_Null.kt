package Generic

class MyClass5<T: Any>{
    fun test(arg1: T, arg2: T){
        println(arg1.equals(arg2))
    }
}

fun main(args: Array<String>) {
    val obj = MyClass5<String>()
    obj.test("Hello", "Hello")
//    val obj2 = MyClass5<Int?>()// 원래 제네릭 기본형은 <T: Any?>인데 위에서 null허용을 하지 않았으니까 null허용 값 넣어주면 에러가 난다.
}