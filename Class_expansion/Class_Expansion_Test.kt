package Class_expansion

open class Super

class Sub: Super()

fun Sub.sayHello(){
    println("Sub()  sayHello(),,,")
}

fun Super.sayHello(){
    println("Super()   sayHello(),,,")
}

fun some(obj: Super){//매개변수 형이 Super형이기 때문에 Sub든 Super든 둘중 하나를 만들어도 Super의 sayHello 함수가 호출된다
    obj.sayHello()
}

fun main(args: Array<String>) {
    some(Sub())
}