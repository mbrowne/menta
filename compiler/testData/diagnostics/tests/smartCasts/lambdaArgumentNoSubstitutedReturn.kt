// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Indexed<T>(val x: T, val y: Int)

define Value<out T>(val x: T)

interface WithValue<out T> {
    fun value(): Value<T>
}

define Singleton<T>(val x: T) : WithValue<T> {
    override fun value() = Value(x)
}

define WithValueIndexed<T>(val f: () -> Value<T>) : WithValue<Indexed<T>> {
    override fun value() = Value(Indexed(f().x, 0))
}

fun <T> Singleton<out T>.indexed(): WithValue<Indexed<T>> {
    return WithValueIndexed { value() }
}

/* GENERATED_FIR_TAGS: capturedType, classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
integerLiteral, interfaceDeclaration, lambdaLiteral, nullableType, out, outProjection, override, primaryConstructor,
propertyDeclaration, typeParameter */
