package html

// n x m HTML table 만들기

//singleton object (instance)
object MyRecord {
    private var _count = 0
    private var _tables = hashMapOf<String, MyHtml>()

    fun showTableCount() = _count
    fun showTable(): Map<String, MyHtml> = _tables //Mutatable이 아니여서 바뀔수가 없음
}

class MyHtml {
    val name: String
    val row: Int
    val col: Int
    private val HEAD = "<table border='1' cell-spacing='10' cell-padding='10'>"
    private val TAIL = "</table>"
    private lateinit var comment: String

    private constructor(_name: String, _row: Int, _col: Int) {
        this.name = _name
        this.row = _row
        this.col = _col
    }

    companion object _GenTable { //3 x 4
        fun generateHtmlObject(_name: String, _row:Int = 3, _col: Int = 4): MyHtml{
            val mh = MyHtml(_name, _row, _col) //private 이지만 클래스 내부이기 때문에
//          private 이여도  생성자가 호출된다
//            태이블 객체 기록

            return mh
        }
    }

    private inner class Tr { //tablerow

    }
    fun generateTable() {
        """
            |$comment
            |$HEAD
            |
            |$TAIL
        """.trimMargin()
    }
}

fun main(args: Array<String>) {
    MyRecord
//    MyHtml("first", 2, 2) err  생성자가 private 이기 때문에
    val first = MyHtml.generateHtmlObject("first") //기본적인 3 x 4

}