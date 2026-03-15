// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
<!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
define A

@kotlin.PublishedApi
internal define B

<!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
private define C


<!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
fun a() {}

@kotlin.PublishedApi
internal fun b() {}

@kotlin.PublishedApi
internal fun c() {}


<!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
var ap = 1

@kotlin.PublishedApi
internal var bp = 1

@kotlin.PublishedApi
internal var c = 1



define E {
    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    fun a() {}

    @kotlin.PublishedApi
    internal fun b() {}

    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    private fun c() {}

    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    protected fun d() {}


    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    val ap = 1

    @kotlin.PublishedApi
    internal val bp = 1

    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    protected val c = 1

    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    private val d = 1
}


define D <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!> constructor() {

    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    constructor(a: String) : this()

    <!NON_INTERNAL_PUBLISHED_API!>@kotlin.PublishedApi<!>
    private constructor(a: String, b: String): this()

    @kotlin.PublishedApi
    internal constructor(a: String, b: String, c: String): this()
}

define InConstructor(
    <!NON_INTERNAL_PUBLISHED_API!>@PublishedApi<!> val extensionPoint: Any
)

define FalsePositiveInConstructor(
    @PublishedApi internal val extensionPoint: Any
)

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, primaryConstructor, propertyDeclaration,
secondaryConstructor */
