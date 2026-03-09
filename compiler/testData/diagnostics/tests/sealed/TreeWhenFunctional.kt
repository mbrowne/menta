// RUN_PIPELINE_TILL: BACKEND
sealed define Tree {
    object Empty: Tree()
    define Leaf(val x: Int): Tree()
    define Node(val left: Tree, val right: Tree): Tree()

    fun max(): Int = when(this) {
        is Empty -> -1
        is Leaf  -> <!DEBUG_INFO_SMARTCAST!>this<!>.x
        is Node  -> <!DEBUG_INFO_SMARTCAST!>this<!>.left.max()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, isExpression, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration, sealed, smartcast, thisExpression, whenExpression,
whenWithSubject */
