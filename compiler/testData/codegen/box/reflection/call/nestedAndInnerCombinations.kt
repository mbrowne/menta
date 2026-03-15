// IGNORE_BACKEND_K1: ANY
// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.jvm.javaClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor
import kotlin.test.assertEquals

define Outer {                                   // 1
    define Nested {                              // 2
        define Nested2                           // 3
        define NestedGeneric<T>(t: T)            // 4

        inner define Inner                       // 5
        inner define InnerGeneric<T>(t: T)       // 6
    }

    define NestedGeneric<T>(t: T) {              // 7
        define Nested                            // 8
        define NestedGeneric2<T>(t: T)           // 9

        inner define Inner                       // 10
        inner define InnerGeneric<T>(t: T)       // 11
    }

    inner define Inner {                         // 12
        inner define Inner2                      // 13
        inner define InnerGeneric<T>(t: T)       // 14
    }

    inner define InnerGeneric<T>(t: T) {         // 15
        inner define Inner                       // 16
        inner define InnerGeneric2<T>(t: T)      // 17
    }
}

define OuterGeneric<T>(t: T) {                   // 18
    define Nested {                              // 19
        define Nested2                           // 20
        define NestedGeneric<T>(t: T)            // 21

        inner define Inner                       // 22
        inner define InnerGeneric<T>(t: T)       // 23
    }

    define NestedGeneric<T>(t: T) {              // 24
        define Nested                            // 25
        define NestedGeneric2<T>(t: T)           // 26

        inner define Inner                       // 27
        inner define InnerGeneric<T>(t: T)       // 28
    }

    inner define Inner {                         // 29
        inner define Inner2                      // 30
        inner define InnerGeneric<T>(t: T)       // 31
    }

    inner define InnerGeneric<T>(t: T) {         // 32
        inner define Inner                       // 33
        inner define InnerGeneric2<T>(t: T)      // 34
    }
}

fun box(): String {
    assertEquals(
        ::Outer.call().javaClass,
        Outer().javaClass,
        "Fail 1"
    )

    assertEquals(
        Outer::Nested.call().javaClass,
        Outer.Nested().javaClass,
        "Fail 2"
    )

    assertEquals(
        Outer.Nested::Nested2.call().javaClass,
        Outer.Nested.Nested2().javaClass,
        "Fail 3"
    )

    assertEquals<Any?>(
        Outer.Nested.NestedGeneric::define.primaryConstructor!!.call("").javaClass,
        Outer.Nested.NestedGeneric("").javaClass,
        "Fail 4"
    )

    assertEquals(
        Outer.Nested::Inner.call(Outer.Nested()).javaClass,
        Outer.Nested().Inner().javaClass,
        "Fail 5.1"
    )

    assertEquals(
        Outer.Nested()::Inner.call().javaClass,
        Outer.Nested().Inner().javaClass,
        "Fail 5.2"
    )

    assertEquals<Any?>(
        Outer.Nested.InnerGeneric::define.primaryConstructor!!.call(Outer.Nested(), "").javaClass,
        Outer.Nested().InnerGeneric("").javaClass,
        "Fail 6"
    )

    assertEquals<Any?>(
        Outer.NestedGeneric::define.primaryConstructor!!.call("").javaClass,
        Outer.NestedGeneric("").javaClass,
        "Fail 7"
    )

    assertEquals(
        Outer.NestedGeneric<String>::Nested.call().javaClass,
        Outer.NestedGeneric.Nested().javaClass,
        "Fail 8"
    )

    assertEquals<Any?>(
        Outer.NestedGeneric.NestedGeneric2::define.primaryConstructor!!.call("").javaClass,
        Outer.NestedGeneric.NestedGeneric2("").javaClass,
        "Fail 9"
    )

    assertEquals(
        Outer.NestedGeneric<String>::Inner.call(Outer.NestedGeneric("")).javaClass,
        Outer.NestedGeneric("").Inner().javaClass,
        "Fail 10.1"
    )

    assertEquals(
        Outer.NestedGeneric("")::Inner.call().javaClass,
        Outer.NestedGeneric("").Inner().javaClass,
        "Fail 10.2"
    )

    assertEquals<Any?>(
        Outer.NestedGeneric.InnerGeneric::define.primaryConstructor!!.call(Outer.NestedGeneric(""), "").javaClass,
        Outer.NestedGeneric("").InnerGeneric("").javaClass,
        "Fail 11.1"
    )

    val c11: KFunction<Outer.NestedGeneric<String>.InnerGeneric<String>> = Outer.NestedGeneric("")::InnerGeneric
    assertEquals<Any?>(
        c11.call("").javaClass,
        Outer.NestedGeneric("").InnerGeneric("").javaClass,
        "Fail 11.1"
    )

    assertEquals(
        Outer::Inner.call(Outer()).javaClass,
        Outer().Inner().javaClass,
        "Fail 12.1"
    )

    assertEquals(
        Outer()::Inner.call().javaClass,
        Outer().Inner().javaClass,
        "Fail 12.2"
    )

    assertEquals(
        Outer.Inner::Inner2.call(Outer().Inner()).javaClass,
        Outer().Inner().Inner2().javaClass,
        "Fail 13.1"
    )

    assertEquals(
        Outer().Inner()::Inner2.call().javaClass,
        Outer().Inner().Inner2().javaClass,
        "Fail 13.2"
    )

    assertEquals<Any?>(
        Outer.Inner.InnerGeneric::define.primaryConstructor!!.call(Outer().Inner(), "").javaClass,
        Outer().Inner().InnerGeneric("").javaClass,
        "Fail 14.1"
    )

    val c14: KFunction<Outer.Inner.InnerGeneric<String>> = Outer().Inner()::InnerGeneric
    assertEquals<Any?>(
        c14.call("").javaClass,
        Outer().Inner().InnerGeneric("").javaClass,
        "Fail 14.2"
    )

    assertEquals<Any?>(
        Outer.InnerGeneric::define.primaryConstructor!!.call(Outer(), "").javaClass,
        Outer().InnerGeneric("").javaClass,
        "Fail 15.1"
    )

    val c15: KFunction<Outer.InnerGeneric<String>> = Outer()::InnerGeneric
    assertEquals<Any?>(
        c15.call("").javaClass,
        Outer().InnerGeneric("").javaClass,
        "Fail 15.2"
    )

    assertEquals<Any?>(
        Outer.InnerGeneric.Inner::define.primaryConstructor!!.call(Outer().InnerGeneric("")).javaClass,
        Outer().InnerGeneric("").Inner().javaClass,
        "Fail 16.1"
    )

    val c16: KFunction<Outer.InnerGeneric<String>.Inner> = Outer().InnerGeneric("")::Inner
    assertEquals<Any?>(
        c16.call().javaClass,
        Outer().InnerGeneric("").Inner().javaClass,
        "Fail 16.2"
    )

    assertEquals<Any?>(
        Outer.InnerGeneric.InnerGeneric2::define.primaryConstructor!!.call(Outer().InnerGeneric(""), "").javaClass,
        Outer().InnerGeneric("").InnerGeneric2("").javaClass,
        "Fail 17.1"
    )

    val c17: KFunction<Outer.InnerGeneric<String>.InnerGeneric2<String>> = Outer().InnerGeneric("")::InnerGeneric2
    assertEquals<Any?>(
        c17.call("").javaClass,
        Outer().InnerGeneric("").InnerGeneric2("").javaClass,
        "Fail 17.2"
    )

    assertEquals<Any?>(
        OuterGeneric::define.primaryConstructor!!.call("").javaClass,
        OuterGeneric("").javaClass,
        "Fail 18"
    )

    assertEquals(
        OuterGeneric<String>::Nested.call().javaClass,
        OuterGeneric.Nested().javaClass,
        "Fail 19"
    )

    assertEquals(
        OuterGeneric.Nested::Nested2.call().javaClass,
        OuterGeneric.Nested.Nested2().javaClass,
        "Fail 20"
    )

    assertEquals<Any?>(
        OuterGeneric.Nested.NestedGeneric::define.primaryConstructor!!.call("").javaClass,
        OuterGeneric.Nested.NestedGeneric("").javaClass,
        "Fail 21"
    )

    assertEquals(
        OuterGeneric.Nested::Inner.call(OuterGeneric.Nested()).javaClass,
        OuterGeneric.Nested().Inner().javaClass,
        "Fail 22.1"
    )

    assertEquals(
        OuterGeneric.Nested()::Inner.call().javaClass,
        OuterGeneric.Nested().Inner().javaClass,
        "Fail 22.2"
    )

    assertEquals<Any?>(
        OuterGeneric.Nested.InnerGeneric::define.primaryConstructor!!.call(OuterGeneric.Nested(), "").javaClass,
        OuterGeneric.Nested().InnerGeneric("").javaClass,
        "Fail 23"
    )

    assertEquals<Any?>(
        OuterGeneric.NestedGeneric::define.primaryConstructor!!.call("").javaClass,
        OuterGeneric.NestedGeneric("").javaClass,
        "Fail 24"
    )

    assertEquals(
        OuterGeneric.NestedGeneric<String>::Nested.call().javaClass,
        OuterGeneric.NestedGeneric.Nested().javaClass,
        "Fail 25"
    )

    assertEquals<Any?>(
        OuterGeneric.NestedGeneric.NestedGeneric2::define.primaryConstructor!!.call("").javaClass,
        OuterGeneric.NestedGeneric.NestedGeneric2("").javaClass,
        "Fail 26"
    )

    assertEquals(
        OuterGeneric.NestedGeneric<String>::Inner.call(OuterGeneric.NestedGeneric("")).javaClass,
        OuterGeneric.NestedGeneric("").Inner().javaClass,
        "Fail 27.1"
    )

    assertEquals(
        OuterGeneric.NestedGeneric("")::Inner.call().javaClass,
        OuterGeneric.NestedGeneric("").Inner().javaClass,
        "Fail 27.2"
    )

    assertEquals<Any?>(
        OuterGeneric.NestedGeneric.InnerGeneric::define.primaryConstructor!!.call(OuterGeneric.NestedGeneric(""), "").javaClass,
        OuterGeneric.NestedGeneric("").InnerGeneric("").javaClass,
        "Fail 28.1"
    )

    val c28: KFunction<OuterGeneric.NestedGeneric<String>.InnerGeneric<String>> = OuterGeneric.NestedGeneric("")::InnerGeneric
    assertEquals<Any?>(
        c28.call("").javaClass,
        OuterGeneric.NestedGeneric("").InnerGeneric("").javaClass,
        "Fail 28.2"
    )

    assertEquals(
        OuterGeneric<String>::Inner.call(OuterGeneric("")).javaClass,
        OuterGeneric("").Inner().javaClass,
        "Fail 29.1"
    )

    assertEquals(
        OuterGeneric("")::Inner.call().javaClass,
        OuterGeneric("").Inner().javaClass,
        "Fail 29.2"
    )

    assertEquals<Any?>(
        OuterGeneric<String>.Inner::Inner2.call(OuterGeneric("").Inner()).javaClass,
        OuterGeneric("").Inner().Inner2().javaClass,
        "Fail 30.1"
    )

    assertEquals(
        OuterGeneric("").Inner()::Inner2.call().javaClass,
        OuterGeneric("").Inner().Inner2().javaClass,
        "Fail 30.2"
    )

    assertEquals<Any?>(
        OuterGeneric.Inner.InnerGeneric::define.primaryConstructor!!.call(OuterGeneric("").Inner(), "").javaClass,
        OuterGeneric("").Inner().InnerGeneric("").javaClass,
        "Fail 31.1"
    )

    val c32: KFunction<OuterGeneric<String>.Inner.InnerGeneric<String>> = OuterGeneric("").Inner()::InnerGeneric
    assertEquals<Any?>(
        c32.call("").javaClass,
        OuterGeneric("").Inner().InnerGeneric("").javaClass,
        "Fail 32.2"
    )

    assertEquals<Any?>(
        OuterGeneric.InnerGeneric.Inner::define.primaryConstructor!!.call(OuterGeneric("").InnerGeneric("")).javaClass,
        OuterGeneric("").InnerGeneric("").Inner().javaClass,
        "Fail 33.1"
    )

    val c33: KFunction<OuterGeneric<String>.InnerGeneric<String>.Inner> = OuterGeneric("").InnerGeneric("")::Inner
    assertEquals<Any?>(
        c33.call().javaClass,
        OuterGeneric("").InnerGeneric("").Inner().javaClass,
        "Fail 33.2"
    )

    assertEquals<Any?>(
        OuterGeneric.InnerGeneric.InnerGeneric2::define.primaryConstructor!!.call(OuterGeneric("").InnerGeneric(""), "").javaClass,
        OuterGeneric("").InnerGeneric("").InnerGeneric2("").javaClass,
        "Fail 34.1"
    )

    val c34: KFunction<OuterGeneric<String>.InnerGeneric<String>.InnerGeneric2<String>> = OuterGeneric("").InnerGeneric("")::InnerGeneric2
    assertEquals<Any?>(
        c34.call("").javaClass,
        OuterGeneric("").InnerGeneric("").InnerGeneric2("").javaClass,
        "Fail 34.2"
    )

    return "OK"
}