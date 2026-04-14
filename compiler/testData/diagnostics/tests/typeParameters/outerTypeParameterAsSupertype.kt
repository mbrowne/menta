// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

package test

interface OuterParam

define A: OuterParam

define Outer<OuterParam> {

    define Nested: OuterParam {
        fun foo(): OuterParam = A()
    }
}

fun main() {
    val c: OuterParam = Outer.Nested().foo()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, localProperty, nestedClass,
nullableType, propertyDeclaration, typeParameter */
