package berlin.code.smartme.smartme.data

import android.app.Service
import android.util.Log
import berlin.code.smartme.smartme.R
import org.json.JSONObject
import java.io.File
import java.io.InputStream
import java.lang.Exception
class HabitsData{
    val theText: String = "this is it"
    val theSon="{\n" +
            "\t\"sys\": {\n" +
            "\t\t\"country\": \"GB\",\n" +
            "\t\t\"sunrise\": 1381107633,\n" +
            "\t\t\"sunset\": 1381149604\n" +
            "\t},\n" +
            "\t\"weather\": [{\n" +
            "\t\t\"id\": 711,\n" +
            "\t\t\"main\": \"Smoke\",\n" +
            "\t\t\"description\": \"smoke\",\n" +
            "\t\t\"icon\": \"50n\"\n" +
            "\t}],\n" +
            "\n" +
            "\t\"main\": {\n" +
            "\t\t\"temp\": 304.15,\n" +
            "\t\t\"pressure\": 1009\n" +
            "\t}\n" +
            "}"
    fun readJson(inputStream: InputStream) {
        try {
            val inputString = inputStream.bufferedReader().use { it.readText() }
            val reader = JSONObject(inputString)
            Log.d("JSON1", inputString)
            val habits = reader.getJSONArray("habits")!!
            Log.d("JSON", habits[0].toString())
            //val country = sys.getString("country")
        } catch(e:Exception) {
            Log.d("JSON", e.toString())
        }
    }



}