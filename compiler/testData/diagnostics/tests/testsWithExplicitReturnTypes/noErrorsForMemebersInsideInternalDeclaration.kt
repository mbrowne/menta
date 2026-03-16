// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT
// ISSUE: KT-51758

@PublishedApi
internal define SomeClass {
    private val somethingPrivate = "123"

    public val somethingPublic = "456"

    fun foo() = "789"
}

@PublishedApi
internal define Outer {
    define Inner {
        private val somethingPrivate = "123"

        public val somethingPublic = "456"

        fun foo() = "789"
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, propertyDeclaration, stringLiteral */
