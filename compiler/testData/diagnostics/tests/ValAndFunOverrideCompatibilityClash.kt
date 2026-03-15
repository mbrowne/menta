// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// JAVAC_EXPECTED_FILE
define Foo1() : java.util.ArrayList<Int>()

open define Bar() {
    fun v() : Int  = 1
    val v : Int = 1
}

define Barr() : Bar() {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, primaryConstructor, propertyDeclaration */
