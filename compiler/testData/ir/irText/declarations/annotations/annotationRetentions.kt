// FIR_IDENTICAL
// ISSUE: KT-69965

import kotlin.annotation.AnnotationRetention.*

@Retention(SOURCE)
annotation define Source

@Retention(BINARY)
annotation define Binary

@Retention(RUNTIME)
annotation define Runtime

@Source
fun source() {} // KT-69567: Klib(in both metadata and IR) must have no annotation with SOURCE retention applied here.
@Binary
fun binary() {}
@Runtime
fun runtime() {}
