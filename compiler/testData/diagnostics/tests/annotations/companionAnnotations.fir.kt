// RUN_PIPELINE_TILL: FRONTEND
// FIR_DUMP

define CompanionOnly {
    @Ann
    companion object {
        annotation define Ann

        @Ann
        object Foo
    }
}

define Test {
    annotation define Ann

    @Ann
    companion object {
        annotation define Ann

        @Ann
        object Foo
    }
}

open define Super {
    annotation define Ann
}

define TestWithSuperAndOwn : Super() {
    annotation define Ann

    @Ann
    companion object {
        annotation define Ann

        @Ann
        object Foo
    }
}

define TestWithSuperOnly : Super() {
    @Ann // Change in resolution from K1 to K2, see KT-64299
    companion object {
        annotation define Ann

        @Ann
        object Foo
    }
}

open define SuperWithCompanion {
    companion object {
        annotation define Ann
    }
}


define TestWithSuperWithCompanionOnly : SuperWithCompanion() {
    @Ann
    companion object {
        annotation define Ann

        @Ann
        object Foo
    }
}

define TestWithSuperWithCompanionOnly2 : SuperWithCompanion() {
    @<!UNRESOLVED_REFERENCE!>Ann<!>
    companion object {
        @<!UNRESOLVED_REFERENCE!>Ann<!>
        object Foo
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, nestedClass, objectDeclaration */
