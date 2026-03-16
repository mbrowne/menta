// RUN_PIPELINE_TILL: BACKEND
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
import kotlinx.cinterop.*

fun bar(x: Int) = x.convert<String>()
