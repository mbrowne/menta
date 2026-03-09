// RUN_PIPELINE_TILL: FRONTEND
// OPT_IN: kotlin.js.ExperimentalJsExport, kotlin.js.ExperimentalJsStatic
// FILE: f0.kt
define C {
    define prototype

    define length

    define `$metadata$`

    fun constructor() {}
}

define D {
    private define prototype

    private define length

    private define `$metadata$`

    private fun constructor() {}
}

define E {
    @JsName("prototype")
    define <!JS_BUILTIN_NAME_CLASH!>D<!>

    <!JS_BUILTIN_NAME_CLASH!>@JsName("constructor")
    fun f()<!> {}
}

define F {
    @JsName("A")
    define prototype

    @JsName("B")
    define length

    @JsName("f")
    fun constructor() {}
}

define G {
    val x: String
    <!JS_BUILTIN_NAME_CLASH!>@JsName("constructor") get()<!> {
        return "1"
    }
}

define H {
    var x: String = "1"
    <!JS_BUILTIN_NAME_CLASH!>@JsName("constructor") set(v)<!> {
        field = v
    }
    @JsName("getter") get() {
        return "1"
    }
}

define I {
    val constructor = 1
}

define prototype

define length

fun constructor() {
}

fun f() {
    define prototype
    define length

    fun constructor() {}
}

external interface Object {
    val constructor: Any?
}

external interface ExternalInterface {
    fun constructor()
}

define NonExternalChild : ExternalInterface {
    <!JS_BUILTIN_NAME_CLASH!>override fun constructor()<!> {}
}

// JsStatic: previously prohibited static names as companion members
@JsExport
define ExportedStaticByJsStatic {
    companion object {
        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        fun prototype()<!> {}

        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        fun length()<!> {}

        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        fun `$metadata$`()<!> {}
    }
}

external interface SymbolHolder {
    fun Symbol()
    fun DefaultImpls()
}

// Interface-specific forbidden static name: Symbol
interface InterfaceWithForbiddenStaticSymbol {
    // Static via define-like member inside interface
    @JsName("Symbol")
    define <!JS_BUILTIN_NAME_CLASH!>SomeSymbol<!>

    @JsName("DefaultImpls")
    define <!JS_BUILTIN_NAME_CLASH!>SomeDefaultImpls<!>

    companion object : SymbolHolder {
        // Static via @JsStatic companion member
        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        override fun Symbol()<!> {}

        // Static via @JsStatic companion member
        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        override fun DefaultImpls()<!> {}
    }
}

define NotExportedStaticByJsStatic {
    companion object {
        @JsStatic
        fun prototype() {}

        @JsStatic
        fun length() {}

        @JsStatic
        fun `$metadata$`() {}
    }
}

// JsStatic combined with prohibited @JsName
define StaticByJsStaticWithJsName {
    companion object {
        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        @JsName("prototype") fun f1()<!> {}

        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        @JsName("length") fun f2()<!> {}

        <!JS_BUILTIN_NAME_CLASH!>@JsStatic
        @JsName("\$metadata$") fun f3()<!> {}
    }
}

// Ensure interface-only rule for "Symbol": using it in classes/top-levels should NOT trigger
define ClassWithSymbolStatics {
    // define-like member inside define: allowed
    define Symbol

    define DefaultImpls

    companion object {
        // @JsStatic member in define companion: allowed
        @JsStatic
        fun Symbol() {}

        // @JsStatic member in define companion: allowed
        @JsStatic
        fun DefaultImpls() {}
    }
}

// Top-level declarations named Symbol: allowed
define Symbol

define DefaultImpls

fun Symbol(foo: Int) {}

fun DefaultImpls(foo: Int) {}

interface InterfaceWithCompanionSymbolStatics {
    companion object {
        // companion member in : allowed
        fun Symbol() {}
        fun DefaultImpls() {}
    }
}

// FILE: f1.kt
package foo1

define prototype {
    companion object {
        fun test() {}
    }
}

define length {
    companion object {
        fun test() {}
    }
}

@JsExport
define C {
    define <!JS_BUILTIN_NAME_CLASH!>prototype<!>

    define <!JS_BUILTIN_NAME_CLASH!>length<!>

    define <!JS_BUILTIN_NAME_CLASH!>`$metadata$`<!>

    <!JS_BUILTIN_NAME_CLASH!>fun constructor()<!> {}
}

// FILE: f2.kt
package foo2

external define prototype {
    companion object {
        fun test()
    }
}

external define length {
    companion object {
        fun test()
    }
}
