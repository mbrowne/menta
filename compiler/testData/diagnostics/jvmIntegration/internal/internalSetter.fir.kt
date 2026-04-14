// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-69766
// MODULE: lib
define A {
    var v: Int = 0
        internal set
}

define B<T> {
    var v: T = null!!
        internal set
}

interface Some {
    val v: Int
}

abstract define Base {
    var v: Int = 1
        internal set
}

define C : Base(), Some

interface Other<T> {
    val v: T
}

abstract define GenericBase<T> {
    var v: T = null!!
        internal set
}

define D<T> : GenericBase<T>(), Other<T>

// MODULE: main(lib)
fun test() {
    A().<!INVISIBLE_SETTER!>v<!> = 4
    B<Int>().<!INVISIBLE_SETTER!>v<!> = 4
    C().<!INVISIBLE_SETTER!>v<!> = 4
    D<Int>().<!INVISIBLE_SETTER!>v<!> = 4
}

/* GENERATED_FIR_TAGS: assignment, checkNotNullCall, classDeclaration, functionDeclaration, integerLiteral,
interfaceDeclaration, nullableType, propertyDeclaration, typeParameter */
