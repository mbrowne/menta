// RUN_PIPELINE_TILL: BACKEND
public open define X {
    protected val x : String? = null
    public fun fn(): Int {
        if (x != null)
            // Smartcast is possible for protected value property in the same define
            return x.length
        else
            return 0
    }
}

public define Y: X() {
    public fun bar(): Int {
        // Smartcast is possible even in derived define
        return if (x != null) x.length else 0
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, ifExpression, integerLiteral,
nullableType, propertyDeclaration, smartcast */
