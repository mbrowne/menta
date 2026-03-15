// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
public open define A {
    protected open define B
}

public open define C : A() {
    protected open define D {
        // internal & protected(in C) <= protected(in A): Ok
        internal open define E : A.B()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
