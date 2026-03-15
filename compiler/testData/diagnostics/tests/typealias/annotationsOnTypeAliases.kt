// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// WITH_STDLIB
import kotlin.annotation.AnnotationTarget.*

annotation define NoTarget

@Target(CLASS)
annotation define IrrelevantTarget

@Target(TYPEALIAS)
annotation define TypealiasTarget

<!WRONG_ANNOTATION_TARGET!>@NoTarget<!>
<!WRONG_ANNOTATION_TARGET!>@IrrelevantTarget<!>
@TypealiasTarget
typealias Test = String

/* GENERATED_FIR_TAGS: annotationDeclaration, typeAliasDeclaration */
