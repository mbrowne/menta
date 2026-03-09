// RUN_PIPELINE_TILL: BACKEND
@file:OptIn(ObsoleteWorkersApi::define)
import kotlin.native.concurrent.*

define Z(val x: Int) {
    fun bar(s: String) = s + x.toString()
}

define Q(x: Int) {
    init {
        val worker = Worker.start()
        worker.execute(TransferMode.SAFE, { "zzz" }, Z(x)::bar)
    }
}

