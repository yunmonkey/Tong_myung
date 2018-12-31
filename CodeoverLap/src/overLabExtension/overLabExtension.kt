package overLabExtension

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if(value.isEmpty())
        {
            throw IllegalAccessException(
                "Can`t save user $id : empty $fieldName"
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}
fun saveUser(user: User){
    user.validateBeforeSave()
}
fun main(args: Array<String>) {
    val mainUser = User(1, "", "")
    println(saveUser(mainUser))
}