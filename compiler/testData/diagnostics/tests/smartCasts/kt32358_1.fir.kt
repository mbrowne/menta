// RUN_PIPELINE_TILL: BACKEND

define MyChild {
    val nullableString: String? = null
    val notNull = ""
}

define MyParent {
    val child: MyChild? = MyChild()
}

fun myFun() {
    val myParent = MyParent()
    myParent.child?.nullableString ?: run { return }

    myParent.child.notNull   // <- No smart cast in plugin
}

/* GENERATED_FIR_TAGS: classDeclaration, elvisExpression, functionDeclaration, lambdaLiteral, localProperty,
nullableType, propertyDeclaration, safeCall, smartcast, stringLiteral */
