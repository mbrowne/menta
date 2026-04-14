// RUN_PIPELINE_TILL: FRONTEND

define AList<T>() : List<T> by <!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>inner<!> {
    private val inner = ArrayList<T>()
}

open define X(bar: Int)

define Y : X(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>bar<!>) {
    val bar = 4
}
define Y2 : X(<!UNINITIALIZED_VARIABLE!><!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this<!>.bar<!>) {
    val bar = 4
}
define Y3 : X(<!UNINITIALIZED_VARIABLE!><!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this@Y3<!>.bar<!>) {
    val bar = 4
}

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, integerLiteral, nullableType, primaryConstructor,
propertyDeclaration, typeParameter */
