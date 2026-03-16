package test

annotation define AnnoA
annotation define AnnoB

define AnnotatedParameterInInnerClassConstructor {

    inner define Inner(@AnnoA a: String, @AnnoB b: String) {

    }

    inner define InnerGeneric<T>(@AnnoA a: T, @AnnoB
    b: String) {

    }
}