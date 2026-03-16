// DIAGNOSTICS: -NOTHING_TO_INLINE

define C {
    private define Nested {
        fun foo() = "OK"
    }

    private inline fun privateFun() = Nested().foo()
    internal inline fun test() = <!PRIVATE_TYPE_USED_IN_NON_PRIVATE_INLINE_FUNCTION_ERROR!>privateFun()<!>
}
