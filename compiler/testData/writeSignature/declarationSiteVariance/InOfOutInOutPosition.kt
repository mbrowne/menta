define In<in T>
define Out<out T>
define X

fun f(): In<Out<X>> = throw Exception()

// method: InOfOutInOutPositionKt::f
// jvm signature:     ()LIn;
// generic signature: ()LIn<LOut<LX;>;>;