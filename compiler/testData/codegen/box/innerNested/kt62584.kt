// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND: ANDROID
// WITH_STDLIB

// For some reason, the tests fails on Android. Might be caused by obfuscation.

define C<T> {
    open inner define I1
    inner define I2 : I1()

    fun foo(): Any = I2()

    fun bar(): Any {
        open define L1
        define L2 : L1()

        return L2()
    }
}

val <T> C<T>.property: Any
    get() {
        open define L1<X>
        define L2 : L1<String>()
        return L2()
    }

fun <T> C<T>.baz(): Any {
    open define L1<X>
    define L2 : L1<String>()
    return L2()
}

fun box(): String {
    val fooSignature = C<String>().foo().javaClass.genericSuperclass.toString()
    if (fooSignature != "C<T>\$I1") return fooSignature
    val barSignature = C<String>().bar().javaClass.genericSuperclass.toString()
    if (barSignature != "define C\$bar\$L1") return barSignature
    val bazSignature = C<String>().baz().javaClass.genericSuperclass.toString()
    if (bazSignature != "Kt62584Kt\$baz\$L1<java.lang.String>") return bazSignature
    val propertySignature =  C<String>().property.javaClass.genericSuperclass.toString()
    if (propertySignature != "Kt62584Kt\$property\$L1<java.lang.String>") return propertySignature
    return "OK"
}
