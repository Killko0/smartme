package berlin.code.smartme.smartme.ui.habitlist

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import berlin.code.smartme.smartme.ui.BottomNavigation
import berlin.code.smartme.smartme.R
import berlin.code.smartme.smartme.data.HabitsData

import org.json.JSONArray

class MethodsOverview : AppCompatActivity(),
    BottomNavigation.OnFragmentInteractionListener {
    private lateinit var sharedPref: SharedPreferences
    private lateinit var habitsData : HabitsData
    var habits= JSONArray()
    override fun onFragmentInteraction(uri: Uri) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_methods_overview)
        //Getting the JSON data of all habits
        sharedPref = this.getSharedPreferences("habits", Context.MODE_PRIVATE)
        val chosenHabits = sharedPref.all
        habitsData= HabitsData()
        habits = habitsData.readJson(this.assets.open("habits.json"))
        val methods= mutableListOf<String>()

        for (i in 0 until habits.length()){
            val habit = habits.getJSONObject(i)
            methods.add(habit["title"].toString())
        }
        val adapter = Habit(
            this,
            habits
        )///ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, methods)
        val listView: ListView = findViewById(R.id.listview)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.d("MethodsOverview", listView.getItemAtPosition(position).toString())
        }
//        listView.setOnItemClickListener{
//            parent, view, position, id -> val methodsIntent = Intent(this,MethodDetailActivity::class.java)
//            startActivity(methodsIntent)
//        }


    }

}

