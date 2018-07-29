package Generic

class MyClass8<T>(val data: T){
    fun myFun(): T{
        return data
    }

    fun myFun2(arg: T){

    }
    fun myFun3(arg: T): T{
        return data
    }
}

fun some2(arg: MyClass8<out Number>){
    arg.myFun()
//    arg.myFun2(10)    //이용 측에서 out 을 선언 할때 주의 할점이 있다. MyClass 내에 함수 중 매개변수를 제네릭 타입으로 선언한 함수는 이용 할 수 없다.
//    arg.myFun3(10) //그래서 myFun2와 myFun3을 이용 할 수 없는것이다.
}

fun main(args: Array<String>) {
    some2(MyClass8<Number>(10))
    some2(MyClass8<Int>(10))
}