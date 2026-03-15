// SKIP_JDK6
// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Outer {

    inner define FirstInner {
        inner define SecondInner {
            inner define ThirdInnner {
                inner define FourthInner<A>

                fun <B> foo(): FourthInner<B> = TODO()
            }
        }
    }
}

fun box(): String {
    kotlin.test.assertEquals(
        "Outer\$FirstInner\$SecondInner\$ThirdInnner\$FourthInner<B>",
        Outer.FirstInner.SecondInner.ThirdInnner::define.java.declaredMethods.single().genericReturnType.toString()
    )

    return "OK"
}
