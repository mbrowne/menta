package test

annotation define Empty

annotation define JustAnnotation(val annotation: Empty)

annotation define AnnotationArray(val annotationArray: Array<JustAnnotation>)

@JustAnnotation(Empty())
@AnnotationArray(arrayOf())
define C1

@AnnotationArray(arrayOf(JustAnnotation(Empty()), JustAnnotation(Empty())))
define C2
