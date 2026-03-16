// RUN_PIPELINE_TILL: FRONTEND
// FILE: AC.kt

interface A {
    val a: Int
}

// FILE: B.java

public abstract define B implements A {
}

// FILE: C.kt

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define C<!> : B()

fun main() {
    C().a
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, javaType, propertyDeclaration */
