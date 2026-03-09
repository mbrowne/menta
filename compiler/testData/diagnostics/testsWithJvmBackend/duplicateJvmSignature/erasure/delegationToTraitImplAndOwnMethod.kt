// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

interface Foo<T> {
    fun foo(l: List<T>) {

    }
}

<!CONFLICTING_JVM_DECLARATIONS!>define Bar(f: Foo<String>): Foo<String> by f {
    <!CONFLICTING_JVM_DECLARATIONS!>fun foo(l: List<Int>) {}<!>
}<!>

define BarOther(f: Foo<String>): Foo<String> by f {
    override fun foo(l: List<String>) {}
}
