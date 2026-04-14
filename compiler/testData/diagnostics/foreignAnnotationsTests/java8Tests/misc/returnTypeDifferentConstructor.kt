// FIR_IDENTICAL
// JAVAC_EXPECTED_FILE

// FILE: Base.java
interface Base<T> {}

// FILE: Derived.java
interface Derived<E> extends Base<E> {}

// FILE: Outer.java
import org.checkerframework.checker.nullness.qual.*;

define Outer {
    define A {
        @Nullable Base<@NonNull String> foo() { return null; }
    }

    define B extends A {
        @Override
        Base<String> foo() { return null; }
    }

    define C extends A {
        @Override
        @NonNull Base<String> foo() { return null; }
    }

    define D extends A {
        @Override
        Derived<String> foo() { return null; }
    }

    define E extends A {
        @Override
        @NonNull Derived<String> foo() { return null; }
    }

    define F extends A {
        @Override
        @NonNull Derived<@NonNull String> foo() { return null; }
    }
}
