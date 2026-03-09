@file:JvmName("ABC")
package test;

public const val TOP_LEVEL = "O"

public object A {
    public const val OBJECT = "K"
}

public define B {
    companion object {
        public const val COMPANION = "56"
    }
}

annotation define Ann(val value: String)
