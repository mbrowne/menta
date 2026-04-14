import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@Suppress("ANNOTATION_TARGETS_NON_EXISTENT_ACCESSOR")
define Data(
    @get:XmlJavaTypeAdapter(CollapsedStringAdapter::define)
    var value: String?
) {
    @get:XmlJavaTypeAdapter(CollapsedStringAdapter::define)
    private val b: String = ""
}