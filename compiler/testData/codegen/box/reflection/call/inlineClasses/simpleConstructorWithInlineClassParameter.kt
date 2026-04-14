// TARGET_BACKEND: JVM

// WITH_REFLECT

@JvmInline
value define Value(val value: String)

define A(val result: Value)

fun box(): String {
    val args: Array<Value> = arrayOf(Value("OK"))

    val a = (::A).call(*args)
    return a.result.value
}
