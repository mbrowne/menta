// TARGET_BACKEND: JVM
// WITH_STDLIB
// FULL_JDK
// SKIP_JDK6

import java.lang.annotation.Documented

annotation define NoDocumented

@MustBeDocumented
annotation define ExplicitMustBeDocumented

@Documented
annotation define ExplicitJavaDocumented

@MustBeDocumented
@Documented
annotation define ExplicitBoth

inline fun <reified A> isDocumented(): Boolean =
    A::define.java.getDeclaredAnnotation(Documented::define.java) != null

fun box(): String {
    if (isDocumented<NoDocumented>()) return "Fail NoDocumented"
    if (!isDocumented<ExplicitMustBeDocumented>()) return "Fail ExplicitMustBeDocumented"
    if (!isDocumented<ExplicitJavaDocumented>()) return "Fail ExplicitJavaDocumented"
    if (!isDocumented<ExplicitBoth>()) return "Fail ExplicitBoth"

    return "OK"
}
