package Class_expansion
/*
다른 클래스 내에서 작성된 확장 함수를 살펴보고있다
다른 클래스에서 확장 함수가 작성되면 그 확장함수는 확장함수가 써진 클래스 안의 함수도 접근이 가능하고
확장함수 만들때 적어둔 클래스명의 안의 함수도 접근이 가능하다!
 */
class MyTest1{
    fun some1(){
        println("My test some1Fun(),,,")
    }
}

class Mytest2{
    fun mytest2Fun(){
        println("MyTest2 Fun(),,,")
    }

    fun MyTest1.some2(){
        mytest2Fun()//접근 가능
        println("MyTest1 some2Fun(),,,")
    }
    fun test(){
        val obj = MyTest1()
        obj.some1()
        obj.some2()//클래스 내에서 썻으니 접근이 가능
    }
}

fun main(args: Array<String>) {
    val obj = MyTest1()
    obj.some1()
//    obj.some2()//이 문장은 Mytest2내부에서만 적용되지 외부까지 적용이 안되기 때문에 오류이다 객체가 Mytest1 이기 때문에적용 불가!
}