package Generic

fun copy(from: Array<Any>, to: Array<Any>){
    for(i in from.indices)
        to[i] = from[i]
}

fun useOutcopy(from: Array<out Int>, to: Array<Any>){
    for(i in from.indices)
        to[i] = from[i]
}

fun main(args: Array<String>) {
    val array: Array<Int> = arrayOf(1, 2, 3)
    val array2 = Array<Any>(3, {x->0})

//    copy(array, array2) //이 문장이 에러가 나는 이유?  아무 어노테이션을 작성하지 않았으니 invariance이다 Array<Int>는 Array<Any>의 하위가 아니기 때문
    useOutcopy(array, array2)
    array2.forEach { println(it) }
}