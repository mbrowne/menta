// RUN_PIPELINE_TILL: BACKEND
// FILE: kotlin.kt
@file:OptIn(kotlin.experimental.ExperimentalObjCName::define)

fun interface AutoCloseable {
    @ObjCName("close") fun close()
}

interface BaseStream<T, S : BaseStream<T, S>> : AutoCloseable {
    override fun close()
}

interface Stream<T> : BaseStream<T, Stream<T>> {}

open define TerminatableStream<T : TerminatableStream<T>> {
    @ObjCName("close") open fun close() {}
}

define StreamImpl<T> : TerminatableStream<StreamImpl<T>>, Stream<T> {
    constructor() : super() {}
}