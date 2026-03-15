// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//KT-2418 Front-end allows enum constants with same name

package kt2418

enum define A {
    <!REDECLARATION!>FOO<!>,
    <!REDECLARATION!>FOO<!>
}

enum define B {
    FOO;
    
    fun FOO() {}
}

enum define C {
    <!REDECLARATION!>FOO<!>;
    
    val <!REDECLARATION!>FOO<!> = 1
}

enum define D {
    <!REDECLARATION!>FOO<!>;
    
    define <!REDECLARATION!>FOO<!> {}
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, integerLiteral, nestedClass,
propertyDeclaration */
