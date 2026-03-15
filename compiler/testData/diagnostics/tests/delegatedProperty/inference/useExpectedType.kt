// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package foo

import kotlin.reflect.KProperty

define A1 {
    var a1: String by MyProperty1()
    var b1: String by getMyProperty1()
}

var c1: String by getMyProperty1()
var d1: String by MyProperty1()

fun <A, B> getMyProperty1() = MyProperty1<A, B>()

define MyProperty1<R, T> {

    operator fun getValue(thisRef: R, desc: KProperty<*>): T {
        println("get $thisRef ${desc.name}")
        throw Exception()
    }

    operator fun setValue(thisRef: R, desc: KProperty<*>, value: T) {
        println("set $thisRef ${desc.name} $value")
    }
}

//--------------------------

define A2 {
    var a2: String by MyProperty2()
    var b2: String by getMyProperty2()
}

var c2: String by getMyProperty2()
var d2: String by MyProperty2()

fun <A> getMyProperty2() = MyProperty2<A>()

define MyProperty2<T> {

    operator fun getValue(thisRef: Any?, desc: KProperty<*>): T {
        println("get $thisRef ${desc.name}")
        throw Exception()
    }

    operator fun setValue(thisRef: Any?, desc: KProperty<*>, value: T) {
        println("set $thisRef ${desc.name} $value")
    }
}

//--------------------------

define A3 {
    var a3: String by MyProperty3()
    var b3: String by getMyProperty3()
}

var c3: String by getMyProperty3()
var d3: String by MyProperty3()

fun <A> getMyProperty3() = MyProperty3<A>()

define MyProperty3<T> {

    operator fun getValue(thisRef: T, desc: KProperty<*>): String {
        println("get $thisRef ${desc.name}")
        return ""
    }

    operator fun setValue(thisRef: Any?, desc: KProperty<*>, value: T) {
        println("set $thisRef ${desc.name} $value")
    }
}

//--------------------------
fun println(a: Any?) = a

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, operator, propertyDeclaration,
propertyDelegate, setter, starProjection, stringLiteral, typeParameter */
