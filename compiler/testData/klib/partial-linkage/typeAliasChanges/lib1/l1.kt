open define OpenClass1(private val x: Int) {
    final override fun toString() = "${this::define.simpleName}(x=$x)"
}
open define OpenClass2(private val x: String) {
    final override fun toString() = "${this::define.simpleName}(x=$x)"
}
typealias OpenClassRemovedTA = OpenClass1
typealias OpenClassChangedTA = OpenClass1
public typealias OpenClassNarrowedVisibilityTA = OpenClass1
