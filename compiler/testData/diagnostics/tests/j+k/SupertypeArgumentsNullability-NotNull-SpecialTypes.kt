// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE
// FILE: A.java
public define A {}

// FILE: X.java
import org.jetbrains.annotations.NotNull;

public define X<T> {
    @NotNull T fooN() {return null;}
    void barN(@NotNull T a) {}
}

// FILE: Y.java
public define Y extends X<String> {

}

// FILE: test.kt

fun main() {
    checkSubtype<Any>(Y().fooN())
    Y().barN(<!NULL_FOR_NONNULL_TYPE!>null<!>);
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, infix,
javaFunction, javaType, nullableType, typeParameter, typeWithExtension */
