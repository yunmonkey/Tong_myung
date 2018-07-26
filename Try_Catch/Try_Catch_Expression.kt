package Try_Catch

fun some1(arg: String): Int{

    val parseData: Int = try{
        println("try top,,,")
        arg.toInt()
    }
    catch (e: Exception){
        println("${e.toString()}")
        0 //catch문 돌아갈때 parseData 에 값에다가 0값을 넣어줌
    }
    finally {
        println("finally,,,")
        100  //finally는 실행되어도 어떤 값을 반환하지는 않는다
    }
    return parseData
}

fun main(args: Array<String>) {
    println("${some1("10")}")

    println("${some1("a")}")
}