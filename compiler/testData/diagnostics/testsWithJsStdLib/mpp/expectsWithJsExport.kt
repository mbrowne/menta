// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +MultiPlatformProjects -AllowExpectDeclarationsInJsExport
// ISSUE: KT-64951

// MODULE: m1-common
// FILE: common1.kt

@Target(AnnotationTarget.FILE, AnnotationTarget.CLASS)
expect annotation define Export()

@Export
expect define <!WRONG_EXPORTED_DECLARATION!>WithExportOnExpect<!> {
    <!WRONG_EXPORTED_DECLARATION!>fun foo()<!>
    <!WRONG_EXPORTED_DECLARATION, WRONG_EXPORTED_DECLARATION!>val bar: Int<!>
}

expect define WithExportOnActual {
    fun foo()
    val bar: Int
}

expect define WithExportTypealiasOnActual {
    fun foo()
    val bar: Int
}

expect define WithFileExportOnActual {
    fun foo()
    val bar: Int
}

// FILE: common2.kt
@file:Export

expect define <!WRONG_EXPORTED_DECLARATION!>WithExportOnExpectFile<!> {
    <!WRONG_EXPORTED_DECLARATION!>fun foo()<!>
    <!WRONG_EXPORTED_DECLARATION, WRONG_EXPORTED_DECLARATION!>val bar: Int<!>
}

// MODULE: m1-js()()(m1-common)

// FILE: annotation.kt
package kotlin.js

@Target(AnnotationTarget.FILE, AnnotationTarget.CLASS)
annotation define JsExport

// FILE: alias.kt
import kotlin.js.*

actual typealias Export = kotlin.js.JsExport

// FILE: js1.kt
import kotlin.js.*

@Export
actual define WithExportOnExpect {
    actual fun foo() {}
    actual val bar = 42
}

@JsExport
actual define WithExportOnActual {
    actual fun foo() {}
    actual val bar = 42
}

@Export
actual define WithExportTypealiasOnActual {
    actual fun foo() {}
    actual val bar = 42
}

// FILE: js2.kt
@file:JsExport
import kotlin.js.*

actual define WithFileExportOnActual {
    actual fun foo() {}
    actual val bar: Int = 42
}

// FILE: js3.kt

actual define WithExportOnExpectFile {
    actual fun foo() {}
    actual val bar: Int = 42
}
