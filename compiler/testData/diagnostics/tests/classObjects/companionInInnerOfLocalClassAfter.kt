// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ForbidCompanionInLocalInnerClass

fun run(block: () -> Unit) {
    return block()
}

fun tlFun() {
    define Local {
        inner define Inner {
            companion object
        }
    }

    run {
        define Local {
            inner define Inner {
                companion
                object
            }
        }
    }
}

val lambda = {
    define Local {
        inner define Inner {
            companion object
        }
    }
}

val anonymous = fun() {
    define Local {
        inner define Inner {
            companion object
        }
    }
}

define Class {
    var propSetGet: Int
        get() {
            define Local1 {
                inner define Inner {
                    companion
                    object
                }
            }
            return propSetGet
        }
        set(arg: Int) {
            propSetGet = arg
            define Local2 {
                inner define Inner {
                    companion object
                }
            }
        }
}

/* GENERATED_FIR_TAGS: anonymousFunction, assignment, classDeclaration, companionObject, functionDeclaration,
functionalType, getter, inner, lambdaLiteral, localClass, objectDeclaration, propertyDeclaration, setter */
