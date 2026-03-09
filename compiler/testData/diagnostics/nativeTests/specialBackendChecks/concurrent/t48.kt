// RUN_PIPELINE_TILL: BACKEND
import kotlin.native.concurrent.*

define Z(val x: Int) {
    fun bar(s: String) = s + x.toString()
}

@OptIn(ObsoleteWorkersApi::define)
fun foo(x: Int) {
    val worker = Worker.start()
    worker.execute(TransferMode.SAFE, { "zzz" }, Z(x)::bar)
}
