package Generic

class MyClass6<out T>(val data: T){
    val temp: T? = null
//    var temp1: T? = null// out어노테이션은 var 프로퍼티에 대입 불가능!

//    fun myFun(arg: T){
//        println("I am test()")   //out 어노테이션은 매개변수에 대입 불가능!
//    }
    fun myFun(): T{
    return data
    }

}

fun main(args: Array<String>) {
    val obj = MyClass6<Int>(20)
    println(obj.myFun())
    /*
    out을 적용한 사례
     */
    val mutableList: MutableList<Int> = mutableListOf(10, 20)
//    val mutableList2: MutableList<Number> = mutableList //이문장이 에러가 나는 이유 제네릭에 따로 어노테이션이 적혀져 있지 않으면 대입을 할수업다 제네릭 형식 타입이 다르게 형성되있기 때문에 에러
    val immutableList: List<Int> = listOf(10, 20)
    val immutableList2: List<Number> = immutableList //이것은 List에 어노테이션 out이 선언 되어있기 때문에 하위 제네릭 Int가 상위 제네릭 Number에 대입이 가능하다
    immutableList.forEach({println(it)})
    immutableList2.forEach ({println("I am immutableList2 $it")})
}