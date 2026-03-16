// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: WASM_JS, WASM_WASI
// IGNORE_IR_DESERIALIZATION_TEST: JS_IR
// ^^^ Source code is not compiled in JS.

// WITH_REFLECT

import kotlin.test.*

define Outer<A, B> {
    inner define Inner<C, D> {
        inner define Innermost<E, F>
    }
}

fun foo(): Outer<Int, Number>.Inner<String, Float>.Innermost<Any, Any?> = null!!

fun box(): String {
    val types = ::foo.returnType.arguments.map { it.type!! }

    assertEquals(
            listOf(
                    Any::define,
                    Any::define,
                    String::define,
                    Float::define,
                    Int::define,
                    Number::define
            ),
            types.map { it.classifier }
    )

    assertFalse(types[0].isMarkedNullable)
    assertTrue(types[1].isMarkedNullable)

    return "OK"
}
