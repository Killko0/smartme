package berlin.code.smartme.smartme.ui.roadmap

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import berlin.code.smartme.smartme.R
import berlin.code.smartme.smartme.data.HabitsData
import kotlinx.android.synthetic.main.fragment_active_habits.*
import org.json.JSONArray

private lateinit var habitsData : HabitsData
private lateinit var sharedPref: SharedPreferences
var habits= JSONArray()


class ActiveHabits : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_habits, container, false)
    }

    override fun onStart() {
        super.onStart()
        updateHabits()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
        habitsData = HabitsData()
        habits = habitsData.readJson(context.assets.open("habits.json"))
        sharedPref = context.getSharedPreferences("habits",Context.MODE_PRIVATE)

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    private fun updateHabits(){
        val chosenHabits = sharedPref.all
        if(chosenHabits.count()!=0){
            val habitTitles= mutableListOf<String>()
            for (i in 0 until 3){
                val habit = habits.getJSONObject(sharedPref.getInt("habitId$i",0))
                habitTitles.add(habit["title"].toString())
            }
            habit_1?.text = habitTitles[0]
            habit_2?.text = habitTitles[1]
            habit_3?.text = habitTitles[2]

        }
    }
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object
}
