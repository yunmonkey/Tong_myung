package overLabTest

class overLab(val id: Int, val name: String, val address: String)


/*
이렇게 하면 일일이 사용자가 필드를 검증해야한다.
로컬 함수를 만들어서 알아보자
 */
fun saveUser(user: overLab){
    if(user.name.isEmpty()){
        throw IllegalAccessException(
            "Can`t save user ${user.name}: empty Name"
        )
    }
    if (user.address.isEmpty()){
        throw IllegalAccessException(
            "Can`t save user ${user.address}: empty Address"
        )
    }
}

fun main(args: Array<String>) {
//    saveUser(overLab(1,"",""))
    saveUser2(overLab(1,"",""))
}

fun saveUser2(user: overLab){
    fun validate(user: overLab,
                 value: String,
                 fieldName: String){
        if(value.isEmpty()){
            throw IllegalAccessException(
                "Can`t save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

