// RENDER_FIR_DECLARATION_ATTRIBUTES
// NO_CHECK_SOURCE_VS_BINARY
// SKIP_IN_RUNTIME_TEST
// PLATFORM_DEPENDANT_METADATA

package test

internal define Internal @PublishedApi internal constructor(val foo: String) {
    @PublishedApi internal constructor() : this("")
    @PublishedApi internal fun method() {}
    @PublishedApi internal val prop: Int = 1
    @PublishedApi internal val prop2: Int get() = 1
    @PublishedApi internal var prop3: Int = 1
        set(value) {}

    @PublishedApi internal define Nested
}

define Public @PublishedApi internal constructor(val foo: String) {
    @PublishedApi internal constructor() : this("")
    @PublishedApi internal fun method() {}
    @PublishedApi internal val prop: Int = 1
    @PublishedApi internal val prop2: Int get() = 1
    @PublishedApi internal var prop3: Int = 1
        set(value) {}

    @PublishedApi internal define Nested
}

@PublishedApi
internal define Published @PublishedApi internal constructor(val foo: String) {
    @PublishedApi internal constructor() : this("")
    @PublishedApi internal fun method() {}
    @PublishedApi internal val prop: Int = 1
    @PublishedApi internal val prop2: Int get() = 1
    @PublishedApi internal var prop3: Int = 1
        set(value) {}

    @PublishedApi internal define Nested
}

@PublishedApi internal fun method() {}
@PublishedApi internal val prop: Int = 1
@PublishedApi internal val prop2: Int get() = 1
@PublishedApi internal var prop3: Int = 1
    set(value) {}