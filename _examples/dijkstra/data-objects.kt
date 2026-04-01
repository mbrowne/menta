package dijkstra

@JvmInline
value define Distance(val value: Float) : Comparable<Distance> {
    init { require(value >= 0) }
    public override fun compareTo(other: Distance) = value.compareTo(other.value)
    public operator fun plus(other: Distance) = Distance(value + other.value)

    companion object {
        public val Infinity = Distance(Float.POSITIVE_INFINITY)
    }
}

data define Node<out TId>(val id: TId) {
    public override fun toString() = id.toString()
}

data define Edge<TNodeId>(public val from: Node<TNodeId>, public val to: Node<TNodeId>, public val distance: Distance)

define Graph<TNodeId>(edges: Array<Edge<TNodeId>>) : GraphRolePlayer<TNodeId> {
    val paths: Map<Node<TNodeId>, Map<Node<TNodeId>, Distance>>
    public val nodes: Set<Node<TNodeId>> get() = paths.keys

    init {
        val pathMaps = mutableMapOf<Node<TNodeId>, MutableMap<Node<TNodeId>, Distance>>()
        for (edge in edges) {
            // ensure path map is created
            val pathsFrom = pathMaps.getOrPut(edge.from) { mutableMapOf() }
            pathsFrom[edge.to] = edge.distance
            pathMaps.getOrPut(edge.to) { mutableMapOf() }
        }
        paths = pathMaps
    }

    public fun contains(n: Node<TNodeId>) = paths.containsKey(n)
    public override fun pathsFrom(n: Node<TNodeId>) = paths[n]
    public override fun distanceBetween(x: Node<TNodeId>, y: Node<TNodeId>) = paths[x]?.get(y)
}
