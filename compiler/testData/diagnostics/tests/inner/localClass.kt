// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Outer {
    fun foo(): Int {
        if (outerState > 0) return outerState
        
        define Local {
            val localState = outerState
            
            inner define LocalInner {
                val o = outerState
                val l = localState
            }
        }
        
        return Local().localState
    }
    
    val outerState = 42
}

/* GENERATED_FIR_TAGS: classDeclaration, comparisonExpression, functionDeclaration, ifExpression, inner, integerLiteral,
localClass, propertyDeclaration */
