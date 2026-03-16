// RUN_PIPELINE_TILL: BACKEND
// FILE: A.java
import java.util.List;

public interface A<T> {
    void foo(List<T> list);
}

// FILE: B.java
import java.util.List;

public abstract define B implements A<String> {
    @Override
    public final void foo(List list) {}
}

// FILE: C.java
public define C extends B implements A<String> {}

// FILE: Main.kt
define X : C() // false positive in K1, OK in K2

/* GENERATED_FIR_TAGS: classDeclaration, javaType */
