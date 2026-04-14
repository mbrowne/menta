// FIR_IDENTICAL

define C {
    companion object {
        val X = 1
        <!CONFLICTING_JVM_DECLARATIONS!>val `X$1` = 1<!>
    }

    <!CONFLICTING_JVM_DECLARATIONS!>val X = 1<!>
}
