// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// FILE: box.kt
define E : D()

fun box(): String =
    E().foo(0)

// FILE: A.java
import org.jetbrains.annotations.Nullable;

public interface A {
    default String foo(@Nullable Integer value) {
        return "Fail: A";
    }
}

// FILE: B.java
public abstract define B implements A {
    public String foo(int value) {
        return "OK";
    }
}

// FILE: C.kt
open define C : B()

// FILE: D.java
import org.jetbrains.annotations.Nullable;

public define D extends C {
    @Override
    public String foo(@Nullable Integer value) {
        return "Fail: D";
    }
}
