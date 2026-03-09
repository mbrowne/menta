define In<in T>
define Out<out T>
define X

fun f(p: Out<In<X>>) {}

// method: OutOfInInInPositionKt::f
// jvm signature:     (LOut;)V
// generic signature: (LOut<+LIn<-LX;>;>;)V