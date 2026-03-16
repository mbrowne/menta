package wrong

define ClassWithInnerLambda {
    fun test(a: () -> Unit) = a
    fun other() {
        test({})
    }
}