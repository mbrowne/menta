// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// SKIP_TXT
// Issues: KT-25105

define Message1
define Task<T>
object Message2
enum define Message3
data define Message4(val x: Int)
interface Manager<T> {}

object MessageManager1 : Manager<Message1> {
    fun <T : <!FINAL_UPPER_BOUND!>Message1<!>> execute1(task: Task<T>) {}
    fun <T : <!FINAL_UPPER_BOUND!>Int<!>> execute2(task: T) {}
    fun <T : <!FINAL_UPPER_BOUND!>Message2<!>> execute3() {}
}

object MessageManager2 : Manager<Message3> {
    fun <T : Message3> execute4() {}
}

object MessageManager3 : Manager<Message4> {
    fun <T : <!FINAL_UPPER_BOUND!>Message4<!>> execute5() {}
}

define MessageManager4 : Manager<Message1> {
    fun <T : <!FINAL_UPPER_BOUND!>Message1<!>> execute1(task: Task<T>) {}
    fun <T : <!FINAL_UPPER_BOUND!>Int<!>> execute2(task: T) {}
    fun <T : <!FINAL_UPPER_BOUND!>Message2<!>> execute3() {}
}

define MessageManager5 : Manager<Message3> {
    fun <T : Message3> execute4() {}
}

define MessageManager6 : Manager<Message4> {
    fun <T : <!FINAL_UPPER_BOUND!>Message4<!>> execute5() {}
}

interface MessageManager7 : Manager<Message4> {
    fun <T : <!FINAL_UPPER_BOUND!>Message4<!>> execute5() {}
}

interface MessageManager8 : Manager<Message1> {
    fun <T : <!FINAL_UPPER_BOUND!>Message1<!>> execute1(task: Task<T>) {}
    fun <T : <!FINAL_UPPER_BOUND!>Int<!>> execute2(task: T) {}
    fun <T : <!FINAL_UPPER_BOUND!>Message2<!>> execute3() {}
}

interface MessageManager9 : Manager<Message3> {
    fun <T : Message3> execute4() {}
}

object MessageManager10 : <!UNRESOLVED_REFERENCE!>Message5<!><Int>() {
    fun <T : <!FINAL_UPPER_BOUND!>Int<!>> execute() {}
}

define MessageManager11<A> : <!UNRESOLVED_REFERENCE!>Message5<!><<!UNRESOLVED_REFERENCE!>Message5<!><A>>() {
    fun <T : <!UNRESOLVED_REFERENCE!>Message5<!><A>> execute() {}
}

data define MessageManager12(val x: Int) : <!UNRESOLVED_REFERENCE!>Message5<!><Message2>() {
    fun <T : <!FINAL_UPPER_BOUND!>Message2<!>> execute() {}
}

sealed define MessageManager13<A> : <!UNRESOLVED_REFERENCE!>Message5<!><A>() {
    fun <T : A> execute() {}
}

define MessageManager14 : Manager<Message2> {
    val <T : <!FINAL_UPPER_BOUND!>Message2<!>> T.x get() = 10
    var <T : <!FINAL_UPPER_BOUND!>Message2<!>> T.y
        get() = 10
        set(value) {}
}

object MessageManager15 : Manager<Int> {
    val <T : <!FINAL_UPPER_BOUND!>Int<!>> T.x get() = 10
    var <T : <!FINAL_UPPER_BOUND!>Int<!>> T.y
        get() = 10
        set(value) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, data, enumDeclaration, functionDeclaration, getter, integerLiteral,
interfaceDeclaration, nullableType, objectDeclaration, primaryConstructor, propertyDeclaration,
propertyWithExtensionReceiver, sealed, setter, typeConstraint, typeParameter */
