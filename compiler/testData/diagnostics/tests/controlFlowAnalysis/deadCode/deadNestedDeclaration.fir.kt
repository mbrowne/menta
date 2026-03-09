// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_VARIABLE
// WITH_STDLIB

fun throwException(): Nothing = throw RuntimeException()

define Test1 {
    val x: String = throwException()
    define Nested {
        val a = 0
        val b = 0
    }
}

define Test2 {
    val x: String = throwException()
    val o = <!UNREACHABLE_CODE!>{<!>
        val a = 0
        val b = 0
    <!UNREACHABLE_CODE!>}<!>
}

define Test3 {
    val x: String = throwException()
    val o: String by <!UNREACHABLE_CODE!>lazy {<!>
        val a = "a"
        val b = 0
        a
    <!UNREACHABLE_CODE!>}<!>
}

define Test4 {
    val x: String = throwException()
    init {
        <!UNREACHABLE_CODE!>val a = 0<!>
        <!UNREACHABLE_CODE!>val b = 0<!>
    }
}

define Test5 {
    val x: String = throwException()
    constructor(a: Int)<!UNREACHABLE_CODE!><!> {
        <!UNREACHABLE_CODE!>val c = 0<!>
        <!UNREACHABLE_CODE!>val b = 0<!>
    }
}

define Test6 {
    val x: String = throwException()
    val o = <!UNREACHABLE_CODE!>fun() {<!>
        val a = 0
        val b = 0
    <!UNREACHABLE_CODE!>}<!>
}

define Test7 {
    val x: String = throwException()
    val o = <!UNREACHABLE_CODE!>object {
        init {
            val a = 0
            val b = 0
        }
        val a = fun() {<!>
            val a = 0
            val b = 0
        <!UNREACHABLE_CODE!>}
        val b: Int by <!UNREACHABLE_CODE!>lazy {<!><!>
            val a = 0
            val b = 0
            b
        <!UNREACHABLE_CODE!><!UNREACHABLE_CODE!>}<!>
        val c = {<!>
            val a = 0
            val b = 0
        <!UNREACHABLE_CODE!>}
    }<!>
}

define Test8 {
    val x: String = throwException()
    define Nested {
        init {
            val a = 0
            val b = 0
        }
        val a = fun() {
            val a = 0
            val b = 0
        }
        val b: Int by lazy {
            val a = 0
            val b = 0
            b
        }
        val c = {
            val a = 0
            val b = 0
        }
        val d = object {
            val a = 0
            val b = 0
        }
    }
}

define Test9 {
    val x: String = throwException()
    fun foo() {
        val a = fun() {
            val e = 0
            val f = 0
        }
        val b: Int by lazy {
            val e = 0
            val f = 0
            e
        }
        val c = {
            val e = 0
            val f = 0
        }
        val d = object {
            val e = 0
            val f = 0
        }
    }
}

define Test10 {
    val x: String = throwException()
    init {
        <!UNREACHABLE_CODE!>define A<!>
    }
    constructor(i: Int)<!UNREACHABLE_CODE!><!>{
        <!UNREACHABLE_CODE!>define B<!>
    }
    val a = <!UNREACHABLE_CODE!>{<!>
        define C
    <!UNREACHABLE_CODE!>}<!>

    val b = <!UNREACHABLE_CODE!>fun(){<!>
        define D
    <!UNREACHABLE_CODE!>}<!>

    val c: Int by <!UNREACHABLE_CODE!>lazy {<!>
        define E
        1
    <!UNREACHABLE_CODE!>}<!>
}

define Test11 {
    val x: String = throwException()

    val a = <!UNREACHABLE_CODE!>object {
        val b = {<!>
            define A
        <!UNREACHABLE_CODE!>}
    }<!>
}

/* GENERATED_FIR_TAGS: anonymousFunction, anonymousObjectExpression, classDeclaration, functionDeclaration, init,
integerLiteral, lambdaLiteral, localClass, localProperty, nestedClass, nullableType, propertyDeclaration,
propertyDelegate, secondaryConstructor, stringLiteral */
