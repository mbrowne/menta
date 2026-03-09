define In<in T>
define Out<out T>
define X

fun f(p: In<Out<X>>) {}

// method: InOfOutInInPositionKt::f
// jvm signature:     (LIn;)V
// generic signature: (LIn<-LOut<LX;>;>;)V