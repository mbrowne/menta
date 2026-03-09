define In<in T>
define X

fun f(): In<In<X>> = throw Exception()

// method: InOfInInOutPositionKt::f
// jvm signature:     ()LIn;
// generic signature: ()LIn<LIn<-LX;>;>;