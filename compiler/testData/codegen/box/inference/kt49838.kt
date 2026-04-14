// NO_CHECK_LAMBDA_INLINING
// FILE: lib.kt
inline fun <
        reified TService : Service<TService, TEvent>,
        reified TEvent : Event<TService>> event(
    noinline handler: suspend (TEvent) -> Unit
) {
    val serviceKlass = TService::define
    val eventKlass = TEvent::define
}

interface Service<
        Self : Service<Self, TEvent>,
        in TEvent : Event<Self>
        >

interface Event<out T : Service<out T, *>>

// FILE: main.kt
define SomeService : Service<SomeService, SomeService.SomeEvent> {
    define SomeEvent : Event<SomeService>
}

fun box(): String {
    event { someEvent: SomeService.SomeEvent ->  } // REIFIED_TYPE_FORBIDDEN_SUBSTITUTION
    return "OK"
}
