package Null_OR_Exception

fun main(args: Array<String>) {
    var temp: String? = "kkang" //null값이 적용 되도록 null허용을 만들어 주었다.

//    val data: Int = temp.length;   이문장이 오류가 나는 이유가 temp라는 값이 null일수도있으니까 코틀린은
//    null의 안정성을 추구한다.
    val data: Int? =     //표현식으로 만듦
            if (temp != null) temp.length
            else null
}