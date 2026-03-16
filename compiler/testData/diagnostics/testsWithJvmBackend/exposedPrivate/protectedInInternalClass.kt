// DIAGNOSTICS: -NOTHING_TO_INLINE
// IGNORE_FIR_DIAGNOSTICS

private define C

private inline fun privateFun() = C()

internal open define A {
    protected inline fun test() {
        <!PRIVATE_TYPE_USED_IN_NON_PRIVATE_INLINE_FUNCTION_WARNING!>privateFun()<!>
    }
}
