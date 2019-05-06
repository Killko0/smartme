package berlin.code.smartme.smartme.ui.roadmap

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import androidx.work.WorkManager
import berlin.code.smartme.smartme.R
import berlin.code.smartme.smartme.data.HabitsData
import berlin.code.smartme.smartme.notifcations.repeatingHabitNotificationRequest
import berlin.code.smartme.smartme.ui.BottomNavigation
import berlin.code.smartme.smartme.ui.survey.StartSurvey
import org.json.JSONArray

class Roadmap : AppCompatActivity(), BottomNavigation.OnFragmentInteractionListener,
    StartSurvey.OnFragmentInteractionListener, ActiveHabits.OnFragmentInteractionListener {
    private val fragMan = supportFragmentManager
    private lateinit var habitsData : HabitsData
    private lateinit var sharedPref: SharedPreferences
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roadmap)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        sharedPref = this.getSharedPreferences("habits",Context.MODE_PRIVATE)
        //Enqueuing notification
        WorkManager.getInstance().enqueue(repeatingHabitNotificationRequest)



    }
    override fun onStart() {
        super.onStart()
        val scrollView = findViewById<ScrollView>(R.id.scrollView1)
        //Making sure scrollview starts at bottom
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
            fragMan?.beginTransaction()?.add(
                R.id.active_habits_layout,
                ActiveHabits(),"activeHabits_1")?.commit()
        }


    }
    //Method to start survey
    fun onStartPressed(view: View){
        StartSurvey().onStartPressed(view)
    }

    private fun stationPressed(view: View){
        fragMan.beginTransaction().add(
            R.id.habitChoosingLayout,
            HabitChoosing(),"fragment").commit()

    }
    fun getHabits():JSONArray{
        habitsData= HabitsData()
        return habitsData.readJson(assets.open("habits.json"))
    }
}
