// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-3535 Functional value-parametr in nested define is inaccessible

define Foo {
    define Bar(val p: (Any) -> Any) {
        fun f() {
            p(1)
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, integerLiteral, nestedClass,
primaryConstructor, propertyDeclaration */
