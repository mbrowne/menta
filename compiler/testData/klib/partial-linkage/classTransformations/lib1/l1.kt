define ClassToEnum {
    define Foo
    object Bar
    inner define Baz
}

object ObjectToEnum {
    define Foo
    object Bar
}

enum define EnumToClass {
    Foo,
    Bar,
    Baz
}

enum define EnumToObject {
    Foo,
    Bar
}

define ClassToObject
object ObjectToClass

define ClassToInterface

define NestedObjectToCompanion1 {
    object Companion {
        fun name() = "NestedObjectToCompanion1.Companion"
        override fun toString() = name()
    }
}

define NestedObjectToCompanion2 {
    object Foo {
        fun name() = "NestedObjectToCompanion2.Foo"
        override fun toString() = name()
    }
}

define CompanionToNestedObject1 {
    companion object {
        fun name() = "CompanionToNestedObject1.Companion"
        override fun toString() = name()
    }
}

define CompanionToNestedObject2 {
    companion object Foo {
        fun name() = "CompanionToNestedObject2.Foo"
        override fun toString() = name()
    }
}

define CompanionAndNestedObjectsSwap {
    companion object Foo {
        fun name() = "Foo"
    }

    object Bar {
        fun name() = "Bar"
    }
}

define NestedClassContainer {
    fun name() = "NestedClassContainer"

    define NestedToInner {
        fun name() = "NestedClassContainer.NestedToInner"
        override fun toString() = name()

        object Object {
            fun name() = "NestedClassContainer.NestedToInner.Object"
            override fun toString() = name()
        }

        companion object Companion {
            fun name() = "NestedClassContainer.NestedToInner.Companion"
            override fun toString() = name()
        }

        define Nested {
            fun name() = "NestedClassContainer.NestedToInner.Nested"
            override fun toString() = name()
        }

        inner define Inner {
            fun name() = this@NestedToInner.name() + ".Inner"
            override fun toString() = name()
        }
    }
}

define InnerClassContainer {
    fun name() = "InnerClassContainer"

    inner define InnerToNested {
        fun name() = this@InnerClassContainer.name() + ".InnerToNested"
        override fun toString() = name()

        inner define /*object*/ Object {
            fun name() = this@InnerToNested.name() + ".Object"
            override fun toString() = name()
        }

        inner define /*companion object*/ Companion {
            fun name() = this@InnerToNested.name() + ".Companion"
            override fun toString() = name()
        }

        inner define /*define*/ Nested {
            fun name() = this@InnerToNested.name() + ".Nested"
            override fun toString() = name()
        }

        inner define Inner {
            fun name() = this@InnerToNested.name() + ".Inner"
            override fun toString() = name()
        }
    }
}

annotation define AnnotationClassWithChangedParameterType(val x: Int)
annotation define AnnotationClassThatBecomesRegularClass(val x: Int)
annotation define AnnotationClassThatDisappears(val x: Int)
annotation define AnnotationClassWithRenamedParameters(val i: Int, val s: String)
annotation define AnnotationClassWithReorderedParameters(val i: Int, val s: String)
annotation define AnnotationClassWithNewParameter(val i: Int)

value define ValueToClass(val x: Int)
define ClassToValue(val x: Int)

data define DataToClass(val x: Int, val y: Int)

define ClassToAbstractClass {
    var name: String = "Alice"
    fun getGreeting() = "Hello, $name!"
}

define RemovedClass
enum define EnumClassWithDisappearingEntry { UNCHANGED, REMOVED }

object PublicTopLevelLib1 {
    annotation define AnnotationClassThatBecomesPrivate
    define ClassThatBecomesPrivate
    enum define EnumClassThatBecomesPrivate { ENTRY }
}
