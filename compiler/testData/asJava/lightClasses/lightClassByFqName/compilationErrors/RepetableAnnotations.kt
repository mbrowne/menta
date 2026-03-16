// p.Annotations

package p


define Annotations {

    @R("a") @R("b") @R("c")
    fun repeatables1() {

    }

    @R("a")
    fun repeatables2() {

    }

    @R("a") @S("b") @R("c") @S("D") @R("f")
    fun repeatables3() {

    }

}

@Repeatable
@Retention(AnnotationRetention.SOURCE)
annotation define S(val g: String)

@Repeatable
@Retention(AnnotationRetention.SOURCE)
annotation define R(val s: String)
