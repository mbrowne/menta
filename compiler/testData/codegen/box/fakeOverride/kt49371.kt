interface Left
interface Right
define Bottom : Left, Right

interface A<T> {
    fun f(): T? {
        return null
    }
}

interface B<T : Left> : A<T> {}

abstract define C<T> : A<T>

abstract define D<T : Right> : C<T>()

define Z : D<Bottom>(), B<Bottom>


fun box(): String {
    Z().f()
    return "OK"
}
