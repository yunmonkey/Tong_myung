package Class_expansion

class Test1{
    val ClassData: Int = 10
}

//val Test.ClassData2: Int = 20//에러! 프로퍼티의 확장은 이렇게 하지 못하고 get()함수를 써서 해야한다

val Test1.ClassData2: Int
get() = 20

fun main(args: Array<String>) {
    val test = Test1()
    println("classData  ${test.ClassData}   classData2   :  ${test.ClassData2}")
}