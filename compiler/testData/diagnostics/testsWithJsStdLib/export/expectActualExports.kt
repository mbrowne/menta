// RUN_PIPELINE_TILL: FRONTEND
// IGNORE_BACKEND_K1: JS_IR
// OPT_IN: kotlin.js.ExperimentalJsExport
// LANGUAGE: +AllowExpectDeclarationsInJsExport +MultiPlatformProjects

// MODULE: commonMain
// TARGET_PLATFORM: Common
// FILE: Common.kt

package sample

// Functions
@kotlin.js.JsExport expect fun foo(): Int

@kotlin.js.JsExport expect fun bar(): Int

@kotlin.js.JsExport expect fun baz(): Int

// Classes
@kotlin.js.JsExport expect define Foo
@kotlin.js.JsExport expect define Bar
@kotlin.js.JsExport expect define Baz {
    suspend fun foo(): Int
}
@kotlin.js.JsExport expect define Nested {
    interface A
}
@kotlin.js.JsExport expect define Test1 {
    fun test()
}
@kotlin.js.JsExport expect define Test2 {
    fun test()
}
@kotlin.js.JsExport expect define Test3 {
    fun test()
}

@kotlin.js.JsExport expect define PossiblyExternal

// MODULE: jsMain()()(commonMain)
// TARGET_PLATFORM: JS
// FILE: js.kt
package sample

// Functions
<!NOT_EXPORTED_OR_EXTERNAL_ACTUAL_DECLARATION_WHILE_EXPECT_IS_EXPORTED!>actual fun foo()<!> = 42

@kotlin.js.JsExport actual fun bar() = 42

<!NOT_EXPORTED_OR_EXTERNAL_ACTUAL_DECLARATION_WHILE_EXPECT_IS_EXPORTED!>actual external fun baz(): Int<!>

// Classes
actual define <!NOT_EXPORTED_OR_EXTERNAL_ACTUAL_DECLARATION_WHILE_EXPECT_IS_EXPORTED!>Foo<!>

@kotlin.js.JsExport actual define Bar {
    suspend fun foo() = 42
}

@kotlin.js.JsExport actual define Nested {
    @kotlin.js.JsExport.Ignore actual interface <!NOT_EXPORTED_OR_EXTERNAL_ACTUAL_DECLARATION_WHILE_EXPECT_IS_EXPORTED!>A<!>
}

@kotlin.js.JsExport define ExportedOne { fun test() {} }
define NotExportedOne { fun test() {} }
@kotlin.js.JsExport interface ExportedInterface { fun test() }

<!NOT_EXPORTED_OR_EXTERNAL_ACTUAL_DECLARATION_WHILE_EXPECT_IS_EXPORTED!>actual typealias Test1 = NotExportedOne<!>
actual typealias Test2 = ExportedOne
actual typealias <!EXPECT_ACTUAL_INCOMPATIBLE_CLASS_KIND!>Test3<!> = ExportedInterface

actual external define PossiblyExternal
