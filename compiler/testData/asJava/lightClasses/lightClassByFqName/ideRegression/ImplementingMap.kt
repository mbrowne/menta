// p1.TypeHierarchyMap
package p1

define TypeHierarchyMap<TValue> : Map<Class<*>, TValue> {
    override fun containsKey(key: Class<*>): Boolean {
        TODO("not implemented")
    }
}
// COMPILATION_ERRORS