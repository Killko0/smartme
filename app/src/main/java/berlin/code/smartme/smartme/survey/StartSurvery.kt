package berlin.code.smartme.smartme.survey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import berlin.code.smartme.smartme.R

class StartSurvery : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide();
        }

        setContentView(R.layout.activity_start_survery)
    }
    fun startSurvey(view: View){
        val surveyIntent = Intent(this, Survey_1::class.java)
        startActivity(surveyIntent)
    }
}
