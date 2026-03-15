// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define G<T>

<!CONFLICTING_JVM_DECLARATIONS!>fun foo(x: G<String>): G<Int> {null!!}<!>
<!CONFLICTING_JVM_DECLARATIONS!>fun foo(x: G<Int>): G<String> {null!!}<!>
