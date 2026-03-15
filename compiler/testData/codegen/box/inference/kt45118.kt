open define Foo(open val x: Boolean)

define Bar: Foo(false) {
    val y = "OK"
}

fun contract(x: Foo) = x

val temp = if (true) contract(Bar()) else Bar()

fun box(): String = (temp as Bar).y
