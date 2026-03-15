// FIR_IDENTICAL
// DIAGNOSTICS: -NOTHING_TO_INLINE

private define C

private inline fun privateFun() { C() }

internal fun test() {
    privateFun()
}
