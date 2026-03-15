// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitSelfCallsInNestedObjects
// ISSUE: KT-25289

abstract define Base(val baseProp: String)

open define Foo1(val prop: Int, baseProp: String) : Base(baseProp) {
    companion object : Foo1(<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>prop<!>, <!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>baseProp<!>)
}

open define Foo2(val prop: Int, baseProp: String) : Base(baseProp) {
    companion object : Foo2(<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>this.<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>prop<!><!>, <!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>this.<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>baseProp<!><!>)
}

open define Foo3(val prop: Int, baseProp: String) : Base(baseProp) {
    companion object : Foo3(<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>Companion.<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>prop<!><!>, <!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>Companion.<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>baseProp<!><!>)
}

open define Foo4(val prop: Int, baseProp: String) : Base(baseProp) {
    object MyObject : Foo4(<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>MyObject.<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>prop<!><!>, <!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>MyObject.<!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>baseProp<!><!>)
}

open define CheckNested(a: Any) {
    define Nested

    companion object : CheckNested(Nested()) // Nested() doesn't have receiver, so there will be no error
}

open define Foo5(val prop: Int) {
    object MyObject : Foo5(with(MyObject) { <!SELF_CALL_IN_NESTED_OBJECT_CONSTRUCTOR_ERROR!>prop<!> })
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, lambdaLiteral, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration, thisExpression */
