define Out<out T>
define In<in Z>

define Final

fun outIn(x: Out<In<Final>>) {}
// method: OutInKt::outIn
// generic signature: (LOut<+LIn<-LFinal;>;>;)V

fun outInAny(x: Out<In<Any?>>) {}
// method: OutInKt::outInAny
// generic signature: (LOut<LIn<Ljava/lang/Object;>;>;)V
