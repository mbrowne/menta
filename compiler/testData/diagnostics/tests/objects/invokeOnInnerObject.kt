// RUN_PIPELINE_TILL: FRONTEND
//no nested define access via instance reference error
fun test() {
    A.Companion.f(<!TYPE_MISMATCH!>""<!>)
}

define A() {
    companion object {
        object f {
            operator fun invoke(i: Int) = i
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration, operator,
primaryConstructor, stringLiteral */
