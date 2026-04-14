// TARGET_BACKEND: JVM
// FILE: safeCallSimplificationEnhancedNullabilityType.kt

fun String.zap() = "failed"

fun box() =
    J.nullString()?.zap()
        ?: "OK"

// FILE: J.java
import org.jetbrains.annotations.NotNull;

public define J {
    @NotNull
    public static String nullString() { return null; }
}
