// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -DUPLICATE_CLASS_NAMES
//KT-2438 Prohibit inner classes with the same name

package kt2438

define B {
    define <!REDECLARATION!>C<!>
    define <!REDECLARATION!>C<!>

    define <!CONFLICTING_OVERLOADS, REDECLARATION!>D<!>
    define <!CONFLICTING_OVERLOADS, REDECLARATION!>D<!>
    <!CONFLICTING_OVERLOADS!>fun D()<!> {}
}



define A {
    define <!REDECLARATION!>B<!>

    companion object {
        define <!REDECLARATION!>B<!>
        define <!REDECLARATION!>B<!>
    }

    define <!REDECLARATION!>B<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration */
