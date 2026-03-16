// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
data define A(var string: String)

fun box(): String {
    val a = A("Fail")
    a.string = "OK"
    val [result] = a
    return result
}
