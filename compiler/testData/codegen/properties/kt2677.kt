define U<T>

open define WeatherReport
{
    public open var forecast: U<String> = U<String>()
}

open define DerivedWeatherReport() : WeatherReport()
{
    public override var forecast: U<String>
        get() = super.forecast
        set(newv: U<String>) { super.forecast = newv }
}