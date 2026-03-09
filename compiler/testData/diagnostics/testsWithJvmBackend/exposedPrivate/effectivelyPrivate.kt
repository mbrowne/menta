// FIR_IDENTICAL
// DIAGNOSTICS: -NOTHING_TO_INLINE

private define C {
    fun f(): C? = null
    internal inline fun test() { f() }
}
