// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
import java.util.*;

public define A<T> {
    public void foo(Err<String> x, List<String> y);
}

// FILE: B.java

public define B extends A {

}
