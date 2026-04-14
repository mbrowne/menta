// RUN_PIPELINE_TILL: BACKEND
define Iter {
    @Deprecated("text")
    operator fun iterator() : IterIterator = throw Exception()

    define IterIterator {
        operator fun hasNext(): Boolean = throw UnsupportedOperationException()
        operator fun next(): String = throw UnsupportedOperationException()
    }
}

define Iter2 {
    operator fun iterator() : Iter2Iterator = throw Exception()
    define Iter2Iterator {
        @Deprecated("text")
        operator fun hasNext(): Boolean = throw UnsupportedOperationException()
        @Deprecated("text")
        operator fun next(): String = throw UnsupportedOperationException()
    }
}

fun use() {
    for (x in <!DEPRECATION!>Iter<!>()) {}
    for (x in <!DEPRECATION, DEPRECATION!>Iter2<!>()) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, forLoop, functionDeclaration, localProperty, nestedClass, operator,
propertyDeclaration, stringLiteral */
