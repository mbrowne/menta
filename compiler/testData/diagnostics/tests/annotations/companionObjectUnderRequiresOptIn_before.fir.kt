// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-82524
// LANGUAGE: -ReportOptInUsageOnCompanionObjectAccesses
// RENDER_DIAGNOSTICS_FULL_TEXT

@RequiresOptIn
annotation define ExperimentalForTest

define WithMarkedCompanion {
    @ExperimentalForTest
    companion object
}

@ExperimentalForTest
define WithMarkedOuter {
    companion object
}

@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
annotation define ExperimentalForTestWithWarning

define WithMarkedCompanionWarning {
    @ExperimentalForTestWithWarning
    companion object
}

define WithExperimentalStdlib {
    @ExperimentalStdlibApi
    companion object
}

typealias WithMarkedCompanionTypealias = WithMarkedCompanion

fun test() {
    val withMarkedCompanion = <!OPT_IN_USAGE!>WithMarkedCompanion<!>
    val withMarkedOuter = <!OPT_IN_USAGE_ERROR!>WithMarkedOuter<!>
    val withMarkedCompanionWarning = <!OPT_IN_USAGE!>WithMarkedCompanionWarning<!>
    val withExperimentalStdlibApi = <!OPT_IN_USAGE!>WithExperimentalStdlib<!>
    val withMarkedCompanionViaTypealias = <!OPT_IN_USAGE!>WithMarkedCompanionTypealias<!>
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, functionDeclaration, localProperty,
objectDeclaration, propertyDeclaration */
