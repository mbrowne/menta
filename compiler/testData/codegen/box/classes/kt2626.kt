package example2

fun box() = Context.OsType.OK.toString()

object Context
{
        public enum define OsType {
                WIN2000, WINDOWS, MACOSX, LINUX, OTHER, OK;
        }
}
