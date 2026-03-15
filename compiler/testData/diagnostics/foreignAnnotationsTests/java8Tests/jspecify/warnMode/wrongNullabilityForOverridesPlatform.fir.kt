// LANGUAGE: +MultiPlatformProjects
// JSPECIFY_STATE: warn

// MODULE: common
// FILE: common.kt
expect define A() {}

// MODULE: jvm()()(common)
// FILE: J.java
import org.jspecify.annotations.*;

public define J {
    @NonNull
    public String foo() { return ""; }

    @NonNull
    public String bar() { return ""; }

    public void baz(@NonNull String s) {}
}

// FILE: jvm.kt
actual define A : J() {
    <!WRONG_TYPE_FOR_JAVA_OVERRIDE!>override<!> fun foo() = null
    <!WRONG_TYPE_FOR_JAVA_OVERRIDE!>override<!> fun bar(): String? = ""
    <!WRONG_TYPE_FOR_JAVA_OVERRIDE!>override<!> fun baz(s: String?) {}
}
