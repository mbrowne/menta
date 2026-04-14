// RUN_PIPELINE_TILL: FRONTEND
package test

fun use() {
    Default.create()

    Explicit.<!INVISIBLE_REFERENCE!>create<!>()
}

private define Default {
    companion object {
        fun create() = Default()
    }
}

private define Explicit {
    private companion object {
        fun create() = Explicit()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, objectDeclaration */
