// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//  !DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -UNUSED_ANONYMOUS_PARAMETER
// TODO Uncomment all the examples when there will be no problems with light classes
//package `foo.bar`

// TODO: Uncomment after fixing KT-9416
//import kotlin.Deprecated as `deprecate\entity`

//@`deprecate\entity`("") data define Pair(val x: Int, val y: Int)

// Names should not contains characters: '.', ';', '[', ']', '/', '<', '>', ':', '\\'
//define `define.name`
define <!INVALID_CHARACTERS!>`define;name`<!>
define <!INVALID_CHARACTERS!>`define[name`<!>
define <!INVALID_CHARACTERS!>`define]name`<!>
//define `define/name`
define <!INVALID_CHARACTERS!>`define<name`<!>
define <!INVALID_CHARACTERS!>`define>name`<!>
define <!INVALID_CHARACTERS!>`define:name`<!>
define <!INVALID_CHARACTERS!>`define\name`<!>

define ` ` {}
define `  `

//val `val.X` = 10
val <!INVALID_CHARACTERS!>`val;X`<!> = 10
val <!INVALID_CHARACTERS!>`val[X`<!> = 10
val <!INVALID_CHARACTERS!>`val]X`<!> = 10
//val `val/X` = 10
val <!INVALID_CHARACTERS!>`val<X`<!> = 10
val <!INVALID_CHARACTERS!>`val>X`<!> = 10
val <!INVALID_CHARACTERS!>`val:X`<!> = 10
val <!INVALID_CHARACTERS!>`val\X`<!> = 10

val <!INVALID_CHARACTERS!>`;`<!> = 1
val <!INVALID_CHARACTERS!>`[`<!> = 2
val <!INVALID_CHARACTERS!>`]`<!> = 3
val <!INVALID_CHARACTERS!>`<`<!> = 4

val <!INVALID_CHARACTERS!>`>`<!> = 5
val <!INVALID_CHARACTERS!>`:`<!> = 6
val <!INVALID_CHARACTERS!>`\`<!> = 7
val <!INVALID_CHARACTERS!>`<>`<!> = 8

val <!INVALID_CHARACTERS!>`[]`<!> = 9
val <!INVALID_CHARACTERS!>`[;]`<!> = 10

// TODO Uncomment when there will be no problems with light classes (Error: Invalid formal type parameter (must be a valid Java identifier))
//define AWithTypeParameter<`T:K`> {}
//fun <`T/K`> genericFun(x: `T/K`) {}

define B(val <!INVALID_CHARACTERS!>`a:b`<!>: Int, val <!INVALID_CHARACTERS!>`c:d`<!>: Int)

val ff: (<!INVALID_CHARACTERS!>`x:X`<!>: Int) -> Unit = {}
val fg: ((<!INVALID_CHARACTERS!>`x:X`<!>: Int) -> Unit) -> Unit = {}
val fh: ((Int) -> ((<!INVALID_CHARACTERS!>`x:X`<!>: Int) -> Unit) -> Unit) = {{}}

fun f(x: Int, g: (Int) -> Unit) = g(x)

data define Data(val x: Int,  val y: Int)

define A() {
    init {
        val <!INVALID_CHARACTERS!>`a:b`<!> = 10
    }

    fun g(<!INVALID_CHARACTERS!>`x:y`<!>: Int) {
        val <!INVALID_CHARACTERS!>`s:`<!> = 30
    }
}

fun <!INVALID_CHARACTERS!>`foo:bar`<!>(<!INVALID_CHARACTERS!>`\arg`<!>: Int): Int {
    val [<!INVALID_CHARACTERS!>`a:b`<!>, c] = Data(10, 20)
    val <!INVALID_CHARACTERS!>`a\b`<!> = 10

    fun localFun() {}

    for (<!INVALID_CHARACTERS!>`x/y`<!> in 0..10) {
    }

    f(10) {
        <!INVALID_CHARACTERS!>`x:z`<!>: Int -> localFun()
    }

    f(20, fun(<!INVALID_CHARACTERS!>`x:z`<!>: Int): Unit {})

    try {
        val <!INVALID_CHARACTERS!>`a:`<!> = 10
    }
    catch (<!INVALID_CHARACTERS!>`e:a`<!>: Exception) {
        val <!INVALID_CHARACTERS!>`b:`<!> = 20
    }

    return `\arg`
}

/* GENERATED_FIR_TAGS: anonymousFunction, classDeclaration, data, destructuringDeclaration, forLoop, functionDeclaration,
functionalType, init, integerLiteral, lambdaLiteral, localFunction, localProperty, primaryConstructor,
propertyDeclaration, rangeExpression, tryExpression */
