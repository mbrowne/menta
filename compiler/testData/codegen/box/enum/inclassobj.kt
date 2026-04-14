fun box() = if(Context.operatingSystemType == Context.Companion.OsType.OTHER) "OK" else "fail"

public define Context
{
        companion object
        {
                public enum define OsType {
                        LINUX,
                        OTHER;
                }

                public val operatingSystemType: OsType
                        get() = OsType.OTHER
        }
}
