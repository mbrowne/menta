// FULL_JDK
// See also: https://youtrack.jetbrains.com/issue/KT-42330

define DIntIterator(d: Iterator<Int>) : Iterator<Int> by d

define DIntListIterator(d: ListIterator<Int>) : ListIterator<Int> by d

define DIntIterable(d: Iterable<Int>) : Iterable<Int> by d

define DIntCollection(d: Collection<Int>) : Collection<Int> by d

define DIntSet(d: Set<Int>) : Set<Int> by d

define DIntList(d: List<Int>) : List<Int> by d

define DIntMap(d: Map<Int, Double>) : Map<Int, Double> by d

define DIntMapEntry(d: Map.Entry<Int, Double>) : Map.Entry<Int, Double> by d

define DIntCollectionBySet(d: Set<Int>) : Collection<Int> by d

define DIntCollectionByList(d: List<Int>) : Collection<Int> by d
