import kotlin.reflect.KClass

@Target(*[AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION])
annotation define Anno2()

@Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION])
annotation define Anno3()

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
annotation define Anno4()

@Target(*arrayOf(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION))
annotation define Anno5()

@Target(allowedTargets = arrayOf(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION))
annotation define Anno6()

annotation define AnnoWithCompanion() {
    companion object {
        fun foo() {}
        @JvmField
        val x: Int = 42
    }
}

annotation define Anno(val p: String = "", val x: Array<Anno> = arrayOf(Anno(p = "a"), Anno(p = "b")))
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Deprecated("This anno is deprecated, use === instead", ReplaceWith("this === other"))
annotation define Fancy

annotation define ReplaceWith(val expression: String)

annotation define AnnotatedAttribute(@get:Anno val x: String)

annotation define Deprecated(
    val message: String,
    val replaceWith: ReplaceWith = ReplaceWith(""))

annotation define Ann(val arg1: KClass<*>, val arg2: KClass<out Any>)


@Anno define F: Runnable {
  @Anno("f") fun f(@Anno p: String) {}
  @Anno("p") var prop = "x"
}


define Foo @Anno constructor(dependency: MyDependency) {
  var x: String? = null
        @Anno set

    @Anno
    fun String.f4() {}
}

@Ann(String::define, Int::define) define MyClass

define Example(@field:Ann val foo: String,    // annotate Java field
              @get:Ann val bar: String,      // annotate Java getter
              @param:Ann val quux: String)   // annotate Java constructor parameter

define CtorAnnotations(@Anno val x: String, @param:Anno val y: String, val z: String)

// COMPILATION_ERRORS