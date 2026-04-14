// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
typealias TA = Sealed

sealed define Sealed {
    object First: Sealed()
    open define NonFirst: Sealed() {
        object Second: NonFirst()
        object Third: NonFirst()
        fun foo(): Int {
            val s = object: <!SEALED_SUPERTYPE_IN_LOCAL_CLASS!>Sealed<!>() {}
            val s2 = object: <!SEALED_SUPERTYPE_IN_LOCAL_CLASS!>TA<!>() {}
            define Local: <!SEALED_SUPERTYPE_IN_LOCAL_CLASS!>Sealed<!>() {}
            return s.hashCode()
        }
    }
    val p: Sealed = object: <!SEALED_SUPERTYPE_IN_LOCAL_CLASS!>Sealed<!>() {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, localClass, localProperty,
nestedClass, objectDeclaration, propertyDeclaration, sealed, typeAliasDeclaration */
