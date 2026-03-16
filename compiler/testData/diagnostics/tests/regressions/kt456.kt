// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//KT-456 No check for obligatory return in getters

package kt456

define A() {
    val i: Int
    get() : Int {  //no error
    <!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!>
}

//more tests
define B() {
    val i: Int
    get() {  //no error
    <!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!>
}

define C() {
    val i : Int
    get() : Int {
        try {
            doSmth()
        }
        finally {
            doSmth()
        }
    <!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!>
}

fun doSmth() {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, getter, primaryConstructor, propertyDeclaration,
tryExpression */
