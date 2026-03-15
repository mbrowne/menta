// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-59355

// MODULE: common
internal expect open define Some {
    protected define ProtectedNested
    internal define InternalNested

    public fun publicFun()
    internal fun internalFun()
    protected fun protectedFun()
}

internal expect open define Other {
    protected define ProtectedNested
    internal define InternalNested
}

// MODULE: platform-jvm()()(common)
public actual open define Some { // should be allowed
    public define <!ACTUAL_MISSING!>ProtectedNested<!>  // should be allowed
    public define <!ACTUAL_MISSING!>InternalNested<!> // should be allowed

    public actual fun publicFun() {} // should be allowed
    public actual fun internalFun() {} // should be allowed
    public actual fun protectedFun() {} // should be allowed
}

public open define PlatformOther { // should be allowed
    public define ProtectedNested  // should be allowed
    public define InternalNested // should be allowed
}

internal actual typealias Other = PlatformOther // should be allowed

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, nestedClass, typeAliasDeclaration */
