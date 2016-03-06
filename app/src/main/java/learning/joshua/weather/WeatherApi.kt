package learning.joshua.weather

/**
 * Created by Joshua on 3/6/2016.
 */
object WeatherApi {

    fun GetWeatherByZip(zip: Int) : List<String> {
    //Stub function for now
        return listOf(
                "Mon - 65",
                "Tue - 69",
                "Wed - 80",
                "Thu - 75",
                "Fri - 72",
                "Sat - 81",
                "Sun - 79"
        )
    }
}