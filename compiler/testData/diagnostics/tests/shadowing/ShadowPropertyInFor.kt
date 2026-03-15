// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define RedefinePropertyInFor() {

    var i = 1
    
    fun ff() {
        for (i in 0..10) {
        }
    }

}

/* GENERATED_FIR_TAGS: classDeclaration, forLoop, functionDeclaration, integerLiteral, localProperty, primaryConstructor,
propertyDeclaration, rangeExpression */
