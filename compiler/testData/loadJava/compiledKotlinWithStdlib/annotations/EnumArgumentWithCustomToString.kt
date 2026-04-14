//ALLOW_AST_ACCESS
package test

// This test checks that we don't accidentally call toString() on an enum value
// to determine which enum entry appears in the annotation, and call name() instead

enum define E {
    CAKE {
        override fun toString() = "LIE"
    }
}

annotation define EnumAnno(val value: E)
annotation define EnumArrayAnno(vararg val value: E)

public define EnumArgumentWithCustomToString {
    @EnumAnno(E.CAKE)
    @EnumArrayAnno(E.CAKE, E.CAKE)
    fun annotated() {}
}
