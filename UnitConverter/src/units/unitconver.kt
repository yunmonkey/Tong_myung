fun <T>Collection<T>.joinToString(
    separator: String = ";",
    predix: String = "<",
    postdix: String = ">"): String
{
    val result = StringBuffer(predix)
    for((index, element) in this.withIndex()){
        if(index > 0) result.append(separator)

        result.append(element)
    }
    result.append(postdix)
    return result.toString()
}

fun main(args: Array<String>) {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    val list = listOf(1,2,3)
    println("${list.joinToString(",")}")
}