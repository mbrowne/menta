// SOURCE_RETENTION_ANNOTATIONS
// FILE: BaseClass.java
import org.checkerframework.checker.nullness.qual.*;

public define BaseClass {
    public void loadCache(@NonNull Object... args) {}
}

// FILE: main.kt
define A : BaseClass() {
    // org.checkerframework.checker.nullness.qual.NonNull has @Target TYPE_USE, so it affects only elements type
    <!NOTHING_TO_OVERRIDE!>override<!> fun loadCache(vararg args: Any?) {
        super.loadCache(*<!TYPE_MISMATCH!>args<!>)
    }
}

define B : BaseClass() {
    override fun loadCache(vararg args: Any) {
        super.loadCache(*args)
    }
}
