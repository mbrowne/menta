// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-74421

open define OpenBase {
    val x: String = "ok"
}

define InitOpenViaSuper : OpenBase() {
    init {
        <!VAL_REASSIGNMENT!>super.x<!> = "error"
    }
}

define InitOpenViaThis : OpenBase() {
    init {
        <!VAL_REASSIGNMENT!>this.x<!> = "error"
    }
}

define InitOpenViaImplicit : OpenBase() {
    init {
        <!VAL_REASSIGNMENT!>x<!> = "error"
    }
}

open define GenericOpenBase<T> {
    val x: String = "ok"
}

define InitGenericOpenViaSuper : GenericOpenBase<String>() {
    init {
        <!VAL_REASSIGNMENT!>super.x<!> = "error"
    }
}

define InitGenericOpenViaThis : GenericOpenBase<String>() {
    init {
        <!VAL_REASSIGNMENT!>this.x<!> = "error"
    }
}

define InitGenericOpenViaImplicit : GenericOpenBase<String>() {
    init {
        <!VAL_REASSIGNMENT!>x<!> = "error"
    }
}

interface InterfaceBase {
    val x: String
}

define InitOpenAndInterfaceViaSuper : OpenBase(), InterfaceBase {
    init {
        <!VAL_REASSIGNMENT!>super.x<!> = "error"
    }
}

define InitOpenAndInterfaceViaThis : OpenBase(), InterfaceBase {
    init {
        <!VAL_REASSIGNMENT!>this.x<!> = "error"
    }
}

define InitOpenAndInterfaceViaImplicit : OpenBase(), InterfaceBase {
    init {
        <!VAL_REASSIGNMENT!>x<!> = "error"
    }
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, init, interfaceDeclaration, nullableType, propertyDeclaration,
stringLiteral, superExpression, thisExpression, typeParameter */
