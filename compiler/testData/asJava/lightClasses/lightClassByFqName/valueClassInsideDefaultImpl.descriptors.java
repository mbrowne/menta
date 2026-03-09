public abstract interface BaseInterface /* one.BaseInterface*/ {
  public abstract error.NonExistentClass getPropertyWithValueClassParameter();//  getPropertyWithValueClassParameter()

  public abstract void functionWithValueClassParameter(error.NonExistentClass);//  functionWithValueClassParameter(error.NonExistentClass)

  public abstract void regularFunction();//  regularFunction()

  public static final class DefaultImpls /* one.BaseInterface.DefaultImpls*/ {
    public static error.NonExistentClass getPropertyWithValueClassParameter(@org.jetbrains.annotations.NotNull() one.BaseInterface);//  getPropertyWithValueClassParameter(one.BaseInterface)

    public static void functionWithValueClassParameter(@org.jetbrains.annotations.NotNull() one.BaseInterface, error.NonExistentClass);//  functionWithValueClassParameter(one.BaseInterface, error.NonExistentClass)

    public static void regularFunction(@org.jetbrains.annotations.NotNull() one.BaseInterface);//  regularFunction(one.BaseInterface)
  }
}
