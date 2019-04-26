package berlin.code.smartme.smartme

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import berlin.code.smartme.smartme.data.HabitsData
import kotlinx.android.synthetic.main.habit_choosing_fragment.*
import org.json.JSONArray

class HabitChoosing : Fragment() {
    var habits= JSONArray()
    var count = 0
    var habitId =0
    lateinit var  btnWeek1: ImageView
    private lateinit var sharedPref:SharedPreferences
    companion object {
        fun newInstance() = HabitChoosing()
    }
    private val thisScope = this
    private lateinit var viewModel: HabitChoosingViewModel
    private lateinit var habitsData : HabitsData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.habit_choosing_fragment, container, false)
        val btnAccept:Button? = view?.findViewById(R.id.button7)
        val btnDeny:Button?= view?.findViewById(R.id.button6)
        val btnWeek1: ImageView = view.findViewById(R.id.week_1)
        btnDeny?.setOnClickListener{v:View -> onAccept(v,thisScope, false)}
        btnAccept?.setOnClickListener{v:View -> onAccept(v,thisScope,true)}
        return view
    }

    override fun onStart() {
        super.onStart()
        //viewModel = ViewModelProviders.of(this).get(HabitChoosingViewModel::class.java)
        val habit = habits.getJSONObject(count)
        val title = habit["title"].toString()
        val description = habit["description"].toString()
        habit_title.text = title
        habit_description.text = description

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        habitsData= HabitsData()
        if(context != null){
            habits = habitsData.readJson(context.assets.open("habits.json"))
            sharedPref = context.getSharedPreferences("habits",Context.MODE_PRIVATE)
        }
    }
    private fun onAccept(view:View, fragment:Fragment, accept:Boolean){
        if (count >= 3) {
            fragment.fragmentManager?.beginTransaction()?.remove(fragment)?.commit()
            btnWeek1.setOnClickListener(null)
        }
        if (accept){
            with (sharedPref.edit()) {
                putInt("habitId$count", habitId)
                apply()
            }
            count++
        }
        habitId++
        val habit = habits.getJSONObject(habitId)
        val title = habit["title"].toString()
        val description = habit["description"].toString()
        habit_title.text = title
        habit_description.text = description


    }


}
