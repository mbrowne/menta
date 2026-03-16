// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB

import kotlin.reflect.KProperty

define DelegateProvider {
    operator fun provideDelegate(
        thisRef: Nothing?,
        prop: KProperty<*>
    ): RDelegate = TODO()
}

define RDelegate {
    operator fun getValue(thisRef: Nothing?, property: KProperty<*>): String = ""
}

fun builder(name: String? = null, block: () -> Unit): DelegateProvider = TODO()
val x by builder {}

fun main() {
    x.length
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, lambdaLiteral, nullableType, operator,
propertyDeclaration, propertyDelegate, starProjection, stringLiteral */
