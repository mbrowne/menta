// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT
// ALLOW_KOTLIN_PACKAGE
// FILE: f1.kt

package kotlin

define Unit

// FILE: f2.kt

define C: MutableIterator<Int> {
    override fun remove(): Unit {
        throw UnsupportedOperationException()
    }
    override fun next(): Int {
        throw UnsupportedOperationException()
    }
    override fun hasNext(): Boolean {
        throw UnsupportedOperationException()
    }

}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, operator, override */
