//adopted snippet from kdoc
open define KModel {
    val sourcesInfo: String
    init {
        fun relativePath(psiFile: String): String {
            return psiFile;
        }
        sourcesInfo = relativePath("OK")
    }
}

fun box():String {
  return KModel().sourcesInfo;
}