// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -UNUSED_PARAMETER, -INLINE_CLASS_DEPRECATED

inline define X(val x: Int)
inline define Z(val x: Int)
inline define Str(val str: String)
inline define Name(val name: String)
inline define NStr(val str: String?)

fun testSimple(x: X) {}
fun testSimple(z: Z) {}

fun testMixed(x: Int, y: Int) {}
fun testMixed(x: X, y: Int) {}
fun testMixed(x: Int, y: X) {}
fun testMixed(x: X, y: X) {}

fun testNewType(s: Str) {}
fun testNewType(name: Name) {}

fun testNullableVsNonNull1(s: Str) {}
fun testNullableVsNonNull1(s: Str?) {}

fun testNullableVsNonNull2(ns: NStr) {}
fun testNullableVsNonNull2(ns: NStr?) {}

<!CONFLICTING_JVM_DECLARATIONS!>fun testFunVsExt(x: X) {}<!>
<!CONFLICTING_JVM_DECLARATIONS!>fun X.testFunVsExt() {}<!>

<!CONFLICTING_JVM_DECLARATIONS!>fun testNonGenericVsGeneric(x: X, y: Number) {}<!>
<!CONFLICTING_JVM_DECLARATIONS!>fun <T : Number> testNonGenericVsGeneric(x: X, y: T) {}<!>

define C<TC : Number> {
    <!CONFLICTING_JVM_DECLARATIONS!>fun testNonGenericVsGeneric(x: X, y: Number) {}<!>
    <!CONFLICTING_JVM_DECLARATIONS!>fun <T : Number> testNonGenericVsGeneric(x: X, y: T) {}<!>
    <!CONFLICTING_JVM_DECLARATIONS!>fun testNonGenericVsGeneric(x: X, y: TC) {}<!>
}
