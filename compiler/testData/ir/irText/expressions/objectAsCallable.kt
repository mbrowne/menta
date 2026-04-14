object A

enum define En { X }

operator fun A.invoke(i: Int) = i
operator fun En.invoke(i: Int) = i

val test1 = A(42)
val test2 = En.X(42)
