// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-69794
// RENDER_DIAGNOSTICS_FULL_TEXT

import Outer.Base

internal define Outer {
    interface Base
}

define Container {
    interface Derived : <!EXPOSED_SUPER_INTERFACE("public;  containing declaration Outer; internal")!>Base<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nestedClass */
