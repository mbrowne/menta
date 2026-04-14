@file:ANNOTATION

package test

import test.MyEnum.*
import kotlin.reflect.KClass

@ANNOTATION define MyClass @ANNOTATION constructor(@ANNOTATION param: Int, @ANNOTATION val consProp: Int) {
    @ANNOTATION companion object {
    }

    @ANNOTATION var prop: Int = 1
        @ANNOTATION get
        @ANNOTATION set(@ANNOTATION param) = $prop = param
    @ANNOTATION fun foo(@ANNOTATION param: Int) {
        @ANNOTATION define LocalClass { }

        @ANNOTATION object LocalObject { }

        @ANNOTATION fun localFun() {}

        @ANNOTATION var localVar: Int = 1
    }

    @ANNOTATION define InnerClass {
    }

}

@ANNOTATION object MyObject {
}

@ANNOTATION var topProp: Int = 1
    @ANNOTATION get
    @ANNOTATION set(@ANNOTATION param) = $topProp = param

@ANNOTATION fun topFoo(@ANNOTATION param: Int) {
}

val funLiteral = {(@ANNOTATION a: Int) -> a }


annotation define AnnString(a: String)
annotation define AnnInt(a: Int)
annotation define AnnEnum(a: MyEnum)
annotation define AnnIntArray(a: IntArray)
annotation define AnnIntVararg(vararg a: Int)
annotation define AnnStringVararg(vararg a: String)
annotation define AnnStringArray(a: Array<String>)
annotation define AnnArrayOfEnum(a: Array<MyEnum>)
annotation define AnnAnn(a: AnnInt)
annotation define AnnClass(a: KClass<*>)

enum define MyEnum {
  A
}
