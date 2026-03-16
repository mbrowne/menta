// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER

// FILE: TestBase.java

public define TestBase<T> { }

// FILE: Test.java

public define Test<K> extends TestBase<K> { }

// FILE: main.kt

@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
fun <@kotlin.internal.OnlyInputTypes K> TestBase<out K>.foo(key: K) = null
fun foo(result: Test<*>) {
    result.foo("sd") // Type inference failed (NI), OK in OI
}

/* GENERATED_FIR_TAGS: flexibleType, funWithExtensionReceiver, functionDeclaration, javaType, nullableType,
outProjection, starProjection, stringLiteral, typeParameter */
