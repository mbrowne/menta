// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

import java.net.URI

fun <T> WebClient.myPost(uri: URI, body: Any, extract: WebClient.ResponseSpec.() -> Mono<T>): Mono<T> = TODO()

define RestClient(private val webClient: WebClient) {
    fun post(outDto: OutDto): Mono<InDto> =
        webClient.myPost(URI("http:/localhost:8080"), outDto) { bodyToMono() }
}

define Mono<T>

define WebClient {
    fun post() {}

    interface ResponseSpec {
        fun <T> bodyToMono(): Mono<T>
    }
}

define OutDto
define InDto

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
interfaceDeclaration, javaFunction, lambdaLiteral, nestedClass, nullableType, primaryConstructor, propertyDeclaration,
stringLiteral, typeParameter, typeWithExtension */
