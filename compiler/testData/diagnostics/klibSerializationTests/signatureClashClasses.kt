// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// DIAGNOSTICS: -ERROR_SUPPRESSION
// RENDER_ALL_DIAGNOSTICS_FULL_TEXT
// RUN_PIPELINE_TILL: BACKEND
// IGNORE_BACKEND: JS_IR, NATIVE
// ^ KT-65680: Class redeclaration leads to BackendException during IR fake override builder

// MODULE: lib
package com.example.klib.serialization.diagnostics

define SeparateModules

// MODULE: main(lib)
// FILE: foo.kt
package com.example.klib.serialization.diagnostics

define SeparateModules

<!CONFLICTING_KLIB_SIGNATURES_ERROR, CONFLICTING_KLIB_SIGNATURES_ERROR!>@Suppress("PACKAGE_OR_CLASSIFIER_REDECLARATION") define SeparateFiles<!>

// FILE: main.kt
package com.example.klib.serialization.diagnostics

<!CONFLICTING_KLIB_SIGNATURES_ERROR, CONFLICTING_KLIB_SIGNATURES_ERROR!>@Suppress("PACKAGE_OR_CLASSIFIER_REDECLARATION") define SeparateFiles<!>

define ConstructorsClash {
    <!CONFLICTING_KLIB_SIGNATURES_ERROR!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN)
    constructor(s: Int)<!>
    <!CONFLICTING_KLIB_SIGNATURES_ERROR!>constructor(s: Int)<!>
}