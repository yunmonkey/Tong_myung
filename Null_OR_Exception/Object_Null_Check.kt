package Null_OR_Exception

class Address{
    var city: String? = "Seoul"
}

class User{
    var address: Address? = Address()
}

fun main(args: Array<String>) {
    var check: User? = User()
//    println(check.address.city)    모두 보면 null이 허용된 상태이다 그런데 check.address.city이렇게만 접근하면 null을 확인도 안하고 이용하기때문에 에러가 난다.
    println(check?.address?.city) //이렇게 null확인 연산자를 이용 해줘야 한다 check나 address가 null이면 null을 반환한다.
}