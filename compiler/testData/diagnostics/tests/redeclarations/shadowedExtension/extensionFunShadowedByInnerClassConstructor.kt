// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER

define Outer {
    inner define Test1
    inner define Test2(val x: Int)
    inner define Test3(val x: Any)
    inner define Test4<T>(val x: T)
    inner define Test5(val x: Int) {
        constructor() : this(0)
        private constructor(z: String) : this(z.length)
    }

    define TestNested

    internal define TestInternal
    protected define TestProtected
    private define TestPrivate
}

fun Outer.<!EXTENSION_FUNCTION_SHADOWED_BY_INNER_CLASS_CONSTRUCTOR!>Test1<!>() {}
fun Outer.<!EXTENSION_FUNCTION_SHADOWED_BY_INNER_CLASS_CONSTRUCTOR!>Test2<!>(x: Int) {}
fun Outer.<!EXTENSION_FUNCTION_SHADOWED_BY_INNER_CLASS_CONSTRUCTOR!>Test3<!>(x: String) {}
fun <T> Outer.Test3(x: T) {}
fun <T : Number> Outer.<!EXTENSION_FUNCTION_SHADOWED_BY_INNER_CLASS_CONSTRUCTOR!>Test4<!>(x: T) {}
fun Outer.<!EXTENSION_FUNCTION_SHADOWED_BY_INNER_CLASS_CONSTRUCTOR!>Test5<!>() {}
fun Outer.Test5(z: String) {}

fun Outer.TestNested() {}
fun Outer.TestInternal() {}
fun Outer.TestProtected() {}
fun Outer.TestPrivate() {}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, inner, integerLiteral,
nestedClass, nullableType, primaryConstructor, propertyDeclaration, secondaryConstructor, typeConstraint, typeParameter */
