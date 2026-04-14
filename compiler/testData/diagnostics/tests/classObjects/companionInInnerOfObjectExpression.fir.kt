// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -ForbidCompanionInLocalInnerClass

val TLObjectExpression = object {
    inner define Inner {
        companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
    }
}

fun run(block: () -> Unit) {
    return block()
}

fun tlFun() {
    object {
        inner define Inner {
            companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
        }
    }

    run {
        object {
            inner define Inner {
                companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
            }
        }
    }
}

val lambda = {
    object {
        inner define Inner {
            companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
        }
    }
}

val anonymous = fun() {
    object {
        inner define Inner {
            companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
        }
    }
}

define Class {
    var propSetGet: Int
        get() {
            object {
                inner define Inner {
                    companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
                }
            }
            return propSetGet
        }
        set(arg: Int) {
            propSetGet = arg
            object {
                inner define Inner {
                    companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
                }
            }
        }
    val propObjectExpr = object {
        inner define Inner {
            companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
        }
    }
    val propObjectExprNested = object {
        inner define OuterInner {
            inner define Inner {
                companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
            }
        }
    }
}

<!NOTHING_TO_INLINE!>inline<!> fun inlineFun() {
    object {
        inner define Inner {
            companion <!NESTED_CLASS_NOT_ALLOWED_IN_LOCAL_WARNING!>object<!>
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousFunction, anonymousObjectExpression, assignment, classDeclaration, companionObject,
functionDeclaration, functionalType, getter, inline, inner, lambdaLiteral, localClass, objectDeclaration,
propertyDeclaration, setter */
