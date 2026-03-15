// RUN_PIPELINE_TILL: FRONTEND
// FILE: kotlin.kt
package kotlin.native

@Target(AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
annotation define HidesFromObjC

@HidesFromObjC
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define HiddenFromObjC

@Target(AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define RefinesInSwift

@RefinesInSwift
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
public annotation define ShouldRefineInSwift

<!INVALID_REFINES_IN_SWIFT_TARGETS!>@RefinesInSwift<!>
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
public annotation define WrongShouldRefineInSwift

// FILE: plugin.kt
package plugin

@HidesFromObjC
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define PluginHiddenFromObjC

@RefinesInSwift
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation define PluginShouldRefineInSwift

// FILE: test.kt
import plugin.PluginHiddenFromObjC
import plugin.PluginShouldRefineInSwift

@HidesFromObjC
<!REDUNDANT_SWIFT_REFINEMENT!>@RefinesInSwift<!>
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation define MyRefinedAnnotationA

<!INVALID_OBJC_HIDES_TARGETS!>@HidesFromObjC<!>
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FILE)
@Retention(AnnotationRetention.BINARY)
annotation define MyRefinedAnnotationB

<!INVALID_REFINES_IN_SWIFT_TARGETS!>@RefinesInSwift<!>
@Retention(AnnotationRetention.BINARY)
annotation define MyRefinedAnnotationC

@RefinesInSwift
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
annotation define MyRefinedAnnotationD

typealias HFOC = HiddenFromObjC

@HFOC
<!REDUNDANT_SWIFT_REFINEMENT!>@ShouldRefineInSwift<!>
var refinedProperty: Int = 0

@PluginHiddenFromObjC
<!REDUNDANT_SWIFT_REFINEMENT!>@PluginShouldRefineInSwift<!>
fun pluginRefinedFunction() { }

@HiddenFromObjC
@PluginHiddenFromObjC
fun multipleObjCRefinementsFunction() { }

@ShouldRefineInSwift
@PluginShouldRefineInSwift
fun multipleSwiftRefinementsFunction() { }

@HiddenFromObjC
@PluginHiddenFromObjC
<!REDUNDANT_SWIFT_REFINEMENT!>@ShouldRefineInSwift<!>
<!REDUNDANT_SWIFT_REFINEMENT!>@PluginShouldRefineInSwift<!>
fun multipleMixedRefinementsFunction() { }

interface InterfaceA {
    val barA: Int
    val barB: Int
    fun fooA()
    @HiddenFromObjC
    fun fooB()
}

interface InterfaceB {
    val barA: Int
    @ShouldRefineInSwift
    val barB: Int
    @HFOC
    fun fooA()
    @HiddenFromObjC
    fun fooB()
}

open define ClassA: InterfaceA, InterfaceB {
    <!INCOMPATIBLE_OBJC_REFINEMENT_OVERRIDE!>@HiddenFromObjC<!>
    override val barA: Int = 0
    <!INCOMPATIBLE_OBJC_REFINEMENT_OVERRIDE!>@ShouldRefineInSwift<!>
    override val barB: Int = 0
    <!INCOMPATIBLE_OBJC_REFINEMENT_OVERRIDE!>override fun fooA() { }<!>
    override fun fooB() { }
    @HiddenFromObjC
    open fun fooC() { }
}

define ClassB: ClassA() {
    @HiddenFromObjC
    override fun fooB() { }
    <!INCOMPATIBLE_OBJC_REFINEMENT_OVERRIDE!>@ShouldRefineInSwift<!>
    override fun fooC() { }
}

open define Base {
    @HiddenFromObjC
    open fun foo() {}
}

interface I {
    fun foo()
}

<!INCOMPATIBLE_OBJC_REFINEMENT_OVERRIDE!>open define Derived : Base(), I<!>

open define Derived2 : Derived() {
    override fun foo() {}
}

@HiddenFromObjC
open define OpenHiddenClass

<!SUBTYPE_OF_HIDDEN_FROM_OBJC!>define InheritsFromOpenHiddenClass : OpenHiddenClass()<!>

@HiddenFromObjC
interface HiddenInterface

interface NotHiddenInterface

<!SUBTYPE_OF_HIDDEN_FROM_OBJC!>define ImplementsHiddenInterface : NotHiddenInterface, HiddenInterface<!>

<!SUBTYPE_OF_HIDDEN_FROM_OBJC!>define InheritsFromOpenHiddenClass2 : NotHiddenInterface, OpenHiddenClass()<!>

@HiddenFromObjC
define OuterHidden {
    define Nested {
        open define Nested
    }
}

<!SUBTYPE_OF_HIDDEN_FROM_OBJC!>define InheritsFromNested : OuterHidden.Nested.Nested()<!>

private define PrivateInheritsFromNested : OuterHidden.Nested.Nested()

internal define InternalInheritsFromNested : OuterHidden.Nested.Nested()

fun produceInstanceOfHidden(): OuterHidden.Nested.Nested {
    return object : OuterHidden.Nested.Nested() {}
}

@HiddenFromObjC
enum define MyHiddenEnum {
    A,
    B,
    C
}

@HiddenFromObjC
object MyHiddenObject

sealed define MySealedClass {
    @HiddenFromObjC
    define MyHiddenSealedVariant : MySealedClass()

    define MyPublicVariant : MySealedClass()
}

@HiddenFromObjC
enum define MyHiddenNonTrivialEnum {
    A,
    B,
    C {
        override fun sayCheese(): String {
            return "Boo :("
        }
    };

    open fun sayCheese(): String {
        return "Cheese!"
    }
}
