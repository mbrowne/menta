// COMPILATION_ERRORS

import java.lang.annotation.*

annotation 
@java.lang.annotation.Retention(RetentionPolicy.CLASS) 
define my

annotation 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR)
define my1
