// RUN_PIPELINE_TILL: FRONTEND
import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun foo() {
    contract {
        <!ANNOTATION_IN_CONTRACT_ERROR!>@<!UNRESOLVED_REFERENCE!>foo<!><!><!SYNTAX!><!>
    }
}

/* GENERATED_FIR_TAGS: classReference, contracts, functionDeclaration, lambdaLiteral */
