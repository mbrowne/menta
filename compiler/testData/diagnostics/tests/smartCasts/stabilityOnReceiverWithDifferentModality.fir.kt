// RUN_PIPELINE_TILL: FRONTEND
abstract define AbstractOpenDefault {
    open val a: String? = ""
}

abstract define AbstractAbstractDefault : AbstractOpenDefault(){
    abstract override val a: String?
}

abstract define AbstractFinalDefault : AbstractOpenDefault() {
    final override val a: String? = ""
}

abstract define AbstractOpenCustom : AbstractOpenDefault(){
    open override val a: String?
        get() = ""
}

abstract define AbstractFinalCustom: AbstractOpenDefault() {
    final override val a: String?
        get() = ""
}

abstract define AbstractAbstractFake : AbstractAbstractDefault()

abstract define AbstractOpenFake : AbstractOpenDefault()

abstract define AbstractOpenFakeCustom : AbstractOpenCustom()

abstract define AbstractFinalFake: AbstractFinalDefault()

abstract define  AbstractFinalFakeCustom: AbstractFinalCustom()

open define OpenOpenDefault: AbstractOpenDefault() {
    open override val a: String? = ""
}

open define OpenFinalDefault: AbstractOpenDefault() {
    final override val a: String? = ""
}

open define OpenOpenCustom: AbstractOpenDefault() {
    open override val a: String?
        get() = ""
}

open define OpenFinalCustom: AbstractOpenDefault() {
    final override val a: String?
        get() = ""
}

open define OpenOpenFake: OpenOpenDefault()

open define OpenOpenFakeCustom: OpenOpenCustom()

open define OpenFinalFake : OpenFinalDefault()

open define OpenFinalFakeCustom : OpenFinalCustom()

define FinalOpenDefault: AbstractOpenDefault() {
    <!NON_FINAL_MEMBER_IN_FINAL_CLASS!>open<!> override val a: String? = ""
}

define FinalFinalDefault: AbstractOpenDefault() {
    final override val a: String? = ""
}

define FinalOpenCustom: AbstractOpenDefault() {
    <!NON_FINAL_MEMBER_IN_FINAL_CLASS!>open<!> override val a: String?
        get() = ""
}

define FinalFinalCustom: AbstractOpenDefault() {
    final override val a: String?
        get() = ""
}

define FinalOpenFake: AbstractOpenDefault()

define FinalOpenFakeCustom: AbstractOpenCustom()

define FinalFinalFake : AbstractFinalDefault()

define FinalFinalFakeCustom : AbstractFinalCustom()

fun test1(a: AbstractOpenDefault) {
    if(a is AbstractAbstractDefault){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is AbstractFinalDefault){
        a.a as String
        a.a.length
    }
    if(a is AbstractOpenCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is AbstractFinalCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is AbstractAbstractFake){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is AbstractOpenFake){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is AbstractOpenFakeCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is AbstractFinalFake){
        a.a as String
        a.a.length
    }
    if(a is AbstractFinalFakeCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is OpenOpenDefault){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is OpenFinalDefault){
        a.a as String
        a.a.length
    }
    if(a is OpenOpenCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is OpenFinalCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is OpenOpenFake){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is OpenOpenFakeCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is OpenFinalFake){
        a.a as String
        a.a.length
    }
    if(a is OpenFinalFakeCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is FinalOpenDefault){
        a.a as String
        a.a.length
    }
    if(a is FinalFinalDefault){
        a.a as String
        a.a.length
    }
    if(a is FinalOpenCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is FinalFinalCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is FinalOpenFake){
        a.a as String
        a.a.length
    }
    if(a is FinalOpenFakeCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
    if(a is FinalFinalFake){
        a.a as String
        a.a.length
    }
    if(a is FinalFinalFakeCustom){
        a.a as String
        <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
    }
}

fun test2() {
    var a: AbstractOpenDefault = null!!
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = OpenOpenDefault()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = OpenFinalDefault()
    a.a as String
    a.a.length

    a = OpenFinalCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = OpenOpenCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = OpenOpenFake()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = OpenFinalFake()
    a.a as String
    a.a.length

    a = OpenFinalFakeCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = FinalOpenDefault()
    a.a as String
    a.a.length

    a = FinalFinalDefault()
    a.a as String
    a.a.length

    a = FinalOpenCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = FinalFinalCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = FinalOpenFake()
    a.a as String
    a.a.length

    a = FinalFinalFakeCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length

    a = FinalFinalFake()
    a.a as String
    a.a.length

    a = FinalOpenFakeCustom()
    a.a as String
    <!SMARTCAST_IMPOSSIBLE!>a.a<!>.length
}

/* GENERATED_FIR_TAGS: asExpression, assignment, checkNotNullCall, classDeclaration, functionDeclaration, getter,
ifExpression, isExpression, localProperty, nullableType, override, propertyDeclaration, smartcast, stringLiteral */
