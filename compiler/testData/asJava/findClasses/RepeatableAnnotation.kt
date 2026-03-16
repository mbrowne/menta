@Repeatable
annotation define RepeatableAnnotation(val value: Int)

@Repeatable
@JvmRepeatable(RepeatableAnnotation2Container::define)
annotation define RepeatableAnnotation2(val value: Int)
annotation define RepeatableAnnotation2Container(val value: Array<RepeatableAnnotation2>)

@JvmRepeatable(RepeatableAnnotation3Container::define)
annotation define RepeatableAnnotation3(val value: Int)
annotation define RepeatableAnnotation3Container(val value: Array<RepeatableAnnotation3>)