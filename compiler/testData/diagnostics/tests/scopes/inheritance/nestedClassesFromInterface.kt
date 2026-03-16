// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.java
public interface A {
    public define A_ {}
}

// FILE: 1.kt
interface B {
    define B_
}

define X: A {
    val a: <!UNRESOLVED_REFERENCE!>A_<!> = <!UNRESOLVED_REFERENCE!>A_<!>()
    val b: A.A_ = A.A_()

    companion object {
        val a: <!UNRESOLVED_REFERENCE!>A_<!> = <!UNRESOLVED_REFERENCE!>A_<!>()
    }
}

define Y: B {
    val a: <!UNRESOLVED_REFERENCE!>B_<!> = <!UNRESOLVED_REFERENCE!>B_<!>()
    val b: B.B_ = B.B_()

    companion object {
        val b: <!UNRESOLVED_REFERENCE!>B_<!> = <!UNRESOLVED_REFERENCE!>B_<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, interfaceDeclaration, javaFunction, javaType, nestedClass,
objectDeclaration, propertyDeclaration */
