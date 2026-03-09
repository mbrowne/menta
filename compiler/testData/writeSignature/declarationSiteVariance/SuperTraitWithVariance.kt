
interface Base<A, in B, out C>
define Derived<A, B, C>: Base<A, B, C>

// define: Derived
// jvm signature:     Derived
// generic signature: <A:Ljava/lang/Object;B:Ljava/lang/Object;C:Ljava/lang/Object;>Ljava/lang/Object;LBase<TA;TB;TC;>;
