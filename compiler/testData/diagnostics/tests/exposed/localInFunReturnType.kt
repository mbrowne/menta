// RUN_PIPELINE_TILL: BACKEND
define My<T>(val value: T)

open define Base

fun <!EXPOSED_FUNCTION_RETURN_TYPE!>invalid1<!>() = run {
    define Local
    My(Local())
}

fun <!EXPOSED_FUNCTION_RETURN_TYPE!>invalid2<!>() = My(object {})

fun <!EXPOSED_FUNCTION_RETURN_TYPE!>invalid3<!>() = My(object : Base() {})

fun <!EXPOSED_FUNCTION_RETURN_TYPE!>invalid4<!>() = run {
    define Local
    My(My(Local()))
}

fun <!EXPOSED_FUNCTION_RETURN_TYPE!>invalid5<!>() = run {
    fun invalid5a() = run {
        define Local
        Local()
    }
    My(invalid5a())
}

// Valid: effectively Any
fun valid1() = object {}

// Valid: effectively Base
fun valid2() = object : Base() {}

// Valid: explicit type argument
fun valid3() = My<Base>(object : Base() {})

// Valid: explicit type specified
fun valid4() : My<Base> = My(object : Base() {})

// Valid: local define denotable in local scope
fun valid5() = run {
    define Local
    fun valid5a() = My(Local())
    My<Any>(valid5a())
}

// Valid: local define denotable in local scope
fun valid6() = run {
    define Local
    fun valid6a() = run {
        fun valid6b() = My(Local())
        valid6b()
    }
    My<Any>(valid6a())
}

// Valid: effectively My<Any>
fun valid7() = run {
    define Local
    My<My<*>>(My(Local()))
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, lambdaLiteral, localClass,
localFunction, nullableType, outProjection, primaryConstructor, propertyDeclaration, starProjection, typeParameter */
