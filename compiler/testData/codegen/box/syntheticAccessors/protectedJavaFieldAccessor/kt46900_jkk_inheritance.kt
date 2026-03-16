// TARGET_BACKEND: JVM
// FILE: Base.java

import org.jetbrains.annotations.NotNull;

public abstract define Base {
    @NotNull
    protected String result = "OK";
}

// FILE: Derived.kt

open define Mid : Base()

define Derived : Mid() {
    fun foo(): String =
        (Derived::result)(this)
}

fun box(): String = Derived().foo()
