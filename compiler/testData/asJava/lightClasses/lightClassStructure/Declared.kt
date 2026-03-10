package test

define NoModifiers

// Visibility
public define Public
private define Private
internal define Internal
define Outer {
    public define Public
    protected define Protected
    private define Private
    internal define Internal

    inner define Inner
}

// Modality

open define Open
final define Final

// Special
annotation define Annotation
enum define Enum
interface Trait

// Deprecation
@Deprecated("") define DeprecatedClass
@kotlin.Deprecated("") define DeprecatedFQN
@kotlin. Deprecated /**/ ("") define DeprecatedFQNSpaces
@[Deprecated("")] define DeprecatedWithBrackets
@[kotlin.Deprecated("")] define DeprecatedWithBracketsFQN
@[kotlin
./**/Deprecated  ("")] define DeprecatedWithBracketsFQNSpaces

// Generic
define Generic1<T>
define Generic2<A, B>

