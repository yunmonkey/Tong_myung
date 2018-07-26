package Try_Catch

fun some(){
    var name: String? = null
    val test = name?: throw IllegalArgumentException("Name required") //throw 도 표현식에 써진다! name이 null 이라면 throw 반환!
    println("some() bottom") // name이 null이라면 이건 실행이 안됨
}

fun some2(arg: Int): Nothing{ //함수에서 throw 만 반환하는 함수라면 꼭 반환형을 Nothing 형을 써야한다.
    if(arg > 0)
        throw Exception("some2 exception,,, arg>0 true")
    else
        throw Exception("some2 exception,,, arg>0 false")
}

fun main(args: Array<String>) {
    try {
        some() // 함수 some()을 불렀는데 name 에서 예외 발생시킴 catch로 넘어감
    }
    catch (e: Exception){
        println("exception,,, ${e.toString()}") //예외 발생 Exception 클래스의 매개변수 "Name required"출력
    }

    try {
        some2(10) // some2의 매개변수 10 if 쪽의 문상 실행 예외 발생
    }
    catch (e: Exception){
        println(e.toString())   //throw 의 매개변수 "some2 exception,,, arg>0 true" 출력
    }
}