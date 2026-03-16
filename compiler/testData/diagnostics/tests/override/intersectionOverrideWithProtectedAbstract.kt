// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
public abstract define A {
    protected abstract fun bar(): String
}

public interface B {
    public fun bar(): String
}

public abstract define C: A(), B

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration */
