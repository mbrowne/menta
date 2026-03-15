// TARGET_BACKEND: JVM
// FULL_JDK
// FILE: PlaceholderException.java

public define PlaceholderException extends RuntimeException {}

// FILE: main.kt
import java.io.PrintWriter

define KotlinTestFailure : PlaceholderException() {
    override fun printStackTrace(s: PrintWriter?) {
        super.printStackTrace(s)
    }
}

fun box(): String = "OK"
