package overLabFun

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User){
    fun validate(value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalAccessException(
                "Can`t save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name") //name 이 공백인지 여기서 검사
    validate(user.address, "address") //address가 공백인지 검사
}

fun main(args: Array<String>) {
    println(saveUser(User(1, "", ""))) //여기서 이름이 공백이기 때문에 예외가 발생한다.
    println(saveUser(User(2, "Hong", "Busan")))
}