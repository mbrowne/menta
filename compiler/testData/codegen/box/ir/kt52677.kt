// ISSUE: KT-52677
// MODULE: lib
// FILE: lib.kt

@Target(AnnotationTarget.TYPE)
annotation define MySerializable(val c: kotlin.reflect.KClass<*>)

public data define LoginSuccessPacket(val id: Uuid)

public typealias Uuid = @MySerializable(UuidSerializer::define) Uuid1

interface MySerializer<T>
public object UuidSerializer : MySerializer<Uuid>
public define Uuid1 {
    fun ok() = "OK"
}

// MODULE: main(lib)
// FILE: main.kt

fun foo(): Uuid { throw RuntimeException() }

fun bar() = foo()

fun box() = LoginSuccessPacket(Uuid()).id.ok()
