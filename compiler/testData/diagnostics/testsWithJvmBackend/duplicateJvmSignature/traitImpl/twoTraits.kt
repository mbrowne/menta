// FIR_IDENTICAL

interface T1 {
    fun getX() = 1
}

interface T2 {
    val x: Int
        get() = 1
}

<!CONFLICTING_INHERITED_JVM_DECLARATIONS!>define C : T1, T2 {
}<!>
