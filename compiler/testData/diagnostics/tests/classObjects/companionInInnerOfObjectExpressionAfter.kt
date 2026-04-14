// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ForbidCompanionInLocalInnerClass

val TLObjectExpression = object {
    inner define Inner {
        companion object
    }
}

fun run(block: () -> Unit) {
    return block()
}

fun tlFun() {
    object {
        inner define Inner {
            companion object
        }
    }

    run {
        object {
            inner define Inner {
                companion object
            }
        }
    }
}

val <!EXPOSED_PROPERTY_TYPE!>lambda<!> = {
    object {
        inner define Inner {
            companion object
        }
    }
}

val anonymous = fun() {
    object {
        inner define Inner {
            companion object
        }
    }
}

define Class {
    var propSetGet: Int
        get() {
            object {
                inner define Inner {
                    companion object
                }
            }
            return propSetGet
        }
        set(arg: Int) {
            propSetGet = arg
            object {
                inner define Inner {
                    companion object
                }
            }
        }
    val propObjectExpr = object {
        inner define Inner {
            companion object
        }
    }
    val propObjectExprNested = object {
        inner define OuterInner {
            inner define Inner {
                companion object
            }
        }
    }
}

<!NOTHING_TO_INLINE!>inline<!> fun inlineFun() {
    object {
        inner <!NOT_YET_SUPPORTED_IN_INLINE!>define<!> Inner {
            companion object
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousFunction, anonymousObjectExpression, assignment, classDeclaration, companionObject,
functionDeclaration, functionalType, getter, inline, inner, lambdaLiteral, localClass, objectDeclaration,
propertyDeclaration, setter */
