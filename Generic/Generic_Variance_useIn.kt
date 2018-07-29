package Generic

class MyClass7<T>(val data: T){ //이번 클래스는 invariance로 선언 되었지만
    fun myFun(): T{
        return data
    }
    fun myFun2(arg: T){

    }
    fun myFun3(arg: T): T{
        return data
    }
}

fun some1(arg: MyClass7<in Int>){//some 함수 호출할때 variance로 선언 되었다 즉 이용측 variance이다
    arg.myFun()
    arg.myFun2(10)
    arg.myFun3(10)
}

fun main(args: Array<String>) {
    some1(MyClass7<Int>(10))
    some1(MyClass7<Number>(10))
}