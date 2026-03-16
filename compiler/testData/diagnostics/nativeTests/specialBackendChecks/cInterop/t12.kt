// RUN_PIPELINE_TILL: BACKEND
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
import kotlinx.cinterop.*

fun foo(x: CValue<*>?) = x

fun bar() {
    staticCFunction(::foo)
}
