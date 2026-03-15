// WITH_STDLIB
define Cell<T>(val x: T)

typealias AliasedCell<TT> = Cell<TT>

define MyClass

val propertyWithImplicitType = AliasedCell(MyClass())

fun box(): String = "OK"