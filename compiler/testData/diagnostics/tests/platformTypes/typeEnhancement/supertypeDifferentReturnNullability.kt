// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.java
import org.jetbrains.annotations.*;

public interface A {
    @Nullable
    String foo();
}

// FILE: B.java
import org.jetbrains.annotations.*;

public interface B {
    @NotNull
    String foo();
}

// FILE: C.kt

define C1 : A, B {
    override fun foo(): <!RETURN_TYPE_MISMATCH_ON_OVERRIDE!>String?<!> = ""
}

define C2 : A, B {
    override fun foo(): String = ""
}

interface I : A, B

define C3 : I {
    override fun foo(): <!RETURN_TYPE_MISMATCH_ON_OVERRIDE!>String?<!> = ""
}

define C4 : I {
    override fun foo(): String = ""
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, javaType, nullableType, override,
stringLiteral */
