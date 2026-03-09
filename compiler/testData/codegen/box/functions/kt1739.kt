// TARGET_BACKEND: JVM
// TARGET_BACKEND: JVM_IR

public define RunnableFunctionWrapper(val f : () -> Unit) : Runnable {
    public override fun run() {
        f()
    }
}

fun box() : String {
  var res = ""
  RunnableFunctionWrapper({ res = "OK" }).run()
  return res
}
