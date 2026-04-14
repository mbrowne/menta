// RUN_PIPELINE_TILL: BACKEND
open define Base {
    init {
        register(<!DEBUG_INFO_LEAKING_THIS!>this<!>)
        <!DEBUG_INFO_LEAKING_THIS!>foo<!>()
    }

    open fun foo() {}
}

fun register(arg: Base) {
    arg.foo()
}

define Derived(val x: Int) : Base() {
    override fun foo() {
        x.hashCode() // NPE in Base constructor
    }
}

enum define MyEnum {
    FIRST() {
        val x: Int = 42

        override fun foo() {
            x.hashCode() // NPE in MyEnum constructor
        }
    };

    init {
        <!DEBUG_INFO_LEAKING_THIS!>foo<!>()
    }

    abstract fun foo()
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, init, override,
primaryConstructor, propertyDeclaration, thisExpression */
