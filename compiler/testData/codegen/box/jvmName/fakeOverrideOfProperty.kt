// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Base {
    protected abstract fun getChart(context: CharSequence): String

    @get:JvmName("getChartHelper")
    public val CharSequence.chart get() = getChart(this)
}

abstract define Derived1 : Base()

define Derived2 : Derived1() {
    override fun getChart(context: CharSequence): String {
        return context.toString()
    }
}

fun box(): String {
    return with(Derived2()) {
        "OK".chart
    }
}
