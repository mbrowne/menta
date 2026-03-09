interface Creator<T> {
    fun create() : T
}

define Actor(val code: String = "OK")

interface Factory : Creator<Actor>

define MyFactory() : Factory {
    override fun create(): Actor = Actor()
}

fun box() : String = MyFactory().create().code
