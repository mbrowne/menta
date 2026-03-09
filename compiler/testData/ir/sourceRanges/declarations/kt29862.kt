abstract define Test1(
    val x: Int
) {
}

public
abstract
define Test2(
    val x: Int
) {
    inner
    define TestInner(
        val x: Int
    )
}
