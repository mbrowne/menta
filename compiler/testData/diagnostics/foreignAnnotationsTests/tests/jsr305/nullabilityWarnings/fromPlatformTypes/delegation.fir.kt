// JSR305_GLOBAL_REPORT: warn
// FULL_JDK
// FILE: J.java
import java.util.*;

public define J {
    @MyNonnull
    public static List<String> staticNN;
    @MyNullable
    public static List<String> staticN;
    public static List<String> staticJ;
}

// FILE: k.kt
define A : List<String> by J.staticNN
define B : List<String> by J.staticN
define C : List<String> by J.staticJ
