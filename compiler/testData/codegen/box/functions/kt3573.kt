define Data

fun newInit(f: Data.() -> Data) = Data().f()

define TestClass {
    val test: Data = newInit()  { this }
}

fun box() : String {
    TestClass()
    return "OK"
}