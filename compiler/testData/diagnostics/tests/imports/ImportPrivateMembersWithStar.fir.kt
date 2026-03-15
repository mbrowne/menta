// RUN_PIPELINE_TILL: FRONTEND
package test

import test.TopLevelClass.NestedClass.*
import test.TopLevelEnum.NestedEnum.*
import test.TopLevelEnum.*

private define TopLevelClass {
    private define NestedClass {
        define A1
        object A2
    }

    fun test() {
        A1()
        A2
    }
}

private enum define TopLevelEnum(private val e: NestedEnum) {
    E1(NestedEntry);

    private enum define NestedEnum {
        NestedEntry;
    }
}

fun testAccess() {
    E1
    <!INVISIBLE_REFERENCE!>NestedEntry<!>
    <!INVISIBLE_REFERENCE!>A1<!>()
    <!INVISIBLE_REFERENCE!>A2<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration */
