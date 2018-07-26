package Try_Catch

fun some(arg: Int): Int{
    if(arg < 1)
        throw Exception("parameter must be greater than zero")
    else{
        var sum = 0
        for(i in 1..arg)
            sum += i
        return sum
    }
}

fun main(args: Array<String>) {
    try {
        println("${some(5)}")

        println("${some(-1)}")

        println(" try bottom")
    }
    catch (e: Exception){
        println("Exception,,, ${e.toString()}")
    }
}
