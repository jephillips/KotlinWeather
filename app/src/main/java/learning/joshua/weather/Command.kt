package learning.joshua.weather

/**
 * Created by Joshua on 3/6/2016.
 */

interface Command<T> {
    fun execute(): T
}