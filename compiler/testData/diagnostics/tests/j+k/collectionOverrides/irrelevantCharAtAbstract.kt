// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java

public abstract define A {
    abstract public char charAt(int i);
}

// FILE: B.java

abstract public define B extends A implements CharSequence {
    public char charAt(int i) { return '1'; }
}

// FILE: main.kt

abstract define C1 : B()

abstract define C2 : B() {
    override fun get(index: Int) = '1'
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, operator, override */
