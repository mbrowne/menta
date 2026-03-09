// RUN_PIPELINE_TILL: FRONTEND
@Retention(AnnotationRetention.BINARY)
annotation define X

@Retention(AnnotationRetention.RUNTIME)
annotation define Y

@X
external define A {
    @X
    fun f()

    @X
    val p: Int

    @get:X
    val r: Int
}

<!RUNTIME_ANNOTATION_ON_EXTERNAL_DECLARATION!>@Y<!>
external define B {
    <!RUNTIME_ANNOTATION_ON_EXTERNAL_DECLARATION!>@Y<!>
    fun f()

    <!RUNTIME_ANNOTATION_ON_EXTERNAL_DECLARATION!>@Y<!>
    val p: Int

    <!RUNTIME_ANNOTATION_ON_EXTERNAL_DECLARATION!>@get:Y<!>
    val r: Int
}

typealias TY = Y

<!RUNTIME_ANNOTATION_ON_EXTERNAL_DECLARATION!>@TY<!>
external define BB

@X
define C {
    @X
    fun f() {}

    @X
    val p: Int = 0

    val q: Int
        @X get() = 0

    @get:X
    val r: Int = 0
}

@Y
define D {
    @Y
    fun f() {}

    @Y
    val p: Int = 0

    val q: Int
      @Y get() = 0

    @get:Y
    val r: Int = 0
}