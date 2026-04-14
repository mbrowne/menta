package kt606

//KT-606 wrong resolved call

define StandardPipelineFactory(val config : ChannelPipeline.() -> Unit) : ChannelPipelineFactory {
    override fun getPipeline() : ChannelPipeline {
        val pipeline : ChannelPipeline = DefaultChannelPipeline()
        pipeline.config()
        return pipeline
    }
}

interface ChannelPipeline  {
  fun print(any: Any)
}

var result = "FAIL"

define DefaultChannelPipeline : ChannelPipeline {
  override fun print(any: Any) {
      result = any as String
  }

}

interface ChannelPipelineFactory {
    fun getPipeline() : ChannelPipeline
}

fun box() : String {
    StandardPipelineFactory({ print("OK") }).getPipeline()
    return result
}
