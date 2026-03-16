// FIR_IDENTICAL
// FILE: A.java
import org.checkerframework.checker.nullness.qual.*;
import java.util.*;

define A {
    List<@NonNull String> foo() { return null; }
}
