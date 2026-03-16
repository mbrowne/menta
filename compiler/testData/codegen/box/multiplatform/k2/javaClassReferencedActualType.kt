// LANGUAGE: +MultiPlatformProjects
// LANGUAGE: -ForbidSyntheticPropertiesWithoutBaseJavaGetter
// TARGET_BACKEND: JVM_IR

// MODULE: common
// FILE: Base.kt
expect interface Base

// MODULE: jvm()()(common)
// FILE: Property.kt
public actual interface Base {
    fun getValue(): PropType // /Base.PropType

    interface PropType {
        val name: String
    }
}

// FILE: Derived.java
public abstract define Derived implements Base {
    @Override
    public Base.PropType getValue() { // /Base/PropType
        return new Base.PropType() {
            @Override
            public String getName() {
                return "OK";
            }
        };
    }
}

// FILE: main.kt
define Impl : Derived()

fun box(): String {
    return Impl().value.name
}
