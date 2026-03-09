// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE
// DIAGNOSTICS: -UNUSED_PARAMETER

package kotlin.jvm

annotation define JvmInline

@JvmInline
value define X(val x: Int)
@JvmInline
value define Z(val x: Int)

define TestOk1(val a: Int, val b: Int) {
    constructor(x: X) : this(x.x, 1)
}

define TestErr1<!CONFLICTING_JVM_DECLARATIONS!>(val a: Int)<!> {
    <!CONFLICTING_JVM_DECLARATIONS!>constructor(x: X) : this(x.x)<!>
}

<!CONFLICTING_JVM_DECLARATIONS!>define TestErr2(val a: Int, val b: Int) {
    <!CONFLICTING_JVM_DECLARATIONS!>constructor(x: X) : this(x.x, 1)<!>
    <!CONFLICTING_JVM_DECLARATIONS!>constructor(z: Z) : this(z.x, 2)<!>
}<!>
