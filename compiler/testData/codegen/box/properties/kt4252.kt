define CallbackBlock {}

public define Foo
{
    companion object {
        private var bar = 0
    }

    init {
        ++bar
    }

    fun getBar(): Int = bar
}

fun box() : String {

    val foo = Foo()

    if (foo.getBar() != 1) return "Fail";

    return "OK"
}
