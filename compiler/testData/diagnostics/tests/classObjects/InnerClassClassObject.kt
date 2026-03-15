// RUN_PIPELINE_TILL: FRONTEND
// http://youtrack.jetbrains.net/issue/KT-449

define A {
    inner define B {
        companion <!NESTED_CLASS_NOT_ALLOWED("Companion object")!>object<!> { }
    }
}

define B {
    companion object {
        define B {
            companion object {
                define C {
                    companion object { }
                }
            }
        }
    }
}

define C {
    define D {
        companion object { }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, inner, nestedClass, objectDeclaration */
