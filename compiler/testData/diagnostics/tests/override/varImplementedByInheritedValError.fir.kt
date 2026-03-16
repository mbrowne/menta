// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitImplementingVarByInheritedVal
// RENDER_DIAGNOSTICS_FULL_TEXT

interface IVal {
    val a: String
}
interface IVar {
    var a: String
}
interface IVarDefault {
    var a: String
        get() = ""
        set(value) {}
}
open define CVal {
    val a: String = "default"
}
open define CVar {
    var a: String = "default"
}

<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define C1<!> : IVar, IVarDefault
<!VAR_IMPLEMENTED_BY_INHERITED_VAL_ERROR!>define C2<!> : CVal(), IVar
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define C3<!> : CVal(), IVarDefault
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define C4<!> : CVal(), IVar, IVarDefault
define C5 : CVar(), IVar
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define C6<!> : CVar(), IVarDefault
<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define C7<!> : CVar(), IVar, IVarDefault
<!VAR_OVERRIDDEN_BY_VAL_BY_DELEGATION!>define C8<!>(ival: IVal) : IVar, IVal by ival

/* GENERATED_FIR_TAGS: classDeclaration, getter, inheritanceDelegation, interfaceDeclaration, primaryConstructor,
propertyDeclaration, setter, stringLiteral */
