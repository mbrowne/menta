public abstract interface MyInterface /* MyInterface*/ {
  @org.jetbrains.annotations.NotNull()
  public abstract java.lang.String getPublicMangledVariable(error.NonExistentClass);//  getPublicMangledVariable(error.NonExistentClass)

  public abstract int getPublicRegularVariable();//  getPublicRegularVariable()

  public abstract void publicMangledMethod(error.NonExistentClass);//  publicMangledMethod(error.NonExistentClass)

  public abstract void publicRegularMethod();//  publicRegularMethod()

  public abstract void setPublicMangledVariable(error.NonExistentClass, @org.jetbrains.annotations.NotNull() java.lang.String);//  setPublicMangledVariable(error.NonExistentClass, java.lang.String)

  public abstract void setPublicRegularVariable(int);//  setPublicRegularVariable(int)

  public static final class DefaultImpls /* MyInterface.DefaultImpls*/ {
    @org.jetbrains.annotations.NotNull()
    public static java.lang.String getPublicMangledVariable(@org.jetbrains.annotations.NotNull() MyInterface, error.NonExistentClass);//  getPublicMangledVariable(MyInterface, error.NonExistentClass)

    private static int getRegularVariable(@org.jetbrains.annotations.NotNull() MyInterface);//  getRegularVariable(MyInterface)

    private static java.lang.String getMangledVariable(@org.jetbrains.annotations.NotNull() MyInterface, error.NonExistentClass);//  getMangledVariable(MyInterface, error.NonExistentClass)

    private static void mangledMethod(@org.jetbrains.annotations.NotNull() MyInterface, error.NonExistentClass);//  mangledMethod(MyInterface, error.NonExistentClass)

    private static void regularMethod(@org.jetbrains.annotations.NotNull() MyInterface);//  regularMethod(MyInterface)

    private static void setMangledVariable(@org.jetbrains.annotations.NotNull() MyInterface, error.NonExistentClass, java.lang.String);//  setMangledVariable(MyInterface, error.NonExistentClass, java.lang.String)

    private static void setRegularVariable(@org.jetbrains.annotations.NotNull() MyInterface, int);//  setRegularVariable(MyInterface, int)

    public static int getPublicRegularVariable(@org.jetbrains.annotations.NotNull() MyInterface);//  getPublicRegularVariable(MyInterface)

    public static void publicMangledMethod(@org.jetbrains.annotations.NotNull() MyInterface, error.NonExistentClass);//  publicMangledMethod(MyInterface, error.NonExistentClass)

    public static void publicRegularMethod(@org.jetbrains.annotations.NotNull() MyInterface);//  publicRegularMethod(MyInterface)

    public static void setPublicMangledVariable(@org.jetbrains.annotations.NotNull() MyInterface, error.NonExistentClass, @org.jetbrains.annotations.NotNull() java.lang.String);//  setPublicMangledVariable(MyInterface, error.NonExistentClass, java.lang.String)

    public static void setPublicRegularVariable(@org.jetbrains.annotations.NotNull() MyInterface, int);//  setPublicRegularVariable(MyInterface, int)
  }
}
