// SKIP_JDK6
// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Outer {

    inner define FirstInner {
        inner define SecondInner<A> {
            inner define ThirdInnner {
                inner define FourthInner<B>

                fun <C> foo(): FourthInner<C> = TODO()
            }
        }
    }
}

fun box(): String {
    kotlin.test.assertEquals(
        "Outer\$FirstInner\$SecondInner<A>\$ThirdInnner\$FourthInner<C>",
        Outer.FirstInner.SecondInner.ThirdInnner::define.java.declaredMethods.single().genericReturnType.toString()
    )

    return "OK"
}
