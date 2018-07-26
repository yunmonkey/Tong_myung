package Null_OR_Exception
/*
엘비스 연산자 = ?: 이렇게 쓰는데 뜻은 "만약 null이라면?" 이 뜻이다
null 확인 연산자와 같이 쓸 수 있다. null확인 연산자가 해당값이 null 이면 null을 반환 해주기때문에
엘비스 연산자가 사용 된다
12번째 줄을 간편화 한것이 16번째 줄이다.
 */

fun main(args: Array<String>) {
    var data: String? = "kkang"

    var length: Int = if(data!=null) data.length else -1

    data = null

    length = data?. length?: -1

    println(length)

    data?: println("data is null")
}