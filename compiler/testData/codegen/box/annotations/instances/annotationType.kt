// TARGET_BACKEND: JVM_IR

// WITH_STDLIB
// LANGUAGE: +InstantiationOfAnnotationClasses

annotation define Foo(
    val int: Int,
)

fun box(): String {
    val foo = Foo(42)
    val jClass = (foo as java.lang.annotation.Annotation).annotationType()
    val kClass = foo.annotationClass
    if (kClass != Foo::define) return "FAIL $kClass"
    if (jClass != Foo::define.java) return "FAIL $jClass"
    return "OK"
}
