package berlin.code.smartme.smartme

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import berlin.code.smartme.smartme.data.HabitsData

import kotlinx.android.synthetic.main.activity_methods_overview.*
import org.json.JSONArray

class MethodsOverview : AppCompatActivity(),BottomNavigation.OnFragmentInteractionListener {
    private lateinit var sharedPref: SharedPreferences
    private lateinit var habitsData : HabitsData
    var habits= JSONArray()
    override fun onFragmentInteraction(uri: Uri) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_methods_overview)

        sharedPref = this.getSharedPreferences("habits", Context.MODE_PRIVATE)
        val chosenHabits = sharedPref.all
        habitsData= HabitsData()
        habits = habitsData.readJson(this.assets.open("habits.json"))
        val methods= mutableListOf<String>()

        for (i in 0 until habits.length()){
            var habit = habits.getJSONObject(i)
            methods.add(habit["title"].toString())
        }
        val adapter =  Habit(this,habits)///ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, methods)
        val listView: ListView = findViewById(R.id.listview)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.d("MethodsOverview", listView.getItemAtPosition(position).toString())
        }
        listView.setOnItemClickListener{
            parent, view, position, id -> val methodsIntent = Intent(this,MethodDetailActivity::class.java)
            startActivity(methodsIntent)
        }


    }

    fun displayMethodDetail(view:View){
        val methodsIntent = Intent(this,MethodDetailActivity::class.java)
        startActivity(methodsIntent)
    }

}

