package Class_expansion

open class Super{
    open fun superFun(){
        println("i`m superFun(),,,,")
    }
}

class Sub: Super(){
    var subData: Int = 20
    override fun superFun() {
        println("Sub superFun,,, $subData")
    }
    fun some(data: Int){
        this.subData = data
        superFun()
        super.superFun()
    }
}

fun Sub.some2(data: Int){
    this.subData = data
    superFun()
//    super.superFun() //이 문장은 에러이다 왜냐면 확장은 사용한 클래스만 인지하기 때문에 상위 클래스는 인지하지 못한다 super 키워드 쓰지못한다.
}

fun main(args: Array<String>) {
    val obj: Sub = Sub()
    obj.some(30)
    obj.some2(40)
}