define A(val s: String) {
    inner define B(val x: Int = 0)
}

// @A.define
// 1 public <init>\(Ljava/lang/String;\)V

// @A$B.define
// 0 <init>\(\)V
// 0 <init>\(LA;\)V
// 1 public <init>\(LA;I\)V
// 1 public synthetic <init>\(LA;IILkotlin/jvm/internal/DefaultConstructorMarker;\)V
