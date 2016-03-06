package learning.joshua.weather

import android.util.Log
import com.google.gson.Gson
import org.jetbrains.anko.async
import java.net.URL


/**
 * Created by Joshua on 3/6/2016.
 */
object WeatherApi {
    val APIENDPOINT = "api.openweathermap.org/data/2.5/"

    fun GetWeatherByID(id: Int): List<String> {
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=" +
                Constants.APIKEY + "&q=" + id+ "&mode=json&units=metric&cnt=7"

        async() {
            val ForecastResult = Request(url).run()
        }

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

    class Request(val url: String)  {

        fun run() : ForecastResult {
            val forecastJsonStr = URL(url).readText()
            return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
        }
    }

    data class ForecastResult(val city: City, val list: List<Forecast>)
    data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)
    data class Coordinates(val lon: Float, val lat: Float)
    data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)
    data class Weather(val id: Long, val main: String, val description: String, val icon: String)
    data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int,
                        val weather: List<Weather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

}