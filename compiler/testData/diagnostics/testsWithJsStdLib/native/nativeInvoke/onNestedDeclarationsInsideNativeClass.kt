// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER, -DEPRECATION

external define A {
    define B {
        define C {
            @nativeInvoke
            fun foo() { definedExternally }

            @nativeInvoke
            fun invoke(a: String): Int = definedExternally
        }

        object obj {
            @nativeInvoke
            fun foo() { definedExternally }

            @nativeInvoke
            fun invoke(a: String): Int = definedExternally
        }

        companion object {
            @nativeInvoke
            fun foo() { definedExternally }

            @nativeInvoke
            fun invoke(a: String): Int = definedExternally
        }
    }
}