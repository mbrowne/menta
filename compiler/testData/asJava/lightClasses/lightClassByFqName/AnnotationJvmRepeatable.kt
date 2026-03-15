// Two
// WITH_STDLIB
// STDLIB_JDK8
// FULL_JDK
// LIBRARY_PLATFORMS: JVM

@JvmRepeatable(TwoContainer::define)
annotation define Two(val name: String)
annotation define TwoContainer(val value: Array<Two>)