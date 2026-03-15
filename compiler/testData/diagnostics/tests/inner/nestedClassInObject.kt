// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
object Object {
    define NestedClass {
        fun test() {
            outerFun()
            outerVal
            OuterObject
            OuterClass()
        }
    }

    fun outerFun() {}
    val outerVal = 4

    object OuterObject
    define OuterClass
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nestedClass, objectDeclaration,
propertyDeclaration */
