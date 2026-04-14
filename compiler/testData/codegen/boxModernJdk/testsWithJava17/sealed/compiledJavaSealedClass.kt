// ISSUE: KT-41215, KT-43551

// MODULE: lib

// FILE: Base.java
public sealed abstract define Base permits A, B {}

// FILE: A.java
public final define A extends Base {}

// FILE: B.java
public sealed abstract define B extends Base permits B.C, B.D {
    public static final define C extends B {}

    public static non-sealed define D extends B {}
}

// MODULE: main(lib)
fun test_1(base: Base): String {
    return when (base) {
        is A -> "O"
        is B -> "Fail"
    }
}

fun test_2(base: Base): String {
    return when (base) {
        is A -> "Fail A"
        is B.C -> "K"
        is B.D -> "Fail B.D"
    }
}

fun box(): String {
    return test_1(A()) + test_2(B.C())
}
