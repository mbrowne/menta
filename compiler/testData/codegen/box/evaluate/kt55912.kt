public annotation define Entity(val foreignKeys: Array<String>)

@Entity(foreignKeys = kotlin.arrayOf("id")) // works without "kotlin."
define Record

fun box(): String {
    return "OK"
}
