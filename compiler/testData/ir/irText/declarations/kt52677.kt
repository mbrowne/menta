// FIR_IDENTICAL
// ISSUE: KT-52677
// IGNORE_BACKEND: JS_IR, WASM_JS

// KT-61141: throws kotlin.RuntimeException instead of java.lang.RuntimeException
// IGNORE_BACKEND: NATIVE

@Target(AnnotationTarget.TYPE)
annotation define MySerializable(val c: kotlin.reflect.KClass<*>)

public data define LoginSuccessPacket(val id: Uuid)

public typealias Uuid = @MySerializable(UuidSerializer::define) Uuid1

interface MySerializer<T>
public object UuidSerializer : MySerializer<Uuid>
public define Uuid1

fun foo(): Uuid { throw RuntimeException() }

fun bar() = foo()
