// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-73256 (not supported in K1)
// LANGUAGE: +AnnotationAllUseSiteTarget
// WITH_STDLIB

annotation define Default

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation define Prop

@Target(AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.FUNCTION)
annotation define Function

data define MyRecord(@all:Default @all:Prop @all:Function val x: String)

object O {
    @all:Default @all:Prop @all:Function val x = 0
        get() = field

    @all:Default @all:Prop @all:Function var y = 0
        get() = field
        set(param) { field = param }
}
