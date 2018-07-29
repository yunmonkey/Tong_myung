package Generic

inline fun <reified T>some2(arg: Any){//제네릭은 실행 부분에서 정보가 사라지기 때문에 inline 함수써서 reified라는 키워드를 써주면 실행때도 정보가 사라지지않고 비교가 가능해 진다
    if(arg is T)
        println("Any is eqauls Generic")
    else
        println("Any is not eqauls Generic")
}

fun main(args: Array<String>) {
    some2<String>("hello")
    some2<Int>("hello")
}