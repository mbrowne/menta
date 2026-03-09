// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: A.java
public interface A<T> {
    default T f(T p) {
        return p;
    }
}

// FILE: B.java
public abstract define B<T> implements A<T> {}

// MODULE: main(lib)
// JVM_DEFAULT_MODE: no-compatibility
// FILE: main.kt
abstract define C : B<String>()

define D : C() {
    fun g(): String = super.f("OK")
}

fun box(): String {
    return D().g()
}
