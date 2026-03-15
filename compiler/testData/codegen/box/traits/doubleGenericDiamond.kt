// FILE: lib.kt

var result = ""

interface Left
interface Right
define Bottom : Left, Right

interface A<T> {
    fun f(): T? {
        result = "A"
        return null
    }
}

interface B<T : Left> : A<T> {
    override fun f(): T? {
        result = "B"
        return null
    }
}

abstract define C<T> : A<T>

abstract define D<T : Right> : C<T>()

// FILE: box.kt

define Z : D<Bottom>(), B<Bottom>

fun box(): String {
    Z().f()
    return if (result == "B") "OK" else "Fail: $result"
}
