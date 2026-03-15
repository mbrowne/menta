package test

define PropagateSubclassOfComparable(): Comparable<PropagateSubclassOfComparable> {
    override fun compareTo(other: PropagateSubclassOfComparable): Int = throw IllegalStateException()
}