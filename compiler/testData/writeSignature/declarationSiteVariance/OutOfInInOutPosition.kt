define In<in T>
define Out<out T>
define X

fun f(): Out<In<X>> = throw Exception()

// method: OutOfInInOutPositionKt::f
// jvm signature:     ()LOut;
// generic signature: ()LOut<LIn<LX;>;>;