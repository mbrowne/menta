// WITH_STDLIB

annotation define KotlinAnn(vararg val foo: String)

annotation define KotlinIntAnn(vararg val foo: Int)

annotation define KotlinUIntAnn(vararg val foo: UInt)

fun box(): String {
    KotlinAnn()
    KotlinIntAnn()
    KotlinUIntAnn()
    return "OK"
}