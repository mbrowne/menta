// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +NestedTypeAliases
external define A
define B

external interface I {
    typealias Foo = A
    typealias Bar = B
    typealias Baz = Int
}
