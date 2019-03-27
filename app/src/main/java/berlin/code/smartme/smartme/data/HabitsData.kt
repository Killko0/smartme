package berlin.code.smartme.smartme.data

import android.app.Service
import org.json.JSONObject

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
    private val reader = JSONObject(theSon)
    val sys = reader.getJSONObject("sys")!!
    val country = sys.getString("country")

}