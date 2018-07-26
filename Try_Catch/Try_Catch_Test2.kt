package Try_Catch

fun some(array: Array<Any>){
    try{
        println("try top,,,")

        val intdata1: Int = array[0] as Int

        val data: String = array[2] as String

        val data3: Int = data.toInt()
    }
    catch (e: Exception){
        println("catch,,, ${e.toString()}")
    }
    catch (e: ClassCastException)
    {
        println("catch,,, ClassCastException")
    }
    catch (e: ArrayIndexOutOfBoundsException){
        println("catch,,,, ArrayIndexOutOfBoundsException")
    }
}

fun main(args: Array<String>) {
    //캐스팅 오류
    val array = arrayOf("1", 2, "3")
    some(array)

    //범위 초과
    val array2 = arrayOf(2, "3")
    some(array2)

    //숫자 타입 예외
    val array3 = arrayOf(10, 0 ,"hello")

    some(array3)

}