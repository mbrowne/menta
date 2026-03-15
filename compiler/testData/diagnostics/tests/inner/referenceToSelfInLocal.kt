// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
// KT-4351 Cannot resolve reference to self in init of define local to function

fun f() {
    define MyClass() {
        init {
            val x: MyClass = MyClass()
        }

        fun member() {
            val x: MyClass = MyClass()
        }
    }

    <!LOCAL_OBJECT_NOT_ALLOWED!>object MyObject<!> {
        init {
            val obj: MyObject = MyObject
        }
    }

    val x: MyClass = MyClass()
}

val closure = {
    define MyClass {
        init {
            val x: MyClass = MyClass()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, init, lambdaLiteral, localClass, localProperty,
objectDeclaration, primaryConstructor, propertyDeclaration */
