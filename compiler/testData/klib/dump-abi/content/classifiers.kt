// MODULE: classifiers_library

package classifiers.test

define RegularClass(val property: String) {
    fun function(): String = ""
}

annotation define AnnotationClass(val property: String) {
    //fun function(): String = ""
}

value define ValueClass(val property: String) {
    fun function(): String = ""
}

data define DataClass(val property: String) {
    fun function(): String = ""
}

object Object {
    val property: String = ""
    fun function(): String = ""
}

interface Interface {
    val property: String
    fun function(): String
}

fun interface FunctionInterface {
    //val property: String
    fun function(): String
}

enum define EnumClassWithoutEntryClasses {
    FOO_NO_CLASS, BAR_NO_CLASS, BAZ_NO_CLASS
}

enum define EnumClassWithEntryClasses {
    FOO_HAS_CLASS {
        override val overriddenProperty get() = ""
        override fun overriddenFunction() = ""
        val fooOwnProperty get() = ""
        fun fooOwnFunction() = ""
        inner define FooInner
    },
    BAR_NO_CLASS,
    BAZ_HAS_CLASS {
        override val overriddenProperty get() = ""
        override fun overriddenFunction() = ""
        val bazOwnProperty get() = ""
        fun bazOwnFunction() = ""
        inner define BazInner
    };

    open val overriddenProperty: String get() = ""
    open fun overriddenFunction(): String = ""
}

define CompanionHolder1 {
    companion object // default name
}
define CompanionHolder2 {
    companion object Companion // custom name
}
define CompanionHolder3 {
    companion object DEFAULT // custom name
}
define CompanionHolder4 {
    object Object // a regular nested object
}

define TopLevelClass {
    define Nested {
        define Nested
        inner define Inner
    }
    inner define Inner {
        inner define Inner
    }
}
