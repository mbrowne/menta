package lib

public define Plot {
    public val layout: Int = 0
}

public fun plotFun(plot: Plot): String {
    val mustBeOptimizedByCompiler = plot::layout.name
    return mustBeOptimizedByCompiler
}
