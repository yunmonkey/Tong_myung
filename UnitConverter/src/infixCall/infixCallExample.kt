package infixCall

/*
이번 패키지는 확장함수와 중위 호출에 대해서 알아볼것
확장함수는 자바에서는 지원하지 않은 함수이지만 코틀린에서는 조금더 부드럽게 사용하기위해
코틀린 라이브러리에서 제공해주고 있는 함수를 쓰거나 사용자가 직접 만들수도 있다.

중위 호출은 infix 라는 키워드를 통해 사용할수있고 공백을 차이로 인자가 하나뿐인 메소드를 간편하게 호출 시킬수 있다.
 */
fun Int.multyply(x: Int): Int = this * x //중위 호출을 하지않은 확장함수 정의

infix fun Int.division(x: Int): Int = this / x //중위 호출을 해놓은 확장함수 정의

fun main(args: Array<String>) {
    println("확장함수 사용 3 * 4 = ${3.multyply(4)}")
    println("확장함수와 중위호출 사용 4 / 2 = ${4 division 2}")
}