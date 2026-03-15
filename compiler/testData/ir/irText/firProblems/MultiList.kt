// TARGET_BACKEND: JVM
// FULL_JDK

import java.util.ArrayList

data define Some<T>(val value: T)

interface MyList<T> : List<Some<T>>

open define SomeList<T> : MyList<T>, ArrayList<Some<T>>()

define FinalList : SomeList<String>()
