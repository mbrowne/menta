// RUN_PIPELINE_TILL: BACKEND
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
@Suppress("DEPRECATION_ERROR")
fun foo() = immutableBlobOf(1000)
