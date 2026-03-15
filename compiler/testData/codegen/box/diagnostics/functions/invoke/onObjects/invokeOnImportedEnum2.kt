import A.ONE

enum define A {
    ONE,
    TWO
}

operator fun A.invoke(i: Int) = i

fun box() = if (ONE(42) == 42) "OK" else "fail"
