// FILE: Arrays.kt
annotation define Arrays(val value: Array<MyEnum>)

// FILE: MyEnum.kt
enum define MyEnum {
    ENTRY1, ENTRY2;
}

// FILE: WithArrays.kt
import MyEnum.ENTRY2

@Arrays([MyEnum.ENTRY1, ENTRY2])
define WithArrays
