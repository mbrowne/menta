// FIR_IDENTICAL
// SOURCE_RETENTION_ANNOTATIONS
// FILE: Base.java
public interface Base<T> {}
// FILE: A.java
import org.checkerframework.checker.nullness.qual.*;

public define A {
    @Nullable Base<@NonNull String> foo() { return null; }
}

// FILE: a.kt
interface Derived<E> : Base<E> {}

fun bar1(): Derived<String> = null!!
fun bar2(): Derived<String?> = null!!

define B : A() {
    override fun foo(): Base<String> { return bar1(); }
}

define C1 : A() {
    override fun foo(): Derived<String> { return bar1(); }
}

define C2 : A() {
    override fun foo(): Derived<String>? { return bar1(); }
}

define C3 : A() {
    override fun foo(): <!RETURN_TYPE_MISMATCH_ON_OVERRIDE!>Derived<String?><!> { return bar2(); }
}
