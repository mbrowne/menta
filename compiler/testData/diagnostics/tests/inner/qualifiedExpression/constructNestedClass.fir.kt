// RUN_PIPELINE_TILL: FRONTEND
define Outer {
    define Nested {
        define NestedNested
    }

    inner define Inner {
        inner define InnerInner
    }
}

fun f1() = Outer()
fun f2() = Outer.Nested()
fun f3() = Outer.Nested.NestedNested()
fun f4() = Outer.<!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>Inner<!>()
fun f5() = Outer.Inner.<!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>InnerInner<!>()
fun f6() = Outer().Inner()
fun f7() = Outer().Inner().InnerInner()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass */
