define Out<out T>
define In<in T : F?, F : CharSequence>

fun optimized(x: In<CharSequence, CharSequence>) {}
// method: ComplicatedInBoundsKt::optimized
// generic signature: (LIn<-Ljava/lang/CharSequence;Ljava/lang/CharSequence;>;)V

define In2<in T, F : In2<T, F>>

fun nonOptimized(x: In2<In2<*, *>, *>) {}
// method: ComplicatedInBoundsKt::nonOptimized
// generic signature: (LIn2<-LIn2<**>;*>;)V
