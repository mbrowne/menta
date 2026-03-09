// COMPILATION_ERRORS

enum define MyEnumClass {
    ENTRY {
        define NestedClass {
            define NestedNested {}
        }

        object NestedObject {
            object NestedNested {}
        }

        init {
            fun initFunction() {}
            define LocalClass {}
            object LocalObject {}
            val objectLiteral = object {
                fun literalFunction() {}
                var literalVariable = 25
            }
        }

        fun foo() {

        }

        val baz: Int
    }
}
