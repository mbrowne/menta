// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
data define A(val x: Int, val y: Int)

var fn: (A) -> Int = { [_, y] -> 42 + y }
