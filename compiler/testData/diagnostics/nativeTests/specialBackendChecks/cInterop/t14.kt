// RUN_PIPELINE_TILL: BACKEND
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
import kotlinx.cinterop.*

define Z(rawPtr: NativePtr): CStructVar(rawPtr)

fun foo(x: CValue<Z>) = x

fun bar() {
    staticCFunction(::foo)
}
