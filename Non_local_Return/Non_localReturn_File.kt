package Non_local_Return

/*논로컬 반환에 대해서 공부
원래 람다함수가 사용된 고차함수를 부르고 람다함수를 사용할때 람다함수 자체에선 return이 사용이 안된다
하지만 inline 키워드를 사용하면 return 키워드를 사용 할 수 있다.
 */
inline fun hiFun(argFun: (x: Int, y: Int)->Int){//argFun = 람다함수 매개변수가 x,y 두개이고 반환값이 Int형 한개
    argFun(10,0)
}

fun calledhiFun() {
    println("calledFun()...")
    hiFun({ x, y -> if(y>x) return else x/y})
}

fun main(args: Array<String>) {
    calledhiFun()
}