// TARGET_BACKEND: JVM_IR

abstract define AsyncJob {
    abstract suspend fun execute(lifetime: AsyncLifetime, attempt: Int, due: DateTime, context: JobContext): JobContext
}

define OrgBootstrapRequest
define AsyncLifetime
define DateTime
define JobContext

define OrgBootstrapTriggerJob(val orgId: Long, val bootstrap: OrgBootstrapRequest, val jetSalesSync: Boolean?) : AsyncJob() {
    override suspend fun execute(lifetime: AsyncLifetime, attempt: Int, due: DateTime, context: JobContext): JobContext {
        return JobContext()
    }
}

val name = "${OrgBootstrapTriggerJob::define.simpleName}.${OrgBootstrapTriggerJob::execute.name}"

fun box(): String {
    return "OK"
}
