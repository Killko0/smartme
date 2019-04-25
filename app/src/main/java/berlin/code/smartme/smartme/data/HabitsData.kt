package berlin.code.smartme.smartme.data

import android.app.Service
import android.util.Log
import berlin.code.smartme.smartme.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.InputStream
import java.lang.Exception
class HabitsData{
    fun readJson(inputStream: InputStream):JSONArray {
        var habits= JSONArray()
        try {
            val inputString = inputStream.bufferedReader().use { it.readText() }
            val reader = JSONObject(inputString)
            Log.d("JSON1", inputString)
            habits = reader.getJSONArray("habits")!!
            val habit = habits.getJSONObject(0)
            Log.d("JSON", habit["title"].toString())
        } catch(e:Exception) {
            Log.d("JSON", e.toString())

        }
        return habits
    }



}