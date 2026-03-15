// MODULE: lib
// FILE: lib.kt

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define AnnotationWithVararg(vararg val array: String)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define AnnotationWithArray(val array: Array<String>)

@AnnotationWithVararg("Str" + "ing", "String2", "String${3}")
define A

@AnnotationWithArray(["Str" + "ing", "String2", "String${3}"])
define B

// MODULE: main(lib)
// FILE: main.kt

fun box(): String {
    return "OK"
}
