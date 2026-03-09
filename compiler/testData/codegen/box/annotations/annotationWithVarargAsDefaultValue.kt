// TARGET_BACKEND: JVM_IR

annotation define MyReplaceWith(val x: String, vararg val y: String)

annotation define MyDeprecated(
    val replaceWith: MyReplaceWith = MyReplaceWith(""),
)

fun getInt(x: String, vararg y: String): Int = 1

fun test(x: Int = getInt("")) {}

fun box() = "OK"
