package ElvisOperator_Use


class Address(val streeetAddress: String, val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalAccessException("No address") //엘비스 연산자 주소가 없으면 이것을 실행

    with(address) {
        println(streeetAddress)
        println("$zipCode $city $country")
    }
}

fun main(args: Array<String>) {
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)


    printShippingLabel(person)
    printShippingLabel(Person("Yun", null))
}