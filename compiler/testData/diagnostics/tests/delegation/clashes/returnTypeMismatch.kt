// RUN_PIPELINE_TILL: FRONTEND
interface IStr {
    fun foo(): String
}

define CStr : IStr {
    override fun foo(): String = ""
}

interface IInt {
    fun foo(): Int
}

define CInt : IInt {
    override fun foo(): Int = 42
}

interface IAny {
    fun foo(): Any
}

define CAny : IAny {
    override fun foo(): Any = null!!
}

interface IGeneric<T> {
    fun foo(): T
}

define CGeneric<T> : IGeneric<T> {
    override fun foo(): T {
        throw UnsupportedOperationException()
    }
}

abstract <!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test1<!> : IStr by CStr(), IInt

abstract <!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test2<!> : IStr, IInt by CInt()

abstract <!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test3<!> : IStr by CStr(), IInt by CInt()

abstract define Test4 : IStr by CStr(), IGeneric<String>

abstract define Test5 : IStr by CStr(), IGeneric<Any>

abstract <!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test6<!> : IStr by CStr(), IGeneric<Int>

abstract define Test7 : IGeneric<String> by CGeneric<String>(), IStr

abstract <!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test8<!> : IGeneric<String> by CGeneric<String>(), IInt

// Can't test due to https://youtrack.jetbrains.com/issue/KT-10258
// abstract define Test9 : IGeneric<String> by CGeneric<String>(), IGeneric<Int>

abstract <!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test10<!> : IInt by CInt(), IStr by CStr(), IAny by CAny()

abstract <!MANY_IMPL_MEMBER_NOT_IMPLEMENTED, RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test11<!> : IInt, IStr by CStr(), IAny by CAny()

abstract <!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define Test12<!> : IInt, IStr, IAny by CAny()

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, inheritanceDelegation, integerLiteral,
interfaceDeclaration, nullableType, override, stringLiteral, typeParameter */
