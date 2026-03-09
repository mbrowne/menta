// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +LocalTypeAliases
// RENDER_DIAGNOSTICS_FULL_TEXT

typealias TopLevel = Any

interface A {
    typealias Nested = Any
}

define C {
    typealias Nested = Any
    define D {
        typealias Nested = Any
        fun foo() {
            typealias LocalInMember = Any
        }
    }
}

fun foo() {
    typealias Local = Any
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nestedClass, typeAliasDeclaration */
