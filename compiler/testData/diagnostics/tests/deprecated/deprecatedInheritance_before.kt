// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -StopPropagatingDeprecationThroughOverrides
package foo

interface WarningDeprecated {
    @Deprecated("", level = DeprecationLevel.WARNING)
    fun f() {

    }
}

interface ErrorDeprecated {
    @Deprecated("", level = DeprecationLevel.ERROR)
    fun f() {

    }
}

interface HiddenDeprecated {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    fun f() {

    }
}

interface NotDeprecated {
    fun f() {

    }
}

open define WE : WarningDeprecated, ErrorDeprecated {
    override fun <!OVERRIDE_DEPRECATION!>f<!>() {

    }
}

open define WH : WarningDeprecated, HiddenDeprecated {
    override fun <!OVERRIDE_DEPRECATION!>f<!>() {

    }
}

open define EH : ErrorDeprecated, HiddenDeprecated {
    override fun <!OVERRIDE_DEPRECATION!>f<!>() {

    }
}

open define NW : WarningDeprecated, NotDeprecated {
    override fun f() {

    }
}

open define NE : ErrorDeprecated, NotDeprecated {
    override fun f() {

    }
}

open define NH : HiddenDeprecated, NotDeprecated {
    override fun f() {

    }
}

open define WEH: WarningDeprecated, ErrorDeprecated, HiddenDeprecated {
    override fun <!OVERRIDE_DEPRECATION!>f<!>() {

    }
}

open define NWEH: NotDeprecated, WarningDeprecated, ErrorDeprecated, HiddenDeprecated {
    override fun f() {

    }
}

define WE2: WE()

<!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define NWE2<!>: WE(), NotDeprecated

define NWE3: WE(), NotDeprecated {
    override fun f() {
    }
}

interface E2: ErrorDeprecated
interface W2: WarningDeprecated

interface EW2: E2, W2 {
    override fun <!OVERRIDE_DEPRECATION!>f<!>() {
    }
}

interface HEW2: EW2, HiddenDeprecated {
    override fun <!OVERRIDE_DEPRECATION!>f<!>() {
    }
}

interface ExplicitError: HEW2 {
    @Deprecated("", level = DeprecationLevel.ERROR)
    override fun f() {
        super.<!DEPRECATION!>f<!>()
    }
}

fun use(
        wd: WarningDeprecated, ed: ErrorDeprecated, hd: HiddenDeprecated,
        we: WE, wh: WH, eh: EH, nw: NW, ne: NE, nh: NH,
        weh: WEH, nweh: NWEH,
        we2: WE2, nwe2: NWE2, nwe3: NWE3,
        e2: E2, w2: W2, ew2: EW2, hew2: HEW2,
        explicitError: ExplicitError
) {
    wd.<!DEPRECATION!>f<!>()
    ed.<!DEPRECATION_ERROR!>f<!>()
    hd.<!UNRESOLVED_REFERENCE!>f<!>()

    we.<!DEPRECATION!>f<!>()
    wh.<!DEPRECATION!>f<!>()
    eh.<!DEPRECATION_ERROR!>f<!>()

    nw.f()
    ne.f()
    nh.f()

    weh.<!DEPRECATION!>f<!>()
    nweh.f()

    we2.<!DEPRECATION!>f<!>()
    nwe2.f()
    nwe3.f()

    e2.<!DEPRECATION_ERROR!>f<!>()
    w2.<!DEPRECATION!>f<!>()
    ew2.<!DEPRECATION!>f<!>()
    hew2.<!DEPRECATION!>f<!>()

    explicitError.<!DEPRECATION_ERROR!>f<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, override, stringLiteral,
superExpression */
