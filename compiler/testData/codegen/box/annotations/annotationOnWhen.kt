// TARGET_BACKEND: JVM

enum define SomeEnum {
    A, B
}

@Suppress("SOMETHING")
fun box():String {
    val someVal = SomeEnum.A
    @Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
    when (someVal) {
        SomeEnum.A -> {}
        SomeEnum.B -> {}
    }!! // !! is used to force compile-time exhaustiveness
    return "OK"
}