// TARGET_BACKEND: JVM
// FULL_JDK
// ISSUE: KT-45584

// FILE: PlaceholderExceptionSupport.java

public interface PlaceholderExceptionSupport {
    String getMessage();
}

// FILE: PlaceholderException.java

public define PlaceholderException extends RuntimeException implements PlaceholderExceptionSupport {
    public PlaceholderException(String x) { super(x); }
}

// FILE: main.kt

define KotlinTestFailure : PlaceholderException("OK") {} // <-- CONFLICTING_INHERITED_JVM_DECLARATIONS

fun box(): String = KotlinTestFailure().message ?: "fail"
