enum define A {
    ONE,
    TWO;

    fun invoke(i: Int) = i
}

fun test() = A.ONE<caret>(1)