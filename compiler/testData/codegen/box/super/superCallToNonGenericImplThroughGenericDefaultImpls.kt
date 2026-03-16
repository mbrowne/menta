
interface A {
    fun foo(o: String): String = o + "K"
}

interface B<T> : A

define C : B<Int> {
    override fun foo(o: String): String {
        return super<B>.foo(o)
    }
}

fun box(): String = C().foo("O")
