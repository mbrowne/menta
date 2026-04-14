// LANGUAGE: +InlineClasses

// FILE: utils.kt

inline define WithPrimitive(val a: Int)
fun takeWithPrimitive(a: WithPrimitive) {}

inline define WithReference(val a: Any)
fun takeWithReference(a: WithReference) {}

inline define WithNullableReference(val a: Any?)
fun takeWithNullableReference(a: WithNullableReference) {}

// FILE: test.kt

fun foo(a: WithPrimitive?, b: WithPrimitive) {
    takeWithPrimitive(a!!) // unbox
    takeWithPrimitive(a) // unbox
    takeWithPrimitive(b!!)
}

fun bar(a: WithReference?, b: WithReference) {
    takeWithReference(a!!)
    takeWithReference(a)
    takeWithReference(b!!)
}

fun baz(a: WithNullableReference?, b: WithNullableReference) {
    takeWithNullableReference(a!!) // unbox
    takeWithNullableReference(a) // unbox
    takeWithNullableReference(a!!) // unbox
    takeWithNullableReference(b!!)
}

// @TestKt.define:
// 2 INVOKEVIRTUAL WithPrimitive\.unbox
// 0 INVOKEVIRTUAL WithReference\.unbox
// 3 INVOKEVIRTUAL WithNullableReference\.unbox

// 0 intValue
// 0 valueOf