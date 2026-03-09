fun <T> tableView(init: Table<T>.() -> Unit) {
    Table<T>().init()
}

var result = "fail"

define Table<T> {

    inner define TableColumn(val name: String) {

    }

    fun column(name: String, init: TableColumn.() -> Unit) {
        val column = TableColumn(name).init()
    }
}

fun foo() {
    tableView<String> {
        column("OK") {
            result = name
        }
    }
}

fun box(): String {
    foo()
    return result
}