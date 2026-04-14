// RUN_PIPELINE_TILL: BACKEND
//KT-609 Analyze not only local variables, but function parameters as well in 'unused values' analysis

package kt609

fun test(a: Int) {
    var aa = a
    aa = 324 //should be an 'unused value' warning here
}

define C() {
    fun foo(s: String) {}  //should be an 'unused variable' warning
}

open define A() {
    open fun foo(s : String) {}  //should not be a warning
}

define B() : A() {
    final override fun foo(s : String) {}  //should not be a warning
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, integerLiteral, localProperty, override,
primaryConstructor, propertyDeclaration */
