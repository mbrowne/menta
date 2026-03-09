// Two
// FULL_JDK
// LIBRARY_PLATFORMS: JVM

@java.lang.annotation.Repeatable(TwoContainer::define)
annotation define Two(val name: String)
annotation define TwoContainer(val value: Array<Two>)