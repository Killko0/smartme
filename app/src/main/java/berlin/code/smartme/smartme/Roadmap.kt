package berlin.code.smartme.smartme

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.ScrollView
import berlin.code.smartme.smartme.data.HabitsData
import berlin.code.smartme.smartme.survey.StartSurvery
import berlin.code.smartme.smartme.survey.StartSurvey
import kotlinx.android.synthetic.main.activity_roadmap.*
import kotlinx.android.synthetic.main.fragment_start_survey.*
import org.json.JSONArray

class Roadmap : AppCompatActivity(),BottomNavigation.OnFragmentInteractionListener,StartSurvey.OnFragmentInteractionListener{
    val fragMan = supportFragmentManager
    private lateinit var habitsData : HabitsData

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

    }

    override fun onStart() {
        super.onStart()
        val scrollView = findViewById<ScrollView>(R.id.scrollView1)
        scrollView.post {
            run {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
        }
        val fragment = HabitChoosing()
        fragMan.beginTransaction().add(R.id.habitChoosingLayout,fragment,"fragment").commit()
    }
    fun onStartPressed(view: View){
        StartSurvey().onStartPressed(view)
    }


}
