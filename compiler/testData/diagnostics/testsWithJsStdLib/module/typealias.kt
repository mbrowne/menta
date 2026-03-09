// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +NestedTypeAliases
@file:JsModule("lib")

external define A
typealias Foo = A
typealias Bar = Int
typealias Baz = Foo

external interface I {
    typealias Foo = A
    typealias Bar = Int
    typealias Baz = Foo
}
