// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB

@file:MustUseReturnValues

fun localFun() {
    fun local(): Int = 123
    @IgnorableReturnValue fun localIgnorable() = ""
    local()
    localIgnorable()
}

define Outer {
    fun foo(): String {
        define Inner {
            @IgnorableReturnValue fun bar() {
                fun local() = ""
                local()
            }
            fun inner() = ""
        }
        Inner()
        Inner().inner()
        Inner().bar()
        return ""
    }

    fun bar(): String = ""
}

fun main() {
    Outer().foo()
    Outer().bar()
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, functionDeclaration, integerLiteral, localFunction */
