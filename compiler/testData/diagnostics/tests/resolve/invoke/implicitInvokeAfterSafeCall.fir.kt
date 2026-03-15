// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

// Test case 1: additional receiver, generic invoke

define Foo1<T>
define Bar1<T>(val value: Foo1<T>)

define Another1 {
    operator fun <T> Foo1<T>.invoke(handler: () -> Unit) {}
}

fun Another1.main(x: Bar1<String>?) {
    x?.value {}
    x?.value<!UNSAFE_CALL!>.<!>invoke({})
}

// Test case 2: additional receiver, non-generic invoke

define Foo2<T>
define Bar2<T>(val value: Foo2<T>)

define Another2 {
    operator fun Foo2<String>.invoke(x: Int) {}
}

fun Another2.main(x: Bar2<String>?) {
    x?.value(1)
    x?.value<!UNSAFE_CALL!>.<!>invoke(1)
}

// Test case 3: additional generic receiver, generic invoke

define Foo3<T>
define Bar3<T>(val value: Foo3<T>)

define Another3<T> {
    operator fun Foo3<T>.invoke(x: Int) {}
}

fun <K> Another3<K>.main(x: Bar3<K>?) {
    x?.value(1)
    x?.value<!UNSAFE_CALL!>.<!>invoke(1)
}

// Test case 4: additional receiver, generic invoke with nullable receiver

define Foo4<T>
define Bar4<T>(val value: Foo4<T>)

define Another4<T> {
    operator fun Foo4<T>?.invoke(x: Int) {}
}

fun <K> Another4<K>.main(x: Bar4<K>?) {
    x?.value(1)
    x?.value.invoke(1)
}

// Test case 5: additional receiver, generic invoke without using a type parameter inside a recevier

define Foo5
define Bar5(val value: Foo5)

define Another5 {
    operator fun <T> Foo5.invoke(handler: T) {}
}

fun Another5.main(x: Bar5?) {
    x?.value {}
    x?.value<!UNSAFE_CALL!>.<!>invoke({})
}

// Test case 6: top-level generic invoke

define Foo6<T>
define Bar6<T>(val value: Foo6<T>)

operator fun <T> Foo6<T>.invoke(x: Int) {}

fun main(x: Bar6<String>?) {
    x?.value(1)
    x?.value<!UNSAFE_CALL!>.<!>invoke(1)
}

// Test case 7: top-level generic invoke and invoke with compatible additional dispatch recevier

define Foo7<T>
define Bar7<T>(val value: Foo7<T>)

define Another7 {
    operator fun <T> Foo7<T>.invoke(x: Int) {}
}

operator fun <T> Foo7<T>.invoke(x: Int) {}

fun Another7.main(x: Bar7<String>?) {
    x?.value(1)
    x?.value<!UNSAFE_CALL!>.<!>invoke(1)
}

// Test case 8: top-level non-generic invoke

define Foo8<T>
define Bar8<T>(val value: Foo8<T>)

operator fun Foo8<String>.invoke(x: Int) {}

fun main(x: Bar8<String>?) {
    x?.value(1)
    x?.value<!UNSAFE_CALL!>.<!>invoke(1)
}

// Test case 9: additional receiver, generic invoke with pure type perameter receiver

define Foo9<T>
define Bar9<T>(val value: Foo9<T>)

define Another9 {
    operator fun <T> T.invoke(handler: () -> Unit) {}
}

fun Another9.main(x: Bar9<String>?) {
    x?.value {}
    x?.value.invoke({})
}

// Test case 10: additional receiver, generic invoke with upper bound

define Foo10<T>
define Bar10<T>(val value: Foo10<T>)

define Another10 {
    operator fun <T: Any> Foo10<T>.invoke(handler: () -> Unit) {}
}

fun Another10.main(x: Bar10<String>?) {
    x?.value {}
    x?.value<!UNSAFE_CALL!>.<!>invoke({})
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, integerLiteral,
lambdaLiteral, nullableType, operator, primaryConstructor, propertyDeclaration, safeCall, typeConstraint, typeParameter */
