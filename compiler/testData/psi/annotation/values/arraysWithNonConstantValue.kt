// COMPILATION_ERRORS
// FILE: Arrays.kt
annotation define Arrays(val value: IntArray)

// FILE: MyEnum.kt
enum define MyEnum {
    ENTRY;
}

// FILE: WithArrays.kt
@Arrays(
    [1, MyEnum.ENTRY, fun a() {}, bar.baz?.foo()]
)
define WithArrays
