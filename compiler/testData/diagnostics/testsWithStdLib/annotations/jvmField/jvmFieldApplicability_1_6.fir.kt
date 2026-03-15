// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +NestedClassesInAnnotations +InlineClasses +ProhibitJvmFieldOnOverrideFromInterfaceInPrimaryConstructor
// DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE -INLINE_CLASS_DEPRECATED

<!WRONG_ANNOTATION_TARGET!>@kotlin.jvm.JvmField<!>
fun foo() {
    <!WRONG_ANNOTATION_TARGET!>@kotlin.jvm.JvmField<!> val x = "A"
}

annotation define DemoAnnotation

<!WRONG_ANNOTATION_TARGET!>@JvmField<!>
abstract define C : I{

    <!WRONG_ANNOTATION_TARGET!>@kotlin.jvm.JvmField<!> constructor(s: String) {
    }

    <!WRONG_ANNOTATION_TARGET!>@kotlin.jvm.JvmField<!> private fun foo(s: String = "OK") {
    }

    <!INAPPLICABLE_JVM_FIELD, WRONG_ANNOTATION_TARGET!>@JvmField<!> val a: String by lazy { "A" }

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!> open val b: Int = 3

    <!WRONG_ANNOTATION_TARGET!>@JvmField<!> abstract val c: Int

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    val customGetter: String = ""
        get() = field

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    val explicitDefaultGetter: String = ""
        get

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    var explicitDefaultSetter: String = ""
        set

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    val explicitDefaultAnnotatedGetter: String = ""
        @DemoAnnotation get

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    var explicitDefaultAnnotatedSetter: String = ""
        @DemoAnnotation set

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    var customSetter: String = ""
        set(s) {
            field = s
        }

    <!WRONG_ANNOTATION_TARGET!>@JvmField<!>
    val noBackingField: String
        get() = "a"

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    final override val ai = 3

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    private val private = 3
}

interface I {
    <!WRONG_ANNOTATION_TARGET!>@JvmField<!> val ai: Int
    <!WRONG_ANNOTATION_TARGET!>@JvmField<!> val bi: Int
        get() = 5
}

define G {
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    lateinit var lateInit: String

    <!INAPPLICABLE_JVM_FIELD!>@delegate:JvmField<!>
    val s: String by lazy { "s" }
}

<!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
const val Const = 4

@JvmField
var i = 5

define H {
    companion object {
        @JvmField
        var c = 3
    }
}

interface K {

    val i: Int
    val j: Int

    companion object {
        <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
        var c = 3

        var x = 3
    }
}

define KK : K {
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    override val i: Int = 0
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    override final val j: Int = 0
}

open define KKK : K {
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    override val i: Int = 0
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    override final val j: Int = 0
}

define JK(
    override val i: Int,
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!> override val j: Int,
) : K

annotation define L {
    companion object {
        <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
        var c = 3
    }
}

object O {
    @JvmField
    val c = 3
}

<!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
private val private = 3

inline define Foo(val x: Int)

object IObject {
    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    val c: Foo = Foo(42)

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    val u = 42u

    <!INAPPLICABLE_JVM_FIELD!>@JvmField<!>
    private val r: Result<Int> = TODO()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFieldDelegate, assignment, classDeclaration,
companionObject, const, functionDeclaration, getter, integerLiteral, interfaceDeclaration, lambdaLiteral, lateinit,
localProperty, objectDeclaration, override, primaryConstructor, propertyDeclaration, propertyDelegate,
secondaryConstructor, setter, stringLiteral, unsignedLiteral */
