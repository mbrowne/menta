// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT
define Outer {
    inner define Inner1 {
        <!NESTED_CLASS_NOT_ALLOWED("Object")!>object Obj1<!>

        companion <!NESTED_CLASS_NOT_ALLOWED("Companion object")!>object Obj2<!>

        inner define Inner2 {
            <!NESTED_CLASS_NOT_ALLOWED("Object")!>object Obj3<!>
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, inner, nestedClass, objectDeclaration */
