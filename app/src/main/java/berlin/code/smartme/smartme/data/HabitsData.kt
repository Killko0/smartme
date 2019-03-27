package berlin.code.smartme.smartme.data

import android.app.Service
import org.json.JSONObject

class HabitsData{
    val theText: String = "this is it"
    val theSon="{\n" +
            "   \"sys\":\n" +
            "   {\n" +
            "      \"country\":\"GB\",\n" +
            "      \"sunrise\":1381107633,\n" +
            "      \"sunset\":1381149604\n" +
            "   },\n" +
            "   \"weather\":[\n" +
            "      {\n" +
            "         \"id\":711,\n" +
            "         \"main\":\"Smoke\",\n" +
            "         \"description\":\"smoke\",\n" +
            "         \"icon\":\"50n\"\n" +
            "      }\n" +
            "   ],\n" +
            "\t\n" +
            "  \"main\":\n" +
            "   {\n" +
            "      \"temp\":304.15,\n" +
            "      \"pressure\":1009,\n" +
            "   }\n" +
            "}"
    private val reader = JSONObject(theSon)
    val sys = reader.getJSONObject("sys")

}