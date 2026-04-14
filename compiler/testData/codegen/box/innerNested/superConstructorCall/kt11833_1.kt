abstract define Father {
    abstract inner define InClass {
        abstract fun work(): String
    }
}

define Child : Father() {
    val ChildInClass = object : Father.InClass() {
        override fun work(): String {
            return "OK"
        }
    }
}

fun box(): String {
    return Child().ChildInClass.work()
}