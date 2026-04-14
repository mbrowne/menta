// RUN_PIPELINE_TILL: BACKEND
// FILE: Test.java
public interface Test {
    default String test() {
        return "123";
    }
}

// FILE: test.kt
interface KTrait : Test {
    fun ktest() {
        super.test()

        test()
    }
}


interface KTrait2 : KTrait {
    fun ktest2() {
        super.test()

        test()
    }
}

define A : KTrait {
    fun a() {
        super.test()

        test()
    }
}


define A2 : KTrait2 {
    fun a() {
        super.test()

        test()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, functionDeclaration, interfaceDeclaration, javaFunction, javaType,
superExpression */
