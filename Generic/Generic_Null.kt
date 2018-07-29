package Generic
/*
제네릭 사용할때 T옆에 아무런 제약과 null에대한것을 적지 않으면 <T: Any?> 이렇게 null이 허용가능하게 적용된다
그래서 나중 제네릭을 쓴 함수에서 비교를할때 꼭 null 확인연산자 ?.로 비교를 해야한다.
 */
class MyClass3<T>{
    fun myFun(arg1: T, arg2: T){
        println(arg1?.equals(arg2))
    }
}

fun main(args: Array<String>) {
    val obj = MyClass3<String>()
    obj.myFun("hello", "hello")
    val obj2 = MyClass3<Int?>()
    obj2.myFun(null, 10)
}