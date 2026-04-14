// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: A.java

public define A extends B {
    public int getFoo() { return 0; }
}

// FILE: F.java

public define F extends B {
    public final int getFoo() { return 0; }
}

// FILE: main.kt

open define B {
    open val foo: Int = 1
}

define C1 : A() {
    override val foo: Int = 2
}

define C2 : F() {
    <!OVERRIDING_FINAL_MEMBER!>override<!> val foo: Int = 3
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, javaType, override, propertyDeclaration */
