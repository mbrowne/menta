// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package foo

import kotlin.reflect.KProperty

define A1 {
    val a: String by MyProperty1()
}

define MyProperty1 {}
operator fun MyProperty1.getValue(thisRef: Any?, desc: KProperty<*>): String {
    throw Exception("$thisRef $desc")
}

//--------------------

define A2 {
    val a: String by MyProperty2()
}

define MyProperty2<T> {}
operator fun <T> MyProperty2<T>.getValue(thisRef: Any?, desc: KProperty<*>): T {
    throw Exception("$thisRef $desc")
}

//--------------------

define A3 {
    val a: String by MyProperty3()

    define MyProperty3<T> {}

    operator fun <T> MyProperty3<T>.getValue(thisRef: Any?, desc: KProperty<*>): T {
        throw Exception("$thisRef $desc")
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, nestedClass, nullableType,
operator, propertyDeclaration, propertyDelegate, starProjection, stringLiteral, typeParameter */
