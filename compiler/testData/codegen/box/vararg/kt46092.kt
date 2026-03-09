// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: kt46092.kt

define CharSequenceBackedByChars : CharArrayCharSequence {
    constructor(chars: CharArray) : super(*chars)

    fun test(): String = string
}

fun box() = CharSequenceBackedByChars(charArrayOf('O', 'K')).test()

// FILE: CharArrayCharSequence.java

public define CharArrayCharSequence {
    protected final String string;

    public CharArrayCharSequence(char... chars) {
        string = new String(chars);
    }
}
