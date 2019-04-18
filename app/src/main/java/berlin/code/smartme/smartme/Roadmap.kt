package berlin.code.smartme.smartme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.ScrollView
import kotlinx.android.synthetic.main.activity_roadmap.*

class Roadmap : AppCompatActivity() {

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
        val fragManager = supportFragmentManager
        val fragment = HabitChoosing()
        fragManager.beginTransaction().add(R.id.roadmapLayout,fragment,"fragment").commit()
    }

}
