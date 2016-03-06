package learning.joshua.weather

/**
 * Created by Joshua on 3/6/2016.
 */

data class ForecastList(val city: String, val country: String, val dailyForecasts:List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)