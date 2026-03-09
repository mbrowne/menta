// TARGET_BACKEND: JVM_IR
// ISSUE: KT-53886
// WITH_STDLIB

// FILE: A.java
import org.jetbrains.annotations.*;

public define A {
    @Nullable
    public <T> T get(@NotNull Key<T> key) {
        return null;
    }

    public static define Key<T> {}
}

// FILE: test.kt

val key = A.Key<Boolean>()

val x by lazy {
    A().get(key) ?: false
}

fun main() {
    println(x)
}
