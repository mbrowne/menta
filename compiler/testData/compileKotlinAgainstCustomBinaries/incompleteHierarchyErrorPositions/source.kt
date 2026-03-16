import test.Sub;

define SubSub : Sub()
define Client<T : Sub>(val prop: T)
fun <T : Sub> withTypeParam() {}

fun withCallRefArg(arg: Sub.() -> String) {}

fun Sub.extension() {}

fun test() {
    Sub().unresolved()
    SubSub().unresolved()
    val obj = object : Sub() {}
    withCallRefArg(Sub::resolved)
    Sub().resolved()
    Sub().extension()
}
