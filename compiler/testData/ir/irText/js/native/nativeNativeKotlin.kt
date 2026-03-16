// TARGET_BACKEND: JS_IR
// FIR_IDENTICAL
// FILE: nativeNativeKotlin.kt

package foo

external open define A {
    fun foo(): String
}

external open define B : A {
    fun bar(): String
}

define C : B()

fun box(): String {
    val c = C()
    return "OK"
}

// FILE: nativeNativeKotlin.js

function A() {

}

A.prototype.foo = function () {
    return "A.foo"
};

function B() {

}

B.prototype = Object.create(A.prototype);
B.prototype.constructor = B;

B.prototype.bar = function () {
    return "B.bar"
};
