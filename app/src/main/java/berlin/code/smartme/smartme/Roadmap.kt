package berlin.code.smartme.smartme

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ScrollView
import androidx.work.WorkManager
import berlin.code.smartme.smartme.data.HabitsData
import berlin.code.smartme.smartme.survey.StartSurvery
import berlin.code.smartme.smartme.survey.StartSurvey
import kotlinx.android.synthetic.main.activity_roadmap.*
import kotlinx.android.synthetic.main.fragment_start_survey.*
import org.json.JSONArray

class Roadmap : AppCompatActivity(),BottomNavigation.OnFragmentInteractionListener,StartSurvey.OnFragmentInteractionListener,ActiveHabits.OnFragmentInteractionListener{
    val fragMan = supportFragmentManager
    private lateinit var habitsData : HabitsData
    private lateinit var sharedPref: SharedPreferences
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




    fun getHabits():JSONArray{
        habitsData= HabitsData()
        return habitsData.readJson(assets.open("habits.json"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roadmap)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        WorkManager.getInstance().enqueue(repeatingHabitNotificationRequest)
        sharedPref = this.getSharedPreferences("habits",Context.MODE_PRIVATE)


    }

    override fun onStart() {
        super.onStart()
        val scrollView = findViewById<ScrollView>(R.id.scrollView1)
        scrollView.post {
            run {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
        }
        val btnWeek1: ImageView? = this.findViewById(R.id.week_1)
        val chosenHabits = sharedPref.all
        if(chosenHabits.count()<3){
            btnWeek1?.setOnClickListener{v:View -> stationPressed(v)}

        }
        else{
            fragMan?.beginTransaction()?.add(R.id.active_habits_layout,ActiveHabits(),"activeHabits_1")?.commit()
        }


    }
    fun onStartPressed(view: View){
        StartSurvey().onStartPressed(view)
    }

    fun stationPressed(view: View){
        fragMan.beginTransaction().add(R.id.habitChoosingLayout,HabitChoosing(),"fragment").commit()

    }
}
