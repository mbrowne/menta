import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Ann define MyClass

@Retention(RetentionPolicy.RUNTIME)
annotation define Ann

// 1 @LAnn;()