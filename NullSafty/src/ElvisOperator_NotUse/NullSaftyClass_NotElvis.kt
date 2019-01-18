package ElvisOperator_NotUse

class Address(val streetAddress: String, val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if(country != null) country else "Unknow" //엘비스 연산자 쓰지 않았을때
}

fun main(args: Array<String>) {
    val person = Person("Yun", null)
    println(person.countryName())
}