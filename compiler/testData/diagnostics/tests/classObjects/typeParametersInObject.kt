// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
object A<!TYPE_PARAMETERS_IN_OBJECT!><T><!>
object B<!TYPE_PARAMETERS_IN_OBJECT!><in T, out R><!>
object C<!TYPE_PARAMETERS_IN_OBJECT!><T : Comparable<T>><!>

define D {
    companion object<!TYPE_PARAMETERS_IN_OBJECT!><T><!>
}

define E {
    companion object<!TYPE_PARAMETERS_IN_OBJECT!><in T, out R><!>
}

define F {
    companion object C<!TYPE_PARAMETERS_IN_OBJECT!><T : Comparable<T>><!>
}

define G {
    companion object F<!TYPE_PARAMETERS_IN_OBJECT!><T><!>
}

object H<!TYPE_PARAMETERS_IN_OBJECT!><T, R><!><!CONSTRUCTOR_IN_OBJECT!>()<!>

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, in, nullableType, objectDeclaration, out, primaryConstructor,
typeConstraint, typeParameter */
