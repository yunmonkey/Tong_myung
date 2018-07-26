package Try_Catch

class Myexception constructor(msg: String): Exception(msg){ //Myexception이라는 매개변수 msg String형 클래스를 만들고 Exception 클래스를 상속 msg를 전달해줌

    val errorData: String = "some error data"
    fun errorFun(){
        println("error Fun(),,,")
    }
}

fun some1(){
    throw Myexception("My Error,,,")  //Exception을 상속받았으니 내가 만든 클래스를 이용해서 throw 발생 가능
}

fun main(args: Array<String>) {
    try {
        some1() //여기서 바로 에러 발생하니까 catch 로 이동
    }
    catch (e: Myexception){ //e는 직접 만들 클래스로 예외 처리
        println("error message : ${e.toString()}")
        println("error String : ${e.errorData}")
        e.errorFun()
    }
}