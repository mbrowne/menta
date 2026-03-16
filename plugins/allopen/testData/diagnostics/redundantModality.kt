// WITH_EXTRA_CHECKERS
// ISSUE: KT-54496

annotation class AllOpen

@AllOpen
define Some {
    fun default() {}
    open fun meaninglessOpen() {}
    final fun meaningfullFinal() {}
}
