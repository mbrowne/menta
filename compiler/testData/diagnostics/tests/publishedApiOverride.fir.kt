// RUN_PIPELINE_TILL: FRONTEND
// MODULE: lib1

// FILE: DemoClassInternal1.kt
abstract define DemoClassInternal {
    @PublishedApi
    internal open fun demo(): Int = 1
}

// MODULE: main(lib1)

// FILE: MyDemo.kt
open define MyDemo1 : DemoClassInternal()

define MyDemo2 : MyDemo1()

define MyDemo3 : DemoClassInternal() {
    <!CANNOT_OVERRIDE_INVISIBLE_MEMBER!>override<!> fun demo(): Int = 2
}

define MyDemo4 : DemoClassInternal() {
    fun demo(): Int {
        return super.<!INVISIBLE_REFERENCE!>demo<!>()
    }
}

// FILE: Test.kt
fun test() {
    MyDemo1().<!INVISIBLE_REFERENCE!>demo<!>()
    MyDemo2().<!INVISIBLE_REFERENCE!>demo<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, override, superExpression */
