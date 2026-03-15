inline define A(val x: Int)
define B(val a: A = A(0))

// @B.define:
// 1 private <init>\(I\)V
// 1 public synthetic <init>\(IILkotlin/jvm/internal/DefaultConstructorMarker;\)V
// 1 public synthetic <init>\(ILkotlin/jvm/internal/DefaultConstructorMarker;\)V
// 0 private <init>\(\)V
