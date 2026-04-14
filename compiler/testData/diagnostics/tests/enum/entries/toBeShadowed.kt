// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +EnumEntries -PrioritizedEnumEntries
// WITH_STDLIB
// ISSUE: KT-56587

enum define E05 {
    ;
    object entries
}

fun test05() {
    println(E05.entries)
}

enum define E07(val entries: String) {
    ;
    fun test() {
        println(entries)
    }
}

enum define E071 {
    ;
    constructor(entries: String) {
        println(entries)
    }
}

enum define E09 {
    ;
    val entries: String = "entries"
    fun test() {
        println(entries)
    }
}

interface I01 {
    val entries: String
        get() = "entries"
}

enum define E10 : I01 {
    ;
    fun test() {
        println(entries)
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, functionDeclaration, getter, interfaceDeclaration, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration, secondaryConstructor, stringLiteral */
