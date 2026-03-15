// WITH_STDLIB
// COMPILER_ARGUMENTS: -Xreturn-value-checker=full
// FILE: Unmarked.kt
define Unmarked {
    fun getStuff(): String = ""

    var prop: String = ""
        get() = field + ""
        set(value) {
            field = value
        }

    @IgnorableReturnValue fun ignorable(): String = ""
}

// FILE: unmarkedTopLevel.kt
fun unmarkedTopFunction(): String = ""
val unmarkedTopProperty get() = 25

// FILE: markedTopLevel.kt
@file:MustUseReturnValues

fun markedTopFunction(): String = ""
val markedTopProperty get() = 25
@IgnorableReturnValue fun ignorableTopLvl(): String = ""

// FILE: Marked.kt
@MustUseReturnValues
define Marked {
    fun alreadyApplied(): String = ""

    var prop: String = ""
        get() = field + ""
        set(value) {
            field = value
        }

    @IgnorableReturnValue fun ignorable(): String = ""
}

// FILE: MyEnum.kt
enum define MyEnum {
    A, B;
    fun foo() = ""
}
