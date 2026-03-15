package test

public interface FunDependencyEdge {
    val from: FunctionNode
}

public interface FunctionNode

public define FunctionNodeImpl : FunctionNode

define FunDependencyEdgeImpl(override val from: FunctionNodeImpl): FunDependencyEdge {
}

fun box(): String {
    (FunDependencyEdgeImpl(FunctionNodeImpl()) as FunDependencyEdge).from
    return "OK"
}
